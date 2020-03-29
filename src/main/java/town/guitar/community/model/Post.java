package town.guitar.community.model;

public class Post {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column POST.ID
     *
     * @mbg.generated Wed Mar 25 22:07:46 GMT+08:00 2020
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column POST.TITLE
     *
     * @mbg.generated Wed Mar 25 22:07:46 GMT+08:00 2020
     */
    private String title;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column POST.CONTENT
     *
     * @mbg.generated Wed Mar 25 22:07:46 GMT+08:00 2020
     */
    private String content;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column POST.GMT_CREATE
     *
     * @mbg.generated Wed Mar 25 22:07:46 GMT+08:00 2020
     */
    private Long gmtCreate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column POST.GMT_MODIFIED
     *
     * @mbg.generated Wed Mar 25 22:07:46 GMT+08:00 2020
     */
    private Long gmtModified;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column POST.CREATOR
     *
     * @mbg.generated Wed Mar 25 22:07:46 GMT+08:00 2020
     */
    private Long creator;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column POST.COMMENT_COUNT
     *
     * @mbg.generated Wed Mar 25 22:07:46 GMT+08:00 2020
     */
    private Integer commentCount;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column POST.VIEW_COUNT
     *
     * @mbg.generated Wed Mar 25 22:07:46 GMT+08:00 2020
     */
    private Integer viewCount;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column POST.LIKE_COUNT
     *
     * @mbg.generated Wed Mar 25 22:07:46 GMT+08:00 2020
     */
    private Integer likeCount;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column POST.TAG
     *
     * @mbg.generated Wed Mar 25 22:07:46 GMT+08:00 2020
     */
    private String tag;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column POST.ID
     *
     * @return the value of POST.ID
     *
     * @mbg.generated Wed Mar 25 22:07:46 GMT+08:00 2020
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column POST.ID
     *
     * @param id the value for POST.ID
     *
     * @mbg.generated Wed Mar 25 22:07:46 GMT+08:00 2020
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column POST.TITLE
     *
     * @return the value of POST.TITLE
     *
     * @mbg.generated Wed Mar 25 22:07:46 GMT+08:00 2020
     */
    public String getTitle() {
        return title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column POST.TITLE
     *
     * @param title the value for POST.TITLE
     *
     * @mbg.generated Wed Mar 25 22:07:46 GMT+08:00 2020
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column POST.CONTENT
     *
     * @return the value of POST.CONTENT
     *
     * @mbg.generated Wed Mar 25 22:07:46 GMT+08:00 2020
     */
    public String getContent() {
        return content;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column POST.CONTENT
     *
     * @param content the value for POST.CONTENT
     *
     * @mbg.generated Wed Mar 25 22:07:46 GMT+08:00 2020
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column POST.GMT_CREATE
     *
     * @return the value of POST.GMT_CREATE
     *
     * @mbg.generated Wed Mar 25 22:07:46 GMT+08:00 2020
     */
    public Long getGmtCreate() {
        return gmtCreate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column POST.GMT_CREATE
     *
     * @param gmtCreate the value for POST.GMT_CREATE
     *
     * @mbg.generated Wed Mar 25 22:07:46 GMT+08:00 2020
     */
    public void setGmtCreate(Long gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column POST.GMT_MODIFIED
     *
     * @return the value of POST.GMT_MODIFIED
     *
     * @mbg.generated Wed Mar 25 22:07:46 GMT+08:00 2020
     */
    public Long getGmtModified() {
        return gmtModified;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column POST.GMT_MODIFIED
     *
     * @param gmtModified the value for POST.GMT_MODIFIED
     *
     * @mbg.generated Wed Mar 25 22:07:46 GMT+08:00 2020
     */
    public void setGmtModified(Long gmtModified) {
        this.gmtModified = gmtModified;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column POST.CREATOR
     *
     * @return the value of POST.CREATOR
     *
     * @mbg.generated Wed Mar 25 22:07:46 GMT+08:00 2020
     */
    public Long getCreator() {
        return creator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column POST.CREATOR
     *
     * @param creator the value for POST.CREATOR
     *
     * @mbg.generated Wed Mar 25 22:07:46 GMT+08:00 2020
     */
    public void setCreator(Long creator) {
        this.creator = creator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column POST.COMMENT_COUNT
     *
     * @return the value of POST.COMMENT_COUNT
     *
     * @mbg.generated Wed Mar 25 22:07:46 GMT+08:00 2020
     */
    public Integer getCommentCount() {
        return commentCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column POST.COMMENT_COUNT
     *
     * @param commentCount the value for POST.COMMENT_COUNT
     *
     * @mbg.generated Wed Mar 25 22:07:46 GMT+08:00 2020
     */
    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column POST.VIEW_COUNT
     *
     * @return the value of POST.VIEW_COUNT
     *
     * @mbg.generated Wed Mar 25 22:07:46 GMT+08:00 2020
     */
    public Integer getViewCount() {
        return viewCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column POST.VIEW_COUNT
     *
     * @param viewCount the value for POST.VIEW_COUNT
     *
     * @mbg.generated Wed Mar 25 22:07:46 GMT+08:00 2020
     */
    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column POST.LIKE_COUNT
     *
     * @return the value of POST.LIKE_COUNT
     *
     * @mbg.generated Wed Mar 25 22:07:46 GMT+08:00 2020
     */
    public Integer getLikeCount() {
        return likeCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column POST.LIKE_COUNT
     *
     * @param likeCount the value for POST.LIKE_COUNT
     *
     * @mbg.generated Wed Mar 25 22:07:46 GMT+08:00 2020
     */
    public void setLikeCount(Integer likeCount) {
        this.likeCount = likeCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column POST.TAG
     *
     * @return the value of POST.TAG
     *
     * @mbg.generated Wed Mar 25 22:07:46 GMT+08:00 2020
     */
    public String getTag() {
        return tag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column POST.TAG
     *
     * @param tag the value for POST.TAG
     *
     * @mbg.generated Wed Mar 25 22:07:46 GMT+08:00 2020
     */
    public void setTag(String tag) {
        this.tag = tag == null ? null : tag.trim();
    }
}