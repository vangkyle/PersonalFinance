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
<!--
<script type="text/javascript" class="init">
    $(document).ready( function () {
        $("input[name$='entryType']").click(function() {
            var test = $(this).val();

            $("div")
        })
    } );
</script>
-->


<html>
    <head>
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
                            <option></option>
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
