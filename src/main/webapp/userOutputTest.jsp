<%--
  Created by IntelliJ IDEA.
  User: kvang
  Date: 3/2/17
  Time: 6:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="taglib.jsp"%>
<c:set var="title" value="User Output" />
<%@include file="head.jsp"%>

<script>
    $(document).ready(function(){
        $('#userResults').DataTable();
    });
</script>

<html>
    <body>
    <div>
        <h2>Users results: </h2>
        <table id="userResults" class="display" cellspacing="0" width="100%">
                <thead>
                <th>User ID</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Email</th>
                <th>Username</th>
                <th>Password</th>
                </thead>
                <tbody>
                <c:forEach var="user" items="${user}">
                    <tr>
                        <td>${user.userid}</td>
                        <td>${user.firstName}</td>
                        <td>${user.lastName}</td>
                        <td>${user.email}</td>
                        <td>${user.userName}</td>
                        <td>${user.userPass}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
    </body>
</html>