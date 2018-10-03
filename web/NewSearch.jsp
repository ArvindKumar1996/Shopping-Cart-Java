<%-- 
    Document   : NewSearch
    Created on : Jul 10, 2018, 8:39:51 AM
    Author     : Arvind Kumar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <title>New Search</title>
    </head>
    <body>
        <%@page language="java" import="java.sql.*" %>
        <%
            String user_src=(String)session.getValue("user");
            if(user_src!=null){
                String str_searchvar=null;
                String str_colvar=null;
                String query="";
                String tab_var="";
                int total_sel=Integer.parseInt((String)session.getValue("TotalSel"));
                int[] old_bookid=new int[total_sel];
                Connection conn;
                conn=null;
                ResultSet rs;
                rs=null;
                Class.forName("");
                conn=DriverManager.getConnection("");
                Statement stat=conn.createStatement();
                Statement stat_del=conn.createStatement();
                Statement stat_ins=conn.createStatement();
               for(int i=1;i<=total_sel;i++){
                   old_bookid[i-1]=Integer.parseInt((String)session.getValue("chk_var"+i));
               }
               %>
        <section>
            <div class="container">
                <div class="row">
                    <div class="col-sm-3"></div>
                    <div class="col-sm-6">
                        <h2><u>Online Shopping Cart</u></h2>
                        <br><br>
                        <a href="Logout.jsp">Click here to Logout</a>
                        <br><br>
                        <h3>Your cart Details are as follows:</h3>
                        <form name="shop" action="cart_Quantity.jsp">
                            <table class="table">
                                <tr>
                                    <td>S.No</td>
                                    <td>Book Name</td>
                                    <td>Price(in Rs.)</td>
                                </tr>
                                <% 
                                   int price=0;int bookprice=0;
                                   for(int j=0;j<total_sel;j++){
                                       out.println("<tr><td>"+j+1);
                                       
                                       query="select title,price from book_details where bookid="+old_bookid[j]+"";
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
                                       out.println("</tr>");
                                   }
                                %>
                                <tr>
                                    <td>
                                        Total Cart Amount(in Rs.)=
                                        <%=bookprice%>
                                    </td>
                                </tr>
                            </table>
                                    <br>
                                    <input type="submit" value="Place Order">
                        </form>
                                    <%
                                       String test_src=null;
                                       int chk_ctr=0;
                                       
                             if(request.getParameter("R1").equals("Title")){
                                 str_searchvar=request.getParameter("BookTitle");
                                 str_colvar="Title";
                             }
                             if(request.getParameter("R1").equals("Category")){
                                 chk_ctr=1;
                                 str_searchvar=request.getParameter("BookCategory");
                                 str_colvar="CategoryName";
                             }
                             if(request.getParameter("R1").equals("Publisher")){
                                 str_searchvar=request.getParameter("BookPublisher");
                                 str_colvar="Publisher";
                             }
                             if(request.getParameter("R1").equals("Author")){
                                 str_searchvar=request.getParameter("BookAuthor");
                                 str_colvar="Author";
                             }
                             if(request.getParameter("R2")==null){
                                 tab_var="BOOK_DETAILS";
                             }
                             else{
                                 //to get the name of the table in which the search to be done-----------
                                 if(request.getParameter("R2").equals("A")){
                                     tab_var="TEMP_DETAIL";
                                 }
                                 else{
                                     tab_var="BOOK_DETAILS";
                                 }
                             }
                             //----------------Whether search is by category or other criteria------------------
                             if(chk_ctr==0){
                                 query="select a.*,b.categoryname from "+tab_var+"a,CATEGORY_DETAILS b where a."+str_colvar+"='"+str_searchvar+"' and a.categoryid=b.categoryid";
                             }
                             else{
                                 query="select a.*,b.categoryname from "+tab_var+"a.CATEGORY_DETAILS b where b."+str_colvar+"='"+str_searchvar+"' and a.categoryid=b.categoryiid";
                             }
                             try{
                                 rs=stat.executeQuery(query);
                                 int ctr=0; %>
                                 <h3>Search results are as follows:</h3>
                                 <form name="cart" action="NewInter_cart.jsp" method="post">
                                     <table class="table">
                                         <tr>
                                             <td>S.No</td>
                                             <td>Select</td>
                                             <td>Book Name</td>
                                             <td>Author Name</td>
                                             <td>Publisher</td>
                                             <td>Edition</td>
                                             <td>Price(in Rs.)</td>
                                             <td>Quantity Available(Nos.)</td>
                                             <td>Description</td>
                                             <td>Category</td>
                                         </tr>
                                         <%
                                            String delete_query="delete from TEMP_DETAIL";
                                            String ins_query=null;
                                            int int_BOOKID,int_CATEGORYID,int_PRICE,int_QUANTITY;
                                            String str_TITLE,str_AUTHOR,str_PUBLISHER,str_EDITION,str_DESCRIPTION;
                                            int rs_del=stat.executeUpdate(delete_query);
                                            while(rs.next()){
                                                ctr=ctr+1;
                                                out.println("<tr><td>"+ctr);
                                                int_BOOKID=rs.getInt(1);
                                                out.println("<td><input type=checkbox name=chk"+ctr+" value="+int_BOOKID+">");
                                                
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
                                                ins_query="insert into TEMP_DETAIL VALUES("+int_BOOKID+","+int_CATEGORYID+",'"+str_TITLE+"','"+str_AUTHOR+"','"+str_PUBLISHER+"','"+str_EDITION+"',"+int_PRICE+","+int_QUANTITY+",'"+str_DESCRIPTION+"')";
                                                int rs_ins=stat_ins.executeUpdate(ins_query);
                                            }
                                            String str_ctr=String.valueOf(ctr);
                                            session.putValue("ctr_val", str_ctr);
                                         %>
                                     </table>
                                     <input type="submit" value="Add to Cart" name="Add" class="btn btn-success">
                                 </form>
                                <%
                                   Statement stat_combo=conn.createStatement();
                                   ResultSet rscombo=null;
                                   String query1="select * from category_details";
                                   rscombo=stat_combo.executeQuery(query1);
                                %>
                                <br>
                                <h3>Search results are as follows:</h3>
                                <form name="newsrc" action="NewSearch.jsp" method="post">
                                    <table class="table">
                                        <tr>
                                            <td>
                                                <input type="radio" value="Category" checked name="R1" >
                                            </td>
                                            <td>Search based on Category</td>
                                            <td>
                                                <select name="BookCategory">
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
                                                <input type="text" name="BookTitle">
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <input type="radio" name="R1" value="Author" >
                                            </td>
                                            <td>Search by Book Author</td>
                                            <td>
                                                <input type="text" name="BookAuthor" >
                                            </td>
                                        </tr>
                                        <tr>
                                        <td>
                                            <input type="radio" name="R1" value="Publisher">
                                        </td>
                                        <td>Search by Book Publisher</td>
                                        <td>
                                            <input type="text" name="BookPublisher">
                                        </td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <input type="radio" name="R2" value="A" >Advanced Search
                                            </td>
                                            <td>
                                                <input type="radio" name="R2" value="N" checked>New Search
                                            </td>
                                            <td>
                                                <input type="submit" value="Search">
                                            </td>
                                        </tr>
                                    </table>
                                </form>
                    </div>
                    <div class="col-sm-3"></div>
                </div>
            </div>
        </section>
                                             <%}
                          catch(Exception E){
                                   out.println("Error "+E);
                            }
                           finally{
conn.close();
}
}
else{
response.sendRedirect("Unauthorised.html");
}
%>
    </body>
</html>
