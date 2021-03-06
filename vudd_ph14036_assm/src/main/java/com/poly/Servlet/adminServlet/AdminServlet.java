package com.poly.Servlet.adminServlet;

import com.poly.DAO.UsersDAO;
import com.poly.Entity.Users;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet({"/AdminServlet",
        "/AdminServlet/createUser",
        "/AdminServlet/updateUser",
        "/AdminServlet/deleteUser",
        "/AdminServlet/editUser",
        "/AdminServlet/resetUser",
        "/AdminServlet/adminUser",
        "/AdminServlet/index",
})
@MultipartConfig
public class AdminServlet extends HttpServlet {
    private UsersDAO dao;

    public AdminServlet() {
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
        } else if (uri.contains("resetUser")) {
            request.setAttribute("user", new Users());
            this.adminUsers(request,response);
        }
        request.getRequestDispatcher("/views/index.jsp").forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        String uri = request.getRequestURI();
        if (uri.contains("createUser")) {
            this.doInsertUser(request, response);
        }if (uri.contains("updateUser")) {
            this.doUpdateUser(request, response);
        }

        request.getRequestDispatcher("/views/index.jsp").forward(request, response);
    }

    private void doUpdateUser(HttpServletRequest request, HttpServletResponse response) {
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
                user.setAvatar(photoFile.getName());
                user.setStatus(true);
                Date date = new Date();
                Timestamp ts = new Timestamp(date.getTime());
                user.setCreated(ts);
                BeanUtils.populate(user, request.getParameterMap());
                dao.insert(user);
                request.setAttribute("message", "User inserted successfully!");
            } catch (Exception e) {
                e.printStackTrace();
                request.setAttribute("error", "ERROR: " + e.getMessage());
            }
            this.adminUsers(request, response);
        }

//        String redirect = response.encodeRedirectURL(request.getContextPath() + "/AdminServlet/adminUser");
//        response.sendRedirect(redirect);
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
        request.setAttribute("tableUsers", "/views/admin/ManagerUser/tableUser.jsp");
        request.setAttribute("views", "/views/admin/ManagerUser/formUsers.jsp");
        this.findAll(request, response);
    }
}
