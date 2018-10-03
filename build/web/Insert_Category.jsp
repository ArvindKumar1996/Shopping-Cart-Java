<%-- 
    Document   : Insert_Category
    Created on : Jul 11, 2018, 1:50:05 PM
    Author     : Arvind Kumar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <title>Insert_Category</title>
    </head>
    <body>
                        <%@page import="java.net.*" %>
                        <%@page import="java.io.*" %>
                        <%@page import="java.sql.*" %>
                        
                        <%
                            Connection con=null;
                            Statement stat=null;
                            ResultSet rs=null;
                            String query=null;
                            int ctr=0, flag=0;
                            try{
                                Class.forName("oracle.jdbc.driver.OracleDriver");
                                con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","cart","root");
                                stat=con.createStatement();
                                query="Select* from category_details";
                                rs=stat.executeQuery(query);
                                %>
        <section>
            <div class="container">
                <div class="row">
                    <div class="col-sm-3"></div>
                    <div class="col-sm-6">
                        <h2 class="text-center"><u>Administering Online Shopping Cart</u></h2>
                        <br>
                        <br>
                        <h3>Add Category</h3>
                        <br>
                        <br>
                        <a href="Logout.jsp">Click here to Logout</a>
                        <br>
                                <h3>Add New Category :</h3>
                                <form name="addbook" action="AddCategory.jsp">
                                    <table class="table">
                                        <tr>
                                            <td>Categories Available</td>
                                            <td>
                                                <select name="cat" class="form-control">
                                                    <%
                                                        while(rs.next()){
                                                            %>
                                                            <option value="<%=rs.getString(1)%>"><%=rs.getString(2)%><option>
                                                        <%}%>
                                                </select>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>
                                                Category to be added
                                            </td>
                                            <td>
                                                <input type="text" name="cat_name" class="form-control" >
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <input type="submit" value="Add" class="btn btn-primary w-50">
                                            </td>
                                            <td>
                                                <input type="Reset" class="btn btn-danger w-50" value="Clear">
                                            </td>
                                        </tr>
                                    </table>
                                </form>
                    </div>
                    <div class="col-sm-3"></div>
                </div>
            </div>
        </section>
                         <%
                             }
                         catch(Exception e){
                            out.print("Error "+e+"<hr>");
                              }
                         finally{
                            rs.close();
                            con.close();
                            }
                         %>
    </body>
</html>
