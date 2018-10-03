package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.net.*;
import java.io.*;
import java.sql.*;

public final class AddBook_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>Add Book</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <section>\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <div class=\"col-sm-3\"></div>\n");
      out.write("                    <div class=\"col-sm-6\">\n");
      out.write("                        <h2 class=\"text-center\"><u>Administering Online Shopping Cart</u></h2>\n");
      out.write("                        <br>\n");
      out.write("                        <hr>\n");
      out.write("                        <br>\n");
      out.write("                        <h3>Add Book</h3>\n");
      out.write("                        <br>\n");
      out.write("                        \n");
      out.write("                        \n");
      out.write("                        \n");
      out.write("                        ");

                            Connection con=null;
                            Statement stat=null;
                            Class.forName("oracle.jdbc.driver.OracleDriver");
                            con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","cart","root");
                            stat=con.createStatement();
                            ResultSet rs1=null;
                            int rs;
                            String query=null;
                            String query1=null;
                            String TITLE;
                            TITLE=request.getParameter("title");
                            query1="select a.* from book_details a where a.title=?";
                            PreparedStatement stat1=con.prepareStatement(query1);
                            stat1.setString(1,TITLE);
                            rs1=stat1.executeQuery();
                            if(rs1.next()){
                                
      out.write("\n");
      out.write("                                <script language=\"JavaScript\">\n");
      out.write("                                    alert(\"This book already exists.\");\n");
      out.write("                                    location.href=\"Insert.jsp\";\n");
      out.write("                                </script>\n");
      out.write("                                ");

                            }
else{
int int_BOOKID,int_CATEGORYID,int_PRICE,int_QUANTITY;
String str_TITLE,str_AUTHOR,str_PUBLISHER,str_EDITION,str_DESCRIPTION;
int_BOOKID=(int)(10000*Math.random()+1);

int_CATEGORYID=Integer.parseInt(request.getParameter("cat"));
str_TITLE=request.getParameter("title");
str_AUTHOR=request.getParameter("author");
str_PUBLISHER=request.getParameter("pub");
str_EDITION=request.getParameter("edition");

int_PRICE=Integer.parseInt(request.getParameter("price"));

int_QUANTITY=Integer.parseInt(request.getParameter("qty"));
str_DESCRIPTION=request.getParameter("desc");

query="insert into book_details values("+int_BOOKID+","+int_CATEGORYID+",'"+str_TITLE+"','"+str_AUTHOR+"','"+str_PUBLISHER+"','"+str_EDITION+"',"+int_PRICE+","+int_QUANTITY+",'"+str_DESCRIPTION+"')";
rs=stat.executeUpdate(query);
if(rs==1){

      out.write("\n");
      out.write("<br>\n");
      out.write("<h3>Successfully Inserted the data.</h3>\n");

}
else{

      out.write("\n");
      out.write("<br>\n");
      out.write("<h3>Could not add the book</h3>\n");
}
}
      out.write("\n");
      out.write("<br>\n");
      out.write("<a href=\"Logout.jsp\">Click here to Logout</a>\n");
      out.write("<br><br>\n");
      out.write("<a href=\"Admin.jsp\">Click here to go to Administrator page</a>\n");
      out.write("<br><br>\n");
      out.write("<a href=\"Insert.jsp\">Click here to add more books</a>\n");
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
