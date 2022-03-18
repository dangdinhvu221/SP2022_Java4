package com.poly.admin;

import com.poly.Entity.Staff;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet({"/users/index","/users/create","/users/edit","/users/show","/users/delete"})
public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("index")){
            this.index(request, response);
        }else if(uri.contains("create")){
            this.create(request, response);
        }else if(uri.contains("edit")){
            this.edit(request, response);
        }else if(uri.contains("show")){
            this.show(request, response);
        }else if(uri.contains("delete")){
            this.delete(request, response);
        }else{
            System.out.println("404");
        }
    }

    private void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Staff> list = new ArrayList<Staff>();
        Staff o1 = new Staff("vudd", "Dang Dinh Vu", "123", "vuddph14036@fpt.edu.vn", "0965528854", "Ha noi", "", true, 1);
        Staff o2 = new Staff("vudd1", "Dang Dinh Vu1", "123", "vuddph14036@fpt.edu.vn", "0965528854", "Ha noi", "", false, 1);
        Staff o3 = new Staff("vudd2", "Dang Dinh Vu2", "123", "vuddph14036@fpt.edu.vn", "0965528854", "Ha noi", "", true, 1);

        list.add(o1);
        list.add(o2);
        list.add(o3);

        request.setAttribute("ds", list);
        request.setAttribute("view", "/views/admin/users/index.jsp");
        request.getRequestDispatcher("/views/layout.jsp").forward(request, response);
    }
    private void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("/views/create.jsp").forward(request, response);
    }
    private void edit(HttpServletRequest request, HttpServletResponse response) {

    }
    private void show(HttpServletRequest request, HttpServletResponse response) {

    }
    private void delete(HttpServletRequest request, HttpServletResponse response) {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("index")) {
//			this.store(request, response);
        } else if (uri.contains("edit")) {
//			this.update(request, response);
        }
    }
}
