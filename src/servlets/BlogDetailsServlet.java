package servlets;

import db.DBManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Blog;

import java.io.IOException;

@WebServlet(value = "/blogDetails")
public class BlogDetailsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Blog blog = DBManager.getBlogById(Long.parseLong(id));
        req.setAttribute("blogDetails", blog);
        req.getRequestDispatcher("blogDetails.jsp").forward(req,resp);
    }
}
