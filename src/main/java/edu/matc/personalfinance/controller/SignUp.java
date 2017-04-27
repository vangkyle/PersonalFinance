package edu.matc.personalfinance.controller;

import edu.matc.personalfinance.persistence.UserDao;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by kvang on 2/20/17.
 */

@WebServlet (
        urlPatterns = {"/signup"}
)
public class SignUp extends HttpServlet {

    private final Logger logger = Logger.getLogger(this.getClass());

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        RequestDispatcher dispatcher = req.getRequestDispatcher("/signUp.jsp");
        dispatcher.forward(req, resp);

    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String firstName = req.getParameter("signUpFirstName");
        String lastName = req.getParameter("signUpLastName");
        String email = req.getParameter("signUpEmail");
        String username = req.getParameter("signUpUsername");
        String password = req.getParameter("signUpPassword");

            try {
                UserDao dao = new UserDao();
                //dao.addUserFromSignUp(firstName, lastName, email, username, password);
                logger.info("The dao is working?" + dao);
                logger.debug(dao.addUserFromSignUp(firstName, lastName, email, username, password));
                resp.sendRedirect("/success");
            } catch (Exception e) {
                logger.error("Exception: " + e);
            }

    }
}
