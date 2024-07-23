package org.example.aula_servlet;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("/login")
public class HelloServlet extends HttpServlet {
   public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String action = request.getServletPath();
       if(action.equals("/login")) {
           String email = request.getParameter("email");
           String password = request.getParameter("password");
           request.setAttribute("email", email);
           if (email.equals("admin") && password.equals("admin")) {
               request.getRequestDispatcher("welcome.jsp").forward(request, response);

               System.out.println(email + "" + password);
           }else{
               request.getRequestDispatcher("loginfailed.jsp").forward(request, response);
           }
       }
   }
}