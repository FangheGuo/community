package town.guitar.community.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import town.guitar.community.dto.NotificationDTO;
import town.guitar.community.dto.PaginationDTO;
import town.guitar.community.enums.NotificationTypeEnum;
import town.guitar.community.model.Notification;
import town.guitar.community.model.User;
import town.guitar.community.service.NotificationService;

import javax.servlet.http.HttpServletRequest;

@Controller
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @GetMapping("/notification/{id}")
    public String profile(@PathVariable(name = "id") Long id,
                          HttpServletRequest request) {

        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            System.out.println("用户错误了");
            return "redirect:/";
        }
        NotificationDTO notificationDTO = notificationService.read(id,user);
        if(NotificationTypeEnum.REPLY_COMMENT.getType() == notificationDTO.getType()
            || NotificationTypeEnum.REPLY_POST.getType() == notificationDTO.getType()){
            return "redirect:/postDetail/"+notificationDTO.getOuterid();
        }else{

            System.out.println("回复类型错误了");
            return "redirect:/";
        }
    }
}
