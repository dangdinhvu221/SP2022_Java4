package poly.Servlet.adminServlet;

import org.apache.commons.beanutils.BeanUtils;
import poly.DAO.SupplierDAO;
import poly.Entity.Category;
import poly.Entity.Supplier;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet({
        "/SupplierServlet",
        "/SupplierServlet/createSupplier",
        "/SupplierServlet/updateSupplier",
        "/SupplierServlet/deleteSupplier",
        "/SupplierServlet/editSupplier",

})
public class SupplierServlet extends HttpServlet {
    private SupplierDAO supplierDAO;

    public SupplierServlet() {
        supplierDAO = new SupplierDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        String uri = request.getRequestURI();

        if (uri.contains("deleteSupplier")) {
            this.doDeleteSupplier(request, response);
        }
        this.SupplierFillAll(request, response);
        request.getRequestDispatcher("/views/index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        String uri = request.getRequestURI();
        if (uri.contains("createSupplier")) {
            this.doCreateSupplier(request, response);
        } else if (uri.contains("updateSupplier")) {
            this.doUpdateSupplier(request, response);
        } else if (uri.contains("editSupplier")) {
            this.doEditSupplier(request, response);
        }

        request.getRequestDispatcher("/views/index.jsp").forward(request, response);
    }

    private void doEditSupplier(HttpServletRequest request, HttpServletResponse response) {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            Supplier supplier = supplierDAO.findByID(id);
            request.setAttribute("categories", supplier);
            this.SupplierFillAll(request, response);
        } catch (Exception e) {
            request.setAttribute("error", "ERROR: " + e.getMessage());
        }
    }

    private void doDeleteSupplier(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            supplierDAO.delete(id);
            request.setAttribute("message", "Supplier delete successfully!!!");
            this.SupplierFillAll(request, response);
        } catch (Exception e) {
            request.setAttribute("error", "ERROR: " + e.getMessage());
        }
    }

    private void doUpdateSupplier(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getMethod();
        if (method.equalsIgnoreCase("POST")) {
            try {
                Supplier supplier = new Supplier();
                BeanUtils.populate(supplier, request.getParameterMap());
                String name = request.getParameter("nameSupplier");
                supplierDAO.update(supplier);
                request.setAttribute("message", "Supplier update successfully!");
            } catch (Exception e) {
                e.printStackTrace();
                request.setAttribute("error", "ERROR: " + e.getMessage());
            }
            this.SupplierFillAll(request, response);
        }
    }

    private void doCreateSupplier(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Supplier supplier = new Supplier();
            BeanUtils.populate(supplier, request.getParameterMap());
            supplierDAO.insert(supplier);
            request.setAttribute("message", "Supplier inserted successfully !");
        } catch (Exception e) {
            request.setAttribute("error", "ERROR: " + e.getMessage());
            e.printStackTrace();
        }
        this.SupplierFillAll(request, response);
    }

    private void SupplierFillAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.findAll(request, response);
        request.setAttribute("views", "/views/admin/ManagerSupplier/tableSupplier.jsp");
    }

    protected void findAll(HttpServletRequest request, HttpServletResponse response) {
        try {
            List<Supplier> list = supplierDAO.findAll();
            request.setAttribute("ListSupplier", list);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "Error: " + e.getMessage());
        }
    }
}
