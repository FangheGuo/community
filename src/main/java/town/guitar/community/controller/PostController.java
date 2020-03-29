package town.guitar.community.controller;


import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import town.guitar.community.cache.TagCache;
import town.guitar.community.dto.PostDTO;
import town.guitar.community.model.Post;
import town.guitar.community.model.User;
import town.guitar.community.service.PostService;

import javax.servlet.http.HttpServletRequest;

@Controller
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("/post/{id}")
    public String edit(@PathVariable(name = "id") Long id,
                       Model model) {
        PostDTO post = postService.getById(id);
        model.addAttribute("title", post.getTitle());
        model.addAttribute("content", post.getContent());
        model.addAttribute("tag", post.getTag());
        model.addAttribute("id", post.getId());
        model.addAttribute("tags", TagCache.get());
        return "post";
    }

    @GetMapping("/post")
    public String post(Model model) {
        model.addAttribute("tags", TagCache.get());
        return "post";
    }


    //发布
    @PostMapping("/post")
    public String doPost(
            @RequestParam(value = "title", required = false) String title,
            @RequestParam(value = "content", required = false) String content,
            @RequestParam(value = "tag", required = false) String tag,
            @RequestParam(value = "id", required = false) Long id,
            HttpServletRequest request,
            Model model) {
        //保存输入的信息
        model.addAttribute("title", title);
        model.addAttribute("content", content);
        model.addAttribute("tag", tag);
        model.addAttribute("tags", TagCache.get());
        //校验输入是否为空
        if (title == null || title == "") {
            model.addAttribute("error", "标题不能为空");
            return "post";
        }
        if (content == null || content == "") {
            model.addAttribute("error", "详细内容不能为空");
            return "post";
        }
        if (tag == null || tag == "") {
            model.addAttribute("error", "标签不能为空");
            return "post";
        }

        String invalid = TagCache.filterInvalid(tag);
        if (StringUtils.isNotBlank(invalid)) {
            model.addAttribute("error", "输入非法标签" + invalid);
            return "post";
        }

        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            model.addAttribute("error", "用户未登录");
            return "post";
        }

        Post post = new Post();
        post.setTitle(title);
        post.setContent(content);
        post.setTag(tag);
        post.setCreator(user.getId());
        post.setId(id);
        postService.createOrUpdate(post);
        return "redirect:/";
    }

}
