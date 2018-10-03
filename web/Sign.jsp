<%-- 
    Document   : Sign
    Created on : Jul 4, 2018, 2:52:20 PM
    Author     : Arvind Kumar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <%@ page language="java" import="java.sql.*" %>
        <% 
            Connection conn;
            conn=null;
            ResultSet rs;
            rs=null;
            String UserName=request.getParameter("UserName");
            String Password=request.getParameter("Password");
            String Password2=request.getParameter("Password2");
            String FirstName=request.getParameter("FirstName");
            String MiddleName=request.getParameter("MiddleName");
            String LastName=request.getParameter("LastName");
            String Address1=request.getParameter("Address1");
            String Address2=request.getParameter("Address2");
            String City=request.getParameter("City");
            String State=request.getParameter("State");
            String PinCode=request.getParameter("PinCode");
            String Email=request.getParameter("Email");
            String Phone=request.getParameter("Phone");
            int flag=0;
            try{
                Class.forName("oracle.jdbc.driver.OracleDriver");
                conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","cart","root");
                PreparedStatement stat=conn.prepareStatement("SELECT * FROM user_profile where username=?");
                stat.setString(1,UserName);
                rs=stat.executeQuery();
                if(rs.next()){
                    flag=1;
                    %>
                    <Script language="JavaScript">
                        alert("User name already exists");
                        location.href="signup.jsp";
                    <%
                }
           else{
                conn.close();
              }
            }
catch (Exception E) {
out.println("Error " + E);
}
if (flag == 0) {
try {
  Class.forName("oracle.jdbc.driver.OracleDriver");
  conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "cart", "root");
  PreparedStatement stat1 = conn.prepareStatement("INSERT INTO user_auth values(?,?)");
  stat1.setString(1,UserName);
  stat1.setString(2,Password);
  PreparedStatement stat = conn.prepareStatement("INSERT INTO user_profile values(?,?,?,?,?,?,?,?,?,?,?,?)");
  stat.setString(1, UserName);
  stat.setString(2, Password);
  stat.setString(3, FirstName);
  stat.setString(4, MiddleName);
  stat.setString(5, LastName);
  stat.setString(6, Address1);
  stat.setString(7, Address2);
  stat.setString(8, City);
  stat.setString(9, State);
  stat.setString(10, PinCode);
  stat.setString(11, Email);
  stat.setString(12, Phone);
  stat1.executeUpdate();
  stat.executeUpdate();
  flag=0;
  response.sendRedirect("login.jsp");
}
catch(Exception E){
out.println("Error inserting value"+E);
}
finally{
rs.close();
conn.close();
}
}
        %>
    </body>
</html>
