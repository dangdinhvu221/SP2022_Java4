package poly.Servlet.userServlet;

import org.apache.commons.beanutils.BeanUtils;
import poly.DAO.ProductsDAO;
import poly.DAO.UsersDAO;
import poly.DAO.favoritesDAO;
import poly.Entity.Favorite;
import poly.Entity.Products;
import poly.Entity.Users;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet({
        "/favoritesServlet",
        "/favoritesServlet/Unlike",
        "/favoritesServlet/like",
})
public class favoritesServlet extends HttpServlet {
    private ProductsDAO productsDAO;
    private favoritesDAO favoritesDAO;
    private UsersDAO usersDAO;

    private List<Products> list;

    public favoritesServlet() {
        productsDAO = new ProductsDAO();
        favoritesDAO = new favoritesDAO();
        usersDAO = new UsersDAO();
        list = new ArrayList<>();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String uri = request.getRequestURI();
       if(uri.contains("Unlike")){
           this.doUnlike(request, response);
       }else if(uri.contains("like")){
           this.doLike(request, response);
       }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("Unlike")){
            this.doUnlike(request, response);
        }else if(uri.contains("like")){
            this.doLike(request, response);
        }
    }
    private void doUnlike(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        Users user = (Users) request.getSession().getAttribute("users");
        try {
            Favorite favorite = new Favorite();
            favorite.setProduct_id(null);
            favorite.setUser_id(user);
            Date date = new Date();
            Timestamp ts = new Timestamp(date.getTime());
            favorite.setLikeDate(ts);
//            this.favoritesDAO.delete();
            System.out.println("okokok");
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("error");
        }
        response.sendRedirect("/assignmentJava4_v1_war_exploded/HomePagesServlet");
    }

    private void doLike(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        Products product = productsDAO.findByID(Integer.parseInt(id));
        Users user = (Users) request.getSession().getAttribute("users");
        try {
            Favorite favorite = new Favorite();
            favorite.setProduct_id(product);
            favorite.setUser_id(user);
            Date date = new Date();
            Timestamp ts = new Timestamp(date.getTime());
            favorite.setLikeDate(ts);
            this.favoritesDAO.insert(favorite);
            System.out.println("okokok");
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("error");
        }
        response.sendRedirect("/assignmentJava4_v1_war_exploded/HomePagesServlet");
    }

    protected void findAll(HttpServletRequest request, HttpServletResponse response){
        Users user = (Users) request.getSession().getAttribute("users");
        try{
            List<Favorite> listF = favoritesDAO.findAll();
            int idPF = 0;
            int idU = 0;
            for (Favorite f: listF) {
                if(f.getUser_id().getId() == user.getId()){
                    request.setAttribute("list_favorite", f);
                }
            }
            request.setAttribute("idPF", idPF);
            request.setAttribute("idU", idU);
            request.setAttribute("list_favorites", listF);
        }catch (Exception e) {
            e.printStackTrace();
        }
//        response.sendRedirect("/assignmentJava4_v1_war_exploded/HomePagesServlet");
    }

}
