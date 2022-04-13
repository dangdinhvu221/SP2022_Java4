package poly.Servlet.adminServlet;

import poly.DAO.OrderDAO;
import poly.DAO.OrderStatesDAO;
import poly.DAO.ProductsDAO;
import poly.Entity.OrderStates;
import poly.Entity.Orders;
import poly.Entity.Products;
import poly.Entity.Users;
import poly.Entity.order.FlowOrder;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet({
        "/OrderControlServlet",
        "/OrderControlServlet/update",
        "/OrderControlServlet/historyOrder"
})
public class OrderControlServlet extends HttpServlet {
    private List<FlowOrder> list;
    private List<OrderStates> listStates;

    private OrderDAO oDao;
    private OrderStatesDAO statesDAO;

    public OrderControlServlet() {
        list = new ArrayList<FlowOrder>();
        listStates = new ArrayList<OrderStates>();
        oDao = new OrderDAO();
        statesDAO = new OrderStatesDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("historyOrder")) {
            historyOrder(request, response);
        } else if (uri.contains("update")) {
            updateStatusOrder(request, response);
        } else if (uri.contains("OrderControlServlet")) {
            findAll(request, response);
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("historyOrder")) {
            historyOrder(request, response);
        } else if (uri.contains("update")) {
            updateStatusOrder(request, response);
        } else if (uri.contains("OrderControlServlet")) {
            findAll(request, response);
        }
    }

    private void historyOrder(HttpServletRequest request, HttpServletResponse response) {
        try {
            Users user = (Users) request.getSession().getAttribute("users");
            list = oDao.historyOrders(user.getId());
            request.setAttribute("list_history", list);
            request.setAttribute("views", "/views/admin/ManagerOrders/historyOrder.jsp");
            request.getRequestDispatcher("/views/user/detailsProducts/indexDeltaProduct.jsp").forward(request, response);
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
    }


    private void updateStatusOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        int status = Integer.parseInt(request.getParameter("statusOrder"));
        System.out.println(id + "-----------------------------------------------");
        System.out.println(status + "-----------------------------------------------");

        Orders orders = oDao.findByID(id);
        OrderStates orderStates = new OrderStates();
        orderStates.setId(status);
        orders.setOrdersByOrderId(orderStates);
        oDao.update(orders);
        this.findAll(request, response);
    }

    protected void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            list = oDao.findAllOrders();
            request.setAttribute("orders_list", list);
            listStates = statesDAO.findAll();
            request.setAttribute("orderStates", listStates);
            request.setAttribute("views", "/views/admin/ManagerOrders/tableOrders.jsp");
            request.getRequestDispatcher("/views/index.jsp").forward(request, response);
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
    }

}
