package edu.matc.personalfinance.controller;

import edu.matc.personalfinance.persistence.UserDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by kvang on 2/21/17.
 */
@WebServlet (
        name = "/Success",
        urlPatterns = {"/success"}
)
public class Success extends HttpServlet {


    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();

        if (session.getAttribute("user") != null) {
            session.setAttribute("user", null);
        }

        UserDao dao = new UserDao();

        session.setAttribute("user", dao.getAllUsers());

        RequestDispatcher dispatcher = req.getRequestDispatcher("/userOutputTest.jsp");
        dispatcher.forward(req, resp);

    }
}
