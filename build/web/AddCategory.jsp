<%-- 
    Document   : AddCategory
    Created on : Jul 11, 2018, 1:18:30 PM
    Author     : Arvind Kumar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <title>Add Category</title>
    </head>
    <body>
        <section>
            <div class="container">
                <div class="row">
                    <div class="col-sm-3"></div>
                    <div class="col-sm-6">
                        <h2 class="text-center"><u>Administering Online shopping cart</u></h2>
                        <br>
                        <br>
                        <h3>Add Category</h3>
                        <br>
                        <hr>
                        <br>
                        <%@page import="java.net.*" %>
                        <%@page import="java.io.*" %>
                        <%@page import="java.sql.*" %>
                        <%
                            Connection con=null;
                            Statement stat=null;
                            try{
                            Class.forName("oracle.jdbc.driver.OracleDriver");
                            con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","cart","root");
                            stat=con.createStatement();
                             int rs;
                             int int_CATEGORYID;
                             
                             String query=null;
                             String str_CATEGORY;
                             
                             int_CATEGORYID=(int)(10000*Math.random()+1);
                             str_CATEGORY=request.getParameter("cat_name");
                             
                             query="insert into CATEGORY_details values("+int_CATEGORYID+",'"+str_CATEGORY+"')";
                             
                             rs=stat.executeUpdate(query);
                             if(rs==1){
                                 %>
                                 <h3>New Category Successfully Added</h3><%
                             }
                             else{
                                  %>
                                  <h3>Transaction Not Allowed</h3><%
                             }
                                }
                             catch(Exception e){
                                      out.print("Error ="+e+"<hr>");
                                   }
                                finally{
                                    con.close();
                                 }
                            %>
                            <br>
                            <a href="Logout.jsp">Click here to Logout</a>
                            <br>
                            <br>
                            <a href="Admin.jsp">Click here to go to administrator page</a>
                            <br>
                            <br>
                            <a href="Insert_Category.jsp">Click here to add more categories</a>
                            <br>
                            <br>
                    </div>
                    <div class="col-sm-3"></div>
                </div>
            </div>
        </section>
    </body>
</html>
