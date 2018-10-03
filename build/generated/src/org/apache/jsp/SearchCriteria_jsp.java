package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.net.*;
import java.io.*;
import java.sql.*;

public final class SearchCriteria_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>Search Criteria</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <script language=\"JavaScript\">\n");
      out.write("          function StartSearch(){\n");
      out.write("              if(document.frm.R1[1].checked){\n");
      out.write("                  if(document.frm.BookTitle.value==\"\"){\n");
      out.write("                      alert(\"You must enter a book title.\");\n");
      out.write("                      return;\n");
      out.write("                  }\n");
      out.write("              }\n");
      out.write("              if(document.frm.R1[2].checked){\n");
      out.write("                  if(document.frm.BookAuthor.value==\"\"){\n");
      out.write("                      alert(\"You must enter an author name.\");\n");
      out.write("                      return;\n");
      out.write("                  }\n");
      out.write("              }\n");
      out.write("              if(document.frm.R1[3].checked){\n");
      out.write("                  if(document.frm.BookPublisher.value==\"\"){\n");
      out.write("                      alert(\"You must enter a publisher name\");\n");
      out.write("                      return;\n");
      out.write("                  }\n");
      out.write("              }\n");
      out.write("              document.frm.action=\"Search.jsp\";\n");
      out.write("              document.frm.submit();\n");
      out.write("          }\n");
      out.write("        </script>\n");
      out.write("        \n");
      out.write("        \n");
      out.write("        \n");
      out.write("        ");
 
             Connection con=null;
             Statement stat=null;
             ResultSet rs=null;
             String query=null;
             int ctr=0,flag=0;
             try{
                Class.forName("oracle.jdbc.driver.OracleDriver");
                con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","cart","root");
                stat=con.createStatement();
                query="select * from category_details";
                rs=stat.executeQuery(query);
                
      out.write("\n");
      out.write("        <section>\n");
      out.write("            <div class=\"contianer\">\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <div class=\"col-sm-3\"></div>\n");
      out.write("                    <div class=\"col-sm-6\">\n");
      out.write("                        <h2 class=\"text-center\"><u>Online Shopping Cart</u></h2>\n");
      out.write("                        <form name=\"frm\" method=\"post\">\n");
      out.write("                            <h3 class=\"text-center\">Search Book</h3>\n");
      out.write("                            <br>\n");
      out.write("                            <table class=\"table\" width=\"100%\">\n");
      out.write("                            <tr>\n");
      out.write("                                <td>\n");
      out.write("                                    <input type=\"radio\" value=\"Category\" checked name=\"R1\"> \n");
      out.write("                                </td>\n");
      out.write("                                <td>\n");
      out.write("                                    Search by Category\n");
      out.write("                                </td>\n");
      out.write("                                <td>\n");
      out.write("                                    <select name=\"BookCategory\" class=\"form-control\">\n");
      out.write("                                        <option selected value=\"Select\">Select Category</option>\n");
      out.write("                                        ");

                                            while(rs.next()){
                                                String category=rs.getString(2); 
      out.write("\n");
      out.write("                                                <option value=\"");
      out.print(category);
      out.write('"');
      out.write('>');
      out.print(category);
      out.write("</option>\n");
      out.write("                                                ");
}
      out.write("\n");
      out.write("                                    </select>\n");
      out.write("                                </td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <td>\n");
      out.write("                                    <input type=\"radio\" name=\"R1\" value=\"Title\">\n");
      out.write("                                </td>\n");
      out.write("                                <td>Search by Book Title</td>\n");
      out.write("                                <td>\n");
      out.write("                                    <input type=\"text\" name=\"BookTitle\" class=\"form-control\">\n");
      out.write("                                </td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <td>\n");
      out.write("                                    <input type=\"radio\" name=\"R1\" value=\"Author\">\n");
      out.write("                                </td>\n");
      out.write("                                <td>\n");
      out.write("                                    Search by Book Author\n");
      out.write("                                </td>\n");
      out.write("                                <td>\n");
      out.write("                                    <input type=\"text\" name=\"BookAuthor\" class=\"form-control\">\n");
      out.write("                                </td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <td>\n");
      out.write("                                    <input type=\"radio\" name=\"R1\" value=\"Publisher\">\n");
      out.write("                                </td>\n");
      out.write("                                <td>\n");
      out.write("                                    Search by Book Publisher\n");
      out.write("                                </td>\n");
      out.write("                                <td>\n");
      out.write("                                    <input type=\"text\" name=\"BookPublisher\" class=\"form-control\">\n");
      out.write("                                </td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <td></td>\n");
      out.write("                                <td>\n");
      out.write("                                    <input type=\"submit\" value=\"Search\" class=\"btn btn-warning float-right w-100\" name=\"Search\" onclick=\"StartSearch();\">\n");
      out.write("                                </td>\n");
      out.write("                                <td><a href=\"Logout.jsp\">Click here to logout</a></td>\n");
      out.write("                            </tr>\n");
      out.write("                        </table>\n");
      out.write("                        </form>  \n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-sm-3\"></div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </section>\n");
      out.write("        ");

            }
            catch(Exception e){
              out.println("Error = "+e+"<hr>");
                   }
             finally{
                 rs.close();
                 con.close();
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
