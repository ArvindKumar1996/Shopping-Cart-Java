package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <script src=\"js/jquery-3.2.1.min.js\" type=\"text/javascript\"></script>\n");
      out.write("        <script src=\"js/bootstrap.min.js\" type=\"text/javascript\"></script>\n");
      out.write("        <title>login</title>\n");
      out.write("        <script>\n");
      out.write("            \n");
      out.write("        </script>\n");
      out.write("    </head>\n");
      out.write("    <style>\n");
      out.write("        #login{\n");
      out.write("            margin-top:100px;\n");
      out.write("\n");
      out.write("        }\n");
      out.write("        .lgn{\n");
      out.write("            border: 3px solid darkgreen;\n");
      out.write("            padding:30px;\n");
      out.write("        }\n");
      out.write("        label{\n");
      out.write("            color:#0056b3;\n");
      out.write("        }\n");
      out.write("        </style>\n");
      out.write("        <script language=\"JavaScript\">\n");
      out.write("            function validate(){\n");
      out.write("                if(document.frm.UserName.value==\"\" || document.frm.Password.value==\"\"){\n");
      out.write("                    alert(UserName or Passsword can not be blank.);\n");
      out.write("                    return;\n");
      out.write("                }\n");
      out.write("                document.frm.action=\"Validate.jsp\";\n");
      out.write("                document.frm.submit();\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("    <body>\n");
      out.write("        <section id=\"login\">\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <div class=\"col-sm-3\"></div>\n");
      out.write("                    <div class=\"col-sm-6 lgn\">\n");
      out.write("                        <u> <h4 class=\"text-center\">Online Shopping Cart</h4></u>\n");
      out.write("                        <h3 class=\"text-center\">Login Here</h3>\n");
      out.write("                        <form name=\"frm\" method=\"post\">\n");
      out.write("                            <label>Username</label>\n");
      out.write("                            <input type=\"text\" class=\"form-control\" placeholder=\"Enter Username\" name=\"UserName\">\n");
      out.write("                            <label>Password</label>\n");
      out.write("                            <input type=\"password\" class=\"form-control\" placeholder=\"Enter Password\" name=\"Password\">\n");
      out.write("                            <br>\n");
      out.write("                            <input type=\"submit\" class=\"btn btn-success w-100\" value=\"Login\" name=\"B1\" onclick=\"validate();\">\n");
      out.write("                        </form>\n");
      out.write("                        <span>New user?</span><a href=\"signup.jsp\">Register here</a>\n");
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
