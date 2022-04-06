package poly.Servlet.adminServlet;

import org.apache.commons.beanutils.BeanUtils;
import poly.DAO.CategoriesDAO;
import poly.Entity.Category;
import poly.Entity.Users;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@WebServlet({
        "/CategoryServlet",
        "/CategoryServlet/createCategory",
        "/CategoryServlet/updateCategory",
        "/CategoryServlet/deleteCategory",
        "/CategoryServlet/editCategory",
})
public class CategoriesServlet extends HttpServlet {
    private CategoriesDAO categoriesDAO;

    public CategoriesServlet() {
        categoriesDAO = new CategoriesDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        String uri = request.getRequestURI();
        if (uri.contains("deleteCategory")) {
            this.doDeleteCategory(request, response);
        }
        this.CategoryFillAll(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        String uri = request.getRequestURI();
        if (uri.contains("createCategory")) {
            this.doCreateCategory(request, response);
        }if (uri.contains("updateCategory")) {
            this.doUpdateCategory(request, response);
        }if (uri.contains("editCategory")) {
            this.doEditCategory(request, response);
        }
    }

    private void doEditCategory(HttpServletRequest request, HttpServletResponse response) {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            Category category = categoriesDAO.findByID(id);
            request.setAttribute("categories", category);
          this.CategoryFillAll(request,response);
        } catch (Exception e) {
            request.setAttribute("error", "ERROR: " + e.getMessage());
        }
    }

    private void doDeleteCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            categoriesDAO.delete(id);
            request.setAttribute("message", "User delete successfully!!!");
            this.CategoryFillAll(request,response);
        } catch (Exception e) {
            request.setAttribute("error", "ERROR: " + e.getMessage());
        }
    }

    private void doUpdateCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getMethod();
        if (method.equalsIgnoreCase("POST")) {
            try {
                Category category = new Category();
                BeanUtils.populate(category, request.getParameterMap());
                String name = request.getParameter("nameCategory");
                int id = Integer.parseInt(request.getParameter("user_id"));
                category.setUser_id(id);
                categoriesDAO.update(category);
                request.setAttribute("message", "Category update successfully!");
            } catch (Exception e) {
                e.printStackTrace();
                request.setAttribute("error", "ERROR: " + e.getMessage());
            }
            this.CategoryFillAll(request, response);
        }
    }

    private void doCreateCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Category category = new Category();
            BeanUtils.populate(category, request.getParameterMap());
            String name = request.getParameter("nameCategory");
            int id = Integer.parseInt(request.getParameter("user_id"));
            category.setUser_id(id);
            categoriesDAO.insert(category);
            request.setAttribute("message", "Categories inserted successfully !");
        } catch (Exception e) {
            request.setAttribute("error", "ERROR: " + e.getMessage());
            e.printStackTrace();
        }
        this.CategoryFillAll(request,response);
    }

    private void CategoryFillAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.findAll(request, response);
        request.setAttribute("views", "/views/admin/ManagerCategory/tableCategory.jsp");
        request.getRequestDispatcher("/views/index.jsp").forward(request, response);
    }

    protected void findAll(HttpServletRequest request, HttpServletResponse response) {
        try {
            List<Category> list = categoriesDAO.findAll();
            request.setAttribute("ListCategory", list);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "Error: " + e.getMessage());
        }
    }
}
