package servlets;

import db.DBManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.User;

import java.io.IOException;

@WebServlet(value = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("signin.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("username");
        String password = req.getParameter("password");

        HttpSession httpSession = req.getSession();

        User user = DBManager.getUser(email);
        if (user!=null && user.getPassword().equals(password)){
            resp.sendRedirect("/profile");
            httpSession.setAttribute("ONLINE_USER",user);
        }else{
            resp.sendRedirect("/login?someerror");
        }
    }
}
