<%--
  Created by IntelliJ IDEA.
  User: kvang
  Date: 4/16/17
  Time: 3:59 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="taglib.jsp"%>
<c:set var="title" value="Dashboard" />
<%@include file="head.jsp"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="row">
    <div class="col-md-4">?? AREA</div>
    <div class="col-md-4">
        <h2><Strong>Users Transactions: </Strong></h2>
        <table id="userTransactions" class="display" cellspacing="0" width="100%">
            <thead>
            <th>Date</th>
            <th>Amount</th>
            <th>Category</th>
            </thead>
            <tbody>
            <c:forEach var="transaction" items="${transaction}">
                <tr>
                    <td>${transaction}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <div class="col-md-4">PIE CHART</div>
</div>
</body>
</html>
