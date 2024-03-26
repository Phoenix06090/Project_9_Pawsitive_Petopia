<%@page import="db.DBConnector"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.SQLException"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String petowner = (String)session.getAttribute("username");
            String password = (String)session.getAttribute("password");
            try{
                Statement st = DBConnector.getStatement();
                String query = "DELETE FROM pet where petowner ='"+petowner+"' and password ='"+password+"' ";
            
            int i = st.executeUpdate(query);

            if(i>0)
            {
                System.out.println(i+" Record Deleted...");
                response.sendRedirect("AboutUs.html");
            }
            else
            {
                System.out.println("Record Deletion Failed..");
                response.sendRedirect("DogHome.jsp");
            }
            }
        catch(SQLException e)
        {
            System.out.println(e);
        }
            
        %>
        
    </body>
</html>
