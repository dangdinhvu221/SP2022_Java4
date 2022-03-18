package com.example.lab1;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet("/hello-servlet")
public class HelloServlet extends HttpServlet {
//    private String message;

    public void init() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        response.getWriter().println("<h1>FPT Polytechnic</h1>");
        request.setAttribute("message", "Chao the gioi Servlet/JSP!");

        request.getRequestDispatcher("/view/index.jsp").forward(request,response);
    }

    public void destroy() {
    }
}