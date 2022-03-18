package com.poly.servlet;

import com.poly.entity.Staff;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@MultipartConfig
@WebServlet("/BeanUtilsServlet")
public class BeanUtilsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("view/register.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        try {
            File file = new File(request.getServletContext().getRealPath("/files"));
            if(!file.exists()){
                file.mkdirs();
            }

            Part photo = request.getPart("image");
            File photoFile = new File(file, photo.getSubmittedFileName());
            photo.write(photoFile.getAbsolutePath());
            Staff staff = new Staff();
            staff.setImage(photoFile.getName());
            BeanUtils.populate(staff, request.getParameterMap());
            request.setAttribute("bean", staff);
            request.getRequestDispatcher("view/register.jsp").forward(request,response);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
