package edu.matc.personalfinance.controller;

import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kvang on 4/27/17.
 */
@WebServlet(
        urlPatterns = {"/categoryListJson"}
)
public class CategoryListJson extends HttpServlet {


    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String categoryName = req.getParameter("categoryName");
        List<String> list = new ArrayList<String>();
        String json = null;

        if (categoryName.equals("Automobile")) {
            list.add("Gasoline");
            list.add("Maintenance");
            list.add("Registration fees");
            list.add("Auto loan payment");
        } else if (categoryName.equals("Bank Charges")) {
            list.add("Check orders");
            list.add("Service fees");
            list.add("Insufficient funds fee");
            list.add("Minimum balance fee");
            list.add("ATM fees");
        } else if (categoryName.equals("Charity")) {
            list.add("Church");
            list.add("Non-profit");
        } else if (categoryName.equals("Childcare")) {
            list.add("Babysitting");
            list.add("Child support");
        } else if (categoryName.equals("Clothing")) {
            list.add("");
        } else if (categoryName.equals("Credit Card Fees")) {
            list.add("Annual fee");
            list.add("Finance charge");
            list.add("Over the limit fee");
            list.add("Minimum usage fee");
            list.add("Cash advance fee");
            list.add("Late fee");
            list.add("Rewards programs");
            list.add("Monthly payment");
        } else if (categoryName.equals("Education")) {
            list.add("Tuition");
            list.add("Books");
            list.add("School supplies");
            list.add("Field trips");
            list.add("Misc. fees");
            list.add("Student loan payment");
        } else if (categoryName.equals("Events")) {
            list.add("Wedding");
            list.add("Moving");
        } else if (categoryName.equals("Food")) {
            list.add("Groceries");
            list.add("Dining out");
            list.add("Vending machines");
        } else if (categoryName.equals("Gifts")) {
            list.add("Birthday");
            list.add("Wedding/Wedding shower");
            list.add("Baby shower");
            list.add("Holiday");
            list.add("Anniversary");
            list.add("Just because");
        } else if (categoryName.equals("Healthcare")) {
            list.add("Dental");
            list.add("Vision");
            list.add("Physician");
            list.add("Hospital");
            list.add("Prescription meds");
            list.add("Over the counter meds");
            list.add("Vitamins");
        } else if (categoryName.equals("Household")) {
            list.add("Rent/Mortgage payment");
            list.add("Homeowner's association dues");
            list.add("Furniture");
            list.add("Supplies");
            list.add("Decorating");
            list.add("Tools");
            list.add("Home maintenance and repair");
            list.add("Home improvement");
        } else if (categoryName.equals("Insurance")) {
            list.add("Automobile");
            list.add("Health");
            list.add("Life");
            list.add("Disability");
            list.add("Long term care");
            list.add("Roadside assistance");
        } else if (categoryName.equals("Job Expenses")) {
            list.add("Reimbursed");
            list.add("Clothing");
            list.add("Professional dues");
        } else if (categoryName.equals("Leisure (daily/non-vacation")) {
            list.add("Books");
            list.add("Magazines");
            list.add("Movie theater");
            list.add("Video rental/Pay per view");
            list.add("Sporting events");
            list.add("Sporting goods");
        } else if (categoryName.equals("Hobbies")) {
            list.add("Cultural events");
            list.add("CD's");
            list.add("Video games");
            list.add("Toys");
            list.add("Tourist attractions");
        } else if (categoryName.equals("Loans")) {
            list.add("Loan payment");
            list.add("Finance charge");
            list.add("Late fee");
        } else if (categoryName.equals("Pet Care")) {
            list.add("Food");
            list.add("Supplies");
            list.add("Veterinarian");
        } else if (categoryName.equals("Savings")) {
            list.add("Retirement");
            list.add("Investments");
            list.add("Emergency fund");
            list.add("Reserve fund");
        } else if (categoryName.equals("Taxes")) {
            list.add("Federal");
            list.add("State");
            list.add("Local");
        } else if (categoryName.equals("Utilities")) {
            list.add("Water");
            list.add("Sewer");
            list.add("Electricity");
            list.add("Gas");
            list.add("Television");
            list.add("Telephone");
            list.add("Internet service");
            list.add("Garbage/Recycling");
        } else if (categoryName.equals("Vacation")) {
            list.add("Day trips");
            list.add("Transportation");
            list.add("Lodging");
            list.add("Entertainment");
        } else if (categoryName.equals("Select Category")) {
            list.add("Select Subcategory");
        }

        json = new Gson().toJson(list);
        resp.setContentType("application/json");
        resp.getWriter().write(json);

        //RequestDispatcher dispatcher = req.getRequestDispatcher("/entries.jsp");
        //dispatcher.forward(req, resp);
    }
}
