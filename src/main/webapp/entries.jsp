<%--
  Created by IntelliJ IDEA.
  User: kvang
  Date: 2/21/17
  Time: 10:07 AM
  To change this template use File | Settings | File Templates.
--%>
<%@include file="taglib.jsp"%>
<c:set var="title" value="Transaction Entry" />
<%@include file="head.jsp"%>

<html>
    <head>
    </head>
    <body>
        <div class="container">
            <h2>Transaction Entry</h2>
            <form action="/dashboard" class="form-horizontal" method="POST">
                <div class="form-group">
                    <label class="control-label col-sm-2" for="date">Date: </label>
                    <div class="col-sm-4">
                        <input type="date" class="form-control" name="date" id="date">
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2" for="amount">Amount: </label>
                    <div class="col-sm-4">
                        <input type="text" class="form-control" name="amount" id="amount" placeholder="0.00"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2" for="category">Category: </label>
                    <div class="col-sm-4">
                        <select class="form-control" name="category" id="category">
                            <option value="Select Category">Select Category</option>
                            <c:forEach var="category" items="${category}">
                                <option value="${category.category_id}">${category.cat_description}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <input type="submit" name="submit" value="submit" class="btn btn-primary"/>
                        <button type="reset" name="clear" value="reset" class="btn btn-primary" action="">Clear</button>
                    </div>
                </div>
            </form>
        </div>
    </body>
</html>
