<%-- 
    Document   : Search
    Created on : Jul 9, 2018, 1:57:34 PM
    Author     : Arvind Kumar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <title>Search Results</title>
    </head>
    <body>
        <%@page language="java" import="java.sql.*" %>
        <%
          String str_searchvar=null;
          int chk_ctr=0;
          String str_colvar=null;
          String tab_var="";
          String user_src=(String)session.getValue("user");
          if(user_src!=null){
              String query=null;
              Connection conn;
              conn=null;
              ResultSet rs;
              rs=null;
              if(request.getParameter("R1").equals("Title")){
              str_searchvar=request.getParameter("BookTitle");
              str_colvar="Title";
          }
              if(request.getParameter("R1").equals("Category")){
                  chk_ctr=1;
                  str_searchvar=request.getParameter("BookCategory");
                  str_colvar="Categoryname";
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
                  // To get the name of the table in which the search to be done...............
                  if(request.getParameter("R2").equals("A")){
                      tab_var="TEMP_DETAIL";
                  }
                  else{
                      tab_var="BOOK_DETAILS";
                  }
              }
              //-------whether search is by Category or other criteria------------
              if(chk_ctr==0){
                  query="Select a.*,b.categoryname from "+tab_var+" a,CATEGORY_DETAILS b where UPPER(a."+str_colvar+")=UPPER('"+str_searchvar+"') and a.categoryid=b.categoryid";
              }
              else{
                  query="select a.*,b.categoryname from "+tab_var+" a,CATEGORY_DETAILS b where UPPER(b."+str_colvar+")=UPPER('"+str_searchvar+"') and a.categoryid=b.categoryid";              }
              try{
                  Class.forName("oracle.jdbc.driver.OracleDriver");
                  conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","cart","root");
                  Statement stat=conn.createStatement();
                  Statement stat_del=conn.createStatement();
                  Statement stat_ins=conn.createStatement();
                  rs=stat.executeQuery(query);
                  int ctr=0; %>
                   <section>
            <div class="container">
                <div class="row">
                    <div class="col-sm"></div>
                    <div class="col-sm-12">
                        <h2 class="text-center"><u>Online Shopping Cart</u></h2>
                            <br>
                            <h3 class="text-center">Search Results</h3>
                        <form name="cart" action="Inter_Cart.jsp" method="post">
                            <h5>  <a href="Logout.jsp">Click here to Logout</a>  </h5>  
                            <table class="table table-bordered table-responsive">
                                <tr style="background:coral">
                                    <th>S.No</th>
                                    <th>Select</th>
                                    <th>Book Name</th>
                                    <th>Author Name</th>
                                    <th>Publisher</th>
                                    <th>Edition</th>
                                    <th>Price (in Rs.)</th>
                                    <th>Quantity Available(Nos.)</th>
                                    <th>Description</th>
                                    <th>category</th>
                                </tr>
                                <%
                                    ResultSet rs1=null;
                                    String delete_query="Delete from TEMP_DETAIL";
                                    String ins_query=null;
                                    int int_BOOKID, int_CATEGORYID,int_PRICE,int_QUANTITY;
                                    String str_TITLE,str_AUTHOR,str_PUBLISHER,str_EDITION,str_DESCRIPTION;
                                    int rs_del=stat_del.executeUpdate(delete_query);
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
                                       
                                       out.println("<tr>");
                                       
                                       ins_query="INSERT INTO TEMP_DETAIL VALUES("+int_BOOKID+","+int_CATEGORYID+",'"+str_TITLE+"','"+str_AUTHOR+"','"+str_PUBLISHER+"','"+str_EDITION+"',"+int_PRICE+","+int_QUANTITY+",'"+str_DESCRIPTION+"')";
                                       int rs_ins=stat_ins.executeUpdate(ins_query);
                                    }
                                    String str_ctr=String.valueOf(ctr);
                                    session.putValue("ctr_val",str_ctr);
                                    Statement stat_combo=conn.createStatement();
                                    ResultSet rscombo=null;
                                    String query1="SELECT * FROM CATEGORY_DETAILS";
                                    rscombo=stat_combo.executeQuery(query1);
                                    %>
                            </table>
                            <br>
                            <input type="submit" value="Add to Cart" name="Add" class="btn btn-success">
                        </form>
                            <hr>
                            <br>
                            <br>
                            <h3 class="text-center">Search More</h3>
                            <br>
                            <form name="newsrc" action="Search.jsp" method="post">
                                <table class="table">
                                    <tr>
                                        <td>
                                            <input type="radio" value="Category" checked name="R1">
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
                                        <td>
                                            Search by Book Title
                                        </td>
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
                                            <input type="radio" name="R2" value="N" checked> New Search
                                        </td>
                                        <td>
                                            <input type="submit" value="Search" class="btn btn-primary">
                                        </td>
                                    </tr>
                                </table>
                            </form>
                    </div>
                    <div class="col-sm"></div>
                </div>
            </div>
        </section>
            <% }
      catch(Exception E){
         out.println("Error" +E);
}
finally{
      rs.close();
      conn.close();
    }
}
else{
response.sendRedirect("Unauthorised.html");
}
%>
       
    </body>
</html>
