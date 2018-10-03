package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.net.*;
import java.io.*;
import java.sql.*;

public final class Insert_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>Insert</title>\n");
      out.write("        <script language=\"JavaScript\">\n");
      out.write("            function check(){\n");
      out.write("                var ctr=0;\n");
      out.write("                if(document.addbook.title.value==\"\"){\n");
      out.write("                    alert(\"Please enter title\");\n");
      out.write("                    return;\n");
      out.write("                }\n");
      out.write("                if(document.addbook.author.value==\"\"){\n");
      out.write("                    alert(\"Please enter author\");\n");
      out.write("                    return;\n");
      out.write("                }\n");
      out.write("                if(document.addbook.pub.value==\"\"){\n");
      out.write("                    alert(\"Please enter publisher name\");\n");
      out.write("                    return;\n");
      out.write("                }\n");
      out.write("                if(document.addbook.edition.value==\"\"){\n");
      out.write("                    alert(\"Please enter edition\");\n");
      out.write("                    return;\n");
      out.write("                }\n");
      out.write("                if(document.addbook.price.value==\"\"){\n");
      out.write("                 alert(\"Please enter price (in Rs.\");\n");
      out.write("                 return;\n");
      out.write("                }\n");
      out.write("                if(document.addbook.qty.value==\"\"){\n");
      out.write("                    alert(\"Please enter quantity\");\n");
      out.write("                    return;\n");
      out.write("                }\n");
      out.write("                if(document.addbook.desc.value==\"\"){\n");
      out.write("                    alert(\"Please enter description\");\n");
      out.write("                    return;\n");
      out.write("                }\n");
      out.write("                if(isNaN(document.addbook.price.value==\"\")){\n");
      out.write("                    alert(\"Please enter a numeric value for price (in Rs.)\");\n");
      out.write("                    ctr=1;\n");
      out.write("                }\n");
      out.write("                if(isNaN(document.addbook.qty.value==\"\")){\n");
      out.write("                    alert(\"Please enter a numeric value for quantity\");\n");
      out.write("                    ctr=1;\n");
      out.write("                }\n");
      out.write("                if(ctr==0){\n");
      out.write("                    document.forms[0].action=\"AddBook.jsp\";\n");
      out.write("                    document.forms[0].submit();\n");
      out.write("                }\n");
      out.write("                else{\n");
      out.write("                    return true;\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("            </script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        \n");
      out.write("        \n");
      out.write("        \n");
      out.write("        ");
 
           Connection con=null;
           Statement stat=null;
           Statement stat1=null;
           ResultSet rs=null;
           ResultSet rs1=null;
           
           String query=null;
           String query1=null;
           int ctr=0,flag=0;
           try{
               Class.forName("oracle.jdbc.driver.OracleDriver");
               con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","cart","root");
               stat=con.createStatement();
               stat1=con.createStatement();
               
               query="select a.*,b.categoryname from book_details a,category_details b where a.categoryid=b.categoryid";
               query1="select * from category_details";
               
               rs=stat.executeQuery(query);
               rs1=stat1.executeQuery(query1);
               
      out.write("\n");
      out.write("        <section>\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <div class=\"col-sm\"></div>\n");
      out.write("                    <div class=\"col-sm-12\">\n");
      out.write("                        <h2 class=\"text-center\"><u>Administering Online Shopping Cart</u></h2>\n");
      out.write("                        <br>\n");
      out.write("                        <br>\n");
      out.write("                        <a href=\"Logout.jsp\">Click here to Logout</a>\n");
      out.write("                        <br>\n");
      out.write("                        <br>\n");
      out.write("                        <h3>List of Available Books :</h3>\n");
      out.write("                        <form name=\"addbook\" method=\"post\">\n");
      out.write("                        <table class=\"table table-bordered\">\n");
      out.write("                            <tr>\n");
      out.write("                                <td>S.No</td>\n");
      out.write("                                <td>Book Id</td>\n");
      out.write("                                <td>Author Name</td>\n");
      out.write("                                <td>Publisher</td>\n");
      out.write("                                <td>Edition</td>\n");
      out.write("                                <td>Price (in Rs.)</td>\n");
      out.write("                                <td>Quantity Available(Nos.)</td>\n");
      out.write("                                <td>Description</td>\n");
      out.write("                                <td>Category</td>\n");
      out.write("                            </tr>\n");
      out.write("                            ");

                                int int_BOOKID,int_CATEGORYID,int_PRICE,int_QUANTITY;
                                String str_TITLE,str_AUTHOR,str_PUBLISHER,str_EDITION,str_DESCRIPTION;
                                while(rs.next()){
                                    ctr=ctr+1;
                                    out.println("<tr><td>"+ctr);
                                    int_BOOKID=rs.getInt(1);
                                    out.println("<td>");
                                    out.println(int_BOOKID);
                                    
                                    int_CATEGORYID=rs.getInt(2);
                                    
                                    str_TITLE=rs.getString(3);
                                    out.println("<td>");
                                    out.println(str_TITLE);
                                    
                                    str_AUTHOR=rs.getString(4);
                                    out.println("<td>");
                                    out.println(str_AUTHOR);
                                    
                                    str_PUBLISHER=rs.getString(5);
                                    out.println("<td>");
                                    out.println(str_PUBLISHER);
                                    
                                    str_EDITION=rs.getString(6);
                                    out.println("<td>");
                                    out.println(str_EDITION);
                                    
                                    int_PRICE=rs.getInt(7);
                                    out.println("<td>");
                                    out.println(int_PRICE);
                                    
                                    int_QUANTITY=rs.getInt(8);
                                    out.println("<td>");
                                    out.println(int_QUANTITY);
                                    
                                    str_DESCRIPTION=rs.getString(9);
                                    out.println("<td>");
                                    out.println(str_DESCRIPTION);
                                    
                                    out.println("<td>");
                                    out.println(rs.getString(10));
                                    
                                    out.println("</tr>");
                                }
                                out.println("</table>");
                                
      out.write("\n");
      out.write("                                <br>\n");
      out.write("                                <hr>\n");
      out.write("                                <h3>Add New Book Details</h3>\n");
      out.write("                                \n");
      out.write("                                    <table class=\"table\">\n");
      out.write("                                        <tr>\n");
      out.write("                                            <td>Book Title</td>\n");
      out.write("                                            <td>\n");
      out.write("                                                <input type=\"text\" class=\"form-control\" name=\"title\">\n");
      out.write("                                            </td>\n");
      out.write("                                        </tr>\n");
      out.write("                                        <tr>\n");
      out.write("                                            <td>Author Name</td>\n");
      out.write("                                            <td>\n");
      out.write("                                                <input type=\"text\" class=\"form-control\" name=\"author\">\n");
      out.write("                                            </td>\n");
      out.write("                                        </tr>\n");
      out.write("                                        <tr>\n");
      out.write("                                            <td>Publisher</td>\n");
      out.write("                                            <td>\n");
      out.write("                                                <input type=\"text\" class=\"form-control\" name=\"pub\">\n");
      out.write("                                            </td>\n");
      out.write("                                        </tr>\n");
      out.write("                                        <tr>\n");
      out.write("                                            <td>Edition</td>\n");
      out.write("                                            <td>\n");
      out.write("                                                <input type=\"text\" class=\"form-control\" name=\"edition\">\n");
      out.write("                                            </td>\n");
      out.write("                                        </tr>\n");
      out.write("                                        <tr>\n");
      out.write("                                            <td>Price (in Rs.)</td>\n");
      out.write("                                            <td>\n");
      out.write("                                                <input type=\"text\" class=\"form-control\" name=\"price\">\n");
      out.write("                                            </td>\n");
      out.write("                                        </tr>\n");
      out.write("                                        <tr>\n");
      out.write("                                            <td>Quantity Available</td>\n");
      out.write("                                            <td>\n");
      out.write("                                                <input type=\"text\" class=\"form-control\" name=\"qty\">\n");
      out.write("                                            </td>\n");
      out.write("                                        </tr>\n");
      out.write("                                        <tr>\n");
      out.write("                                            <td>Description</td>\n");
      out.write("                                            <td>\n");
      out.write("                                                <input type=\"text\" class=\"form-control\" name=\"desc\">\n");
      out.write("                                            </td>\n");
      out.write("                                        </tr>\n");
      out.write("                                        <tr>\n");
      out.write("                                            <td>Category</td>\n");
      out.write("                                            <td>\n");
      out.write("                                                <select name=\"cat\" class=\"form-control\">\n");
      out.write("                                                    ");

                                                        while(rs1.next()){
                                                            
      out.write("\n");
      out.write("                                                            <option value=\"");
      out.print(rs1.getString(1));
      out.write('"');
      out.write('>');
      out.print(rs1.getString(2));
      out.write("</option>\n");
      out.write("                                                        ");
}
      out.write("\n");
      out.write("                                                </select>\n");
      out.write("                                            </td>\n");
      out.write("                                        </tr>\n");
      out.write("                                        <br>\n");
      out.write("                                        <tr>\n");
      out.write("                                            <td>\n");
      out.write("                                                <input type=\"submit\"  value=\"Add\" onClick=\"check();\" class=\"btn btn-primary w-50\">\n");
      out.write("                                            </td>\n");
      out.write("                                            <td>\n");
      out.write("                                                <input type=\"Reset\"  value=\"Clear\" class=\"btn btn-danger w-50\">\n");
      out.write("                                            </td>\n");
      out.write("                                            <td>\n");
      out.write("                                        </tr>\n");
      out.write("                                    </table>\n");
      out.write("                                </form>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-sm\"></div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </section>\n");
      out.write("                                                    ");

                                                        }
                                                catch(Exception e){
                                              out.print("Error = "+e+"<hr>");
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
