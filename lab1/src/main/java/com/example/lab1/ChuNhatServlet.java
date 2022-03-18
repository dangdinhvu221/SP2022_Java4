package com.example.lab1;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ChuNhatServlet", value = "/ChuNhatServlet")
public class ChuNhatServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("view/caculator/formCaculator.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String x = request.getParameter("chieuD");
        double dai = Double.parseDouble(x);
        String y = request.getParameter("chieuR");
        double rong = Double.parseDouble(y);

        double dienT = dai*rong;
        double chuVi = (dai+rong)*2;

        request.setAttribute("DienTich", "Diện tích: " + dienT);
        request.setAttribute("ChuVi", "Chu vi: " + chuVi);
        request.getRequestDispatcher("view/caculator/success.jsp").forward(request,response);

    }
}
