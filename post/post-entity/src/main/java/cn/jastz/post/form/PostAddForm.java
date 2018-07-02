package cn.jastz.post.form;

import cn.jastz.post.entity.Post;

import java.util.Date;

/**
 * @author zhiwen
 */
public class PostAddForm {
    private String postTitle;
    private String postContent;
    private String postDescription;
    private int postAuthor;
    private String appId;

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public String getPostDescription() {
        return postDescription;
    }

    public void setPostDescription(String postDescription) {
        this.postDescription = postDescription;
    }

    public String getPostContent() {
        return postContent;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }

    public int getPostAuthor() {
        return postAuthor;
    }

    public void setPostAuthor(int postAuthor) {
        this.postAuthor = postAuthor;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public Post toPost() {
        Post post = new Post();
        post.setCreatedTime(new Date());
        post.setPostAuthor(this.getPostAuthor());
        post.setPostTitle(this.getPostTitle());
        post.setPostDescription(this.getPostDescription());
        post.setPostContent(this.getPostContent());
        post.setAppId(appId);
        return post;
    }
}
