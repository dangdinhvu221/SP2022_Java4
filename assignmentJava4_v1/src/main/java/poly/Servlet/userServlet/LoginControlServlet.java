package poly.Servlet.userServlet;

import poly.DAO.UsersDAO;
import poly.Entity.Users;
import poly.Utils.EncryptUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet({
        "/LoginControlServlet",
        "/LoginControlServlet/login",
})
public class LoginControlServlet extends HttpServlet {
    private UsersDAO dao;

    public LoginControlServlet() {
        dao = new UsersDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String uri = request.getRequestURI();
        if (uri.contains("login")) {
            this.doLogin(request, response);
        } else if (uri.contains("LoginControlServlet")) {
            request.setAttribute("views", "/views/admin/Login/loginForm.jsp");
        }
        request.getRequestDispatcher("/views/admin/Login/index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String uri = request.getRequestURI();
        if (uri.contains("login")) {
            this.doLogin(request, response);
        }
        request.setAttribute("views", "/views/admin/Login/loginForm.jsp");
    }

    private void doLogin(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        try {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            //        session
            HttpSession session = request.getSession();
            if (username.length() == 0 || password.length() == 0) {
                session.setAttribute("error", "Username or password cannot be empty!!!");
                response.sendRedirect("/assignmentJava4_v1_war_exploded/LoginControlServlet");
            }
            Users users = dao.findKeywordUser(username.trim());
            boolean checkPass = EncryptUtils.check(password, users.getPassword());
            if (checkPass == true) {
                session.setAttribute("profile_list", users);
                session.setAttribute("message", "Login successfully !");
                response.sendRedirect("/assignmentJava4_v1_war_exploded/AdminServlet");
            } else {
                session.setAttribute("error", "Wrong user or password");
                response.sendRedirect("/assignmentJava4_v1_war_exploded/LoginControlServlet");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
