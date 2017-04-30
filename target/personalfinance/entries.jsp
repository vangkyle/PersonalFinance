<%@ page import="java.sql.*" %>
<%--
  Created by IntelliJ IDEA.
  User: kvang
  Date: 2/21/17
  Time: 10:07 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="taglib.jsp"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<c:set var="title" value="Transaction Entry" />
<%@include file="head.jsp"%>

<html>
    <head>
        <!--
        <script>
            $(document).ready(function() {
                $('#expenseCat').change(function(event) {
                    var expenses = $("select #expenseCat").val();
                    $.get('CategoryListJson', {
                            categoryName : expenses
                    }, function(response) {
                        var select = $('#expenseSubcat');
                        select.find('option').remove();
                            $.each(response, function(index, value) {
                                console.log($('<option>').val(value).text(value).appendTo(select));
                            });
                    });
                });

            });
        </script>
        -->
    </head>
    <body>
        <!-- Database credentials -->
        <%! String driverName = "com.mysql.jdbc.Driver";%>
        <%! String url = "jdbc:mysql://localhost:3306/financetracker";%>
        <%! String user = "root";%>
        <%! String psw = "frances88";%>
        
        <div class="container">
            <h2>Transaction Entry</h2>
            <form action="categoryListJson" class="form-horizontal">
                <div class="form-group">
                    <label class="control-label col-sm-2" for="date">Date: </label>
                    <div class="col-sm-4">
                        <input type="date" class="form-control" name="date" id="date">
                    </div>
                </div>
                <div class="form-group" name="amount">
                    <label class="control-label col-sm-2" for="amount">Amount: </label>
                    <div class="col-sm-4">
                        <input type="text" class="form-control" id="amount" placeholder="0.00"/>
                    </div>
                </div>
                <div class="form-group" name="expenseCat">
                    <%
                        Connection con = null;
                        PreparedStatement ps = null;
                        
                        try {
                            Class.forName(driverName);
                            con = DriverManager.getConnection(url,user,psw);
                            String sql = "SELECT cat_description FROM category";
                            ps = con.prepareStatement(sql);
                            ResultSet rs = ps.executeQuery();
                    %>
                            <label class="control-label col-sm-2" for="expenseCat">Category: </label>
                            <div class="col-sm-4">
                                <select class="form-control" name="expenseCat" id="expenseCat">
                                    <option value="Select Category">Select Category</option>
                            <%
                                while(rs.next()) {
                                    String cat_desc = rs.getString("cat_description");
                            %>
                                    <option value="<%=cat_desc %>"><%=cat_desc %></option>
                            <%
                                }
                            %>
                                </select>
                            <%
                                } catch (SQLException sqle) {
                                    out.println(sqle);
                                }
                            %>
                    </div>
                </div>
                <div class="form-group" name="expenseSubcat">
                    <%
                        try {
                            Class.forName(driverName);
                            con = DriverManager.getConnection(url,user,psw);
                            String sql2 = "SELECT subcat_description FROM subcategory JOIN category ON subcategory.category = category.category_id;";
                            ps = con.prepareStatement(sql2);
                            ResultSet rs = ps.executeQuery();
                    %>
                            <label class="control-label col-sm-2" for="expenseSubcat">Subcategories: </label>
                            <div class="col-sm-4">
                                <select class="form-control" name="expenseSubcat" id="expenseSubcat">
                                    <option>Select Subcategory</option>
                    <%
                            while (rs.next()) {
                                String subcat_desc = rs.getString("subcat_description");

                    %>
                                    <option value="<%=subcat_desc %>"><%=subcat_desc %></option>
                    <%
                            }
                    %>
                            </select>
                    <%
                        } catch (SQLException sqle) {
                            out.println(sqle);
                        }
                    %>
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
