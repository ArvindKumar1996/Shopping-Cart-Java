<%-- 
    Document   : Validate
    Created on : Jul 7, 2018, 9:29:01 AM
    Author     : Arvind Kumar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <title>Validate</title>
    </head>
    <body>
        <%@page language="java" import="java.sql.*" %>
        <% 
           Connection conn;
           conn=null;
           ResultSet rs;
           rs=null;
           try{
               String strName=request.getParameter("UserName");
               String strPass=request.getParameter("Password");
               Class.forName("oracle.jdbc.driver.OracleDriver");
               conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","cart","root");
               PreparedStatement stat=conn.prepareStatement("SELECT * FROM cart.user_auth where username=? and password=?");
               stat.setString(1, strName);
               stat.setString(2, strPass);
               rs=stat.executeQuery();
               if(rs.next()){
                   String str1,str2;
                   str1=rs.getString(1);
                   str2=rs.getString(2);
                   out.println(str1+str2);
                   session.putValue("user", strName);
                   if(str1.equals("Administrator")){
                    response.sendRedirect("Admin.html");
                   }
                   else{
                       out.println("LOGGED IN");
                       response.sendRedirect("SearchCriteria.jsp");
                   }
               }
               else{
                   response.sendRedirect("InvalidUser.html");
               }
           }
           catch(Exception E){
               out.println("Error"+E);
           }
           finally{
               rs.close();
               conn.close();
           }
        %>
    </body>
</html>
