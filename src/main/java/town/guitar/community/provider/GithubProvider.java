package town.guitar.community.provider;

import com.alibaba.fastjson.JSON;
import okhttp3.*;
import org.springframework.stereotype.Component;
import town.guitar.community.dto.AccessTokenDTO;

import java.io.IOException;

@Component
public class GithubProvider {

    public String getAccessTokenDTO(AccessTokenDTO accessTokenDTO){
        MediaType mediatype = MediaType.get("application/json; charset=utf-8");
        OkHttpClient client = new OkHttpClient();

        RequestBody body = RequestBody.create(mediatype, JSON.toJSONString(accessTokenDTO));
        Request request = new Request.Builder()
                .url("https://github.com/login/oauth/access_token")
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            String string =  response.body().string();
            String[] split = string.split("&");
            String tokenstr = split[0];
            String token = tokenstr.split("=")[1];
//            System.out.println("token是"+token+"string是"+string);
            return token;
        } catch (Exception e) {
            System.out.println("异常");
            e.printStackTrace();
        }
        return null;
    }

    public GithubUser getuser(String accesstoken){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://api.github.com/user")
                .header("Authorization","token "+accesstoken)
                .build();
        try{
            Response response = client.newCall(request).execute();
            String string =  response.body().string();
            //string的json对象自动转化成类对象
            //fastjson自动把下划线标识映射到驼峰的属性
            GithubUser githubUser = JSON.parseObject(string, GithubUser.class);
            return githubUser;
        } catch (IOException e) {
            System.out.println("获取用户异常");
        }
        return null;
    }

}
