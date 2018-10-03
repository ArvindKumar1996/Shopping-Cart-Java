<%-- 
    Document   : NewInter_cart
    Created on : Jul 10, 2018, 11:43:47 AM
    Author     : Arvind Kumar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <title>NewInter_cart</title>
    </head>
    <body>
        <%@page language="java" %>
        <% 
           int i;
           String bookid=null;
           String user_src=null;
           user_src=(String)session.getValue("user");
           if(user_src!=null){
               int counter=0;
               int total_sel=Integer.parseInt((String)session.getValue("TotalSel"));
               counter=Integer.parseInt((String)session.getValue("ctr_val"));
               int ctr=total_sel;
               for(i=1;i<=counter;i++){
                   if(request.getParameter("chk"+i)!=null){
                       bookid=request.getParameter("chk"+i);
                       ctr=ctr+1;
                       session.putValue("chk_var"+ctr, bookid);
                   }
               }
               session.putValue("TotalSel", String.valueOf(ctr));
               response.sendRedirect("Cart.jsp");
           }
           else{
               out.println("<center><h4>Unauthorised Shopping is not allowed</h4></center>");
           }
        %>
    </body>
</html>
