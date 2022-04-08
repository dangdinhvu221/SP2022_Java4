package poly.Servlet.adminServlet;


import org.apache.commons.beanutils.BeanUtils;
import poly.DAO.UsersDAO;
import poly.Entity.Users;
import poly.Utils.EncryptUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.ws.rs.HttpMethod;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@WebServlet({
        "/AdminServlet",
        "/AdminServlet/adminUser",
        "/AdminServlet/index",
        "/AdminServlet/profile",
        "/AdminServlet/updateUser",
        "/AdminServlet/deleteUser",
        "/AdminServlet/editUser",
        "/AdminServlet/resetUser",
        "/AdminServlet/createUser",
        "/AdminServlet/logout",
})
@MultipartConfig
public class UsersServlet extends HttpServlet {
    private UsersDAO dao;

    public UsersServlet() {
        dao = new UsersDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        request.setAttribute("views", "/views/admin/Component/contentV2.jsp");
        String uri = request.getRequestURI();
        if (uri.contains("index")) {
            request.setAttribute("views", "/views/admin/Component/contentV2.jsp");
        } else if (uri.contains("adminUser")) {
            this.adminUsers(request, response);
        } else if (uri.contains("editUser")) {
            this.doEditUser(request, response);
        } else if (uri.contains("deleteUser")) {
            this.doDeleteUser(request, response);
        } else if (uri.contains("profile")) {
            request.setAttribute("views", "/views/admin/ManagerUser/profile.jsp");
        }else if(uri.contains("logout")){
            HttpSession session = request.getSession();
            session.setAttribute("profile_list", new Users());
            session.removeAttribute("profile_list");
        }
        request.setAttribute("modal", "views/admin/ManagerUser/modal.jsp");
        request.getRequestDispatcher("/views/index.jsp").forward(request, response);
    }




    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String uri = request.getRequestURI();
        if (uri.contains("createUser")) {
            this.doInsertUser(request, response);
        } else if (uri.contains("updateUser")) {
            this.doUpdateUser(request, response);
        } else if (uri.contains("resetUser")) {
            request.setAttribute("user", new Users());
            this.adminUsers(request, response);
        }
        request.getRequestDispatcher("/views/index.jsp").forward(request, response);
    }

    private void doUpdateUser(HttpServletRequest request, HttpServletResponse response) {
        validateForm(request, response);
        String method = request.getMethod();
        int id = Integer.parseInt(request.getParameter("id"));
        if (method.equalsIgnoreCase("POST")) {
            try {
                File dir = new File(request.getServletContext().getRealPath("/uploads"));
                if (!dir.exists()) {
                    dir.mkdirs();
                }
                Part photo = request.getPart("avatar");
                File photoFile = new File(dir, photo.getSubmittedFileName());
                photo.write(photoFile.getAbsolutePath());
                Users userPassOld = dao.findByID(id);
                Users user = new Users();
                BeanUtils.populate(user, request.getParameterMap());
                user.setAvatar(photoFile.getName());
                user.setStatus(true);
                Date date = new Date();
                Timestamp ts = new Timestamp(date.getTime());
                user.setCreated(ts);
                user.setPassword(userPassOld.getPassword());
                dao.update(user);
                request.setAttribute("message", "User update successfully!");
            } catch (Exception e) {
                e.printStackTrace();
                request.setAttribute("error", "ERROR: " + e.getMessage());
            }
            this.adminUsers(request, response);
        }
    }

    private void doEditUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            Users user = dao.findByID(id);
            request.setAttribute("user", user);
            request.setAttribute("tableUsers", "/views/admin/ManagerUser/tableUser.jsp");
            request.setAttribute("views", "/views/admin/ManagerUser/formEdit.jsp");
            this.findAll(request, response);
        } catch (Exception e) {
            request.setAttribute("error", "ERROR: " + e.getMessage());
        }
    }

    private void doInsertUser(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        validateForm(request, response);
        String method = request.getMethod();
        if (method.equalsIgnoreCase("POST")) {
            try {
                File dir = new File(request.getServletContext().getRealPath("/uploads"));
                if (!dir.exists()) {
                    dir.mkdirs();
                }
                Part photo = request.getPart("avatar");
                File photoFile = new File(dir, photo.getSubmittedFileName());
                photo.write(photoFile.getAbsolutePath());
                Users user = new Users();
                BeanUtils.populate(user, request.getParameterMap());

                user.setAvatar(photoFile.getName());
                user.setStatus(true);
                String encryptedPass  = EncryptUtils.encrypt(request.getParameter("password"));
                user.setPassword(encryptedPass);
                Date date = new Date();
                Timestamp ts = new Timestamp(date.getTime());
                user.setCreated(ts);
                dao.insert(user);
                request.setAttribute("message", "User inserted successfully!");
            } catch (Exception e) {
                e.printStackTrace();
//                request.setAttribute("error", "ERROR: " + e.getMessage());
            }
            this.adminUsers(request, response);
        }
    }

    private void doDeleteUser(HttpServletRequest request, HttpServletResponse response) {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            dao.delete(id);
            request.setAttribute("message", "User delete successfully!!!");
        } catch (Exception e) {
            request.setAttribute("error", "ERROR: " + e.getMessage());
        }
        this.adminUsers(request, response);
    }

    protected void findAll(HttpServletRequest request, HttpServletResponse response) {
        try {
            List<Users> list = dao.findAll();
            request.setAttribute("listUsers", list);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "Error: " + e.getMessage());
        }
    }

    private void adminUsers(HttpServletRequest request, HttpServletResponse response) {
//        HttpSession session = request.getSession();
//        session.setAttribute("profile_list", new Users());
        request.setAttribute("tableUsers", "/views/admin/ManagerUser/tableUser.jsp");
        request.setAttribute("views", "/views/admin/ManagerUser/formUsers.jsp");
        this.findAll(request, response);
    }

    private void validateForm(HttpServletRequest request, HttpServletResponse response){
        String username = request.getParameter("username");
        String fullName = request.getParameter("fullName");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        String password = request.getParameter("password");
        String rePassword = request.getParameter("rePassword");
        String avatar = request.getParameter("avatar");

        if(username.length() == 0 || fullName.length() == 0 || email.length() == 0 || address.length() == 0 ||
                phone.length() == 0 || password.length() == 0 || rePassword.length() == 0 || avatar.length() == 0){
            request.setAttribute("error", "Can not be empty!!!");
        }

    }
}
