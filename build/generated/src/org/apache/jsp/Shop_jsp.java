package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class Shop_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link href=\"css/bootstrap.min.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <title>Shop</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        \n");
      out.write("        ");
 
          if(session.getValue("user")!=null){
              
      out.write("\n");
      out.write("              <script language=\"JavaScript\">\n");
      out.write("                  function validate(){\n");
      out.write("                      var r=document.form1;\n");
      out.write("                      var creditcard=r.Card.value;\n");
      out.write("                      var year=r.Year.value;\n");
      out.write("                      var month=r.Month.value;\n");
      out.write("                      var day=r.Day.value;\n");
      out.write("                      \n");
      out.write("                      if(creaditcard.length!=16){\n");
      out.write("                          alert(\"Invalid Credit Card Number\");\n");
      out.write("                          r.Card.focus();\n");
      out.write("                          return;\n");
      out.write("                      }\n");
      out.write("                      //--------------------------------------------------------------------------------------------------\n");
      out.write("                      if(day==\"Select Day\"){\n");
      out.write("                          alert(\"Please select the day\");\n");
      out.write("                          r.Day.focus();\n");
      out.write("                          return;\n");
      out.write("                      }\n");
      out.write("                      //---------------------------------------------------------------------------------------------------\n");
      out.write("                      if(month==\"Select Month\"){\n");
      out.write("                          alert(\"Please select the month\");\n");
      out.write("                          r.Month.focus();\n");
      out.write("                          return;\n");
      out.write("                      }\n");
      out.write("                      //----------------------------------------------------------------------------------------------------\n");
      out.write("                      if(year.length==0){\n");
      out.write("                          alert(\"Please enter the year\");\n");
      out.write("                          r.Year.focus();\n");
      out.write("                      }\n");
      out.write("                      //----------------------------------------------------------------------------------------------------\n");
      out.write("                      else if(year.length!=4){\n");
      out.write("                          alert(\"Please enter the year in YYYY format\");\n");
      out.write("                          r.Year.focus();\n");
      out.write("                      }\n");
      out.write("                      //------------------------------------------------------------------------------------------------------\n");
      out.write("                      if((month==\"3\" || month==\"5\" || month==\"8\" || month==\"10\") && (day==\"31\")){\n");
      out.write("                          alert(\"Please enter a valid date\");\n");
      out.write("                          r.Day.focus();\n");
      out.write("                      }\n");
      out.write("                      if((month==\"1\") && (day==\"30\") && (day==\"31\")){\n");
      out.write("                          alert(\"Please enter a valid date\");\n");
      out.write("                          r.Day.focus();\n");
      out.write("                      }\n");
      out.write("                      // To check that card date is not less than current date----------------------------------------------\n");
      out.write("                      var vr_day;\n");
      out.write("                      var vr_month;\n");
      out.write("                      var vr_year;\n");
      out.write("                      var d=new Date();\n");
      out.write("                      vr_year=d.getFullYear();\n");
      out.write("                      vr_month=d.getMonth();\n");
      out.write("                      vr_day=d.getDate();\n");
      out.write("                      \n");
      out.write("                      if(ParseInt(vr_year)>parseInt(document.form1.Year.value)){\n");
      out.write("                          alert(\"Year can not be less than current year\");\n");
      out.write("                          return false;\n");
      out.write("                      }\n");
      out.write("                      else if(parseInt(vr_year)==parseInt(document.form1.Year.value)){\n");
      out.write("                          if(parseInt(vr_month)>parseInt(document.form1.Month.value)){\n");
      out.write("                              alert(\"Month can not be less than Current Month\");\n");
      out.write("                              return false;\n");
      out.write("                          }\n");
      out.write("                          else if(parseInt(vr_month)==paseInt(document.form1.Month.value))\n");
      out.write("                          {\n");
      out.write("                              if(parseInt(vr_day)>parseInt(document.form1.Day.value)){\n");
      out.write("                                  alert(\"Day cannot be less than current Day\");\n");
      out.write("                                  return false;\n");
      out.write("                              }\n");
      out.write("                          }\n");
      out.write("                      }\n");
      out.write("                      //-----------------------------------------------------------------------------------------------------\n");
      out.write("                      document.form1.submit();\n");
      out.write("                      document.form1.action(\"Final.jsp\");\n");
      out.write("                  }\n");
      out.write("              </script>\n");
      out.write("              ");

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
                  
      out.write("\n");
      out.write("        <section>\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <div class=\"col-sm-3\"></div>\n");
      out.write("                    <div class=\"col-sm-6\">\n");
      out.write("                        <h2><u>Online Shopping Cart</u></h2>\n");
      out.write("                        <br><br>\n");
      out.write("                        <a href=\"Logout.jsp\">Click here to Logout</a>\n");
      out.write("                        <form method=\"post\" action=\"Final.jsp\" name=\"form1\">\n");
      out.write("                            <table class=\"table\">\n");
      out.write("                                <tr>\n");
      out.write("                                    <td><b>Total Amount(in Rs.) is : ");
      out.print(bookprice);
      out.write("</b></td>\n");
      out.write("                                </tr>\n");
      out.write("                                <tr></tr>\n");
      out.write("                                <tr>\n");
      out.write("                                    <td><b>Credit Card Number :</b></td>\n");
      out.write("                                    <td>\n");
      out.write("                                        <input type=\"text\" name=\"card\" maxlength=\"16\">\n");
      out.write("                                    </td>\n");
      out.write("                                </tr>\n");
      out.write("                                <tr>\n");
      out.write("                                    <td><b>Expiry Date :</b></td>\n");
      out.write("                                    <td>\n");
      out.write("                                        <select name=\"Day\" class=\"form-control\">\n");
      out.write("                                            <option value=\"Select Day\">Select Day</option>\n");
      out.write("                                            <option value=\"1\">1</option>\n");
      out.write("                                            <option value=\"2\">2</option>\n");
      out.write("                                            <option value=\"3\">3</option>\n");
      out.write("                                            <option value=\"4\">4</option>\n");
      out.write("                                            <option value=\"5\">5</option>\n");
      out.write("                                            <option value=\"6\">6</option>\n");
      out.write("                                            <option value=\"7\">7</option>\n");
      out.write("                                            <option value=\"8\">8</option>\n");
      out.write("                                            <option value=\"9\">9</option>\n");
      out.write("                                            <option value=\"10\">10</option>\n");
      out.write("                                            <option value=\"11\">11</option>\n");
      out.write("                                            <option value=\"12\">12</option>\n");
      out.write("                                            <option value=\"13\">13</option>\n");
      out.write("                                            <option value=\"14\">14</option>\n");
      out.write("                                            <option value=\"15\">15</option>\n");
      out.write("                                            <option value=\"16\">16</option>\n");
      out.write("                                            <option value=\"17\">17</option>\n");
      out.write("                                            <option value=\"18\">18</option>\n");
      out.write("                                            <option value=\"19\">19</option>\n");
      out.write("                                            <option value=\"20\">20</option>\n");
      out.write("                                            <option value=\"21\">21</option>\n");
      out.write("                                            <option value=\"22\">22</option>\n");
      out.write("                                            <option value=\"23\">23</option>\n");
      out.write("                                            <option value=\"24\">24</option>\n");
      out.write("                                            <option value=\"25\">25</option>\n");
      out.write("                                            <option value=\"26\">26</option>\n");
      out.write("                                            <option value=\"27\">27</option>\n");
      out.write("                                            <option value=\"28\">28</option>\n");
      out.write("                                            <option value=\"29\">29</option>\n");
      out.write("                                            <option value=\"30\">30</option>\n");
      out.write("                                            <option value=\"31\">31</option>\n");
      out.write("                                        </select>\n");
      out.write("                                    </td>\n");
      out.write("                                    <td>\n");
      out.write("                                        <select name=\"Month\" class=\"form-control\">\n");
      out.write("                                            <option value=\"Select Month\">Select Month</option>\n");
      out.write("                                            <option value=\"1\">January</option>\n");
      out.write("                                            <option value=\"2\">February</option>\n");
      out.write("                                            <option value=\"3\">March</option>\n");
      out.write("                                            <option value=\"4\">April</option>\n");
      out.write("                                            <option value=\"5\">May</option>\n");
      out.write("                                            <option value=\"6\">June</option>\n");
      out.write("                                            <option value=\"7\">July</option>\n");
      out.write("                                            <option value=\"8\">August</option>\n");
      out.write("                                            <option value=\"9\">September</option>\n");
      out.write("                                            <option value=\"10\">October</option>\n");
      out.write("                                            <option value=\"11\">November</option>\n");
      out.write("                                            <option value=\"12\">December</option>\n");
      out.write("                                        </select>\n");
      out.write("                                    </td>\n");
      out.write("                                    <td>\n");
      out.write("                                        <input type=\"text\" name=\"Year\" class=\"form-control\">\n");
      out.write("                                    </td>\n");
      out.write("                                </tr>\n");
      out.write("                            </table>\n");
      out.write("                                <input type=\"submit\" value=\"Submit\" name=\"B1\" onclick=\"validate();\">\n");
      out.write("                        </form>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-sm-3\"></div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </section>\n");
      out.write("        ");
}
else{
response.sendRedirect("Unauthorised.html");
}

      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
