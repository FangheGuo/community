package town.guitar.community.controller;

import org.omg.CORBA.BAD_QOS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import town.guitar.community.dto.FileDTO;
import town.guitar.community.provider.KeyUtil;
import town.guitar.community.provider.QiNiuProvider;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;

@Controller
public class FileController {

    @Autowired
    private QiNiuProvider qiNiuProvider;

    @RequestMapping("/file/upload")
    @ResponseBody
    public FileDTO upload(@RequestParam("editormd-image-file") MultipartFile multipartFile) throws IOException {
        InputStream inputStream = multipartFile.getInputStream();
        String originalFilename = multipartFile.getOriginalFilename();
        //获取文件的后缀名
        String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
        String randomName = KeyUtil.genUniqueKey();


        String s = qiNiuProvider.uploadQNImg(inputStream, randomName+suffix);

        FileDTO fileDTO = new FileDTO(s);
        return fileDTO;
    }
}
