package town.guitar.community.dto;

import lombok.Data;

@Data
public class PostQueryDTO {
    private String search;
    private Integer size;
    private Integer page;
}
