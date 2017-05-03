package edu.matc.personalfinance.controller;

import edu.matc.personalfinance.entity.Category;
import edu.matc.personalfinance.entity.TransactionRecord;
import edu.matc.personalfinance.entity.User;
import edu.matc.personalfinance.persistence.CategoryDao;
import edu.matc.personalfinance.persistence.TransactionRecordDao;
import edu.matc.personalfinance.persistence.UserDao;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by kvang on 4/29/17.
 */
@WebServlet (
        name = "ExpenseEntry",
        urlPatterns = {"/expenseEntry"}
)
public class ExpenseEntry extends HttpServlet {

    private final Logger logger = Logger.getLogger(this.getClass());
    private CategoryDao categoryDao = null;
    private Category category = null;
    private UserDao userDao = null;
    private User user = new User();

    int newUser = 0;
    int newCat = 0;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();

        if (session.getAttribute("category") != null) {
            session.setAttribute("category", null);
        }

        categoryDao = new CategoryDao();

        session.setAttribute("category", categoryDao.getAllCategory());

        RequestDispatcher dispatcher = req.getRequestDispatcher("/entries.jsp");
        dispatcher.forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        req.getRequestDispatcher("entries.jsp").include(req, resp);

        String dateString = req.getParameter("date");
        String amountString = req.getParameter("amount");
        String categoryString = req.getParameter("expenseCat");

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

        try {
            Date date = formatter.parse(dateString);
            double amount = Double.parseDouble(amountString);

            TransactionRecordDao transactionRecordDao = new TransactionRecordDao();
            TransactionRecord transactionRecord = new TransactionRecord();
            transactionRecord.setAmount(amount);
            transactionRecord.setDate(date);
            transactionRecord.setUser(userDao.getUser(user.getUserid()));
            transactionRecord.setCategory(categoryDao.getCategory(category.getCategory_id()));

            logger.info("date: " + transactionRecord.getDate());
            logger.info("amount: " + transactionRecord.getAmount());
            logger.info("date: " + transactionRecord.getDate());
            logger.info("user id: " + transactionRecord.getUser());
            logger.info("category id: " + transactionRecord.getCategory());

            transactionRecordDao.addTransactionRecord(transactionRecord);
            resp.sendRedirect("/dashboard.jsp");
        } catch (ParseException pe) {
            logger.error("Parse Exception for date format: " + pe);
        } catch (Exception e) {
            logger.error("Exception in ExpenseEntry Class: " + e);
        }
    }

}
