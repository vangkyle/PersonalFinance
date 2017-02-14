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
    <div class="container">
        <h2>Sign Up</h2>
        <form action="/" class="form-horizontal">
            <div class="form-group">
                <label class="control-label col-sm-2" for="signUpFirstName">First Name: </label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="signUpFirstName" placeholder="Enter first name">
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-2" for="signUpLastName">Last Name: </label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="signUpLastName" placeholder="Enter last name">
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-2" for="signUpEmail">Email Address: </label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="signUpEmail" placeholder="Enter email">
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-2" for="signUpPassword">Password: </label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="signUpPassword" placeholder="Enter password">
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-2" for="signUpReEnterPassword">Re-Enter Password: </label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="signUpReEnterPassword" placeholder="Re-Enter password">
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <button type="button" name="submit" value="submit" class="btn btn-primary">Submit</button>
                    <button type="reset" name="clear" value="reset" class="btn btn-primary">Clear</button>
                </div>
            </div>
        </form>
    </div>
</body>
</html>
