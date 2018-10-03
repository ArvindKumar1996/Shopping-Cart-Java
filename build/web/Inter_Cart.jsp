<%-- 
    Document   : Inter_Cart
    Created on : Jul 9, 2018, 6:03:44 PM
    Author     : Arvind Kumar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <title>Inter_Cart</title>
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
                counter=Integer.parseInt((String)session.getValue("ctr_val"));
                int ctr=0;
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
                response.sendRedirect("Unauthorised.html");
            }
            %>
    </body>
</html>
