<%-- 
    Document   : Insert
    Created on : Jul 11, 2018, 6:40:24 AM
    Author     : Arvind Kumar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <title>Insert</title>
        <script language="JavaScript">
            function check(){
                var ctr=0;
                if(document.addbook.title.value==""){
                    alert("Please enter title");
                    return;
                }
                if(document.addbook.author.value==""){
                    alert("Please enter author");
                    return;
                }
                if(document.addbook.pub.value==""){
                    alert("Please enter publisher name");
                    return;
                }
                if(document.addbook.edition.value==""){
                    alert("Please enter edition");
                    return;
                }
                if(document.addbook.price.value==""){
                 alert("Please enter price (in Rs.");
                 return;
                }
                if(document.addbook.qty.value==""){
                    alert("Please enter quantity");
                    return;
                }
                if(document.addbook.desc.value==""){
                    alert("Please enter description");
                    return;
                }
                if(isNaN(document.addbook.price.value=="")){
                    alert("Please enter a numeric value for price (in Rs.)");
                    ctr=1;
                }
                if(isNaN(document.addbook.qty.value=="")){
                    alert("Please enter a numeric value for quantity");
                    ctr=1;
                }
                if(ctr==0){
                    document.forms[0].action="AddBook.jsp";
                    document.forms[0].submit();
                }
                else{
                    return true;
                }
            }
            </script>
    </head>
    <body>
        <%@page import="java.net.*" %>
        <%@page import="java.io.*" %>
        <%@page import="java.sql.*" %>
        <% 
           Connection con=null;
           Statement stat=null;
           Statement stat1=null;
           ResultSet rs=null;
           ResultSet rs1=null;
           
           String query=null;
           String query1=null;
           int ctr=0,flag=0;
           try{
               Class.forName("oracle.jdbc.driver.OracleDriver");
               con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","cart","root");
               stat=con.createStatement();
               stat1=con.createStatement();
               
               query="select a.*,b.categoryname from book_details a,category_details b where a.categoryid=b.categoryid";
               query1="select * from category_details";
               
               rs=stat.executeQuery(query);
               rs1=stat1.executeQuery(query1);
               %>
        <section>
            <div class="container">
                <div class="row">
                    <div class="col-sm"></div>
                    <div class="col-sm-12">
                        <h2 class="text-center"><u>Administering Online Shopping Cart</u></h2>
                        <br>
                        <br>
                        <a href="Logout.jsp">Click here to Logout</a>
                        <br>
                        <br>
                        <h3>List of Available Books :</h3>
                        <form name="addbook" method="post">
                        <table class="table table-bordered">
                            <tr class="table-warning">
                                <th>S.No</th>
                                <th>Book Id</th>
                                <th>Book Title</th>
                                <th>Author Name</th>
                                <th>Publisher</th>
                                <th>Edition</th>
                                <th>Price (in Rs.)</th>
                                <th>Quantity Available(Nos.)</th>
                                <th>Description</th>
                                <th>Category</th>
                            </tr>
                            <%
                                int int_BOOKID,int_CATEGORYID,int_PRICE,int_QUANTITY;
                                String str_TITLE,str_AUTHOR,str_PUBLISHER,str_EDITION,str_DESCRIPTION;
                                while(rs.next()){
                                    ctr=ctr+1;
                                    out.println("<tr><td>"+ctr);
                                    int_BOOKID=rs.getInt(1);
                                    out.println("<td>");
                                    out.println(int_BOOKID);
                                    
                                    int_CATEGORYID=rs.getInt(2);
                                    
                                    str_TITLE=rs.getString(3);
                                    out.println("<td>");
                                    out.println(str_TITLE);
                                    
                                    str_AUTHOR=rs.getString(4);
                                    out.println("<td>");
                                    out.println(str_AUTHOR);
                                    
                                    str_PUBLISHER=rs.getString(5);
                                    out.println("<td>");
                                    out.println(str_PUBLISHER);
                                    
                                    str_EDITION=rs.getString(6);
                                    out.println("<td>");
                                    out.println(str_EDITION);
                                    
                                    int_PRICE=rs.getInt(7);
                                    out.println("<td>");
                                    out.println(int_PRICE);
                                    
                                    int_QUANTITY=rs.getInt(8);
                                    out.println("<td>");
                                    out.println(int_QUANTITY);
                                    
                                    str_DESCRIPTION=rs.getString(9);
                                    out.println("<td>");
                                    out.println(str_DESCRIPTION);
                                    
                                    out.println("<td>");
                                    out.println(rs.getString(10));
                                    
                                    out.println("</tr>");
                                }
                                out.println("</table>");
                                %>
                                <br>
                                <hr>
                                <h3>Add New Book Details</h3>
                                
                                    <table class="table table-hover" style="background: cornsilk;">
                                        <tr>
                                            <td>Book Title</td>
                                            <td>
                                                <input type="text" class="form-control" name="title">
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>Author Name</td>
                                            <td>
                                                <input type="text" class="form-control" name="author">
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>Publisher</td>
                                            <td>
                                                <input type="text" class="form-control" name="pub">
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>Edition</td>
                                            <td>
                                                <input type="text" class="form-control" name="edition">
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>Price (in Rs.)</td>
                                            <td>
                                                <input type="text" class="form-control" name="price">
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>Quantity Available</td>
                                            <td>
                                                <input type="text" class="form-control" name="qty">
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>Description</td>
                                            <td>
                                                <input type="text" class="form-control" name="desc">
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>Category</td>
                                            <td>
                                                <select name="cat" class="form-control">
                                                    <%
                                                        while(rs1.next()){
                                                            %>
                                                            <option value="<%=rs1.getString(1)%>"><%=rs1.getString(2)%></option>
                                                        <%}%>
                                                </select>
                                            </td>
                                        </tr>
                                        <br>
                                        <tr>
                                            <td>
                                                <input type="submit"  value="Add" onClick="check();" class="btn btn-primary w-50">
                                            </td>
                                            <td>
                                                <input type="Reset"  value="Clear" class="btn btn-danger w-50">
                                            </td>
                                            <td>
                                        </tr>
                                    </table>
                                </form>
                    </div>
                    <div class="col-sm"></div>
                </div>
            </div>
        </section>
                                                    <%
                                                        }
                                                catch(Exception e){
                                              out.print("Error = "+e+"<hr>");
                                                        }
                                                     %>
    </body>
</html>
