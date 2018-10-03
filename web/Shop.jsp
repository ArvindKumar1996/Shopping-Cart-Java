<%-- 
    Document   : Shop
    Created on : Jul 10, 2018, 3:15:04 PM
    Author     : Arvind Kumar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <title>Shop</title>
    </head>
    <body>
        <%@page language="java" import="java.sql.*" %>
        <% 
          if(session.getValue("user")!=null){
              %>
              <script language="JavaScript">
                  function validate(){
                      var r=document.form1;
                      var creditcard=r.Card.value;
                      var year=r.Year.value;
                      var month=r.Month.value;
                      var day=r.Day.value;
                      
                      if(creaditcard.length!=16){
                          alert("Invalid Credit Card Number");
                          r.Card.focus();
                          return;
                      }
                      //--------------------------------------------------------------------------------------------------
                      if(day=="Select Day"){
                          alert("Please select the day");
                          r.Day.focus();
                          return;
                      }
                      //---------------------------------------------------------------------------------------------------
                      if(month=="Select Month"){
                          alert("Please select the month");
                          r.Month.focus();
                          return;
                      }
                      //----------------------------------------------------------------------------------------------------
                      if(year.length==0){
                          alert("Please enter the year");
                          r.Year.focus();
                      }
                      //----------------------------------------------------------------------------------------------------
                      else if(year.length!=4){
                          alert("Please enter the year in YYYY format");
                          r.Year.focus();
                      }
                      //------------------------------------------------------------------------------------------------------
                      if((month=="3" || month=="5" || month=="8" || month=="10") && (day=="31")){
                          alert("Please enter a valid date");
                          r.Day.focus();
                      }
                      if((month=="1") && (day=="30") && (day=="31")){
                          alert("Please enter a valid date");
                          r.Day.focus();
                      }
                      // To check that card date is not less than current date----------------------------------------------
                      var vr_day;
                      var vr_month;
                      var vr_year;
                      var d=new Date();
                      vr_year=d.getFullYear();
                      vr_month=d.getMonth();
                      vr_day=d.getDate();
                      
                      if(ParseInt(vr_year)>parseInt(document.form1.Year.value)){
                          alert("Year can not be less than current year");
                          return false;
                      }
                      else if(parseInt(vr_year)==parseInt(document.form1.Year.value)){
                          if(parseInt(vr_month)>parseInt(document.form1.Month.value)){
                              alert("Month can not be less than Current Month");
                              return false;
                          }
                          else if(parseInt(vr_month)==paseInt(document.form1.Month.value))
                          {
                              if(parseInt(vr_day)>parseInt(document.form1.Day.value)){
                                  alert("Day cannot be less than current Day");
                                  return false;
                              }
                          }
                      }
                      //-----------------------------------------------------------------------------------------------------
                      document.form1.submit();
                      document.form1.action("Final.jsp");
                  }
              </script>
              <%
                  int counter=0;
                  counter=Integer.parseInt((String)session.getValue("totalSel"));
                  String query="";
                  int[] bookid=new int[counter];
                  int[] bk_price=new int[counter];
                  int[] bk_quantity=new int[counter];
                  Connection conn;
                  conn=null;
                  ResultSet rs;
                  rs=null;
                  Class.forName("oracle.jdbc.driver.OracleDriver");
                  conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","cart","root");
                  Statement stat=conn.createStatement();
                  int ctr=0,bookprice=0;
                  int i=1;
                  while(i<=counter){
                      if((String)session.getValue("chk_var"+i)!=null){
                          bookid[i-1]=Integer.parseInt((String)session.getValue("chk_var"+i));
                          query="select price from BOOK_DETAILS WHERE BOOKID="+bookid[i-1]+"";
                          rs=stat.executeQuery(query);
                          if(rs.next()){
                              bk_price[i-1]=rs.getInt(1);
                          }
                          else{
                              bk_price[i-1]=0;
                          }
                      }
                      if(request.getParameter("qty"+i)!=null){
                          bk_quantity[i-1]=Integer.parseInt(request.getParameter("qty"+i));
                          String sess_var=String.valueOf(bk_quantity[i-1]);
                          session.putValue(sess_var, String.valueOf(bk_quantity[i-1]));
                      }
                      bookprice=bookprice+(bk_price[i-1]*bk_quantity[i-1]);
                      i++;
                  }
                  session.putValue("bprice", String.valueOf(bookprice));
                  %>
        <section>
            <div class="container">
                <div class="row">
                    <div class="col-sm-3"></div>
                    <div class="col-sm-6">
                        <h2><u>Online Shopping Cart</u></h2>
                        <br><br>
                        <a href="Logout.jsp">Click here to Logout</a>
                        <form method="post" action="Final.jsp" name="form1">
                            <table class="table">
                                <tr>
                                    <td><b>Total Amount(in Rs.) is : <%=bookprice%></b></td>
                                </tr>
                                <tr></tr>
                                <tr>
                                    <td><b>Credit Card Number :</b></td>
                                    <td>
                                        <input type="text" name="card" maxlength="16">
                                    </td>
                                </tr>
                                <tr>
                                    <td><b>Expiry Date :</b></td>
                                    <td>
                                        <select name="Day" class="form-control">
                                            <option value="Select Day">Select Day</option>
                                            <option value="1">1</option>
                                            <option value="2">2</option>
                                            <option value="3">3</option>
                                            <option value="4">4</option>
                                            <option value="5">5</option>
                                            <option value="6">6</option>
                                            <option value="7">7</option>
                                            <option value="8">8</option>
                                            <option value="9">9</option>
                                            <option value="10">10</option>
                                            <option value="11">11</option>
                                            <option value="12">12</option>
                                            <option value="13">13</option>
                                            <option value="14">14</option>
                                            <option value="15">15</option>
                                            <option value="16">16</option>
                                            <option value="17">17</option>
                                            <option value="18">18</option>
                                            <option value="19">19</option>
                                            <option value="20">20</option>
                                            <option value="21">21</option>
                                            <option value="22">22</option>
                                            <option value="23">23</option>
                                            <option value="24">24</option>
                                            <option value="25">25</option>
                                            <option value="26">26</option>
                                            <option value="27">27</option>
                                            <option value="28">28</option>
                                            <option value="29">29</option>
                                            <option value="30">30</option>
                                            <option value="31">31</option>
                                        </select>
                                    </td>
                                    <td>
                                        <select name="Month" class="form-control">
                                            <option value="Select Month">Select Month</option>
                                            <option value="1">January</option>
                                            <option value="2">February</option>
                                            <option value="3">March</option>
                                            <option value="4">April</option>
                                            <option value="5">May</option>
                                            <option value="6">June</option>
                                            <option value="7">July</option>
                                            <option value="8">August</option>
                                            <option value="9">September</option>
                                            <option value="10">October</option>
                                            <option value="11">November</option>
                                            <option value="12">December</option>
                                        </select>
                                    </td>
                                    <td>
                                        <input type="text" name="Year" class="form-control">
                                    </td>
                                </tr>
                            </table>
                                <input type="submit" value="Submit" name="B1" onclick="validate();">
                        </form>
                    </div>
                    <div class="col-sm-3"></div>
                </div>
            </div>
        </section>
        <%}
else{
response.sendRedirect("Unauthorised.html");
}
%>
    </body>
</html>
