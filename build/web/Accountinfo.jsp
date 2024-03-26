
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="db.DBConnector"%>
<%@page import="java.sql.Statement"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Account information</title>
    </head>
    <body>
        
<!--        <button<a href="UpdateDetails.html">Update Details</a>></button>
        <button<a href="SignOut.jsp">Sign Out</a>></button>-->
        <!--<button<a href="LogOut.jsp">Log Out</a>></button>-->
        <%
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
        %>
        <table>
            <tr>
                <td>Pet Owner:</td>
                <td><%=petowner%></td>
            </tr>
            <tr>
                <td>Pet Type</td>
                <td><%=pettype%></td>
            </tr>
            <tr>
                <td>Pet Name:</td>
                <td><%=petname%></td>
            </tr>
            <tr>
                <td>Pet Age:</td>
                <td><%=petage%></td>
            </tr>
            <tr>
                <td>Vaccine count:</td>
                <td><%=vaccinecount%></td>
            </tr>
            <tr>
                <td>Contact no.:</td>
                <td><%=phone%></td>
            </tr>
            <tr>
                <td>City</td>
                <td><%=city%></td>
            </tr>
            <tr>
                <td>Area</td>
                <td><%=location%></td>
            </tr>
            <tr>
                <td>E-Mail Id:</td>
                <td><%=mailid%></td>
            </tr>
        </table>
        <a href="UpdateDetails.jsp">Update Details</a>
        <br>
        <a href="SignOut.jsp">Sign Out</a>
    </body>
</html>
