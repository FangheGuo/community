package town.guitar.community.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import town.guitar.community.dto.CommentDTO;
import town.guitar.community.dto.PostDTO;
import town.guitar.community.enums.CommentTypeEnum;
import town.guitar.community.service.CommentService;
import town.guitar.community.service.PostService;

import java.util.List;

@Controller
public class PostDetailController {

    @Autowired
    private PostService postService;
    @Autowired
    private CommentService commentService;

    @GetMapping("/postDetail/{id}")
    public String PostPage(@PathVariable(name = "id") Long id, Model model) {
        PostDTO postDTO = postService.getById(id);
        List<PostDTO> relatedPosts = postService.selectRelated(postDTO);
        List<CommentDTO> comments = commentService.listByTargetId(id, CommentTypeEnum.POST);
        //累加阅读数
        postService.incView(id);
        model.addAttribute("post", postDTO);
        model.addAttribute("comments", comments);
        model.addAttribute("relatedPosts", relatedPosts);
        return "postDetail";
    }

}
