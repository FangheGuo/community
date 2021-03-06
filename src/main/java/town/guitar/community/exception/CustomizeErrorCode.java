package town.guitar.community.exception;


public enum CustomizeErrorCode implements ICustomizeErrorCode{

    POST_NOT_FOUND(2001,"你找的帖子不在了！要不要换一个试试?"),
    TARGET_PARAM__NOT_FOUND(2002,"未选中任何帖子或评论进行回复。"),
    NO_LOGIN(2003,"当前状态未登录，请登录后重试"),
    SYS_ERROR(2004,"服务冒烟了！要不稍后再试试!!!"),
    TYPE_PARAM_WRONG(2005,"评论类型错误或不存在"),
    COMMENT_NOT_FOUND(2006,"你回复的评论不存在了，要不要换一个试试?"),
    CONTENT_IS_EMPTY(2007,"输入内容不能为空"),
    READ_NOTIFICATION_FAIL(2008,"兄弟，你这是读别人信息呢？"),
    NOTIFICATION_NOT_FOUND(2009,"消息莫非是不翼而飞了？")
    ;


    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    private Integer code;
    private String message;

    CustomizeErrorCode(Integer code,String message) {
        this.message = message;
        this.code = code;
    }

}
