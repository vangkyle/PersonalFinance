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
        <form action="signup" class="form-horizontal" method="post">
            <div class="form-group">
                <label class="control-label col-sm-2" for="signUpFirstName">First Name: </label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" name="signUpFirstName" id="signUpFirstName" placeholder="First Name">
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-2" for="signUpLastName">Last Name: </label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" name="signUpLastName" id="signUpLastName" placeholder="Last Name">
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-2" for="signUpEmail">Email Address: </label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" name="signUpEmail" id="signUpEmail" placeholder="Email">
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-2" for="signUpUsername">Username: </label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" name="signUpUsername" id="signUpUsername" placeholder="Username">
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-2" for="signUpPassword">Password: </label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" name="signUpPassword" id="signUpPassword" placeholder="Password">
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-2" for="signUpReEnterPassword">Re-Enter Password: </label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" name="signUpReEnterPassword" id="signUpReEnterPassword" placeholder="Re-Enter Password">
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <input type="submit" name="submit" value="submit" class="btn btn-primary"/>
                    <button type="reset" name="clear" value="reset" class="btn btn-primary">Clear</button>
                </div>
            </div>
        </form>
    </div>
</body>
</html>
