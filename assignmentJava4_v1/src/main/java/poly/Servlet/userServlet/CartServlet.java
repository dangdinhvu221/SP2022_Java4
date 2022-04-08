package poly.Servlet.userServlet;

//import poly.DAO.OrderDAO;
import poly.DAO.ProductsDAO;
import poly.Entity.Products;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet({
        "/CartServlet",
        "/CartServlet/AddToCart"
})
public class CartServlet extends HttpServlet {
//    private OrderDAO orderDAO;
    private ProductsDAO productsDAO;
    private List<Products> list;


    public CartServlet() {
//        orderDAO = new OrderDAO();
        productsDAO = new ProductsDAO();
        list = new ArrayList<Products>();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("CartServlet")){
            List<Products> list1 = productsDAO.findAll();
            request.setAttribute("list_products", list1);
            processRequest(request, response);
        }else if(uri.contains("AddToCart")){
            processRequest(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String uri = request.getRequestURI();
       if(uri.contains("AddToCart")){
           processRequest(request, response);
       }

    }

    private void orderDetails(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String uri = request.getRequestURI();
        if (uri.contains("AddToCart")) {
//            HttpSession session = request.getSession();
//
//            int id = Integer.parseInt(request.getParameter("id"));
//            Products products = productsDAO.findByID(id);
//            list.add(products);
//            for (Products p: list
//                 ) {
//                System.out.println(p.getNameProduct());
//            }
//            session.setAttribute("lits_orders", list);
        }
        request.setAttribute("views", "/views/user/FormCart/cart.jsp");
        request.getRequestDispatcher("/views/user/detailsProducts/indexDeltaProduct.jsp").forward(request, response);
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html;charset=UTF-8");
        List<Products> list1 = productsDAO.findAll();
        request.setAttribute("list_products", list1);
        Cookie arr[] = request.getCookies();
        ProductsDAO productsDAO = new ProductsDAO();
        for (Cookie o : arr) {
            if (o.getName().equals("id")) {
                String txt[] = o.getValue().split("-");
                for (String s : txt) {
                    list.add(productsDAO.findByID(Integer.parseInt(s)));
                }
            }
        }
        for (int i = 0; i < list.size(); i++) {
            int count = 1;
            for (int j = i+1; j < list.size(); j++) {
                if(list.get(i).getId() == list.get(j).getId()){
                    count++;
                    list.remove(j);
                    j--;
                    list.get(i).setQuantity(count);
                }
            }
        }
        int total = 0;
        for (Products o : list) {
            total = total + o.getQuantity() * o.getPrice();
        }
        request.setAttribute("list", list);
        request.setAttribute("total", total);
        request.setAttribute("vat", 0.1 * total);
        request.setAttribute("sum", 1.1 * total);

        request.setAttribute("views", "/views/user/FormCart/cart.jsp");
        request.getRequestDispatcher("/views/user/detailsProducts/indexDeltaProduct.jsp").forward(request, response);
    }

}
