package org.example.demo_servlet.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.demo_servlet.model.User;
import org.example.demo_servlet.service.Authenticator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet({"/index", "/addNewUser", "/login", "/showAllUser", "/logout"})
public class UserController extends HttpServlet {
    List<User> users = new ArrayList<User>();

    public void init(){
        users.add(new User("Thomas", "thomas@mail.com", "123"));
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();
        Authenticator authenticator = new Authenticator();
        User user;

        switch (action) {
            case "/login":{
                String email = request.getParameter("email");
                String password = request.getParameter("password");
                user = new User(email, password);
                var authUser = authenticator.authenticate(user, users);
                if (authUser != null) {
                    request.getSession().setAttribute("user", authUser);
                    request.getRequestDispatcher("welcome.jsp").forward(request, response);
                }else{
                    request.getSession().setAttribute("user", user);
                    request.getRequestDispatcher("loginfail.jsp").forward(request, response);
                }
            }
            case "addNewUser": {
                String name = request.getParameter("name");
                String email = request.getParameter("email");
                String password = request.getParameter("password");
                user = new User(name, email, password);
                if (users.contains(user)) {
                    user = users.get(users.indexOf(user));
                    request.setAttribute("user", user);
                    request.getRequestDispatcher("addfail.jsp").forward(request, response);
                }else {
                    users.add(user);
                    request.getSession().setAttribute("user", user);
                    request.getRequestDispatcher("welcome.jsp").forward(request, response);
                }
            }
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();
        switch (action) {
            case "/index": {
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
            case "/showAllUsers":{
                request.setAttribute("users", users);
                request.getRequestDispatcher("showAllUsers.jsp").forward(request, response);
            }
            case "/login":{
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
            case "/logout":{
                request.getSession().invalidate();
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }


        }
    }
}
