package com.example;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.beanutils.converters.DateTimeConverter;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.IOException;
import java.util.Date;

@MultipartConfig
@WebServlet(name = "demoServlet", value = "/demoServlet")
public class demoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/register.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Staff staff = new Staff();
        try {
            DateTimeConverter dtc = new DateConverter(new Date());
            dtc.setPattern("MM/dd/yyyy");
            ConvertUtils.register(dtc, Date.class);

            request.setCharacterEncoding("utf-8");
            response.setCharacterEncoding("utf-8");
            BeanUtils.populate(staff, request.getParameterMap());

            File dir = new File(request.getServletContext().getRealPath("/file"));
            if (!dir.exists()) {
                dir.mkdirs();
            }
            Part photo = request.getPart("image");
            File photoFile = new File(dir, photo.getSubmittedFileName());
            photo.write(photoFile.getAbsolutePath());
            staff.setImageName(photoFile.getName());
            request.setAttribute("bean", staff);

        } catch (Exception e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("/register.jsp").forward(request, response);
    }
}
