package town.guitar.community.dto;

import lombok.Data;
import town.guitar.community.model.User;

@Data
public class NotificationDTO {
    private Long id;
    private Integer status;
    private Long gmtCreate;
    private Long notifier;
    private String notifierName;
    private String outerTitle;
    private Long outerid;
    private String typeName;
    private Integer type;

}


