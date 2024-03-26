package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.SQLException;
import java.sql.ResultSet;
import db.DBConnector;
import java.sql.Statement;

public final class Accountinfo_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Account information</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        \n");
      out.write("<!--        <button<a href=\"UpdateDetails.html\">Update Details</a>></button>\n");
      out.write("        <button<a href=\"SignOut.jsp\">Sign Out</a>></button>-->\n");
      out.write("        <!--<button<a href=\"LogOut.jsp\">Log Out</a>></button>-->\n");
      out.write("        ");

            String petowner = (String)session.getAttribute("username");
            String password = (String)session.getAttribute("password");
            String pettype="";
            String petname="";
            String petage="";
            String vaccinecount="";
            String phone="";
            String city="";
            String location="";
            String mailid="";
            
             try
        {
            Statement st = DBConnector.getStatement();
            ResultSet rs = st.executeQuery("SELECT petowner,pettype,petname,petage,vaccinecount,phone,city,location,mailid from pet where petowner='"+petowner+"' and password='"+password+"' ");
            while(rs.next())
            {
                petowner= rs.getString(1);
                pettype=rs.getString(2);
                petname=rs.getString(3);
                petage=rs.getString(4);
                vaccinecount=rs.getString(5);
                phone=rs.getString(6);
                city=rs.getString(7);
                location=rs.getString(8);
                mailid=rs.getString(9);
            }
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
        
      out.write("\n");
      out.write("        <table>\n");
      out.write("            <tr>\n");
      out.write("                <td>Pet Owner:</td>\n");
      out.write("                <td>");
      out.print(petowner);
      out.write("</td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <td>Pet Type</td>\n");
      out.write("                <td>");
      out.print(pettype);
      out.write("</td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <td>Pet Name:</td>\n");
      out.write("                <td>");
      out.print(petname);
      out.write("</td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <td>Pet Age:</td>\n");
      out.write("                <td>");
      out.print(petage);
      out.write("</td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <td>Vaccine count:</td>\n");
      out.write("                <td>");
      out.print(vaccinecount);
      out.write("</td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <td>Contact no.:</td>\n");
      out.write("                <td>");
      out.print(phone);
      out.write("</td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <td>City</td>\n");
      out.write("                <td>");
      out.print(city);
      out.write("</td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <td>Area</td>\n");
      out.write("                <td>");
      out.print(location);
      out.write("</td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <td>E-Mail Id:</td>\n");
      out.write("                <td>");
      out.print(mailid);
      out.write("</td>\n");
      out.write("            </tr>\n");
      out.write("        </table>\n");
      out.write("        <a href=\"UpdateDetails.jsp\">Update Details</a>\n");
      out.write("        <br>\n");
      out.write("        <a href=\"SignOut.jsp\">Sign Out</a>\n");
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
