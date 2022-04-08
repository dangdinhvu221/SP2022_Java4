package poly.Servlet.userServlet;

import org.apache.commons.beanutils.BeanUtils;
import poly.DAO.UsersDAO;
import poly.Entity.Users;
import poly.Utils.EncryptUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet({
        "/ChangePasswordServlet",
        "/ChangePasswordServlet/changePassword",
})
public class ChangePasswordServlet extends HttpServlet {
    private UsersDAO usersDAO;

    public ChangePasswordServlet() {
        usersDAO = new UsersDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("views", "/views/admin/ManagerUser/profile.jsp");
        request.getRequestDispatcher("/views/index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("changePassword")) {
            String password = request.getParameter("password");
            String passwordNew = request.getParameter("password-new");
            String passwordConfirm = request.getParameter("cf-password");
            if (passwordNew.isEmpty()|| passwordConfirm.isEmpty()) {
                request.setAttribute("error", "ERROR: " + "PasswordNew or passwordConfirm isEmpty!!!");
            } else if (!passwordNew.equals(passwordConfirm)) {
                request.setAttribute("error", "ERROR: " + "Please check your password again");
            } else {
                try {
                    int id = Integer.parseInt(request.getParameter("idUser"));
                    Users users = usersDAO.findByID(id);
                    BeanUtils.populate(users, request.getParameterMap());
                    String encryptedPass  = EncryptUtils.encrypt(passwordNew);
                    users.setPassword(encryptedPass);
                    usersDAO.update(users);
                    System.out.println(id);
                    request.setAttribute("message", "Change Passwords successfully!");
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
            request.setAttribute("views", "/views/admin/ManagerUser/profile.jsp");
            request.getRequestDispatcher("/views/index.jsp").forward(request, response);
        }
    }
}
