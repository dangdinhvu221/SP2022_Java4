package com.poly.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Arrays;

@WebServlet("/DangKyServlet")
public class DangKyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("view/dangky/form.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        boolean gender = Boolean.parseBoolean(request.getParameter("gender"));
        boolean married = (request.getParameter("married" )!= null);
        String country = request.getParameter("country");
        String[] hobbies = request.getParameterValues("hobbies");
        String note = request.getParameter("note");



        System.out.println(">>username: " + username);
        System.out.println(">>password: " + password);
        System.out.println(">>gender: " + gender);
        System.out.println(">>married: " + married);
        System.out.println(">>country: " + country);
        System.out.println(">>notes: " + note);
        System.out.println(">>hobbies: " + Arrays.toString(hobbies));

        request.setAttribute("username", username);
        request.setAttribute("password", password);
        request.setAttribute("gender", gender);
        request.setAttribute("married", married);
        request.setAttribute("country", country);
        StringBuilder sb = new StringBuilder();
        for (String item: hobbies) {
            sb.append(item).append(", ");
        }
        request.setAttribute("hobbies", sb.toString());
        request.setAttribute("note", note);

        request.getRequestDispatcher("view/dangky/result.jsp").forward(request,response);
    }
}
