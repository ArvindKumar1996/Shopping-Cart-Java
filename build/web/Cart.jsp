<%-- 
    Document   : Cart
    Created on : Jul 9, 2018, 6:21:13 PM
    Author     : Arvind Kumar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <title>Cart</title>
    </head>
    <body>
        <%@page language="java" import="java.sql.*" %>   
        <%
           int i;
           String user_src=null;
            user_src=(String)session.getValue("user");
            if(user_src!=null){
                int counter=0;
            counter=Integer.parseInt((String)session.getValue("TotalSel"));
            int[] bookid=new int[counter];
            Connection conn;
            conn=null;
            ResultSet rs;
            rs=null;
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","cart","root");
            Statement stat=conn.createStatement();
            int ctr=0,bookprice=0;
            for(i=1;i<=counter;i++){
                if((String)session.getValue("chk_var"+i)!=null){
                    bookid[i-1]=Integer.parseInt((String)session.getValue("chk_var"+i));
                }
            }
            session.putValue("BookArr", bookid);
        %>
        
        <section>
            <div class="container">
                <div class="row">
                    <div class="col-sm-1"></div>
                    <div class="col-sm-10">
                        <h2 class="text-center"><u>Online Shopping Cart</u></h2>
                        <br>
                        <br>
                        <h4>Your Cart Details are as follows</h4>
                        <br>
                        <form name="shop" action="Cart_quantity.jsp">
                            <table class="table table-bordered">
                                <tr style="background:coral">
                                    <td>S.No</td>
                                    <td>Book Name</td>
                                    <td>Price (in Rs.)</td>
                                </tr>
                                <%
                                    int price=0;
                                    for(int j=1;j<=counter;j++){
                                        out.println("<tr><td>"+j);
                                        
                                        String query="select title, price from book_details where bookid="+bookid[j-1]+"";
                                        rs=stat.executeQuery(query);
                                        while(rs.next()){
                                            out.println("<td>");
                                            out.println(rs.getString(1));
                                            out.println("<td>");
                                            price=rs.getInt(2);
                                            out.println(price);
                                        }
                                        rs.close();
                                        bookprice=bookprice+price;
                                        session.putValue("bPrice", String.valueOf(bookprice));
                                        out.println("</tr>");
                                    }
                                    Statement stat_combo=conn.createStatement();
                                    ResultSet rscombo=null;
                                    String query1="select * from category_details";
                                    rscombo=stat_combo.executeQuery(query1);
                                    %>
                            </table>
                                        <b class="float-right">Total Cart Amount(in Rs.)=
                                            <span style="color:red"> <%=bookprice%></span>
                                            </b>
                                        <br>
                                        <input type="submit" value="Place Order" class="btn btn-success"><hr>
                        </form>
                                        <br>
                                        <br>
                                        <h3 class="text-center">Search More</h3>
                                        <br>
                                        <form name="search" action="NewSearch.jsp" method="post">
                                            <table class="table">
                                                <tr>
                                                    <td>
                                                        <input type="radio" value="Category" checked name="R1" >
                                                    </td>
                                                    <td>Search based on Category</td>
                                                    <td>
                                                        <select name="BookCategory" class="form-control">
                                                            <option selected value="Select">Select Category</option>
                                                            <% 
                                                               while(rscombo.next()){
                                                                   String category=rscombo.getString(2);
                                                                   %>
                                                                   <option value="<%=category%>"><%=category%></option>
                                                                   <%
                                                               }
                                                            %>
                                                        </select>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td>
                                                        <input type="radio" name="R1" value="Title">
                                                    </td>
                                                    <td>Search by Book Title</td>
                                                    <td>
                                                        <input type="text" name="BookTitle" class="form-control">
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td>
                                                        <input type="radio" name="R1" value="Author">
                                                    </td>
                                                    <td>Search by Book Author</td>
                                                    <td>
                                                        <input type="text" name="BookAuthor" class="form-control">
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td>
                                                        <input type="radio" name="R1" value="Publisher">
                                                    </td>
                                                    <td>Search by Book Publisher</td>
                                                    <td>
                                                        <input type="text" name="BookPublisher" class="form-control">
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td>
                                                        <input type="radio" name="R2" value="A"> Advanced Search
                                                    </td>
                                                    <td>
                                                        <input type="radio" name="R2" value="N" checked > New Search
                                                    </td>
                                                    <td>
                                                        <input type="submit" value="Search" class="btn btn-primary w-50" >
                                                    </td>
                                                </tr>
                                            </table>
                                        </form>
                    </div>
                    <div class="col-sm-3"></div>
            </div>
        </section>
                                <%}
else{
     response.sendRedirect("Unauthorised.html");
}
%>
    </body>
</html>
