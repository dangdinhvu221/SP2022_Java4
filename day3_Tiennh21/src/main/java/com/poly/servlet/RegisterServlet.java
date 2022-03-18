package com.poly.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Arrays;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("view/register.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
//        request.setAttribute("fullname", request.getParameter("fullname"));
//        request.setAttribute("email", request.getParameter("email"));
//        request.setAttribute("gender", Boolean.parseBoolean(request.getParameter("gender")));
//        request.setAttribute("married", (request.getParameter("married") != null));
//        request.setAttribute("accoutType", request.getParameter("accoutType"));
//        request.setAttribute("hobbies", Arrays.toString(request.getParameterValues("hobbies")));
//        request.setAttribute("note", request.getParameter("note"));

        request.getRequestDispatcher("view/register.jsp").forward(request, response);
    }
}
