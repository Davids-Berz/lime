package com.lime.jakarta.web.forms.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/form")
public class FormController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("/form.html");
//        req.getRequestDispatcher("form.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");


        out.println("<!doctype html>");
        out.println("<html>");
        out.println("   <head>");
        out.println("       <meta charset=\"UTF-8\">");
        out.println("   </head>");
        out.println("   <body>");
        out.println("       <h1>Resultado Form</h1>");
        out.println("       <ul>");
        out.println("           <li>username: "+username+"</li>");
        out.println("           <li>password: "+password+"</li>");
        out.println("           <li>password: "+email+"</li>");
        out.println("       </ul>");
        out.println("       ");
        out.println("   </body>");
        out.println("</html>");
        out.close();
    }
}
