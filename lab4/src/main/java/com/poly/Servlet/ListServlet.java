package com.poly.Servlet;

import com.poly.Entity.Item;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@WebServlet(name = "ListServlet", value = "/ListServlet")
public class ListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Item> items = Arrays.asList(new Item[] {
                new Item("Dell Latitude 3520 70251592", "lap1.png", 18.390000, 0.1),
                new Item("Dell Latitude 7320 42LT732001", "lap2.jpg", 31.090000, 0.15),
                new Item("Dell Latitude 3520 70251592", "lap3.jpg", 18.390000, 0.25),
                new Item("Dell Latitude 3520 70251592", "lap7.jpg", 18.390000, 0.3),
                new Item("Dell Latitude 3520 70251592", "lap8.jpg", 18.390000, 0.5),
                new Item("Dell Latitude 3520 70251592", "lap2.jpg", 18.390000, 0.2)
        });
        request.setAttribute("items", items);
        request.getRequestDispatcher("view/bai4/layout.jsp").forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
