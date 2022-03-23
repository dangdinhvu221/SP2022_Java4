package com.poly.Servlet;

import com.poly.DAO.UsersDAO;
import com.poly.entity.Users;
import com.poly.entity.UsersMy;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

@MultipartConfig
@WebServlet({
        "/UsersServlet",
        "/UsersServlet/insert",
        "/UsersServlet/update",
        "/UsersServlet/delete",
        "/UsersServlet/edit",
        "/UsersServlet/reset"
})
public class UsersServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String uri = request.getRequestURI();
        if (uri.contains("insert")) {
            this.doInsert(request, response);
        } else if (uri.contains("delete")) {
            this.delete(request, response);
        } else if (uri.contains("edit")) {
            this.doEdit(request, response);
        } else if (uri.contains("update")) {
            this.update(request, response);
        } else if (uri.contains("reset")) {
            request.setAttribute("user", new Users());
        }
        findAll(request, response);
        request.getRequestDispatcher("/views/form.jsp").forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String uri = request.getRequestURI();
        if (uri.contains("insert")) {
            this.doInsert(request, response);
        } else if (uri.contains("update")) {
            this.update(request, response);
            request.setAttribute("user", new UsersMy());
        } else if (uri.contains("delete")) {
            this.delete(request, response);
        }
        findAll(request, response);
        request.getRequestDispatcher("/views/form.jsp").forward(request, response);
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) {
        try {
            UsersMy user = new UsersMy();
            BeanUtils.populate(user, request.getParameterMap());
            UsersDAO dao = new UsersDAO();
            int id = Integer.parseInt(request.getParameter("id"));
            dao.delete(id);
            request.setAttribute("message", "User delete successfully!!!");
        } catch (Exception e) {
            request.setAttribute("error", "ERROR: " + e.getMessage());
        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response) {
        try {
            Users user = new Users();
            BeanUtils.populate(user, request.getParameterMap());

            UsersDAO dao = new UsersDAO();
            dao.update(user);
            request.setAttribute("message", "User update successfully!!!");
        } catch (Exception e) {
            request.setAttribute("error", "ERROR: " + e.getMessage());
        }
    }


    protected void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            UsersDAO dao = new UsersDAO();
            List<Users> list = dao.findAll();
            request.setAttribute("list_users", list);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "Error: " + e.getMessage());
        }
    }

    private void doInsert(HttpServletRequest request, HttpServletResponse response) {
        String method = request.getMethod();

        if (method.equalsIgnoreCase("POST")) {
            try {
                Users user = new Users();
                BeanUtils.populate(user, request.getParameterMap());

                File dir = new File(request.getServletContext().getRealPath("/file"));
                if (!dir.exists()) {
                    dir.mkdirs();
                }
                Part photo = request.getPart("avatar");
                File photoFile = new File(dir, photo.getSubmittedFileName());
                photo.write(photoFile.getAbsolutePath());
                user.setAvatar(photoFile.getName());

                UsersDAO dao = new UsersDAO();
                dao.insert(user);
                request.setAttribute("message", "User inserted successfully!!!");
            } catch (Exception e) {
                request.setAttribute("error", "ERROR: " + e.getMessage());
            }
        }
    }

    private void doEdit(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            UsersDAO dao = new UsersDAO();
            Users user = dao.findByID(id);
            request.setAttribute("user", user);
        } catch (Exception e) {
            request.setAttribute("error", "ERROR: " + e.getMessage());
        }
    }

}
