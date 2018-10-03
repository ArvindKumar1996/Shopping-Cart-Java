<%-- 
    Document   : AddBook
    Created on : Jul 12, 2018, 7:50:52 AM
    Author     : Arvind Kumar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <title>Add Book</title>
    </head>
    <body>
        <section>
            <div class="container">
                <div class="row">
                    <div class="col-sm-3"></div>
                    <div class="col-sm-6">
                        <h2 class="text-center"><u>Administering Online Shopping Cart</u></h2>
                        <br>
                        <hr>
                        <br>
                        <h3>Add Book</h3>
                        <br>
                        <%@page import="java.net.*" %>
                        <%@page import="java.io.*" %>
                        <%@page import="java.sql.*" %>
                        <%
                            Connection con=null;
                            Statement stat=null;
                            Class.forName("oracle.jdbc.driver.OracleDriver");
                            con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","cart","root");
                            stat=con.createStatement();
                            ResultSet rs1=null;
                            int rs;
                            String query=null;
                            String query1=null;
                            String TITLE;
                            TITLE=request.getParameter("title");
                            query1="select a.* from book_details a where a.title=?";
                            PreparedStatement stat1=con.prepareStatement(query1);
                            stat1.setString(1,TITLE);
                            rs1=stat1.executeQuery();
                            if(rs1.next()){
                                %>
                                <script language="JavaScript">
                                    alert("This book already exists.");
                                    location.href="Insert.jsp";
                                </script>
                                <%
                            }
else{
int int_BOOKID,int_CATEGORYID,int_PRICE,int_QUANTITY;
String str_TITLE,str_AUTHOR,str_PUBLISHER,str_EDITION,str_DESCRIPTION;
int_BOOKID=(int)(10000*Math.random()+1);

int_CATEGORYID=Integer.parseInt(request.getParameter("cat"));
str_TITLE=request.getParameter("title");
str_AUTHOR=request.getParameter("author");
str_PUBLISHER=request.getParameter("pub");
str_EDITION=request.getParameter("edition");

int_PRICE=Integer.parseInt(request.getParameter("price"));

int_QUANTITY=Integer.parseInt(request.getParameter("qty"));
str_DESCRIPTION=request.getParameter("desc");

query="insert into book_details values("+int_BOOKID+","+int_CATEGORYID+",'"+str_TITLE+"','"+str_AUTHOR+"','"+str_PUBLISHER+"','"+str_EDITION+"',"+int_PRICE+","+int_QUANTITY+",'"+str_DESCRIPTION+"')";
rs=stat.executeUpdate(query);
if(rs==1){
%>
<br>
<h3>Successfully Inserted the data.</h3>
<%
}
else{
%>
<br>
<h3>Could not add the book</h3>
<%}
}%>
<br>
<a href="Logout.jsp">Click here to Logout</a>
<br><br>
<a href="Admin.jsp">Click here to go to Administrator page</a>
<br><br>
<a href="Insert.jsp">Click here to add more books</a>
                    </div>
                    <div class="col-sm-3"></div>
                </div>
            </div>
        </section>
    </body>
</html>
