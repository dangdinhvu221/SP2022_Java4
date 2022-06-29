package poly.Servlet.userServlet;

import poly.DAO.CategoriesDAO;
import poly.DAO.ProductsDAO;
import poly.DAO.UsersDAO;
import poly.DAO.favoritesDAO;
import poly.Entity.Category;
import poly.Entity.Favorite;
import poly.Entity.Products;
import poly.Entity.Users;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet({
        "/DetailsProductServlet",

})
public class DetailsProductServlet extends HttpServlet {
    private ProductsDAO productsDAO;
    private favoritesDAO favoritesDAO;


    public DetailsProductServlet() {
        productsDAO = new ProductsDAO();
        favoritesDAO = new favoritesDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("DetailsProductServlet")) {
            this.doDeltaProduct(request, response);
            AddToCart(request, response);
        }
        request.getRequestDispatcher("/views/user/detailsProducts/indexDeltaProduct.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AddToCart(request, response);
    }

    private void doDeltaProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Products products = productsDAO.findByID(id);
//        Users user = (Users) request.getSession().getAttribute("users");
        try{
            List<Favorite> listF = favoritesDAO.findAll();
            int idPF = 0;
            int idU = 0;
            for (Favorite f: listF) {
                if(id == f.getProduct_id().getId()){
                    idPF = f.getProduct_id().getId();
                    idU = f.getUser_id().getId();
                    System.out.println(idPF);
                    System.out.println(idU);
                }
            }
            request.setAttribute("idPF", idPF);
            request.setAttribute("idU", idU);
            request.setAttribute("list_favorites", listF);
        }catch (Exception e) {
            e.printStackTrace();
        }
        request.setAttribute("products", products);
        request.setAttribute("views", "/views/user/detailsProducts/detailsProduct.jsp");
    }

    protected void AddToCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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

        request.setAttribute("views", "/views/user/detailsProducts/detailsProduct.jsp");
    }

}
