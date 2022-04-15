package poly.Servlet.userServlet;

import poly.DAO.ProductsDAO;
import poly.Entity.Products;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/removeCart")
public class RemoProductCartServlet extends HttpServlet {
    private final ProductsDAO productsDAO;

    public RemoProductCartServlet() {
        productsDAO = new ProductsDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.removeCart(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.removeCart(request, response);
    }

    protected void findAllProducts(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Products> listP = productsDAO.findAll();
            request.setAttribute("list_products", listP);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "Error: " + e.getMessage());
        }
    }

    protected void removeCart(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html;charset=UTF-8");
        String id = request.getParameter("id");
        HttpSession session = request.getSession();
        int count = (int) request.getSession().getAttribute("count");
        List<Products> listCart = (List<Products>) request.getSession().getAttribute("list_cart");

        Cookie[] arr = request.getCookies();
        String txt = "";
        for (Cookie o : arr) {
            if (o.getName().equals("id")) {
                txt += o.getValue();
                o.setMaxAge(0);
                response.addCookie(o);
                count--;

            }
        }
        String[] ids = txt.split("-");
        String txtOutPut = "";
        for (int i = 0; i < ids.length; i++) {
            if (!ids[i].equals(id)) {
                if (txtOutPut.isEmpty()) {
                    txtOutPut = ids[i];
                } else {
                    txtOutPut = txtOutPut + "-" + ids[i];
                }
            }
        }
        if (!txtOutPut.isEmpty()) {
            Cookie c = new Cookie("id", txtOutPut);
            c.setMaxAge(60 * 60 * 24);
            response.addCookie(c);
        }

        listCart.removeIf(p -> p.getId() == Integer.parseInt(id));

        int total = (int) request.getSession().getAttribute("total");
        for (Products o : listCart) {
            total = total + o.getQuantity() * o.getPrice();
        }


        session.setAttribute("list_cart ", listCart);
        session.setAttribute("count", count);
        session.setAttribute("total", total);
        session.setAttribute("vat", 0.1 * total);
        session.setAttribute("sum", (0.1 * total) + total);
        response.sendRedirect("/assignmentJava4_v1_war_exploded/CartServlet");
        this.findAllProducts(request, response);
    }

}


