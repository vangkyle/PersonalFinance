<%--
  Created by IntelliJ IDEA.
  User: kvang
  Date: 2/11/17
  Time: 11:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="taglib.jsp"%>
<c:set var="title" value="Login Page" />
<%@include file="head.jsp"%>
<html>
    <body>
        <h2>Sign In</h2>
        <form action="sign">
            <div>
                <label for="signInEmail">Email: </label>
                <input type="text" id="signInEmail" placeholder="Enter email">
            </div>
            <div>
                <label for="signInPassword">Password: </label>
                <input type="text" id="signInPassword" placeholder="Enter password">
            </div>
            <button type="button" name="submit" value="submit">Submit</button>
            <button type="button" name="clear" value="clear">Clear</button>
        </form>
</body>
</html>
