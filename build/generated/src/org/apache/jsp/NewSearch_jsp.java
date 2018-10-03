package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class NewSearch_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>New Search</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        \n");
      out.write("        ");

            String user_src=(String)session.getValue("user");
            if(user_src!=null){
                String str_searchvar=null;
                String str_colvar=null;
                String query="";
                String tab_var="";
                int total_sel=Integer.parseInt((String)session.getValue("TotalSel"));
                int[] old_bookid=new int[total_sel];
                Connection conn;
                conn=null;
                ResultSet rs;
                rs=null;
                Class.forName("");
                conn=DriverManager.getConnection("");
                Statement stat=conn.createStatement();
                Statement stat_del=conn.createStatement();
                Statement stat_ins=conn.createStatement();
               for(int i=1;i<=total_sel;i++){
                   old_bookid[i-1]=Integer.parseInt((String)session.getValue("chk_var"+i));
               }
               
      out.write("\n");
      out.write("        <section>\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <div class=\"col-sm-3\"></div>\n");
      out.write("                    <div class=\"col-sm-6\">\n");
      out.write("                        <h2><u>Online Shopping Cart</u></h2>\n");
      out.write("                        <br><br>\n");
      out.write("                        <a href=\"Logout.jsp\">Click here to Logout</a>\n");
      out.write("                        <br><br>\n");
      out.write("                        <h3>Your cart Details are as follows:</h3>\n");
      out.write("                        <form name=\"shop\" action=\"cart_Quantity.jsp\">\n");
      out.write("                            <table class=\"table\">\n");
      out.write("                                <tr>\n");
      out.write("                                    <td>S.No</td>\n");
      out.write("                                    <td>Book Name</td>\n");
      out.write("                                    <td>Price(in Rs.)</td>\n");
      out.write("                                </tr>\n");
      out.write("                                ");
 
                                   int price=0;int bookprice=0;
                                   for(int j=0;j<total_sel;j++){
                                       out.println("<tr><td>"+j+1);
                                       
                                       query="select title,price from book_details where bookid="+old_bookid[j]+"";
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
                                       out.println("</tr>");
                                   }
                                
      out.write("\n");
      out.write("                                <tr>\n");
      out.write("                                    <td>\n");
      out.write("                                        Total Cart Amount(in Rs.)=\n");
      out.write("                                        ");
      out.print(bookprice);
      out.write("\n");
      out.write("                                    </td>\n");
      out.write("                                </tr>\n");
      out.write("                            </table>\n");
      out.write("                                    <br>\n");
      out.write("                                    <input type=\"submit\" value=\"Place Order\">\n");
      out.write("                        </form>\n");
      out.write("                                    ");

                                       String test_src=null;
                                       int chk_ctr=0;
                                       
                             if(request.getParameter("R1").equals("Title")){
                                 str_searchvar=request.getParameter("BookTitle");
                                 str_colvar="Title";
                             }
                             if(request.getParameter("R1").equals("Category")){
                                 chk_ctr=1;
                                 str_searchvar=request.getParameter("BookCategory");
                                 str_colvar="CategoryName";
                             }
                             if(request.getParameter("R1").equals("Publisher")){
                                 str_searchvar=request.getParameter("BookPublisher");
                                 str_colvar="Publisher";
                             }
                             if(request.getParameter("R1").equals("Author")){
                                 str_searchvar=request.getParameter("BookAuthor");
                                 str_colvar="Author";
                             }
                             if(request.getParameter("R2")==null){
                                 tab_var="BOOK_DETAILS";
                             }
                             else{
                                 //to get the name of the table in which the search to be done-----------
                                 if(request.getParameter("R2").equals("A")){
                                     tab_var="TEMP_DETAIL";
                                 }
                                 else{
                                     tab_var="BOOK_DETAILS";
                                 }
                             }
                             //----------------Whether search is by category or other criteria------------------
                             if(chk_ctr==0){
                                 query="select a.*,b.categoryname from "+tab_var+"a,CATEGORY_DETAILS b where a."+str_colvar+"='"+str_searchvar+"' and a.categoryid=b.categoryid";
                             }
                             else{
                                 query="select a.*,b.categoryname from "+tab_var+"a.CATEGORY_DETAILS b where b."+str_colvar+"='"+str_searchvar+"' and a.categoryid=b.categoryiid";
                             }
                             try{
                                 rs=stat.executeQuery(query);
                                 int ctr=0; 
      out.write("\n");
      out.write("                                 <h3>Search results are as follows:</h3>\n");
      out.write("                                 <form name=\"cart\" action=\"NewInter_cart.jsp\" method=\"post\">\n");
      out.write("                                     <table class=\"table\">\n");
      out.write("                                         <tr>\n");
      out.write("                                             <td>S.No</td>\n");
      out.write("                                             <td>Select</td>\n");
      out.write("                                             <td>Book Name</td>\n");
      out.write("                                             <td>Author Name</td>\n");
      out.write("                                             <td>Publisher</td>\n");
      out.write("                                             <td>Edition</td>\n");
      out.write("                                             <td>Price(in Rs.)</td>\n");
      out.write("                                             <td>Quantity Available(Nos.)</td>\n");
      out.write("                                             <td>Description</td>\n");
      out.write("                                             <td>Category</td>\n");
      out.write("                                         </tr>\n");
      out.write("                                         ");

                                            String delete_query="delete from TEMP_DETAIL";
                                            String ins_query=null;
                                            int int_BOOKID,int_CATEGORYID,int_PRICE,int_QUANTITY;
                                            String str_TITLE,str_AUTHOR,str_PUBLISHER,str_EDITION,str_DESCRIPTION;
                                            int rs_del=stat.executeUpdate(delete_query);
                                            while(rs.next()){
                                                ctr=ctr+1;
                                                out.println("<tr><td>"+ctr);
                                                int_BOOKID=rs.getInt(1);
                                                out.println("<td><input type=checkbox name=chk"+ctr+" value="+int_BOOKID+">");
                                                
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
                                                ins_query="insert into TEMP_DETAIL VALUES("+int_BOOKID+","+int_CATEGORYID+",'"+str_TITLE+"','"+str_AUTHOR+"','"+str_PUBLISHER+"','"+str_EDITION+"',"+int_PRICE+","+int_QUANTITY+",'"+str_DESCRIPTION+"')";
                                                int rs_ins=stat_ins.executeUpdate(ins_query);
                                            }
                                            String str_ctr=String.valueOf(ctr);
                                            session.putValue("ctr_val", str_ctr);
                                         
      out.write("\n");
      out.write("                                     </table>\n");
      out.write("                                     <input type=\"submit\" value=\"Add to Cart\" name=\"Add\" class=\"btn btn-success\">\n");
      out.write("                                 </form>\n");
      out.write("                                ");

                                   Statement stat_combo=conn.createStatement();
                                   ResultSet rscombo=null;
                                   String query1="select * from category_details";
                                   rscombo=stat_combo.executeQuery(query1);
                                
      out.write("\n");
      out.write("                                <br>\n");
      out.write("                                <h3>Search results are as follows:</h3>\n");
      out.write("                                <form name=\"newsrc\" action=\"NewSearch.jsp\" method=\"post\">\n");
      out.write("                                    <table class=\"table\">\n");
      out.write("                                        <tr>\n");
      out.write("                                            <td>\n");
      out.write("                                                <input type=\"radio\" value=\"Category\" checked name=\"R1\" >\n");
      out.write("                                            </td>\n");
      out.write("                                            <td>Search based on Category</td>\n");
      out.write("                                            <td>\n");
      out.write("                                                <select name=\"BookCategory\">\n");
      out.write("                                                    <option selected value=\"Select\">Select Category</option>\n");
      out.write("                                                    ");

                                                        while(rscombo.next()){
                                                            String category=rscombo.getString(2);
                                                            
      out.write("\n");
      out.write("                                                            <option value=\"");
      out.print(category);
      out.write('"');
      out.write('>');
      out.print(category);
      out.write("</option>\n");
      out.write("                                                            ");

                                                        }
                                                        
      out.write("\n");
      out.write("                                                </select>\n");
      out.write("                                            </td>\n");
      out.write("                                        </tr>\n");
      out.write("                                        <tr>\n");
      out.write("                                            <td>\n");
      out.write("                                                <input type=\"radio\" name=\"R1\" value=\"Title\">\n");
      out.write("                                            </td>\n");
      out.write("                                            <td>Search by Book Title</td>\n");
      out.write("                                            <td>\n");
      out.write("                                                <input type=\"text\" name=\"BookTitle\">\n");
      out.write("                                            </td>\n");
      out.write("                                        </tr>\n");
      out.write("                                        <tr>\n");
      out.write("                                            <td>\n");
      out.write("                                                <input type=\"radio\" name=\"R1\" value=\"Author\" >\n");
      out.write("                                            </td>\n");
      out.write("                                            <td>Search by Book Author</td>\n");
      out.write("                                            <td>\n");
      out.write("                                                <input type=\"text\" name=\"BookAuthor\" >\n");
      out.write("                                            </td>\n");
      out.write("                                        </tr>\n");
      out.write("                                        <tr>\n");
      out.write("                                        <td>\n");
      out.write("                                            <input type=\"radio\" name=\"R1\" value=\"Publisher\">\n");
      out.write("                                        </td>\n");
      out.write("                                        <td>Search by Book Publisher</td>\n");
      out.write("                                        <td>\n");
      out.write("                                            <input type=\"text\" name=\"BookPublisher\">\n");
      out.write("                                        </td>\n");
      out.write("                                        </tr>\n");
      out.write("                                        <tr>\n");
      out.write("                                            <td>\n");
      out.write("                                                <input type=\"radio\" name=\"R2\" value=\"A\" >Advanced Search\n");
      out.write("                                            </td>\n");
      out.write("                                            <td>\n");
      out.write("                                                <input type=\"radio\" name=\"R2\" value=\"N\" checked>New Search\n");
      out.write("                                            </td>\n");
      out.write("                                            <td>\n");
      out.write("                                                <input type=\"submit\" value=\"Search\">\n");
      out.write("                                            </td>\n");
      out.write("                                        </tr>\n");
      out.write("                                    </table>\n");
      out.write("                                </form>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-sm-3\"></div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </section>\n");
      out.write("                                             ");
}
                          catch(Exception E){
                                   out.println("Error "+E);
                            }
                           finally{
conn.close();
}
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
