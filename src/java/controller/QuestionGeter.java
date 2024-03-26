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
import model.QuestionAuthenticator;

/**
 *
 * @author Hardik
 */
public class QuestionGeter extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        response.sendRedirect("AboutUs.html");
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        String email = request.getParameter("email");
        String name=request.getParameter("name");
        String textarea= request.getParameter("textarea");
        
        
        QuestionAuthenticator q1=new QuestionAuthenticator(); 
        boolean question = q1.isQuestion(email,name,textarea);
        
        if(question)
        {
            HttpSession session = request.getSession(true);
//            session.setAttribute("petowner",petowner);
//            session.setAttribute("password",password);
//            PrintWriter out = response.getWriter();
//            out.println("<h1>We have recieved Your message</h1>");         
            System.out.println("Question Asked");
            response.sendRedirect("AboutUs.html");
        }
        
    }
}
