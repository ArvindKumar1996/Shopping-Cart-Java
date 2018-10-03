package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class Cart_005fquantity_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>Cart_quantity</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        \n");
      out.write("        ");

           int i;
           String user_src=null;
           user_src=(String)session.getValue("user");
           if(user_src!=null){
               int counter=0;
               counter=Integer.parseInt((String)session.getValue("ToatalSel")); 
        
      out.write("\n");
      out.write("        <script language=\"JavaScript\">\n");
      out.write("            function check_sum(){\n");
      out.write("                var cost=0;\n");
      out.write("                x_avlqty=new Array(");
      out.print(counter);
      out.write(");\n");
      out.write("                y_orderqty=new Array(");
      out.print(counter);
      out.write(");\n");
      out.write("                z_price=new Array(");
      out.print(counter);
      out.write(");\n");
      out.write("                for(var i=0;i<");
      out.print(counter);
      out.write(";i++){\n");
      out.write("                    z_price[i]=(document.shop.elements[i*4].value);\n");
      out.write("                    x_avlqty[i]=document.shop.elements[i*4+1].value;\n");
      out.write("                    y_orderqty[i]=document.shop.elements[i*4+2].value;\n");
      out.write("                    if(parseInt(y_orderqty[i])<0){\n");
      out.write("                        alert(\"Book quantity can not be negative\");\n");
      out.write("                        return false;\n");
      out.write("                    }\n");
      out.write("                    if(parseInt(x_avlqty[i])<parseInt(y_orderqty[i])){\n");
      out.write("                        alert(\"Order quantity can not be greater than avilable quantity\");\n");
      out.write("                        return false;\n");
      out.write("                    }\n");
      out.write("                    else{\n");
      out.write("                        document.shop.elements[i*4+3].value=((parseInt(y_orderqty[i]))*(parseInt(z_price[i])));\n");
      out.write("                        cost=cost+parseInt(document.shop.elements[i*4+3].value);\n");
      out.write("                    }\n");
      out.write("            }\n");
      out.write("            document.shop.tot_val.value=cost;\n");
      out.write("        }\n");
      out.write("        </script>\n");
      out.write("        ");

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
        
      out.write("\n");
      out.write("        <section>\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <div class=\"col-sm-3\"></div>\n");
      out.write("                    <div class=\"col-sm-6\">\n");
      out.write("                        <h2><u>Online Shopping Cart</u></h2>\n");
      out.write("                        <br>\n");
      out.write("                        <br>\n");
      out.write("                        <a href=\"Logout.jsp\">Click here to Logout</a>\n");
      out.write("                        <br>\n");
      out.write("                        <h3>Your Cart details are as follows:</h3>\n");
      out.write("                        <br>\n");
      out.write("                        <form name=\"shop\" action=\"Shop.jsp\" method=\"post\">\n");
      out.write("                            <table class=\"table\">\n");
      out.write("                                <tr>\n");
      out.write("                                    <td>S.No</td>\n");
      out.write("                                    <td>Book Name</td>\n");
      out.write("                                    <td>Price per unit(in Rs.)</td>\n");
      out.write("                                    <td>Quantity Available</td>\n");
      out.write("                                    <td>Quantity Purchased</td>\n");
      out.write("                                    <td>Amount</td>\n");
      out.write("                                </tr>\n");
      out.write("                                ");

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
                                            
      out.write("\n");
      out.write("                                            <td>\n");
      out.write("                                                <input type=\"hidden\" name=\"bk_price");
      out.print(j);
      out.write("\" value=\"");
      out.print(price);
      out.write("\">\n");
      out.write("                                            </td>\n");
      out.write("                                            ");
out.println(price);
                                            qty_avbl=rs.getInt(3); 
      out.write("\n");
      out.write("                                            <td>\n");
      out.write("                                                <input type=\"hidden\" name=\"qty_avl");
      out.print(j);
      out.write("\" value=\"");
      out.print(qty_avbl);
      out.write('"');
      out.write('>');
      out.print(qty_avbl);
      out.write("\n");
      out.write("                                            </td>\n");
      out.write("                                            <td>\n");
      out.write("                                                <input type=\"text\" name=\"qty");
      out.print(j);
      out.write("\" value=\"0\" onchange=\"return check_sum();\">\n");
      out.write("                                            </td>\n");
      out.write("                                            <td>\n");
      out.write("                                                <input type=\"text\" name=\"cal_amt");
      out.print(j);
      out.write("\">\n");
      out.write("                                            </td>\n");
      out.write("                                            ");

                                        }
                                            
      out.write("\n");
      out.write("                            </tr>\n");
      out.write("                            ");
rs.close();
                            bookprice=bookprice+price;
                            session.putValue("bPrice", String.valueOf(bookprice));
                            out.println("</tr>");
                            }
                           
      out.write("\n");
      out.write("                           <tr>\n");
      out.write("                               <td><td>\n");
      out.write("                               <td><td>\n");
      out.write("                               <td>\n");
      out.write("                                   Total Amount(in Rs.)\n");
      out.write("                               <td>\n");
      out.write("                               <td>\n");
      out.write("                                   <input type=\"text\" name=\"tot_val\" value=\"0\">\n");
      out.write("                               </td>\n");
      out.write("                           </tr>\n");
      out.write("                            </table>\n");
      out.write("                           <br>\n");
      out.write("                           <input type=\"submit\" value=\"Place Order\" class=\"btn btn-primary\">\n");
      out.write("                        </form>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-sm-3\"></div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </section>\n");
      out.write("                           <br>\n");
      out.write("                           <hr>\n");
      out.write("                           ");
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
