package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import controller.UpdateService;
import java.sql.SQLException;
import java.sql.ResultSet;
import db.DBConnector;
import java.sql.Statement;

public final class bookedservices_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        \n");
      out.write("        <h1>Hello Admin of Pawsitive Petopia</h1>\n");
      out.write("        <h2>The below tables show the Booked Services bye the Registered User On Our Website</h2>\n");
      out.write("        ");
 try
        {
            Statement st = DBConnector.getStatement();
            ResultSet rs = st.executeQuery("SELECT name,password,service,servicedone FROM bookedservice");
            
                   out.println("<form action='UpdateService' method='post'>");
                   out.println("<table border='1'>");
                   out.println("<tr><th>Name</th><th>Password</th><th>Service</th><th>Service Done(0/1)</th><th>Update Service Status</th></tr>");
                   while (rs.next()) {
                       out.println("<tr>");
                       out.println("<td>" + rs.getString("name") + "</td>");
                       out.println("<td>" + rs.getString("password") + "</td>");
                       out.println("<td>" + rs.getString("service") + "</td>");
                       out.println("<td>" + rs.getString("servicedone") + "</td>");
                       out.println("<INPUT TYPE=HIDDEN NAME=name value='"+ rs.getString("name") +"'>");
                       out.println("<INPUT TYPE=HIDDEN NAME=password value='"+ rs.getString("password") +"'>");
                       out.println("<td><input id='button'  type='submit' value='Update Status' ></td>");
                       out.println("</tr>");
                   }
                   out.println("</table>");
                   out.println("</form>");
        }
        catch(SQLException e)
        {
            System.out.println(e);
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
