package com.lime.jakarta.web.forms.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

@WebServlet("/form")
public class FormController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.sendRedirect("/form.jsp");
//        req.getRequestDispatcher("form.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String pais = req.getParameter("pais");
        String[] lenguajes = req.getParameterValues("lenguaje");
        String[] roles = req.getParameterValues("roles");
        String idioma = req.getParameter("idioma");
        String habilitar = req.getParameter("habilitar");
        String secreto = req.getParameter("secreto");
        Map<String, String> errores = new HashMap<>();

        if (username == null || username.isBlank()) {
            errores.put("username","El usuario no puede ser vacio");
        }

        if (password == null || password.isBlank()) {
            errores.put("password","El password no puede ser vacio");
        }

        if (email == null || email.isBlank()) {
            errores.put("email","El email no puede ser vacio");
        }

        if (pais == null || pais.isBlank()) {
            errores.put("pais","El pais no puede ser vacio");
        }

        if (lenguajes == null || lenguajes.length == 0) {
            errores.put("lenguaje","Seleccione un lenguaje");
        }

        out.println("<!doctype html>");
        out.println("<html>");
        out.println("   <head>");
        out.println("       <meta charset=\"UTF-8\">");
        out.println("   </head>");
        out.println("   <body>");
        out.println("       <h1>Resultado Form</h1>");
        out.println("       <ul>");

        if (errores.size() == 0) {
            out.println("           <li>username: "+username+"</li>");
            out.println("");
            out.println("           <li>password: "+password+"</li>");
            out.println("           <li>password: "+email+"</li>");
            out.println("           <li>pais: "+pais+"</li>");
            out.println("           <li>Lenguajes: <ul>");
            Arrays.asList(lenguajes).forEach( l -> out.println("<li>"+l+"</li>"));
            out.println("           </ul></li>");
            out.println("           <li>Roles: <ul>");
            Arrays.asList(roles).forEach( r -> out.println("<li>"+r+"</li>"));
            out.println("           </ul></li>");
            out.println("           <li>idioma: "+idioma+"</li>");
            out.println("           <li>habilitar: "+habilitar+"</li>");
            out.println("           <li>secreto: "+secreto+"</li>");
        out.println("       </ul>");
        out.println("       ");
        out.println("   </body>");
        out.println("</html>");
        out.println("<p><a href=\"/lime/index.html\">regresar </p>");
        } else {
//            errores.forEach(e -> out.println("<li>"+e+"</li>"));
//            System.out.println("entra");
//            out.println("<p><a href=\"/lime/index.html\"> </p>");
            req.setAttribute("errores", errores);
            getServletContext().getRequestDispatcher("/form.jsp").forward(req,resp);
        }
        out.close();
    }
}
