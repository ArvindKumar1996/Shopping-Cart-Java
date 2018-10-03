<%-- 
    Document   : Cart_quantity
    Created on : Jul 10, 2018, 1:22:13 PM
    Author     : Arvind Kumar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <title>Cart_quantity</title>
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
        %>
        <script language="JavaScript">
            function check_sum(){
                var cost=0;
                x_avlqty=new Array(<%=counter%>);
                y_orderqty=new Array(<%=counter%>);
                z_price=new Array(<%=counter%>);
                for(var i=0;i<<%=counter%>;i++){
                    z_price[i]=(document.shop.elements[i*4].value);
                    x_avlqty[i]=document.shop.elements[i*4+1].value;
                    y_orderqty[i]=document.shop.elements[i*4+2].value;
                    if(parseInt(y_orderqty[i])<0){
                        alert("Book quantity can not be negative");
                        return false;
                    }
                    if(parseInt(x_avlqty[i])<parseInt(y_orderqty[i])){
                        alert("Order quantity can not be greater than avilable quantity");
                        return false;
                    }
                    else{
                        document.shop.elements[i*4+3].value=((parseInt(y_orderqty[i]))*(parseInt(z_price[i])));
                        cost=cost+parseInt(document.shop.elements[i*4+3].value);
                    }
            }
            document.shop.tot_val.value=cost;
        }
        </script>
        <%
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
                    <div class="col-sm"></div>
                    <div class="col-sm-12">
                        <h2><u>Online Shopping Cart</u></h2>
                        <br>
                        <br>
                        <a href="Logout.jsp">Click here to Logout</a>
                        <br>
                        <h4>Your Cart details are as follows:</h4>
                        <br>
                        <form name="shop" action="Shop.jsp" method="post">
                            <table class="table table-bordered">
                                <tr>
                                    <td>S.No</td>
                                    <td>Book Name</td>
                                    <td>Price per unit(in Rs.)</td>
                                    <td>Quantity Available</td>
                                    <td>Quantity Purchased</td>
                                    <td>Amount</td>
                                </tr>
                                <%
                                    int price=0;
                                    int qty_avbl=0;
                                    for(int j=1;j<=counter;j++){
                                        out.println("<tr><td>"+j);
                                        out.println("</td>");
                                        String query="select title, price,quantity from book_details where bookid="+bookid[j-1]+"";
                                        rs=stat.executeQuery(query);
                                        while(rs.next()){
                                            out.println("<td>");
                                            out.println(rs.getString(1));
                                            out.println("</td>");
                                            price=rs.getInt(2);
                                            %>
                                            <td>
                                                <input type="hidden" name="bk_price<%=j%>" value="<%=price%>">
                                            <%out.println(price);
                                            qty_avbl=rs.getInt(3); %>
                                            <td>
                                                <input type="hidden" name="qty_avl<%=j%>" value="<%=qty_avbl%>"><%=qty_avbl%>
                                            <td>
                                                <input type="text" name="qty<%=j%>" value="0" onChange="return check_sum();" class="form-control">
                                            <td>
                                                <input type="text" name="cal_amt<%=j%>" class="form-control">
                                            <%
                                        }
                                            %>
                            </tr>
                            <%rs.close();
                            bookprice=bookprice+price;
                            session.putValue("bPrice", String.valueOf(bookprice));
                            out.println("</tr>");
                            }
                           %>
                           <tr>
                               <td><td>
                               <td><td>
                               <td>
                                   Total Amount(in Rs.)
                               <td>
                               
                                   <input type="text" name="tot_val" value="0" class="form-control">
                               </td>
                           </tr>
                            </table>
                           <br>
                           <input type="submit" value="Place Order" class="btn btn-primary">
                        </form>
                    </div>
                    <div class="col-sm"></div>
                </div>
            </div>
        </section>
                           <br>
                           <hr>
                           <%}
else{
response.sendRedirect("Unauthorised.html");
}
%>
    </body>
</html>
