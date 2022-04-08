package poly.Servlet.userServlet;

import poly.DAO.ProductsDAO;
import poly.Entity.Products;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "RemoProductCartServlet", value = "/remove")
public class RemoProductCartServlet extends HttpServlet {
    public RemoProductCartServlet() {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.processRequest(request, response);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
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
        String ids[] = txt.split("-");
        String txtOutput = "";
        int check = 0;

        for (int i = 0; i < ids.length; i++) {
            if(!ids[i].equals(id)){
                if(txtOutput.isEmpty()){
                    txtOutput = ids[i];
                }else {
                    txtOutput += "-" + ids[i];
                }
            }
        }
        if(!txtOutput.isEmpty()){
            Cookie e = new Cookie("id", txtOutput);
            e.setMaxAge(60*60*24);
            response.addCookie(e);
        }
        response.sendRedirect("/assignmentJava4_v1_war_exploded/CartServlet");
    }
}
