package poly.Servlet.SearchAjax;

import poly.DAO.ProductsDAO;
import poly.Entity.Products;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.io.PrintWriter;

@WebServlet(name = "loadMoreControlServlet", value = "/loadMoreControlServlet")
public class loadMoreControlServlet extends HttpServlet {
    private ProductsDAO productsDAO;
    private List<Products> list;

    public loadMoreControlServlet() {
        productsDAO = new ProductsDAO();
        list = new ArrayList();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }

    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        int amount = Integer.parseInt(request.getParameter("exits"));
        list = productsDAO.findAllTop3(amount);
        PrintWriter out = response.getWriter();
        for (Products o : list) {
            System.out.println(o.getPrice());
            out.println(" <div class=\"col-lg-3 mb-4 text-center product\">\n" +
                    "                        <div class=\"product-entry border\">\n" +
                    "                            <a href=\"DetailsProductServlet?id=" + o.getId() + "\" class=\"prod-img\">\n" +
                    "                                <img src=\"uploads/" + o.getImageProduct() + "\" class=\"img-fluid\"\n" +
                    "                                     alt=\"Free html5 bootstrap 4 template\">\n" +
                    "                            </a>\n" +
                    "                            <div class=\"desc\">\n" +
                    "                                <h2><a href=\"ShowCartServlet?id=" + o.getNameProduct() + "\">" + o.getNameProduct() + "</a></h2>\n" +
                    "                                <h5 class=\"text-secondary text-muted font-italic\"></h5>\n" +
                    "                                <span class=\"price\"><fmt:formatNumber type=\"number\" maxFractionDigits=\"3\"\n" +
                    "                                                                      value=\"" + o.getPrice() + "\"/>"+ o.getPrice() +"$</span>\n" +
                    "                            </div>\n" +
                    "                        </div>\n" +
                    "                    </div>");
        }
    }
}
