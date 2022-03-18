package com.poly.Sevlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // đọc giá trị cookie
        String user = CookieUtils.get("username", request);
        String pass = CookieUtils.get("password", request);

        // chuyển sang formLogin.jsp để hiển thị lên form
        request.setAttribute("username", user);
        request.setAttribute("password", pass);
        request.getRequestDispatcher("view/cookie/formLogin.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user = request.getParameter("username");
        String pass = request.getParameter("password");
        String remember = request.getParameter("remember");

        if (!user.equalsIgnoreCase("poly")) {
            request.setAttribute("message", "Sai tên đăng nhập!");
        } else if (pass.length() < 6) {
            request.setAttribute("message", "Mật khẩu phải lớn hơn 6 ký tự!");
        } else if (!pass.equalsIgnoreCase("123456789")) {
            request.setAttribute("message", "Sai tên mật khẩu!");
        } else {
            request.setAttribute("message", "Đặng nhập thành công <3...");

            // ghi nhớ hoặc xoá tài khoản đã ghi nhớ bằng cookie
            int hours = (remember == null) ? 0 : 30 * 24;
            CookieUtils.add("username", user, hours, response);
            CookieUtils.add("password", pass, hours, response);
        }
        request.getRequestDispatcher("view/cookie/formLogin.jsp").forward(request, response);

    }
}
