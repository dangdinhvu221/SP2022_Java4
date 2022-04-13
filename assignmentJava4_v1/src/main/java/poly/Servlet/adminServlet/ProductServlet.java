package poly.Servlet.adminServlet;

import org.apache.commons.beanutils.BeanUtils;
import poly.DAO.CategoriesDAO;
import poly.DAO.ProductsDAO;
import poly.DAO.SupplierDAO;
import poly.Entity.Category;
import poly.Entity.Products;
import poly.Entity.Supplier;
import poly.Entity.Users;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@MultipartConfig
@WebServlet({
        "/ProductServlet",
        "/ProductServlet/createProduct",
        "/ProductServlet/updateProduct",
        "/ProductServlet/deleteProduct",
        "/ProductServlet/editProduct",
        "/ProductServlet/reset",
})
public class ProductServlet extends HttpServlet {
    private ProductsDAO productsDAO;
    private CategoriesDAO categoriesDAO;
    private SupplierDAO supplierDAO;

    public ProductServlet() {
        productsDAO = new ProductsDAO();
        categoriesDAO = new CategoriesDAO();
        supplierDAO = new SupplierDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        String uri = request.getRequestURI();
        if (uri.contains("deleteProduct")) {
            this.doDeleteProduct(request, response);
        } else if (uri.contains("editProduct")) {
            this.doEditProduct(request, response);
        } else if (uri.contains("ProductServlet")) {
            this.ProductFillAll(request, response);
        }
        request.getRequestDispatcher("/views/index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");

        String uri = request.getRequestURI();
        if (uri.contains("createProduct")) {
            this.doCreateProduct(request, response);
        } else if (uri.contains("updateProduct")) {
            this.doUpdateProduct(request, response);
        } else if (uri.contains("reset")) {
            request.setAttribute("category", new Products());
            this.ProductFillAll(request, response);
        }
        request.getRequestDispatcher("/views/index.jsp").forward(request, response);
    }

    private void doEditProduct(HttpServletRequest request, HttpServletResponse response) {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            Products products = productsDAO.findByID(id);
            request.setAttribute("products", products);
        } catch (Exception e) {
            request.setAttribute("error", "ERROR: " + e.getMessage());
        }
        this.findAll(request, response);
        request.setAttribute("views", "/views/admin/ManagerProduct/formEditProduct.jsp");
        request.setAttribute("tableProduct", "/views/admin/ManagerProduct/tableProduct.jsp");
    }

    private void doDeleteProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            productsDAO.delete(id);
            request.setAttribute("message", "Product delete successfully!!!");
            this.ProductFillAll(request, response);
        } catch (Exception e) {
            request.setAttribute("error", "ERROR: " + e.getMessage());
        }
    }

    private void doUpdateProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        validateForm(request, response);
        String method = request.getMethod();
        if (method.equalsIgnoreCase("POST")) {
            try {
                File dir = new File(request.getServletContext().getRealPath("/uploads"));
                if (!dir.exists()) {
                    dir.mkdirs();
                }
                Part photo = request.getPart("imageProduct");
                File photoFile = new File(dir, photo.getSubmittedFileName());
                photo.write(photoFile.getAbsolutePath());

                int idCategory = Integer.parseInt(request.getParameter("category_id"));
                int idSupplier = Integer.parseInt(request.getParameter("supplier_id"));

                Products product = new Products();
                product.setImageProduct(photoFile.getName());
                Category category = categoriesDAO.findByID(idCategory);
                Supplier supplier = supplierDAO.findByID(idSupplier);

                product.setCategoryByCategoryId(category);
                product.setSupplierBySupplierId(supplier);

                Date date = new Date();
                Timestamp ts = new Timestamp(date.getTime());
                product.setCreated(ts);

                BeanUtils.populate(product, request.getParameterMap());
                productsDAO.update(product);

                request.setAttribute("message", "Product update successfully !");
            } catch (Exception e) {
//                request.setAttribute("error", "ERROR: " + e.getMessage());
                e.printStackTrace();
            }
            this.ProductFillAll(request, response);
        }
    }

    private void doCreateProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        validateForm(request, response);
        try {
            File dir = new File(request.getServletContext().getRealPath("/uploads"));
            if (!dir.exists()) {
                dir.mkdirs();
            }
            Part photo = request.getPart("imageProduct");
            File photoFile = new File(dir, photo.getSubmittedFileName());
            photo.write(photoFile.getAbsolutePath());

            int idCategory = Integer.parseInt(request.getParameter("category_id"));
            int idSupplier = Integer.parseInt(request.getParameter("supplier_id"));

            Products product = new Products();
            product.setImageProduct(photoFile.getName());
            Category category = categoriesDAO.findByID(idCategory);
            Supplier supplier = supplierDAO.findByID(idSupplier);

            product.setCategoryByCategoryId(category);
            product.setSupplierBySupplierId(supplier);

            Date date = new Date();
            Timestamp ts = new Timestamp(date.getTime());
            product.setCreated(ts);

            BeanUtils.populate(product, request.getParameterMap());
            productsDAO.insert(product);

            request.setAttribute("message", "Product inserted successfully !");
        } catch (Exception e) {
//            request.setAttribute("error", "ERROR: " + e.getMessage());
            e.printStackTrace();
        }
        this.ProductFillAll(request, response);
    }

    private void ProductFillAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.findAll(request, response);
        request.setAttribute("views", "/views/admin/ManagerProduct/formProduct.jsp");
        request.setAttribute("tableProduct", "/views/admin/ManagerProduct/tableProduct.jsp");
    }

    protected void findAll(HttpServletRequest request, HttpServletResponse response) {
        try {
            List<Products> list = productsDAO.findAll();
            request.setAttribute("ListProducts", list);

            List<Category> listcCategories = categoriesDAO.findAll();
            request.setAttribute("ListCategory", listcCategories);

            List<Supplier> listSuppliers = supplierDAO.findAll();
            request.setAttribute("ListSupplier", listSuppliers);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "Error: " + e.getMessage());
        }
    }

    private void validateForm(HttpServletRequest request, HttpServletResponse response){
        String name = request.getParameter("nameProduct");
        String quantity = request.getParameter("quantity");
        String price = request.getParameter("price");
        String color = request.getParameter("color");
        String size = request.getParameter("size");

        if(name.length() == 0 || quantity.length() == 0 || price.length() == 0 || color.length() == 0 ||
                size.length() == 0){
            request.setAttribute("error", "Can not be empty!!!");
        }

    }
}
