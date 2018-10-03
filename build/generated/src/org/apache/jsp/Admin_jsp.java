package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Admin_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>Admin</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <section>\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <div class=\"col\">\n");
      out.write("                        <h2 class=\"text-center\"><u>Administering Online Shopping Cart</u></h2>\n");
      out.write("                        <br>\n");
      out.write("                        <hr>\n");
      out.write("                        <br>\n");
      out.write("                        <h3 class=\"text-center\">Welcome Administrator</h3>\n");
      out.write("                        <form name=\"admin\" method=\"post\">\n");
      out.write("                            <table class=\"table\">\n");
      out.write("                                <tr>\n");
      out.write("                                    <th></th>\n");
      out.write("                                    <th></th>\n");
      out.write("                                    <th></th>\n");
      out.write("                                    <th></th>\n");
      out.write("                                </tr>\n");
      out.write("                                <tr>\n");
      out.write("                                    <th>1</th>\n");
      out.write("                                    <th>Book</th>\n");
      out.write("                                    <th><a href=\"Insert.jsp\">Insert new Book Details</a></th>\n");
      out.write("                                    <th><a href=\"Modify.jsp\">Modify Book Details</a></th>\n");
      out.write("                                </tr>\n");
      out.write("                                <tr>\n");
      out.write("                                    <th>2</th>\n");
      out.write("                                    <th>Category</th>\n");
      out.write("                                    <th><a href=\"Insert_Category.jsp\">Insert Book Category</a></th>\n");
      out.write("                                    <th><a href=\"Update_Category.jsp\">Modify Book Category</a></th>\n");
      out.write("                                </tr>\n");
      out.write("                            </table>\n");
      out.write("                        </form>\n");
      out.write("                    </div>\n");
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
