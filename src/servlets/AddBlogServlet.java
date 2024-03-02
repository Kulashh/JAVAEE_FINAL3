package servlets;

import db.DBManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Blog;
import model.User;

import java.io.IOException;

@WebServlet(value = "/addBlog")
public class AddBlogServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("ONLINE_USER");
        if (user != null) {
            req.getRequestDispatcher("addblogpage.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher("404.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getParameter("title");
        String text = req.getParameter("content");

        User user = (User) req.getSession().getAttribute("ONLINE_USER");

        Blog blog = new Blog();
        blog.setTitle(title);
        blog.setContent(text);
        blog.setUser(user);

        DBManager.addBlog(blog);
        resp.sendRedirect("/home");
    }
}
