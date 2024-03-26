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
import model.BookingAuthenticator;

/**
 *
 * @author Hardik
 */
public class BookingGeter extends HttpServlet {
 public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        response.sendRedirect("AboutUs.html");
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        String name=request.getParameter("name");
        String password = request.getParameter("password");
       
        String service= request.getParameter("service");
        
        
        BookingAuthenticator q1=new BookingAuthenticator(); 
        boolean servicebooked = q1.isBooked(name,password,service);
        
        if(servicebooked)
        {
            HttpSession session = request.getSession(true);
//            session.setAttribute("petowner",petowner);
//            session.setAttribute("password",password);
//            PrintWriter out = response.getWriter();
//            out.println("<h1>We have recieved Your message</h1>");         
            System.out.println(" A Service Booked");
            response.sendRedirect("AboutUs.html");
        }
        
    }
}
