package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.net.*;
import java.io.*;
import java.sql.*;

public final class AddCategory_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>Add Category</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <section>\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <div class=\"col-sm-3\"></div>\n");
      out.write("                    <div class=\"col-sm-6\">\n");
      out.write("                        <h2 class=\"text-center\"><u>Administering Online shopping cart</u></h2>\n");
      out.write("                        <br>\n");
      out.write("                        <br>\n");
      out.write("                        <h3>Add Category</h3>\n");
      out.write("                        <br>\n");
      out.write("                        <hr>\n");
      out.write("                        <br>\n");
      out.write("                        \n");
      out.write("                        \n");
      out.write("                        \n");
      out.write("                        ");

                            Connection con=null;
                            Statement stat=null;
                            try{
                            Class.forName("oracle.jdbc.driver.OracleDriver");
                            con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","cart","root");
                            stat=con.createStatement();
                             int rs;
                             int int_CATEGORYID;
                             
                             String query;
                             String str_CATEGORY;
                             
                             int_CATEGORYID=(int)(10000*Math.random()+1);
                             str_CATEGORY=request.getParameter("cat_name");
                             
                             query="insert into CATEGORY_details values("+int_CATEGORYID+",'"+str_CATEGORY+"')";
                             
                             rs=stat.executeUpdate(query);
                             if(rs==1){
                                 
      out.write("\n");
      out.write("                                 <h3>New Category Successfully Added</h3>");

                             }
                             else{
                                  
      out.write("\n");
      out.write("                                  <h3>Transaction Not Allowed</h3>");

                             }
                                }
                             catch(Exception e){
                                      out.print("Error ="+e+"<hr>");
                                   }
                                finally{
                                    con.close();
                                 }
                            
      out.write("\n");
      out.write("                            <br>\n");
      out.write("                            <a href=\"Logout.jsp\">Click here to Logout</a>\n");
      out.write("                            <br>\n");
      out.write("                            <br>\n");
      out.write("                            <a href=\"Admin.jsp\">Click here to go to administrator page</a>\n");
      out.write("                            <br>\n");
      out.write("                            <br>\n");
      out.write("                            <a href=\"Insert_Category.jsp\">Click here to add more categories</a>\n");
      out.write("                            <br>\n");
      out.write("                            <br>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-sm-3\"></div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </section>\n");
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
