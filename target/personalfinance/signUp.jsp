<%--
  Created by IntelliJ IDEA.
  User: kvang
  Date: 2/12/17
  Time: 12:07 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="taglib.jsp"%>
<c:set var="title" value="Login Page" />
<%@include file="head.jsp"%>
<html>
<head>
</head>
<body>
<h2>Sign Up</h2>
<form action="/">
    <div>
        <label for="signUpFirstName">First Name: </label>
        <input type="text" id="signUpFirstName" placeholder="Enter first name">
    </div>
    <div>
        <label for="signUpLastName">Last Name: </label>
        <input type="text" id="signUpLastName" placeholder="Enter last name">
    </div>
    <div>
        <label for="signUpEmail">Email Address: </label>
        <input type="text" id="signUpEmail" placeholder="Enter email">
    <div>
        <label for="signUpPassword">Password: </label>
        <input type="text" id="signUpPassword" placeholder="Enter password">
    </div>
    <div>
        <label for="signUpReEnterPassword">Re-Enter Password: </label>
        <input type="text" id="signUpReEnterPassword" placeholder="Re-Enter password">
    </div>
    <button type="button" name="submit" value="submit">Submit</button>
    <button type="button" name="clear" value="clear">Clear</button>
</form>
</body>
</html>
