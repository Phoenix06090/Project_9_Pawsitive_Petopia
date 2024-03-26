package controller;

import dto.userdto;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.LoginAuthenticator;

/**
 *
 * @author Hardik
 */
public class LoginChecker extends HttpServlet 
{
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        response.sendRedirect("Login.html");
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        userdto d1 = new userdto();
        d1.setUsername(username);
        d1.setPassword(password);
        
        LoginAuthenticator l1 = new LoginAuthenticator();
        boolean login = l1.isLogin(d1);
        
        if(login)
        {
            HttpSession session = request.getSession(true);
            session.setAttribute("username", username);
            session.setAttribute("password",password);
            String pettype = d1.getPettype();
                   
            switch(pettype)
            {
                case "Dog":
                    response.sendRedirect("DogHome.jsp");
                    break;
                case "Cat":
                    response.sendRedirect("CatHome.jsp");
                    break;
                case "Rabbit":  
                    response.sendRedirect("RabbitHome.jsp");
                    break;
//                case "Bird":
//                    response.sendRedirect("BirdHome.jsp");
//                    break;
//                case "Fish":
//                    response.sendRedirect("BirdHome.html");
//                    break;
                case"Petopia":
                    response.sendRedirect("AdminPage.jsp");
                default:
                    
            }

        }
        else
        {
            response.sendRedirect("AboutUs.html");
        }
    }
}
