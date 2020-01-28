package town.guitar.community.controller;

import org.omg.CORBA.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import town.guitar.community.dto.AccessTokenDTO;
import town.guitar.community.mapper.UserMapper;
import town.guitar.community.model.User;
import town.guitar.community.provider.GithubProvider;
import town.guitar.community.provider.GithubUser;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

@Controller
public class AuthorizeController {

    @Autowired
    private GithubProvider githubProvider;

    @Value("${github.client.id}")
    private String clientId;
    @Value("${github.client.secret}")
    private String clientSecret;
    @Value("${github.redirect.uri}")
    private String redirectUri;

    @Autowired
    private UserMapper userMapper;
    @GetMapping("/callback")
    public String callback(@RequestParam(name="code") String code,
                           @RequestParam(name="state") String state,
                           HttpServletRequest request){
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
//        System.out.println("clientId是:"+clientId+"secret是："+clientSecret+"uri是："+redirectUri);
        accessTokenDTO.setClient_id(clientId);
        accessTokenDTO.setClient_secret(clientSecret);
        accessTokenDTO.setCode(code);
        accessTokenDTO.setRedirect_uri(redirectUri);
        accessTokenDTO.setState(state);
//        System.out.println("clientId是:"+accessTokenDTO.getClient_id()+"secret是："+accessTokenDTO.getClient_secret()+"uri是："+accessTokenDTO.getRedirect_uri());
        String accessToken = githubProvider.getAccessTokenDTO(accessTokenDTO);
        GithubUser githubUser = githubProvider.getuser(accessToken);
        System.out.println(githubUser.getName());
        if(githubUser != null){
            User user = new User();
            user.setToken(UUID.randomUUID().toString());
            user.setName(githubUser.getName());
            user.setAccountId(String.valueOf(githubUser.getId()));
            user.setGmtCreate(System.currentTimeMillis());
            user.setGmtModified(user.getGmtCreate());
            userMapper.insert(user);
            //登录成，写cookie，写session
            request.getSession().setAttribute("user",githubUser);
            return "redirect:/";
        } else{
            //登录失败 重新登录
            return "redirect:/";
        }
    }
}
