<%-- 
    Document   : Final
    Created on : Jul 10, 2018, 5:47:06 PM
    Author     : Arvind Kumar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <title>Final</title>
    </head>
    <body>
        <%@page language="java" import="java.sql.*,java.util.*" %>
        <%
           String user_src=(String)session.getValue("user");
           if(user_src!=null){
               Connection conn;
               conn=null;
               ResultSet rs;
               rs=null;
               Class.forName("");
               conn=DriverManager.getConnection("");
               Statement stat1=conn.createStatement();
               Statement stat_sel=conn.createStatement();
               Statement stat_ins=conn.createStatement();
               int OrderID=(int)(10000*Math.random()+1);
               int price=Integer.parseInt((String)session.getValue("bPrice"));
               int counter=0;
               counter=Integer.parseInt((String)session.getValue("TotalSel"));
               
               int[] bookid=new int[counter];
               int[] bk_quantity=new int[counter];
               int org_bkqty=0;
               int i=0;
               
               String ins_query="";
               String sel_qtyQuery="";
               String ins_qty="";
               
               for(i=1;i<=counter;i++){
                   ResultSet rs_sql=null;
                   if((String)session.getValue("chk_var"+i)!=null){
                       bookid[i-1]=Integer.parseInt((String)session.getValue("chk_var"+i));
                   }
                   if((String)session.getValue("bookqty"+1)!=null){
                       bk_quantity[i-1]=Integer.parseInt((String)session.getValue("bookqty"+i));
                   }
                   ins_query="insert into ORDER_DETAILS VALUES("+OrderID+","+bookid[i-1]+","+bk_quantity[i-1]+")";
                   int rs_int=0;
                   rs_int=stat1.executeUpdate(ins_query);
                   sel_qtyQuery="SELECT QUANTITY FROM BOOK_DETAILS WHERE BOOKID="+bookid[i-1]+"";
                   rs_sql=stat_sel.executeQuery(sel_qtyQuery);
                   if(rs_sql.next()){
                       org_bkqty=rs_sql.getInt(1);
                   }
                   rs_sql.close();
                   ins_query="UPDATE BOOK_DETAILS SET QUANTITY="+(org_bkqty-bk_quantity[i-1])+"WHERE BOOKID="+bookid[i-1]+"";
                   rs_int=stat_ins.executeUpdate(ins_query);
               }
               String insertQuery="";
        %>
        <section>
            <div class="container">
                <div class="row">
                    <div class="col-sm-3"></div>
                    <div class="col-sm-6">
                        <h2><u>Online Shopping cart</u></h2>
                        <br><br>
                        <h3>Order Details</h3>
                        <br>
                        <a href="Logout.jsp">Click here to Logout</a>
                        <form name="newsrc" method="post">
                            <br>
                            <b>Your Order has been successfully placed.</b>
                            <br><br>Order Number is :<%=OrderID%>
                            <br><br>Total Amount is :<%=price%>
                            <br><br>Date of Order is :
                            <%
                                out.println((new java.util.Date()).toLocaleString());
                                %>
                                <br><br>Your order will be delievered within next 48 working hours
                                <%
                                    String card_no=request.getParameter("Card");
                                    Statement stat=conn.createStatement();
                                    insertQuery="insert into ORDER_TABLE values("+OrderID+",'"+user_src+"',"+price+",sysdate,'"+card_no+"')";
                                    int rsint=stat.executeUpdate(insertQuery);
                                    }
                                    else{
                                            response.sendRedirect("Unauthorised.html");
                                        }
                                %>
                        </form> 
                    </div>
                    <div class="col-sm-3"></div>
                </div>
            </div>
        </section>
    </body>
</html>
