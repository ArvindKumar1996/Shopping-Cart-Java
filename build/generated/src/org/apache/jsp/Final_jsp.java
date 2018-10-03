package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import java.util.*;

public final class Final_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>Final</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        \n");
      out.write("        ");

           String user_src=(String)session.getValue("user");
           if(user_src!=null){
               Connection conn;
               conn=null;
               ResultSet rs;
               rs=null;
               Class.forName("");
               conn=DriverManager.getConnection("");
               Statement stat1=conn.createStatement();
               Statement stat_sel=conn.createStatement();
               Statement stat_ins=conn.createStatement();
               int OrderID=(int)(10000*Math.random()+1);
               int price=Integer.parseInt((String)session.getValue("bPrice"));
               int counter=0;
               counter=Integer.parseInt((String)session.getValue("TotalSel"));
               
               int[] bookid=new int[counter];
               int[] bk_quantity=new int[counter];
               int org_bkqty=0;
               int i=0;
               
               String ins_query="";
               String sel_qtyQuery="";
               String ins_qty="";
               
               for(i=1;i<=counter;i++){
                   ResultSet rs_sql=null;
                   if((String)session.getValue("chk_var"+i)!=null){
                       bookid[i-1]=Integer.parseInt((String)session.getValue("chk_var"+i));
                   }
                   if((String)session.getValue("bookqty"+1)!=null){
                       bk_quantity[i-1]=Integer.parseInt((String)session.getValue("bookqty"+i));
                   }
                   ins_query="insert into ORDER_DETAILS VALUES("+OrderID+","+bookid[i-1]+","+bk_quantity[i-1]+")";
                   int rs_int=0;
                   rs_int=stat1.executeUpdate(ins_query);
                   sel_qtyQuery="SELECT QUANTITY FROM BOOK_DETAILS WHERE BOOKID="+bookid[i-1]+"";
                   rs_sql=stat_sel.executeQuery(sel_qtyQuery);
                   if(rs_sql.next()){
                       org_bkqty=rs_sql.getInt(1);
                   }
                   rs_sql.close();
                   ins_query="UPDATE BOOK_DETAILS SET QUANTITY="+(org_bkqty-bk_quantity[i-1])+"WHERE BOOKID="+bookid[i-1]+"";
                   rs_int=stat_ins.executeUpdate(ins_query);
               }
               String insertQuery="";
        
      out.write("\n");
      out.write("        <section>\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <div class=\"col-sm-3\"></div>\n");
      out.write("                    <div class=\"col-sm-6\">\n");
      out.write("                        <h2><u>Online Shopping cart</u></h2>\n");
      out.write("                        <br><br>\n");
      out.write("                        <h3>Order Details</h3>\n");
      out.write("                        <br>\n");
      out.write("                        <a href=\"Logout.jsp\">Click here to Logout</a>\n");
      out.write("                        <form name=\"newsrc\" method=\"post\">\n");
      out.write("                            <br>\n");
      out.write("                            <b>Your Order has been successfully placed.</b>\n");
      out.write("                            <br><br>Order Number is :");
      out.print(OrderID);
      out.write("\n");
      out.write("                            <br><br>Total Amount is :");
      out.print(price);
      out.write("\n");
      out.write("                            <br><br>Date of Order is :\n");
      out.write("                            ");

                                out.println((new java.util.Date()).toLocaleString());
                                
      out.write("\n");
      out.write("                                <br><br>Your order will be delievered within next 48 working hours\n");
      out.write("                                ");

                                    String card_no=request.getParameter("Card");
                                    Statement stat=conn.createStatement();
                                    insertQuery="insert into ORDER_TABLE values("+OrderID+",'"+user_src+"',"+price+",sysdate,'"+card_no+"')";
                                    int rsint=stat.executeUpdate(insertQuery);
                                    }
                                    else{
                                            response.sendRedirect("Unauthorised.html");
                                        }
                                
      out.write("\n");
      out.write("                        </form> \n");
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
