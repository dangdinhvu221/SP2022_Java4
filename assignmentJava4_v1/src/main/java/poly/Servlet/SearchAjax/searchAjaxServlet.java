package poly.Servlet.SearchAjax;

import poly.DAO.CategoriesDAO;
import poly.DAO.ProductsDAO;
import poly.DAO.UsersDAO;
import poly.Entity.Category;
import poly.Entity.Products;
import poly.Entity.Users;

import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet({
        "/searchAjaxServlet",
})
public class searchAjaxServlet extends HttpServlet {
    private ProductsDAO dao;
    private List<Products> list;

    public searchAjaxServlet() {
        dao = new ProductsDAO();
        list = new ArrayList<>();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        String key = request.getParameter("search");
        List<Products> list = dao.findKeyword(key);
        request.setAttribute("ListCategory", list);
        PrintWriter out = response.getWriter();
        request.setAttribute("tableUsers", "/views/admin/ManagerUser/tableUser.jsp");
        for (Products o : list) {
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
                    "                                                                      value=\"" + o.getPrice() + "\"/>" + o.getPrice() + "$</span>\n" +
                    "                            </div>\n" +
                    "                        </div>\n" +
                    "                    </div>");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
