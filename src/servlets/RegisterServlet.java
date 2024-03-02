package servlets;

import db.DBManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;

import java.io.IOException;

@WebServlet(value = "/register")

public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("register.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String repeatPassword = req.getParameter("repeatPassword");
        String fullName = req.getParameter("fullName");


        User user = DBManager.getUser(username);
        if (user == null){
            if (password.equals(repeatPassword)) {
                User user1 = new User();
                user1.setEmail(username);
                user1.setPassword(password);
                user1.setFulName(fullName);
                DBManager.registerUser(user1);
                resp.sendRedirect("/login");
            }
        }else{
            resp.sendRedirect("/register?busy");
        }


    }
}
