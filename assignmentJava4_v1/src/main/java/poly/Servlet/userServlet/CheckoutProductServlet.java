package poly.Servlet.userServlet;

import poly.DAO.OrderDAO;
import poly.DAO.ProductsDAO;
import poly.DAO.UsersDAO;
import poly.Entity.OrderStates;
import poly.Entity.Orders;
import poly.Entity.Products;
import poly.Entity.Users;
import poly.Entity.order.FlowOrder;
import poly.Entity.order.Order;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

import java.text.SimpleDateFormat;
import java.util.*;

@WebServlet({
        "/CheckoutProductServlet",
        "/CheckoutProductServlet/remove"
})
public class CheckoutProductServlet extends HttpServlet {
    private List<Products> list;
    private List<Order> listOrder;
    private ProductsDAO productsDAO;
    private UsersDAO usersDAO;
    private OrderDAO oDao;
    private int orderId;


    public CheckoutProductServlet() {
        list = new ArrayList<Products>();
        listOrder = new ArrayList<>();
        productsDAO = new ProductsDAO();
        usersDAO = new UsersDAO();
        oDao = new OrderDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("remove")) {
            this.removeOrder(request, response);
            this.findAll(request, response);
        } else if (uri.contains("CheckoutProductServlet")) {
            this.findAll(request, response);
        }
        request.setAttribute("views", "/views/user/FormCart/checkout.jsp");
        request.getRequestDispatcher("/views/user/detailsProducts/indexDeltaProduct.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("CheckoutProductServlet")) {
            this.processRequest(request, response);
        } else if (uri.contains("removeOrder")) {
            this.removeOrder(request, response);
            findAll(request, response);
        }
    }

    protected void removeOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            oDao.delete(id);
            request.setAttribute("message", "Order delete successfully!!!");
        } catch (Exception e) {
            request.setAttribute("error", "ERROR: " + e.getMessage());
        }
    }

    protected void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Users auth = (Users) request.getSession().getAttribute("users");
            if (auth != null) {
                List<FlowOrder> list = oDao.findAllOrder(auth.getId());
                request.setAttribute("orders", list);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date();
            Cookie arr[] = request.getCookies();
            Products products = new Products();
            String quantities = request.getParameter("quantity");

            for (Cookie o : arr) {
                if (o.getName().equals("id")) {
                    String txt[] = o.getValue().split("-");
                    for (String s : txt) {
                        if (s != null) {
                            products = productsDAO.findByID(Integer.parseInt(s));
                            products.setQuantity(Integer.parseInt(quantities));
                            list.add(products);
                        }
                    }
                }
            }

            for (Cookie o : arr) {
                if (o.getName().equals("id")) {
                    o.setMaxAge(0);
                    response.addCookie(o);
                }
            }

            Users auth = (Users) request.getSession().getAttribute("users");
            for (Products p : list) {
                Order order = new Order();
                order.setOrderId(p.getId());
                order.setUid(auth.getId());
                order.setQuantity(Integer.parseInt(quantities));
                order.setDate(formatter.format(date));
                order.setStatusState(1);
                oDao.insertOrder(order);
                System.out.println("--------------------------");
                System.out.println(auth.getId());
                System.out.println(order.getOrderId());
                System.out.println(order.getQuantity());
                System.out.println(order.getDate());
                System.out.println("--------------------------");
            }
            session.setAttribute("message", "Ordering successfully!");
            response.sendRedirect("/assignmentJava4_v1_war_exploded/CheckoutProductServlet");
//            request.setAttribute("views", "/views/user/FormCart/checkout.jsp");
//            request.getRequestDispatcher("/views/user/detailsProducts/indexDeltaProduct.jsp").forward(request, response);
        } catch (Exception e) {
            session.setAttribute("error", "Please login before ordering");
            response.sendRedirect("/assignmentJava4_v1_war_exploded/HomePagesServlet/login");
            e.printStackTrace();
        }
    }
}
