<%--
  Created by IntelliJ IDEA.
  User: kvang
  Date: 2/21/17
  Time: 10:07 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="taglib.jsp"%>
<c:set var="title" value="Transaction Entry" />
<%@include file="head.jsp"%>


<html>
    <head>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <script>

        </script>
    </head>
    <body>
        <div class="container">
            <h2>Transaction Entry</h2>
            <form action="entry" class="form-horizontal">
                <div class="form-group">
                    <label class="control-label col-sm-2" for="date">Date: </label>
                    <div class="col-sm-10">
                        <input type="date" class="form-control" name="date" id="date">
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2" for="entryType">Entry type: </label>
                    <div class="col-sm-10">
                        <input type="radio" class="radio-inline" name="entryType" id="entryType" value="Expense"> Expense
                        <input type="radio" class="radio-inline" name="entryType" id="entryType" value="Income"> Income
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2" for="category">Category: </label>
                    <div class="col-sm-2">
                        <select class="form-control" name="category" id="category">
                            <option value="Income">Income</option>
                            <option value="Automobile">Automobile</option>
                            <option value="Bank Charges">Bank Charges</option>
                            <option value="Charity">Charity</option>
                            <option value="Clothing">Clothing</option>
                            <option value="Credit Card Fees">Credit Card Fees</option>
                            <option value="Education">Education</option>
                            <option value="Events">Events</option>
                            <option value="Food">Food</option>
                            <option value="Gifts">Gifts</option>
                            <option value="Healthcare">Healthcare</option>
                            <option value="Household">Household</option>
                            <option value="Insurance">Insurance</option>
                            <option value="Job expenses">Job expenses</option>
                            <option value="Leisure">Leisure (daily / non-vacation)</option>
                            <option value="Hobbies">Hobbies</option>
                            <option value="Loans">Loans</option>
                            <option value="Pet Care">Pet Care</option>
                            <option value="Savings">Savings</option>
                            <option value="Taxes">Taxes</option>
                            <option value="Utilities">Utilities</option>
                            <option value="Vacation">Vacation</option>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="button" name="submit" value="submit" class="btn btn-primary">Submit</button>
                        <button type="reset" name="clear" value="reset" class="btn btn-primary" action="">Clear</button>
                    </div>
                </div>
            </form>
        </div>
    </body>
</html>
