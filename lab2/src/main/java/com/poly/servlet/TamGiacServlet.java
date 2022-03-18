package com.poly.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet({"/TamGiacServlet", "/chu-vi", "/dien-tich"})
public class TamGiacServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("view/tamgiac/form.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String a = request.getParameter("canhA");
        double canhA = Double.parseDouble(a);
        String b = request.getParameter("canhB");
        double canhB = Double.parseDouble(b);
        String c = request.getParameter("canhC");
        double canhC = Double.parseDouble(c);

        String uri = request.getRequestURI();
        double chuVi = (canhA + canhB + canhC);

        if((canhA + canhB > canhC) && (canhA + canhC > canhB) && (canhA < canhB + canhC)){
            if(uri.contains("dien-tich")){
                double dienTich = Math.sqrt(chuVi * (canhA + canhB - canhC) * (canhA + canhC - canhB) * (canhB + canhC - canhA))/4;
                request.setAttribute("message", "Diện tích tam giác: " + dienTich);
            }else{
                request.setAttribute("message", "Chu vi tam giác: " + chuVi);
            }
        }else{
            request.setAttribute("message", "Không thoả mãn các cạnh của một tam giác !!!");

        }

        request.getRequestDispatcher("view/tamgiac/form.jsp").forward(request, response);
    }
}
