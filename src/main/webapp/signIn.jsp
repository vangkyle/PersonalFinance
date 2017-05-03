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
    <head>
        <script></script>
    </head>
    <body>
        <div class="container">
            <h2>Login</h2>
            <FORM ACTION="j_security_check" class="form-horizontal" METHOD="post">
                <div class="form-group">
                    <label class="control-label col-sm-2">Username: </label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" name="j_username" placeholder="Username">
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2">Password: </label>
                    <div class="col-sm-10">
                        <input type="password" class="form-control" name="j_password" id="signInPassword" placeholder="Password">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <input type="submit" name="submit" value="Log In" class="btn btn-primary">
                        <button type="reset" name="clear" value="reset" class="btn btn-primary" action="">Clear</button>
                    </div>
                </div>
            </FORM>
            <div class="g-signin2" data-onsuccess="onSignIn"></div>
        </div>
</body>
</html>


