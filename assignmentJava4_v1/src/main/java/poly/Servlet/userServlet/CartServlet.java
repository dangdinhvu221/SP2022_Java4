package poly.Servlet.userServlet;

import poly.DAO.ProductsDAO;
import poly.Entity.Cart;
import poly.Entity.Products;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@WebServlet({
        "/CartServlet",
        "/CartServlet/AddToCart",
})
public class CartServlet extends HttpServlet {
    private final ProductsDAO productsDAO;
    private List<Products> list;
    private List<Cart> listCart;


    public CartServlet() {
        productsDAO = new ProductsDAO();
        list = new ArrayList<Products>();
        listCart = new ArrayList<>();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String uri = request.getRequestURI();
        if (uri.contains("CartServlet")) {
            processRequest(request, response);
            pagingPage(request, response);
        } else if (uri.contains("AddToCart")) {
            processRequest(request, response);
            pagingPage(request, response);
        }

        request.setAttribute("views", "/views/user/FormCart/cart.jsp");
        request.getRequestDispatcher("/views/user/detailsProducts/indexDeltaProduct.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("AddToCart")) {
            processRequest(request, response);
            pagingPage(request, response);
        }
        request.setAttribute("views", "/views/user/FormCart/cart.jsp");
        request.getRequestDispatcher("/views/user/detailsProducts/indexDeltaProduct.jsp").forward(request, response);
    }


    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        HttpSession session = request.getSession();
        Cookie[] arr = request.getCookies();
        String quantity = request.getParameter("quantity");
        Products product = new Products();
        Cart cart = new Cart();
        int count = 0;
        for (Cookie o : arr) {
            if (o.getName().equals("id")) {
                String[] txt = o.getValue().split("-");
                for (String s : txt) {
                    product = productsDAO.findByID(Integer.parseInt(s));
                    cart.setId(product.getId());
                    cart.setPrice(product.getPrice());
                    cart.setImageProduct(product.getImageProduct());
                    cart.setNameProduct(product.getNameProduct());
                    if (quantity != null) {
                        cart.setQuantity(0);
//                        product.setQuantity(0);
                    }
                    listCart.add(cart);
                    count++;
                }
            }
        }

        for (int i = 0; i < listCart.size(); i++) {
            for (int j = i + 1; j < listCart.size(); j++) {
                if (listCart.get(i).getId() == listCart.get(j).getId()) {
                    listCart.remove(j);
                    j--;
                }
            }
            if (quantity != null) {
                if (listCart.get(i).getId() == Integer.parseInt(request.getParameter("id"))) {
                    listCart.get(i).setQuantity(listCart.get(i).getQuantity() + Integer.parseInt(quantity));
                }
            }
        }

        int total = 0;
        for (Products o : listCart) {
            total = total + o.getQuantity() * o.getPrice();
        }
        session.setAttribute("count", count);
        session.setAttribute("list_cart", listCart);
        session.setAttribute("total", total);
        session.setAttribute("vat", 0.1 * total);
        session.setAttribute("sum", (0.1 * total) + total);
    }

    private void pagingPage(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {
            String indexPage = request.getParameter("index");
            if (indexPage == null) {
                indexPage = "1";
            }
            int index = Integer.parseInt(indexPage);
            ProductsDAO listProductsDAO = new ProductsDAO();
            int count = listProductsDAO.getTotalProducts();
            int endPage = count / 3;
            if (count % 3 != 0) {
                endPage++;
            }
            List<Products> list = listProductsDAO.pagingAccount(index);
            request.setAttribute("listA", list);
            request.setAttribute("endP", endPage);
            request.setAttribute("tag", index);
            findAllProducts(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
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

}
