package com.poly.Servlet;

import com.poly.Entity.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@WebServlet("/userServlet")
public class userServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> users = Arrays.asList(new User[] {
                new User("Username 1", "Password 1", true),
                new User("Username 2", "Password 2", false),
                new User("Username 3", "Password 3", true)
        });
        request.setAttribute("message", "Quản lý người sử dụng!");
        request.setAttribute("form", users.get(0));
        request.setAttribute("items", users);
        request.getRequestDispatcher("view/bai2/index.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
