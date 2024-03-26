<%-- 
    Document   : queryobtained
    Created on : 4 Mar, 2024, 2:32:31 PM
    Author     : Hardik
--%>

<%@page import="db.DBConnector"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.SQLException"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <h1>Hello Admin of Pawsitive Petopia</h1>
        <h2>The below tables show the Registed User On Our Website</h2>
        <% try
        {
            Statement st = DBConnector.getStatement();
            ResultSet rs = st.executeQuery("SELECT email,name,textarea,response FROM query");
                   out.println("<table border='1'>");
                   out.println("<tr><th>E-mail</th><th>Name</th><th>Query</th><th>Answered(0/1)</th><th>Update Query Status</th><th>Answer Query</th></tr>");
                   while (rs.next()) {
                       out.println("<form action='QueryAnswered' method='post'>");                       
                       out.println("<tr>");
                       out.println("<td>" + rs.getString("email") + "</td>");
                       out.println("<td>" + rs.getString("name") + "</td>");
                       out.println("<td>" + rs.getString("textarea") + "</td>");
                       out.println("<td>" + rs.getString("response") + "</td>");
                       out.println("<INPUT TYPE=HIDDEN NAME=name value='"+ rs.getString("name") +"'>");
                       out.println("<INPUT TYPE=HIDDEN NAME=email value='"+rs.getString("email")+"'>");
                       out.println("<td><input id='button'  type='submit' value='Update Status' ></td>");
                       out.println("<td><a href= ><button>Answer</button></a>");
                       out.println("</tr>");
                       out.println("</form>");
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
