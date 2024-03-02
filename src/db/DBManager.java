package db;

import model.Blog;
import model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class DBManager {
    private static Connection connection;

    static {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/SprintTask040Database",
                    "postgres",
                    "postgres");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static User getUser(String email) {
        User user = null;

        try{

            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM users WHERE email = ?");
            preparedStatement.setString(1,email);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                Long id = resultSet.getLong("id");
                String password = resultSet.getString("password");
                String fullName = resultSet.getString("fullName");
                user = new User();
                user.setFulName(fullName);
                user.setPassword(password);
                user.setId(id);
                user.setEmail(email);
            }

            preparedStatement.close();
        }catch (Exception e){
            e.printStackTrace();
        }

        return user;
    }

    public static void registerUser (User user){
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO users (email,password,fullName)" +
                            "VALUES(?,?,?) ");
            preparedStatement.setString(1, user.getFulName());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getFulName());
            int rows = preparedStatement.executeUpdate();
            preparedStatement.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void addBlog (Blog blog){
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO news (title,content,userid,postdate)" +
                            "VALUES(?,?,?,now()) ");
            preparedStatement.setString(1, blog.getTitle());
            preparedStatement.setString(2, blog.getContent());
            preparedStatement.setLong(3, blog.getUser().getId());
            int rows = preparedStatement.executeUpdate();
            preparedStatement.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static List<Blog> getAllBlogs(){
        List<Blog> blogs = new ArrayList<>();
        try{
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT blogs.id, blogs.title, blogs.content, blogs.postdate, users.fullname, users.email " +
                            "FROM blogs " +
                            "INNER JOIN users " +
                            "ON blogs.userid=users.id " +
                            "ORDER BY postdate DESC ");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                Long id = resultSet.getLong("id");
                String title = resultSet.getString("title");
                String text = resultSet.getString("content");
                Timestamp postdate = resultSet.getTimestamp("postdate");
                String userFullName = resultSet.getString("fullname");
                String email = resultSet.getString("email");

                User user = new User();
                user.setFulName(userFullName);
                user.setEmail(email);


                Blog blog = new Blog();
                blog.setId(id);
                blog.setTitle(title);
                blog.setContent(text);
                blog.setPostData(postdate);
                blog.setUser(user);

                blogs.add(blog);
            }
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return blogs;
    }
    public static Blog getBlogById(Long id){
        Blog blog = null;
        try{
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT blogs.title, blogs.content, blogs.postdate, users.fullname, users.email" +
                            "FROM blogs " +
                            "INNER JOIN users " +
                            "ON blogs.userid=users.id " +
                            "WHERE blogs.id=?");
            statement.setLong(1,id);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){

                String title = resultSet.getString("title");
                String text = resultSet.getString("content");
                Timestamp postdate = resultSet.getTimestamp("postdate");
                String userFullName = resultSet.getString("fullname");
                String email = resultSet.getString("email");

                User user = new User();
                user.setFulName(userFullName);
                user.setEmail(email);

                blog.setId(id);
                blog.setTitle(title);
                blog.setContent(text);
                blog.setPostData(postdate);
                blog.setUser(user);
            }
            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }
        return blog;
    }
}
