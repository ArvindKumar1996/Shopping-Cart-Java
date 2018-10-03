package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class Sign_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        \n");
      out.write("        ");
 
            Connection conn;
            conn=null;
            ResultSet rs;
            rs=null;
            String UserName=request.getParameter("UserName");
            String Password=request.getParameter("Password");
            String Password2=request.getParameter("Password2");
            String FirstName=request.getParameter("FirstName");
            String MiddleName=request.getParameter("MiddleName");
            String LastName=request.getParameter("LastName");
            String Address1=request.getParameter("Address1");
            String Address2=request.getParameter("Address2");
            String City=request.getParameter("City");
            String State=request.getParameter("State");
            String PinCode=request.getParameter("PinCode");
            String Email=request.getParameter("Email");
            String Phone=request.getParameter("Phone");
            int flag=0;
            try{
                Class.forName("oracle.jdbc.driver.OracleDriver");
                conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","cart","root");
                PreparedStatement stat=conn.prepareStatement("SELECT * FROM user_profile where username=?");
                stat.setString(1,UserName);
                rs=stat.executeQuery();
                if(rs.next()){
                    flag=1;
                    
      out.write("\n");
      out.write("                    <Script language=\"JavaScript\">\n");
      out.write("                        alert(\"User name already exists\");\n");
      out.write("                        location.href=\"signup.jsp\";\n");
      out.write("                    ");

                }
           else{
                conn.close();
              }
            }
catch (Exception E) {
out.println("Error " + E);
}
if (flag == 0) {
try {
  Class.forName("oracle.jdbc.driver.OracleDriver");
  conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "cart", "root");
  PreparedStatement stat1 = conn.prepareStatement("INSERT INTO user_auth values(?,?)");
  stat1.setString(1,UserName);
  stat1.setString(2,Password);
  PreparedStatement stat = conn.prepareStatement("INSERT INTO user_profile values(?,?,?,?,?,?,?,?,?,?,?,?)");
  stat.setString(1, UserName);
  stat.setString(2, Password);
  stat.setString(3, FirstName);
  stat.setString(4, MiddleName);
  stat.setString(5, LastName);
  stat.setString(6, Address1);
  stat.setString(7, Address2);
  stat.setString(8, City);
  stat.setString(9, State);
  stat.setString(10, PinCode);
  stat.setString(11, Email);
  stat.setString(12, Phone);
  stat1.executeUpdate();
  stat.executeUpdate();
  flag=0;
  response.sendRedirect("login.jsp");
}
catch(Exception E){
out.println("Error inserting value"+E);
}
finally{
rs.close();
conn.close();
}
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
