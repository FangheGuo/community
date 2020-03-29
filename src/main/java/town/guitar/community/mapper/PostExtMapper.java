package town.guitar.community.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Component;
import town.guitar.community.dto.PostQueryDTO;
import town.guitar.community.model.Post;
import town.guitar.community.model.PostExample;

import java.util.List;

@Component
public interface PostExtMapper {

    int incView(Post record);

    int incCommentCount(Post record);
    List<Post> selectRelated(Post post);

    Integer countBySearch(PostQueryDTO postQueryDTO);

    List<Post> selectBySearch(PostQueryDTO postQueryDTO);
}