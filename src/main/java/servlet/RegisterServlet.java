package servlet;

import dao.DBConnector;
import dao.UserDAO;
import dao.UserDAOImpl;
import entity.User;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class RegisterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("/view/register-page.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String login = req.getParameter("login");
        String pass = req.getParameter("pass");
        String email = req.getParameter("email");
        String name = req.getParameter("name");


        UserService us = new UserService();
        us.addUser(new User(login, pass, name, email));

        req.getSession().setAttribute("login", login);
        req.getSession().setAttribute("authorized", "true");

        resp.sendRedirect("/list");
        return;
    }
}
