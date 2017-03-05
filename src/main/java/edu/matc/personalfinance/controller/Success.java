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
import java.io.PrintWriter;

/**
 * Created by kvang on 2/21/17.
 */
@WebServlet (
        urlPatterns = {"/success"}
)
public class Success extends HttpServlet {

    private Logger logger = Logger.getLogger(this.getClass());

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        /*
        String firstName = req.getParameter("signUpFirstName");
        String lastName = req.getParameter("signUpLastName");
        String email = req.getParameter("signUpEmail");
        String username = req.getParameter("signUpUsername");
        String password = req.getParameter("signUpPassword");

        try {
            UserDao dao = dao.getAllUsers();
        } catch (Exception e) {
            logger.error("Exception" + e);
        }
        */

        UserDao dao = new UserDao();
        logger.info(dao);
        //dao.getAllUsers();
        //logger.info(dao.getAllUsers());
        req.setAttribute("users", dao.getAllUsers());
        //logger.info(req);

        String url = "/userOutputTest.jsp";

        RequestDispatcher dispatcher = req.getRequestDispatcher(url);
        dispatcher.forward(req, resp);

        /*
        resp.setContentType("text/html");

        PrintWriter writer = resp.getWriter();

        logger.info(writer);
        logger.info("THis is working");

        writer.println("" + "" + "<center>"
                + "User Added Successfully" + "</center>" + ""
                + "");

        writer.println("<button onclick=\"goBack()\">Go Back</button>");
        writer.print("<script>");
        writer.print("function goBack() {");
        writer.print("window.history.back()");
        writer.print("}");
        writer.print("</script>");
        writer.close();
        */
    }
}
