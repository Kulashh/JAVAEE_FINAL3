package model;

import java.sql.Timestamp;

public class Comments {
    Long id;
    String text;
    Blog blog;
    User user;
    Timestamp postDate;

    public Comments(){

    }
    public Comments(Long id, String text, Blog blog, User user, Timestamp postDate) {
        this.id = id;
        this.text = text;
        this.blog = blog;
        this.user = user;
        this.postDate = postDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Timestamp getPostDate() {
        return postDate;
    }

    public void setPostDate(Timestamp postDate) {
        this.postDate = postDate;
    }
}
