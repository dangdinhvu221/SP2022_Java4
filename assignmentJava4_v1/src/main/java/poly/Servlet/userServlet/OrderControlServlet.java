package poly.Servlet.userServlet;

import poly.DAO.ProductsDAO;
import poly.Entity.Products;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "OrderControlServlet", value = "/OrderControlServlet")
public class OrderControlServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Products> list = new ArrayList<>();
        Cookie arr[] = request.getCookies();
        ProductsDAO dao = new ProductsDAO();
        for (Cookie o : arr
             ) {
            if(o.getName().equals("id")){
                String txt[] = o.getValue().split(",");
                for (String s: txt
                     ) {
                    list.add(dao.findByID(Integer.parseInt(s)));
                }
            }
        }
        for (int i = 0; i < list.size(); i++) {
            int count = 1;
            for (int j = i+1; j < list.size(); j++) {
                if(list.get(i).getId() == list.get(j).getId()) {
                    count++;
                    list.remove(j);
                    j--;
                    list.get(i).setQuantity(count);
                }
            }
        }
        for (Cookie o: arr
             ) {
            o.setMaxAge(0);
            response.addCookie(o);
        }
        response.sendRedirect("/views/HomePage.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
