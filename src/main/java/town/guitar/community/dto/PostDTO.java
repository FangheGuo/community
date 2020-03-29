package town.guitar.community.dto;

import lombok.Data;
import town.guitar.community.model.User;

@Data
public class PostDTO {
    private Long id;
    private String title;
    private String content;
    private String tag;
    private Long gmtCreate;
    private Long gmtModified;
    private Integer commentCount;
    private Integer viewCount;
    private Integer likeCount;
    private long creator;
    private User user;

}
