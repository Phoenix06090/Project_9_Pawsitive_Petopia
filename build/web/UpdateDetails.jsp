<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
       <%
            String username = (String)session.getAttribute("username");
            String loginpassword =(String)session.getAttribute("password");
        %>
        <h1>Hello<%=username%>..!</h1>
        <h2>You May update your Details Here</h2>
        <form action="UpdateChecker" method="post">
            <table>
                <tr>
                    <td><strong>Pet Owner:</strong></td>
                    <td><input type="text" name="petowner" placeholder="Enter Pet Owner Name Here" ></td> 
                </tr>
                <tr>
                    <td><strong>Pet Type:</strong></td>
                    <td><select name="pettype" class="" >
                                <option value="" >Category</option>
                                <option value="Dog">DOG</option>
                                <option value="Cat">CAT</option>
                                <option value="Fish">FISH</option>
                                <option value="Rabbit">RABBIT</option>
                                <option value="Bird">BIRDS</option></td>
               </tr>
               <tr>
                    <td><strong>Pet Name:</strong></td>
                    <td><input type="text" name="petname" placeholder="Enter Pet Name Here" ></td>
               </tr>
               <tr>
                    <td><strong>Pet Age:</strong></td>
                    <td><input type="text" name="petage" placeholder="Enter Pet Age Here" ></td>
               </tr>
               <tr>
                    <td><strong>Pet's Vaccination Count:</strong></td>
                    <td><input type="text" name="vaccinecount" placeholder="Enter Pet's Vaccination Cout Here" ></td>
               </tr>
               <tr>
                    <td><strong>Contact no.:</strong></td>
                    <td><input type="text" name="phone" placeholder="Enter  your Contact no. Here" ></td>
               </tr>
               <tr>
                    <td><strong>City:</strong></td>
                    <td><input type="text" name="city" placeholder="Enter your City Here" ></td>
                </tr>
                <tr>
                    <td><strong>Area:</strong></td>
                    <td><input type="text" name="location" placeholder="Enter your Area Here" ></td>
                </tr>
                <tr>
                    <td><strong>Email id:</strong></td>
                    <td><input type="email" name="mailid" placeholder="Enter your Mail Id Here" ></td>
               </tr>
                <tr>
                    <td><strong>Password:</strong></td>
                    <td><input type="password" name="password" placeholder="Enter Password Here" ></td>
                </tr>
                <tr>
                    <td><strong>Confirm Password:</strong></td>
                    <td><input type="password" name="ConfirmPassword" placeholder="Enter Password Here" ></td>
                </tr>
                <tr>
                    <td><INPUT TYPE=HIDDEN NAME=username value="<%=username%>"></td>
                    <td><INPUT TYPE=HIDDEN NAME=loginpassword value="<%=loginpassword%>"></td>
                    <td><input type="submit" value="Update" ></td>
                </tr>
            </table>
        </form>
    </body>
</html>
