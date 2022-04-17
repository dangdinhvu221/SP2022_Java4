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
            if (o.getId() == Integer.parseInt(id)) {
                amount = o.getQuantity();
                amount--;
                o.setQuantity(amount);
            }
            total = total + o.getQuantity() * o.getPrice();
        }
        try {
            Cookie[] arr = request.getCookies();
            String txt = "";
            for (Cart c : list) {
                if (c.getQuantity() <= 0) {
                    for (Cookie o : arr) {
                        if (o.getName().equals("id")) {
                            txt += o.getValue();
                            o.setMaxAge(0);
                            response.addCookie(o);
                        }
                    }
                    list.remove(c);
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
        }catch (Exception e){
            e.printStackTrace();
        }


        session.setAttribute("amount", amount);
        System.out.println(amount + "----------------------------------------------");
        session.setAttribute("list_cart ", list);
//        session.setAttribute("count", count);
        session.setAttribute("total", total);
        session.setAttribute("vat", 0.1 * total);
        session.setAttribute("sum", (0.1 * total) + total);

        response.sendRedirect("/assignmentJava4_v1_war_exploded/CartServlet");
    }
}
