package poly.Servlet.userServlet;

import poly.DAO.ProductsDAO;
import poly.Entity.Products;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "HomePagesServlet", value = "/HomePagesServlet")
public class HomePagesServlet extends HttpServlet {
    private ProductsDAO productsDAO;

    public HomePagesServlet() {
        productsDAO = new ProductsDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Products> list = productsDAO.findAll();
        request.setAttribute("products", list);
        request.getRequestDispatcher("/views/HomePage.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
