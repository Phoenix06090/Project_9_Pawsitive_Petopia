<%-- 
    Document   : showregistration
    Created on : 4 Mar, 2024, 12:37:13 PM
    Author     : Hardik
--%>

<%@page import="java.sql.SQLException"%>
<%@page import="db.DBConnector"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body bgcolor>
        <h1>Hello Admin of Pawsitive Petopia</h1>
        <h2>The below tables show the Registed User On Our Website</h2>
        <%
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
        %>
    </body>
</html>
