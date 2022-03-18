package com.poly.Sevlet;

import com.poly.Entity.Staff;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.beanutils.converters.DateTimeConverter;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
@MultipartConfig
@WebServlet("/staffServlet")
public class staffServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("view/staff/form.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        try {
            // Định dạng thời gian nhập vào
            DateTimeConverter dtc = new DateConverter(new Date());
            dtc.setPattern("MM/dd/yyyy");
            ConvertUtils.register(dtc, Date.class);

            Staff staff = new Staff();
            // upload File
            File file = new File(request.getServletContext().getRealPath("/uploads"));
            Part photo = request.getPart("image");
            File photoFile = new File(file, photo.getSubmittedFileName());
            photo.write(photoFile.getAbsolutePath());
            // Lấy tên file upload đưa vào bean staff
            staff.setPhoto(photoFile.getName());
            // Đọc tham số vào các thuộc tính của bean staff
            BeanUtils.populate(staff, request.getParameterMap());
            // Chia sẻ với result.jsp
            request.setAttribute("bean", staff);


            StringBuilder sb = new StringBuilder();
            for (String item: staff.getHobbies()) {
                sb.append(item).append(", ");
            }
            request.setAttribute("hobbies", sb.toString());
        }catch (Exception e){
            e.printStackTrace();
        }
        request.getRequestDispatcher("view/staff/result.jsp").forward(request,response);

    }
}
