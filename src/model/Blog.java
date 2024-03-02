package model;

import java.sql.Timestamp;

public class Blog {
    private Long id;
    private User user;
    private String title;
    private String content;
    private Timestamp postData;
    public Blog(){

    }

    public Blog(Long id, User user, String title, String content, Timestamp postData) {
        this.id = id;
        this.user = user;
        this.title = title;
        this.content = content;
        this.postData = postData;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getPostData() {
        return postData;
    }

    public void setPostData(Timestamp postData) {
        this.postData = postData;
    }
}
