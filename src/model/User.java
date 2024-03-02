package model;

public class User {
    private Long id;
    private String email;
    private String password;
    private String fulName;

    public User(){

    }
    public User(Long id, String email, String password, String fulName) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.fulName = fulName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFulName() {
        return fulName;
    }

    public void setFulName(String fulName) {
        this.fulName = fulName;
    }
}
