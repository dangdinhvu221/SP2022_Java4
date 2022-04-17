package poly.Servlet.userServlet;

import poly.Entity.order.Cart;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "SubControlServlet", value = "/SubControlServlet")
public class SubControlServlet extends HttpServlet {
    private List<Cart> list;

    public SubControlServlet() {
        list = new ArrayList<Cart>();
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
        HttpSession session = request.getSession();
        list = (List<Cart>) request.getSession().getAttribute("list_cart");
        String id = request.getParameter("id");
        int total = (int) request.getSession().getAttribute("total");
        int amount = 0;
        for (Cart o : list) {
            if(o.getId() == Integer.parseInt(id)){
                amount = o.getQuantity();
                amount--;
                o.setQuantity(amount);
            }

            total = total + o.getQuantity() * o.getPrice();
        }

        session.setAttribute("amount", amount);
        System.out.println(amount +"----------------------------------------------");
        session.setAttribute("list_cart ", list);
//        session.setAttribute("count", count);
        session.setAttribute("total", total);
        session.setAttribute("vat", 0.1 * total);
        session.setAttribute("sum", (0.1 * total) + total);

        response.sendRedirect("/assignmentJava4_v1_war_exploded/CartServlet");
    }
}
