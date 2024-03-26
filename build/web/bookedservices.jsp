<%-- 
    Document   : booking
    Created on : 4 Mar, 2024, 8:31:41 PM
    Author     : Hardik
--%>

<%@page import="controller.UpdateService"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="db.DBConnector"%>
<%@page import="java.sql.Statement"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <h1>Hello Admin of Pawsitive Petopia</h1>
        <h2>The below tables show the Booked Services bye the Registered User On Our Website</h2>
        <% try
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
        %>
    </body>
</html>
