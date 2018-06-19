package cn.jastz.post.entity;

import java.util.Date;

public class PostComment {
    private Integer commentId;

    private String appId;

    private Integer postId;

    private Integer commentAuthor;

    private Integer commentAuthorIp;

    private String commentAuthorEmail;

    private String commentAuthorUrl;

    private Integer commentParent;

    private Date createdTime;

    private Date updatedTime;

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId == null ? null : appId.trim();
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public Integer getCommentAuthor() {
        return commentAuthor;
    }

    public void setCommentAuthor(Integer commentAuthor) {
        this.commentAuthor = commentAuthor;
    }

    public Integer getCommentAuthorIp() {
        return commentAuthorIp;
    }

    public void setCommentAuthorIp(Integer commentAuthorIp) {
        this.commentAuthorIp = commentAuthorIp;
    }

    public String getCommentAuthorEmail() {
        return commentAuthorEmail;
    }

    public void setCommentAuthorEmail(String commentAuthorEmail) {
        this.commentAuthorEmail = commentAuthorEmail == null ? null : commentAuthorEmail.trim();
    }

    public String getCommentAuthorUrl() {
        return commentAuthorUrl;
    }

    public void setCommentAuthorUrl(String commentAuthorUrl) {
        this.commentAuthorUrl = commentAuthorUrl == null ? null : commentAuthorUrl.trim();
    }

    public Integer getCommentParent() {
        return commentParent;
    }

    public void setCommentParent(Integer commentParent) {
        this.commentParent = commentParent;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }
}