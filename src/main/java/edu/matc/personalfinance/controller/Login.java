package edu.matc.personalfinance.controller;

import edu.matc.personalfinance.entity.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by kvang on 2/11/17.
 */

@WebServlet(
        urlPatterns = {"/login"}
)
public class Login extends HttpServlet {

    User user;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        RequestDispatcher dispatcher = req.getRequestDispatcher("/signIn.jsp");
        dispatcher.forward(req, resp);
    }


    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        req.getRequestDispatcher("/signIn.jsp").include(req, resp);

        String userName = req.getParameter("j_username");
        String userPass = req.getParameter("j_password");

        if (userPass.equals(user.getUserPass())) {
            out.print("Welcome, " + userName);
            HttpSession session = req.getSession();
            session.setAttribute("userName", userName);
        } else {
            out.print("Sorry, username or password does not match!");
            req.getRequestDispatcher("/signIn.jsp").include(req, resp);
        }
        out.close();
    }

}
