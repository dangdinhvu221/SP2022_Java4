package poly.Servlet.userServlet;

import org.apache.commons.beanutils.BeanUtils;
import poly.DAO.ProductsDAO;
import poly.DAO.UsersDAO;
import poly.Entity.Products;
import poly.Entity.Users;
import poly.Utils.EncryptUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@WebServlet({
        "/HomePagesServlet",
        "/HomePagesServlet/deltaProduct",
        "/HomePagesServlet/login",
        "/HomePagesServlet/logout",
        "/HomePagesServlet/profile",
        "/HomePagesServlet/register",
        "/HomePagesServlet/help",
        "/HomePagesServlet/contact",

})
public class HomePagesServlet extends HttpServlet {
    private ProductsDAO productsDAO;
    private UsersDAO usersDAO;

    public HomePagesServlet() {
        productsDAO = new ProductsDAO();
        usersDAO = new UsersDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");
        String uri = request.getRequestURI();
        if (uri.contains("register")) {
            request.getRequestDispatcher("/views/user/register/registerForm.jsp").forward(request, response);
        } else if (uri.contains("contact")) {
            request.setAttribute("views", "/views/user/component/contact.jsp");
            request.getRequestDispatcher("/views/user/detailsProducts/indexDeltaProduct.jsp").forward(request, response);
        } else if (uri.contains("logout")) {
            HttpSession session = request.getSession();
            session.removeAttribute("users");
            session.setAttribute("users", new Users());
            response.sendRedirect("/assignmentJava4_v1_war_exploded/HomePagesServlet");
        } else if (uri.contains("login")) {
            request.getRequestDispatcher("/views/user/loginFormHomePage/loginHomePage.jsp").forward(request, response);
        } else if (uri.contains("HomePagesServlet")) {
            this.doHomePages(request, response);
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");

        String uri = request.getRequestURI();
        if (uri.contains("login")) {
            this.doLogin(request, response);
        } else if (uri.contains("register")) {
            doInsertUser(request, response);
        }
    }

    private void doLogin(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //        session
        HttpSession session = request.getSession();
        try {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            if (username.length() == 0 || password.length() == 0) {
                session.setAttribute("error", "Username or password cannot be empty!!!");
//                response.sendRedirect("/assignmentJava4_v1_war_exploded/HomePagesServlet/login");
            }
            Users users = usersDAO.findKeywordUser(username.trim());
            boolean checkPass = EncryptUtils.check(password, users.getPassword());
            if (checkPass) {
                session.setAttribute("users", users);
                session.setAttribute("message", "Login successfully !");
                response.sendRedirect("/assignmentJava4_v1_war_exploded/HomePagesServlet");
            } else {
                session.setAttribute("error", "Wrong user or password");
                response.sendRedirect("/assignmentJava4_v1_war_exploded/HomePagesServlet/login");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("/assignmentJava4_v1_war_exploded/HomePagesServlet/login");
        }
    }

    private void doHomePages(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Products> list = productsDAO.findAll();
        request.setAttribute("list_products", list);
        request.getRequestDispatcher("/views/HomePage.jsp").forward(request, response);
    }

    private void doInsertUser(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String username = request.getParameter("username");
        String fullName = request.getParameter("fullName");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        String password = request.getParameter("password");
        String rePassword = request.getParameter("rePassword");
        HttpSession session = request.getSession();

        if(username.length() == 0 || fullName.length() == 0 || email.length() == 0 || address.length() == 0 ||
                phone.length() == 0 || password.length() == 0 || rePassword.length() == 0){
            session.setAttribute("error", "Can not be empty!!!");
            response.sendRedirect("/assignmentJava4_v1_war_exploded/HomePagesServlet/register");
            return;
        }
        String method = request.getMethod();
        if (method.equalsIgnoreCase("POST")) {
            try {
                Users user = new Users();
                BeanUtils.populate(user, request.getParameterMap());
                user.setStatus(true);
                String encryptedPass = EncryptUtils.encrypt(request.getParameter("password"));
                user.setPassword(encryptedPass);
                Date date = new Date();
                Timestamp ts = new Timestamp(date.getTime());
                user.setCreated(ts);
                user.setRole(false);
                user.setStatus(true);
                user.setAvatar(" ");
                usersDAO.insert(user);
                session.setAttribute("message", "User inserted successfully!");
                response.sendRedirect("/assignmentJava4_v1_war_exploded/HomePagesServlet");
            } catch (Exception e) {
                e.printStackTrace();
//                session.setAttribute("error", "ERROR: " + e.getMessage());
//                response.sendRedirect("/assignmentJava4_v1_war_exploded/HomePagesServlet/register");
            }
        }
    }

    private void validateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
}
