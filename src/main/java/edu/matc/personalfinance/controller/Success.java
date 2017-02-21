package edu.matc.personalfinance.controller;

import org.apache.log4j.Logger;

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
    }
}
