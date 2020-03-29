package town.guitar.community.enums;

public enum NotificationEnum {
    REPLY_POST(1,"回复了帖子"),
    REPLY_COMMENT(2,"回复了评论"),
    ;

    public int getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    private int type;
    private String name;
    NotificationEnum(int type, String name) {
        this.type = type;
        this.name = name;
    }
}
