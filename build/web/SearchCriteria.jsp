<%-- 
    Document   : SearchCriteria
    Created on : Jul 9, 2018, 12:52:27 PM
    Author     : Arvind Kumar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <title>Search Criteria</title>
    </head>
    <body>
        <script language="JavaScript">
          function StartSearch(){
              if(document.frm.R1[1].checked){
                  if(document.frm.BookTitle.value==""){
                      alert("You must enter a book title.");
                      return;
                  }
              }
              if(document.frm.R1[2].checked){
                  if(document.frm.BookAuthor.value==""){
                      alert("You must enter an author name.");
                      return;
                  }
              }
              if(document.frm.R1[3].checked){
                  if(document.frm.BookPublisher.value==""){
                      alert("You must enter a publisher name");
                      return;
                  }
              }
              document.frm.action="Search.jsp";
              document.frm.submit();
          }
        </script>
        <%@page import="java.net.*" %>
        <%@page import="java.io.*" %>
        <%@page import="java.sql.*" %>
        <% 
             Connection con=null;
             Statement stat=null;
             ResultSet rs=null;
             String query=null;
             int ctr=0,flag=0;
             try{
                Class.forName("oracle.jdbc.driver.OracleDriver");
                con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","cart","root");
                stat=con.createStatement();
                query="select * from category_details";
                rs=stat.executeQuery(query);
                %>
        <section>
            <div class="contianer">
                <div class="row">
                    <div class="col-sm-3"></div>
                    <div class="col-sm-6">
                        <h2 class="text-center"><u>Online Shopping Cart</u></h2>
                        <form name="frm" method="post">
                            <h3 class="text-center">Search Book</h3>
                            <br>
                            <table class="table" width="100%">
                            <tr>
                                <td>
                                    <input type="radio" value="Category" checked name="R1"> 
                                </td>
                                <td>
                                    Search by Category
                                </td>
                                <td>
                                    <select name="BookCategory" class="form-control">
                                        <option selected value="Select">Select Category</option>
                                        <%
                                            while(rs.next()){
                                                String category=rs.getString(2); %>
                                                <option value="<%=category%>"><%=category%></option>
                                                <%}%>
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
                                <td>
                                    Search by Book Author
                                </td>
                                <td>
                                    <input type="text" name="BookAuthor" class="form-control">
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <input type="radio" name="R1" value="Publisher">
                                </td>
                                <td>
                                    Search by Book Publisher
                                </td>
                                <td>
                                    <input type="text" name="BookPublisher" class="form-control">
                                </td>
                            </tr>
                            <tr>
                                <td></td>
                                <td>
                                    <input type="submit" value="Search" class="btn btn-warning float-right w-100" name="Search" onclick="StartSearch();">
                                </td>
                                <td><a href="Logout.jsp">Click here to logout</a></td>
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
              out.println("Error = "+e+"<hr>");
                   }
             finally{
                 rs.close();
                 con.close();
             }
        %>
    </body>
</html>
