package com.poly.Servlet;

import com.poly.Entity.Student;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.beanutils.converters.DateTimeConverter;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet({"/StudentServlet"})
public class StudentServlet extends HttpServlet {
    private List<Student> list;


    @Override
    public void init() throws ServletException {
        list = new ArrayList<>();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("StudentServlet")) {
            this.index(request, response);
        }
    }

    private void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("form", "./form.jsp");
        request.setAttribute("table", "./table.jsp");
        request.getRequestDispatcher("views/layout.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        System.out.println("-------------------loading--------------");

        String uri = request.getRequestURI();
        if (uri.contains("StudentServlet")) {
            try {
                // student
                Student student = new Student();
                student.setDate(new Date());

                // BeanUtils
                BeanUtils.populate(student, request.getParameterMap());
                list.add(student);
                request.setAttribute("student", list);

                // Hien thi
                System.out.println("Code: " + student.getCode());
                System.out.println("Fullname: " + student.getFullname());
                System.out.println("PhoneNumber: " + student.getPhone());
                System.out.println("Email: " + student.getEmail());
                System.out.println("Gender: " + student.isGender());
                System.out.println("Major: " + student.getMajor());
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.index(request, response);
        }
    }

    @Override
    public void destroy() {
        System.out.println("End");
        list = null;
    }
}
