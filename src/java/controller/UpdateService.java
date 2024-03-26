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
import model.UpdateServiceAuthenticator;

/**
 *
 * @author Hardik
 */
public class UpdateService extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        response.sendRedirect("bookedservices.jsp");
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        String name= request.getParameter("name");
        String password= request.getParameter("password");
        
        UpdateServiceAuthenticator u1=new UpdateServiceAuthenticator(); 
        boolean update = u1.isServiceStatusUpdate(name,password);
       
        if(update)
        {
            HttpSession session = request.getSession(true);
            session.setAttribute("name",name);
            session.setAttribute("password",password);
            response.sendRedirect("AdminPage.jsp");
        }
        else
        {
            response.sendRedirect("bookedservices.jsp");
        }
    }
}
