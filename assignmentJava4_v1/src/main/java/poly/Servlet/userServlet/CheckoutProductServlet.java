package poly.Servlet.userServlet;

import poly.DAO.OrderDAO;
import poly.DAO.ProductsDAO;
import poly.DAO.UsersDAO;
import poly.Entity.Orders;
import poly.Entity.Products;
import poly.Entity.Users;
import poly.Entity.order.FlowOrder;
import poly.Entity.order.Order;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet(name = "CheckoutProductServlet", value = "/CheckoutProductServlet")
public class CheckoutProductServlet extends HttpServlet {
    private List<Products> list;
    private List<Order> listOrder;
    private ProductsDAO productsDAO;
    private UsersDAO usersDAO;
    private OrderDAO oDao;


    public CheckoutProductServlet() {
        list = new ArrayList<Products>();
        listOrder = new ArrayList<>();
        productsDAO = new ProductsDAO();
        usersDAO = new UsersDAO();
        oDao = new OrderDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Users auth = (Users) request.getSession().getAttribute("users");
        try {
            List<FlowOrder> list = oDao.findAllOrder(auth.getId());
            request.setAttribute("orders", list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.setAttribute("views", "/views/user/FormCart/checkout.jsp");
        request.getRequestDispatcher("/views/user/detailsProducts/indexDeltaProduct.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date();
            Cookie arr[] = request.getCookies();
            for (Cookie o : arr) {
                if (o.getName().equals("id")) {
                    String txt[] = o.getValue().split("-");
                    for (String s : txt) {
                        list.add(productsDAO.findByID(Integer.parseInt(s)));
                    }
                }
            }
            Users auth = (Users) request.getSession().getAttribute("users");
            for (Products p : list) {
                Order order = new Order();
                order.setOrderId(p.getId());
                order.setUid(auth.getId());
                order.setQuantity(p.getQuantity());
                order.setDate(formatter.format(date));
                order.setStatusState(1);
                oDao.insertOrder(order);
            }


            request.setAttribute("list", listOrder);
            request.setAttribute("views", "/views/user/FormCart/checkout.jsp");
            request.getRequestDispatcher("/views/user/detailsProducts/indexDeltaProduct.jsp").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
