package edu.matc.personalfinance.controller;

import edu.matc.personalfinance.entity.User;
import edu.matc.personalfinance.persistence.UserDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kvang on 2/21/17.
 */
@WebServlet (
        urlPatterns = {"/success"}
)
public class Success extends HttpServlet {


    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();

        if (session.getAttribute("user") != null) {
            session.setAttribute("user", null);
        }

        UserDao dao = new UserDao();

        List<User> users = new ArrayList<>();
        users = dao.getAllUsers();

        session.setAttribute("user", users);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/userOutputTest.jsp");
        dispatcher.forward(req, resp);

    }
}
