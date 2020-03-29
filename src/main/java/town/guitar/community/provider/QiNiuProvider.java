package town.guitar.community.provider;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.io.InputStream;

@Service
public class QiNiuProvider {
    //...生成上传凭证，然后准备上传
    @Value("${qiniu.file.AccessKey}")
    private String accessKey;
    @Value("${qiniu.file.SecretKey}")
    private String secretKey;
    @Value("${qiniu.file.bucket}")
    private String bucket;

    private String path = "http://q7vvgn2n4.bkt.clouddn.com";


    /**
     * 将图片上传到七牛云
     */
    public String uploadQNImg(InputStream file, String key) {
        //构造一个带指定Region对象的配置类
        Configuration cfg = new Configuration(Region.huabei());
        //...其他参数参考类注释
        UploadManager uploadManager = new UploadManager(cfg);

        try {
            Auth auth = Auth.create(accessKey, secretKey);
            String upToken = auth.uploadToken(bucket);
            try {
                Response response = uploadManager.put(file, key, upToken, null, null);
                // 解析上传成功的结果
                DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
                long expireInSeconds = 3600;
                //1小时，可以自定义链接过期时间
                String finalUrl = auth.privateDownloadUrl(path + "/" + putRet.key, expireInSeconds);
                return finalUrl;
            } catch (QiniuException ex) {
                Response r = ex.response;
                System.err.println(r.toString());
                try {
                    System.err.println(r.bodyString());
                } catch (QiniuException ex2) {
                    //ignore
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }


}
