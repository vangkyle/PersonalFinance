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
        <div class="container">
            <h2>Login</h2>
            <form action="login" class="form-horizontal">
                <div class="form-group">
                    <label class="control-label col-sm-2" for="signInUsername">Username: </label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="signInUsername" placeholder="Username">
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2" for="signInPassword">Password: </label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="signInPassword" placeholder="Password">
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
