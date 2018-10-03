package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.net.*;
import java.io.*;
import java.sql.*;

public final class Insert_005fCategory_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>Insert_Category</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("                        \n");
      out.write("                        \n");
      out.write("                        \n");
      out.write("                        \n");
      out.write("                        ");

                            Connection con=null;
                            Statement stat=null;
                            ResultSet rs=null;
                            String query=null;
                            int ctr=0, flag=0;
                            try{
                                Class.forName("oracle.jdbc.driver.OracleDriver");
                                con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","cart","root");
                                stat=con.createStatement();
                                query="Select* from category_details";
                                rs=stat.executeQuery(query);
                                
      out.write("\n");
      out.write("        <section>\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <div class=\"col-sm-3\"></div>\n");
      out.write("                    <div class=\"col-sm-6\">\n");
      out.write("                        <h2 class=\"text-center\"><u>Administering Online Shopping Cart</u></h2>\n");
      out.write("                        <br>\n");
      out.write("                        <br>\n");
      out.write("                        <h3>Add Category</h3>\n");
      out.write("                        <br>\n");
      out.write("                        <br>\n");
      out.write("                        <a href=\"Logout.jsp\">Click here to Logout</a>\n");
      out.write("                        <br>\n");
      out.write("                                <h3>Add New Category :</h3>\n");
      out.write("                                <form name=\"addbook\" action=\"AddCategory.jsp\">\n");
      out.write("                                    <table class=\"table\">\n");
      out.write("                                        <tr>\n");
      out.write("                                            <td>Categories Available</td>\n");
      out.write("                                            <td>\n");
      out.write("                                                <select name=\"cat\" class=\"form-control\">\n");
      out.write("                                                    ");

                                                        while(rs.next()){
                                                            
      out.write("\n");
      out.write("                                                            <option value=\"");
      out.print(rs.getString(1));
      out.write('"');
      out.write('>');
      out.print(rs.getString(2));
      out.write("<option>\n");
      out.write("                                                        ");
}
      out.write("\n");
      out.write("                                                </select>\n");
      out.write("                                            </td>\n");
      out.write("                                        </tr>\n");
      out.write("                                        <tr>\n");
      out.write("                                            <td>\n");
      out.write("                                                Category to be added\n");
      out.write("                                            </td>\n");
      out.write("                                            <td>\n");
      out.write("                                                <input type=\"text\" name=\"cat_name\" class=\"form-control\" >\n");
      out.write("                                            </td>\n");
      out.write("                                        </tr>\n");
      out.write("                                        <tr>\n");
      out.write("                                            <td>\n");
      out.write("                                                <input type=\"submit\" value=\"Add\" class=\"btn btn-primary w-50\">\n");
      out.write("                                            </td>\n");
      out.write("                                            <td>\n");
      out.write("                                                <input type=\"Reset\" class=\"btn btn-danger w-50\" value=\"Clear\">\n");
      out.write("                                            </td>\n");
      out.write("                                        </tr>\n");
      out.write("                                    </table>\n");
      out.write("                                </form>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-sm-3\"></div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </section>\n");
      out.write("                         ");

                             }
                         catch(Exception e){
                            out.print("Error "+e+"<hr>");
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
