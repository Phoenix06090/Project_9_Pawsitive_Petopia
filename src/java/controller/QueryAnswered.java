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
import model.QueryAnsweredAuthenticator;


/**
 *
 * @author Hardik
 */
public class QueryAnswered extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        response.sendRedirect("queryobtained.jsp");
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        String name= request.getParameter("name");
        String email= request.getParameter("email");
        
        QueryAnsweredAuthenticator u1=new QueryAnsweredAuthenticator(); 
        boolean update = u1.isQueryStatusUpdated(name,email);
       
        if(update)
        {
            HttpSession session = request.getSession(true);
            session.setAttribute("name",name);
            session.setAttribute("email",email);
            response.sendRedirect("AdminPage.jsp");
        }
        else
        {
            response.sendRedirect("queryobtained.jsp");
        }
    }
}
