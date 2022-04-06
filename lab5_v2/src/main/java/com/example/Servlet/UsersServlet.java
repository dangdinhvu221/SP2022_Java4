package com.example.Servlet;

import com.example.DAO.UsersDAO;
import com.example.entity.Users;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

@MultipartConfig
@WebServlet({
        "/UsersServlet",
        "/UsersServlet/insert",
        "/UsersServlet/update",
        "/UsersServlet/delete",
        "/UsersServlet/edit",
        "/UsersServlet/reset",
        "/UsersServlet/search",
})
public class UsersServlet extends HttpServlet {

   private UsersDAO dao;

    public UsersServlet() {
        dao = new UsersDAO();
    }

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
        } else if (uri.contains("delete")) {
            this.delete(request, response);
        } else if (uri.contains("search")) {
            this.findKeyword(request, response);
        } else if (uri.contains("reset")) {
            request.setAttribute("user", new Users());
            findAll(request, response);
        }
        request.getRequestDispatcher("/views/form.jsp").forward(request, response);
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) {
        try {
            Users user = new Users();
            BeanUtils.populate(user, request.getParameterMap());
            int id = Integer.parseInt(request.getParameter("id"));
            dao.delete(id);
            request.setAttribute("message", "User delete successfully!!!");
            findAll(request, response);
        } catch (Exception e) {
            request.setAttribute("error", "ERROR: " + e.getMessage());
        }

    }

    private void update(HttpServletRequest request, HttpServletResponse response) {
        try {
            Users user = new Users();
            BeanUtils.populate(user, request.getParameterMap());
            File dir = new File(request.getServletContext().getRealPath("/uploads"));
            if (!dir.exists()) {
                dir.mkdirs();
            }
            Part photo = request.getPart("avatar");
            File photoFile = new File(dir, photo.getSubmittedFileName());
            photo.write(photoFile.getAbsolutePath());
            user.setAvatar(photoFile.getName());
            dao.update(user);
            request.setAttribute("message", "User update successfully!!!");
            findAll(request, response);
        } catch (Exception e) {
            request.setAttribute("error", "ERROR: " + e.getMessage());
        }
    }

    protected void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Users> list = dao.findAll();
            request.setAttribute("list_users", list);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "Error: " + e.getMessage());
        }
    }

    protected void findKeyword(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getMethod();
        try {
            if (method.equalsIgnoreCase("POST")) {
                String key = request.getParameter("fullname");
                List<Users> list = dao.findKeyword(key);
                request.setAttribute("list_users", list);
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "Error: " + e.getMessage());
        }
    }

    private void doInsert(HttpServletRequest request, HttpServletResponse response) {
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

                BeanUtils.populate(user, request.getParameterMap());
                dao.insert(user);
                request.setAttribute("message", "User inserted successfully!!!");
                findAll(request, response);

            } catch (Exception e) {
                request.setAttribute("error", "ERROR: " + e.getMessage());
            }
        }
    }

    private void doEdit(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            Users user = dao.findByID(id);
            request.setAttribute("user", user);
            findAll(request, response);

        } catch (Exception e) {
            request.setAttribute("error", "ERROR: " + e.getMessage());
        }
    }

}
