package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class Cart_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>Cart</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("           \n");
      out.write("        ");

           int i;
           String user_src=null;
            user_src=(String)session.getValue("user");
            if(user_src!=null){
                int counter=0;
            counter=Integer.parseInt((String)session.getValue("TotalSel"));
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
      out.write("        \n");
      out.write("        <section>\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <div class=\"col-sm-3\"></div>\n");
      out.write("                    <div class=\"col-sm-6\">\n");
      out.write("                        <h3>Your Cart Details are as follows</h3>\n");
      out.write("                        <form name=\"shop\" action=\"Cart_quantity.jsp\">\n");
      out.write("                            <table class=\"table\">\n");
      out.write("                                <tr>\n");
      out.write("                                    <td>S.No</td>\n");
      out.write("                                    <td>Book Name</td>\n");
      out.write("                                    <td>Price (in Rs.)</td>\n");
      out.write("                                </tr>\n");
      out.write("                                ");

                                    int price=0;
                                    for(int j=1;j<=counter;j++){
                                        out.println("<tr><td>"+j);
                                        
                                        String query="select title, price from book_details where bookid="+bookid[j-1]+"";
                                        rs=stat.executeQuery(query);
                                        while(rs.next()){
                                            out.println("<td>");
                                            out.println(rs.getString(1));
                                            out.println("<td>");
                                            price=rs.getInt(2);
                                            out.println(price);
                                        }
                                        rs.close();
                                        bookprice=bookprice+price;
                                        session.putValue("bPrice", String.valueOf(bookprice));
                                        out.println("</tr>");
                                    }
                                    Statement stat_combo=conn.createStatement();
                                    ResultSet rscombo=null;
                                    String query1="select * from category_details";
                                    rscombo=stat_combo.executeQuery(query1);
                                    
      out.write("\n");
      out.write("                                    <tr>\n");
      out.write("                                        <td>Total Cart Amount(in Rs.)=\n");
      out.write("                                            ");
      out.print(bookprice);
      out.write("\n");
      out.write("                                        </td>\n");
      out.write("                                    </tr>\n");
      out.write("                            </table>\n");
      out.write("                                        <br>\n");
      out.write("                                        <input type=\"submit\" value=\"Place Order\">\n");
      out.write("                        </form>\n");
      out.write("                                        <br><hr>\n");
      out.write("                                        <h3>Search More</h3>\n");
      out.write("                                        <form name=\"search\" action=\"NewSearch.jsp\" method=\"post\">\n");
      out.write("                                            <table class=\"table\">\n");
      out.write("                                                <tr>\n");
      out.write("                                                    <td>\n");
      out.write("                                                        <input type=\"radio\" value=\"Category\" checked name=\"R1\" >\n");
      out.write("                                                    </td>\n");
      out.write("                                                    <td>Search based on Category</td>\n");
      out.write("                                                    <td>\n");
      out.write("                                                        <select name=\"BookCategory\">\n");
      out.write("                                                            <option selected value=\"Select\">Select Category</option>\n");
      out.write("                                                            ");
 
                                                               while(rscombo.next()){
                                                                   String category=rscombo.getString(2);
                                                                   
      out.write("\n");
      out.write("                                                                   <option value=\"");
      out.print(category);
      out.write('"');
      out.write('>');
      out.print(category);
      out.write("</option>\n");
      out.write("                                                                   ");

                                                               }
                                                            
      out.write("\n");
      out.write("                                                        </select>\n");
      out.write("                                                    </td>\n");
      out.write("                                                </tr>\n");
      out.write("                                                <tr>\n");
      out.write("                                                    <td>\n");
      out.write("                                                        <input type=\"radio\" name=\"R1\" value=\"Title\">\n");
      out.write("                                                    </td>\n");
      out.write("                                                    <td>Search by Book Title</td>\n");
      out.write("                                                    <td>\n");
      out.write("                                                        <input type=\"text\" name=\"BookTitle\">\n");
      out.write("                                                    </td>\n");
      out.write("                                                </tr>\n");
      out.write("                                                <tr>\n");
      out.write("                                                    <td>\n");
      out.write("                                                        <input type=\"radio\" name=\"R1\" value=\"Author\">\n");
      out.write("                                                    </td>\n");
      out.write("                                                    <td>Search by Book Author</td>\\\n");
      out.write("                                                    <td>\n");
      out.write("                                                        <input type=\"text\" name=\"BookAuthor\">\n");
      out.write("                                                    </td>\n");
      out.write("                                                </tr>\n");
      out.write("                                                <tr>\n");
      out.write("                                                    <td>\n");
      out.write("                                                        <input type=\"radio\" name=\"R1\" value=\"Publisher\">\n");
      out.write("                                                    </td>\n");
      out.write("                                                    <td>Search by Book Publisher</td>\n");
      out.write("                                                    <td>\n");
      out.write("                                                        <input type=\"text\" name=\"BookPublisher\">\n");
      out.write("                                                    </td>\n");
      out.write("                                                </tr>\n");
      out.write("                                                <tr>\n");
      out.write("                                                    <td>\n");
      out.write("                                                        <input type=\"radio\" name=\"R2\" value=\"A\">Advanced Search\n");
      out.write("                                                    </td>\n");
      out.write("                                                    <td>\n");
      out.write("                                                        <input type=\"radio\" name=\"R2\" value=\"N\" checked >New Search\n");
      out.write("                                                    </td>\n");
      out.write("                                                    <td>\n");
      out.write("                                                        <input type=\"submit\" value=\"Search\" >\n");
      out.write("                                                    </td>\n");
      out.write("                                                </tr>\n");
      out.write("                                            </table>\n");
      out.write("                                        </form>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-sm-3\"></div>\n");
      out.write("            </div>\n");
      out.write("        </section>\n");
      out.write("                                ");
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
