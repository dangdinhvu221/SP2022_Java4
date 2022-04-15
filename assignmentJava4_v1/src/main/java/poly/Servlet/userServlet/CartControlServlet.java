package poly.Servlet.userServlet;

import poly.DAO.ProductsDAO;
import poly.Entity.Products;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CartControlServlet", value = "/CartControlServlet")
public class CartControlServlet extends HttpServlet {
    private ProductsDAO productsDAO;
    private List<Products> list;

    public CartControlServlet() {
        productsDAO = new ProductsDAO();
        list = new ArrayList<Products>();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String id = request.getParameter("id");
        Cookie arr[] = request.getCookies();
        String txt = "";
        for (Cookie o : arr) {
            if (o.getName().equals("id")) {
                txt = txt + o.getValue();
                o.setMaxAge(0);
                response.addCookie(o);
            }
        }
        if (txt.isEmpty()) {
            txt = id;
        } else {
            txt = txt + "-" + id;
        }
        Cookie c = new Cookie("id", txt);
        c.setMaxAge(60 * 60 * 24);
        response.addCookie(c);

        HttpSession session = request.getSession();
        List<Products> listCart = (List<Products>) request.getSession().getAttribute("list_cart");

        int total = (int) request.getSession().getAttribute("total");
        for (Products o : listCart) {
            total = total + o.getQuantity() * o.getPrice();
        }

        session.setAttribute("list_cart ", listCart);
//        session.setAttribute("count", count);
        session.setAttribute("total", total);
        session.setAttribute("vat", 0.1 * total);
        session.setAttribute("sum", (0.1 * total) + total);

        response.sendRedirect("/assignmentJava4_v1_war_exploded/CartServlet");
    }
}
