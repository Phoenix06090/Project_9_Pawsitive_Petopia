/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.RegistrationAuthenticator;

/**
 *
 * @author Hardik
 */
public class RegistrationChecker extends HttpServlet {
public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        response.sendRedirect("Registration.html");
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        String petowner = request.getParameter("petowner");
        String password= request.getParameter("password");
        String ConfirmPassword = request.getParameter("ConfirmPassword");
        String pettype= request.getParameter("pettype");
        String petname= request.getParameter("petname");
        String petage= request.getParameter("petage");
        String vaccinecount= request.getParameter("vaccinecount");
        String phone= request.getParameter("phone");
        String city= request.getParameter("city");
        String location= request.getParameter("location");
        String mailid= request.getParameter("mailid");
        
        RegistrationAuthenticator r1=new RegistrationAuthenticator(); 
        boolean register = r1.isRegitser(petowner,password,ConfirmPassword,pettype,petname,petage,vaccinecount,phone,city,location,mailid);
        
        if(register)
        {
            HttpSession session = request.getSession(true);
            session.setAttribute("petowner",petowner);
            session.setAttribute("password",password);
            response.sendRedirect("Login.html");
        }
        else
        {
            response.sendRedirect("Registration.html");
        }
    }
}
