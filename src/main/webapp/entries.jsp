<%--
  Created by IntelliJ IDEA.
  User: kvang
  Date: 2/21/17
  Time: 10:07 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="taglib.jsp"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<c:set var="title" value="Transaction Entry" />
<%@include file="head.jsp"%>

<html>
    <head>
        <script>
            $(document).ready(function() {
                $('#expenseCat').change(function(event) {
                    var expenses = $("select #expenseCat").val();
                    $.get('CategoryListJson', {
                            categoryName : expenses
                    }, function(response) {
                        var select = $('#expenseSubcat');
                        select.find('option').remove();
                            $.each(response, function(index, value) {
                                console.log($('<option>').val(value).text(value).appendTo(select));
                            });
                    });
                });

            });
        </script>
    </head>
    <body>
        <div class="container">
            <h2>Transaction Entry</h2>
            <form action="categoryListJson" class="form-horizontal">
                <div class="form-group">
                    <label class="control-label col-sm-2" for="date">Date: </label>
                    <div class="col-sm-10">
                        <input type="date" class="form-control" name="date" id="date">
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2" for="entryType">Entry type: </label>
                    <div class="col-sm-10">
                        <input type="radio" class="radio-inline" name="entryType" id="entryType" value="Expense" checked> Expense
                        <input type="radio" class="radio-inline" name="entryType" id="entryType" value="Income"> Income
                    </div>
                </div>
                <div class="form-group" name="incomeCat">
                    <label class="control-label col-sm-2" for="incomeCat">Category: </label>
                    <div class="col-sm-2">
                        <select class="form-control" name="incomeCat" id="incomeCat">
                            <option></option>
                        </select>
                    </div>
                </div>
                <div class="form-group" name="expenseCat">
                    <label class="control-label col-sm-2" for="expenseCat">Category: </label>
                    <div class="col-sm-2">
                        <select class="form-control" name="expenseCat" id="expenseCat">
                            <option>Select Category</option>
                            <option value="Automobile">Automobile</option>
                            <option value="Bank Charges">Bank Charges</option>
                            <option value="Charity">Charity</option>
                            <option value="Childcare">Childcare</option>
                            <option value="Clothing">Clothing</option>
                            <option value="Credit Card Fees">Credit Card Fees</option>
                            <option value="Education">Education</option>
                            <option value="Events">Events</option>
                            <option value="Food">Food</option>
                            <option value="Gifts">Gifts</option>
                            <option value="Healthcare">Healthcare</option>
                            <option value="Household">Household</option>
                            <option value="Insurance">Insurance</option>
                            <option value="Job Expenses">Job Expenses</option>
                            <option value="Leisure (daily/non-vacation)">Leisure (daily/non-vacation)</option>
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
                <div class="form-group" name="expenseSubcat">
                    <label class="control-label col-sm-2" for="expenseSubcat">Subcategories: </label>
                    <div class="col-sm-2">
                        <select class="form-control" name="expenseSubcat" id="expenseSubcat">
                            <option>Select Subcategory</option>
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
