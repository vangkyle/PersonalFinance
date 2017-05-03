package edu.matc.personalfinance.controller;

import edu.matc.personalfinance.entity.User;
import edu.matc.personalfinance.persistence.TransactionRecordDao;
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
 * Created by kvang on 5/1/17.
 */
@WebServlet (
        name = "Dashboard",
        urlPatterns = {"/dashboard"}
)
public class Dashboard extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();

        if (session.getAttribute("transaction") != null) {
            session.setAttribute("transaction", null);
        }

        TransactionRecordDao transactionRecordDao = new TransactionRecordDao();
        UserDao userDao = new UserDao();
        User user = new User();

        user = userDao.getUser(user.getUserid());

        session.setAttribute("transaction", transactionRecordDao.getTransaction(user.getUserid()));

        RequestDispatcher dispatcher = req.getRequestDispatcher("/dashboard.jsp");
        dispatcher.forward(req, resp);
    }
}
