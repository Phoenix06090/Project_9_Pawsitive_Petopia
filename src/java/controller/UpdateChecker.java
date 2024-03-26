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
import model.UpdateAuthenticator;

/**
 *
 * @author Hardik
 */
public class UpdateChecker extends HttpServlet 
{
   public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        response.sendRedirect("UpdateDetails.jsp");
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
        String username=request.getParameter("username");
        String loginpassword=request.getParameter("loginpassword");
        
        UpdateAuthenticator u1=new UpdateAuthenticator(); 
        boolean update = u1.isUpdate(petowner,password,ConfirmPassword,pettype,petname,petage,vaccinecount,phone,city,location,mailid,username,password);
       
        if(update)
        {
            HttpSession session = request.getSession(true);
            session.setAttribute("petowner",petowner);
            session.setAttribute("password",password);
            response.sendRedirect("Login.html");
        }
        else
        {
            response.sendRedirect("UpdateDetails.jsp");
        }
    }
}