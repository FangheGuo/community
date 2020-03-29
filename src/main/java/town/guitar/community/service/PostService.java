package town.guitar.community.service;


import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import town.guitar.community.dto.PaginationDTO;
import town.guitar.community.dto.PostDTO;
import town.guitar.community.dto.PostQueryDTO;
import town.guitar.community.exception.CustomizeErrorCode;
import town.guitar.community.exception.CustomizeException;
import town.guitar.community.mapper.PostExtMapper;
import town.guitar.community.mapper.PostMapper;
import town.guitar.community.mapper.UserMapper;
import town.guitar.community.model.Post;
import town.guitar.community.model.PostExample;
import town.guitar.community.model.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService {

    @Autowired
    private PostMapper postMapper;
    @Autowired
    private PostExtMapper postExtMapper;
    @Autowired
    private UserMapper userMapper;

    public PaginationDTO list(String search, Integer page, Integer size) {



        if (StringUtils.isNotBlank(search)) {
            String[] tags = StringUtils.split(search, " ");
            search = Arrays.stream(tags).collect(Collectors.joining("|"));
        }

        PaginationDTO paginationDTO = new PaginationDTO();
        Integer totalPage;

        PostQueryDTO postQueryDTO = new PostQueryDTO();
        postQueryDTO.setSearch(search);
        Integer totalCount = postExtMapper.countBySearch(postQueryDTO);
        if (totalCount % size == 0) {
            totalPage = totalCount / size;
        } else {
            totalPage = totalCount / size + 1;
        }
        if (page < 1) {
            page = 1;
        }
        if (page > totalPage) {
            page = totalPage;
        }

        paginationDTO.setPagination(totalPage, page);
        //size*(page-1)
        Integer offset = size * (page - 1);
        postQueryDTO.setSize(size);
        postQueryDTO.setPage(offset);
        List<Post> posts = postExtMapper.selectBySearch(postQueryDTO);
        List<PostDTO> postDTOList = new ArrayList<>();

        for (Post post : posts) {
            User user = userMapper.selectByPrimaryKey(post.getCreator());
            PostDTO postDTO = new PostDTO();
            //快速的把前一个类的属性拷贝到另一个类
            BeanUtils.copyProperties(post, postDTO);

            postDTO.setUser(user);
            postDTOList.add(postDTO);
        }

        paginationDTO.setData(postDTOList);
        return paginationDTO;
    }

    public PaginationDTO list(long userId, Integer page, Integer size) {
        PaginationDTO paginationDTO = new PaginationDTO();

        Integer totalPage;

        PostExample postExample = new PostExample();
        postExample.createCriteria().andCreatorEqualTo(userId);
        Integer totalCount = (int) postMapper.countByExample(postExample);
        if (totalCount % size == 0) {
            totalPage = totalCount / size;
        } else {
            totalPage = totalCount / size + 1;
        }
        if (page < 1) {
            page = 1;
        }
        if (page > totalPage) {
            page = totalPage;
        }

        paginationDTO.setPagination(totalPage, page);
        //size*(page-1)
        Integer offset = size * (page - 1);
        PostExample example = new PostExample();
        example.createCriteria().andCreatorEqualTo(userId);
        List<Post> posts = postMapper.selectByExampleWithRowbounds(example, new RowBounds(offset, size));

        List<PostDTO> postDTOList = new ArrayList<>();

        for (Post post : posts) {
            User user = userMapper.selectByPrimaryKey(post.getCreator());
            PostDTO postDTO = new PostDTO();
            //快速的把前一个类的属性拷贝到另一个类
            BeanUtils.copyProperties(post, postDTO);
            postDTO.setUser(user);
            postDTOList.add(postDTO);
        }

        paginationDTO.setData(postDTOList);
        return paginationDTO;
    }

    public PostDTO getById(Long id) {
        Post post = postMapper.selectByPrimaryKey(id);
        if (post == null) {
            throw new CustomizeException(CustomizeErrorCode.POST_NOT_FOUND);
        }
        PostDTO postDTO = new PostDTO();
        //快速的把前一个类的属性拷贝到另一个类
        BeanUtils.copyProperties(post, postDTO);
        User user = userMapper.selectByPrimaryKey(post.getCreator());
        postDTO.setUser(user);
        return postDTO;
    }

    public void createOrUpdate(Post post) {
        if (post.getId() == null) {
            //创建
            post.setGmtCreate(System.currentTimeMillis());
            post.setGmtModified(post.getGmtCreate());
            post.setViewCount(0);
            post.setLikeCount(0);
            post.setCommentCount(0);
            postMapper.insert(post);
        } else {
            //更新
            Post updatePost = new Post();
            updatePost.setGmtModified(System.currentTimeMillis());
            updatePost.setTitle(post.getTitle());
            updatePost.setContent(post.getContent());
            updatePost.setTag(post.getTag());
            PostExample example = new PostExample();
            example.createCriteria().andIdEqualTo(post.getId());
            int updated = postMapper.updateByExampleSelective(updatePost, example);
            if (updated != 1) {
                throw new CustomizeException(CustomizeErrorCode.POST_NOT_FOUND);
            }
        }
    }

    public void incView(Long id) {
        Post post = new Post();
        post.setId(id);
        post.setViewCount(1);
        postExtMapper.incView(post);
    }

    public List<PostDTO> selectRelated(PostDTO queryDTO) {
        if (StringUtils.isBlank(queryDTO.getTag())) {
            return new ArrayList<>();
        }
        String[] tags = StringUtils.split(queryDTO.getTag(), "，");
        String regexpTag = Arrays.stream(tags).collect(Collectors.joining("|"));
        Post post = new Post();
        post.setId(queryDTO.getId());
        post.setTag(regexpTag);

        List<Post> relatedPosts = postExtMapper.selectRelated(post);
        List<PostDTO> postDTOs = relatedPosts.stream().map(q -> {
            PostDTO postDTO = new PostDTO();
            BeanUtils.copyProperties(q, postDTO);
            return postDTO;
        }).collect(Collectors.toList());
        return postDTOs;
    }
}
