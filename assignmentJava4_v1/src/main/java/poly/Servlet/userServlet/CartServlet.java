package poly.Servlet.userServlet;

import poly.DAO.ProductsDAO;
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
        "/CartServlet/remove",

})
public class CartServlet extends HttpServlet {
    private ProductsDAO productsDAO;
    private List<Products> list;


    public CartServlet() {
        productsDAO = new ProductsDAO();
        list = new ArrayList<Products>();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String uri = request.getRequestURI();

        if (uri.contains("CartServlet")) {
            pagingPage(request, response);
            processRequest(request, response);
        } else if (uri.contains("AddToCart")) {
            processRequest(request, response);
            pagingPage(request, response);
        }
        if (uri.contains("remove")) {
            removeCart(request, response);
        }
        request.setAttribute("views", "/views/user/FormCart/cart.jsp");
        request.getRequestDispatcher("/views/user/detailsProducts/indexDeltaProduct.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("remove")) {
            removeCart(request, response);
        } else if (uri.contains("AddToCart")) {
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
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        Cookie arr[] = request.getCookies();
        String quantity = request.getParameter("quantity");
        Products product = new Products();
        int count = 0;
        for (Cookie o : arr) {
            if (o.getName().equals("id")) {
                String txt[] = o.getValue().split("-");
                for (String s : txt) {
                    if (quantity != null) {
                        product = productsDAO.findByID(Integer.parseInt(s));
                        product.setQuantity(0);
                        list.add(product);
                        count++;
                        session.setAttribute("count", count);
                    } else {
                        product = productsDAO.findByID(Integer.parseInt(s));
                        list.add(product);
                    }
                }
            }
        }

        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i).getId() == list.get(j).getId()) {
                    list.remove(j);
                    j--;
                }
            }
            if (quantity != null) {
                if (list.get(i).getId() == Integer.parseInt(request.getParameter("id"))) {
                    list.get(i).setQuantity(list.get(i).getQuantity() + Integer.parseInt(quantity));
                }
            }
        }

        int total = 0;
        for (Products o : list) {
            total = total + o.getQuantity() * o.getPrice();
        }
        request.setAttribute("list_cart", list);
        request.setAttribute("total", total);
        request.setAttribute("vat", 0.1 * total);
        request.setAttribute("sum", (0.1 * total) + total);
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

    protected void removeCart(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html;charset=UTF-8");
        response.setContentType("text/html;charset=UTF-8");
//        findAllProducts(request, response);
//
        String id = request.getParameter("id");
        System.out.println(id +"------------------------------------------------------");
        Cookie arr[] = request.getCookies();
        String txt = "";
        for (Cookie o : arr) {
            if (o.getName().equals("id")) {
                txt = txt + o.getValue();
                o.setMaxAge(0);
                response.addCookie(o);
            }
        }
        String ids[] = txt.split("-");
        String txtOutPut = "";
        int check = 0;
        for (int i = 0; i < ids.length; i++) {
            if (!ids[i].equals(id)) {
                if (txtOutPut.isEmpty()) {
                    txtOutPut = ids[i];
                } else {
                    txtOutPut = txtOutPut + "-" + ids[i];
                }
            }
        }
//        if (!txtOutPut.isEmpty()) {
//            Cookie c = new Cookie("id", txtOutPut);
//            c.setMaxAge(60 * 60 * 24);
//            response.addCookie(c);
//        }
        Products products = productsDAO.findByID(Integer.parseInt(id));
        for (Products product : list) {
            list.remove(product);
        }
        request.setAttribute("list_cart ", list);
    }

}
