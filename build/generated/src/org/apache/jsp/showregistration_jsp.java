package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.SQLException;
import db.DBConnector;
import java.sql.Statement;
import java.sql.ResultSet;

public final class showregistration_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>Hello Admin of Pawsitive Petopia</h1>\n");
      out.write("        <h2>The below tables show the Registed User On Our Website</h2>\n");
      out.write("        ");

            String petowner = (String)session.getAttribute("username");
            String password = (String)session.getAttribute("password");
//            String pettype="";
//            String petname="";
//            String petage="";
//            String vaccinecount="";
//            String phone="";
//            String city="";
//            String location="";
//            String mailid="";
            try
        {
            Statement st = DBConnector.getStatement();
            ResultSet rs = st.executeQuery("SELECT petowner, pettype,petname,petage,vaccinecount,phone,city,location,mailid from pet Where NOT petname='Pawsitive' ");
            
                   out.println("<table border='1'>");
                   out.println("<tr><th>Pet Owner</th><th>Pet Type</th><th>Pet Name</th><th>Pet Age</th><th>Vaccine Count</th><th>Phone</th><th>City</th><th>Location</th><th>Email</th></tr>");
                   while (rs.next()) {
                       out.println("<tr>");
                       out.println("<td>" + rs.getString("petowner") + "</td>");
                       out.println("<td>" + rs.getString("pettype") + "</td>");
                       out.println("<td>" + rs.getString("petname") + "</td>");
                       out.println("<td>" + rs.getInt("petage") + "</td>");
                       out.println("<td>" + rs.getInt("vaccinecount") + "</td>");
                       out.println("<td>" + rs.getString("phone") + "</td>");
                       out.println("<td>" + rs.getString("city") + "</td>");
                       out.println("<td>" + rs.getString("location") + "</td>");
                       out.println("<td>" + rs.getString("mailid") + "</td>");
                       out.println("</tr>");
                   }
                   out.println("</table>");
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
