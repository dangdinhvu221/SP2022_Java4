package com.poly.Servlet;

import com.poly.Entity.Item;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DetailServlet", value = "/DetailServlet")
public class DetailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Item item = new Item("Nokia", "lap1.png", 500, 0.1);
        request.setAttribute("item", item);
        request.getRequestDispatcher("view/bai3/detail.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
