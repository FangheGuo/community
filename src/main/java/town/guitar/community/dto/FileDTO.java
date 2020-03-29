package town.guitar.community.dto;

import lombok.Data;

@Data
public class FileDTO {
    private Integer success;
    private String url;
    private String message;

    public FileDTO(String url){
        if(url != null){
            this.success = 1;
            this.url = url;
            this.message = "上传成功";
        }
        else {
            this.success = 0;
            this.message = "上传失败";
        }
    }
}
