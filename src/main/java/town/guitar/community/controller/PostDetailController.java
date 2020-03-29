package town.guitar.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class PostPageController {
    @GetMapping("/postPage/{id}")
    public String PostPage(@PathVariable(name = "id") Integer id) {
        return "postPage";
    }

}
