package poly.Servlet.userServlet;

import org.apache.commons.beanutils.BeanUtils;
import poly.DAO.UsersDAO;
import poly.Entity.Users;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

@WebServlet({
        "/ForgotPasswordServlet",
        "/ForgotPasswordServlet/forgotPassword",
        "/ForgotPasswordServlet/resetPassword",

})
public class ForgotPasswordServlet extends HttpServlet {
    private UsersDAO dao;
    public ForgotPasswordServlet() {
        dao = new UsersDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("views", "/views/admin/Login/forGotPassword.jsp");
        String uri = request.getRequestURI();
        if (uri.contains("resetPassword")) {
            request.setAttribute("views", "/views/admin/Login/changePassword.jsp");
        }
        request.getRequestDispatcher("/views/admin/Login/index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("forgotPassword")) {
           this.doforgotPassword(request,response);
        }
        else if (uri.contains("resetPassword")) {
            this.doResetPassword(request,response);
        }
    }

    private void doResetPassword(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String passwordNew = request.getParameter("password-new");
        String passwordConfirm = request.getParameter("cf-password");
        if (passwordNew.isEmpty()|| passwordConfirm.isEmpty()) {
            request.setAttribute("error", "ERROR: " + "PasswordNew or passwordConfirm isEmpty!!!");
            request.setAttribute("views", "/views/admin/Login/changePassword.jsp");
        } else if (!passwordNew.equals(passwordConfirm)) {
            request.setAttribute("error", "ERROR: " + "Please check your password again");
            request.setAttribute("views", "/views/admin/Login/changePassword.jsp");
        } else {
            try {
                String email = request.getParameter("email");
                Users users = dao.findKeywordEmail(email);
                BeanUtils.populate(users, request.getParameterMap());
                users.setPassword(passwordNew);
                dao.update(users);
                System.out.println(email);
                request.setAttribute("message", "Reset Passwords successfully!");
            }catch (Exception e) {
                request.setAttribute("error", "ERROR: " + e.getMessage());
                e.printStackTrace();
            }
            request.setAttribute("views", "/views/admin/Login/loginForm.jsp");
            request.getRequestDispatcher("/views/admin/Login/index.jsp").forward(request, response);
        }
    }

    private void doforgotPassword(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final String usernmae = "dangdinhvu221@gmail.com";
        final String password = "vu123456";

        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(usernmae, password);
            }
        });

        String emailTo = request.getParameter("email");
        HttpSession session1 = request.getSession();
        session1.setAttribute("emailTo", emailTo);
        request.setAttribute("emailTo", emailTo);
        String emailSubject = "Reset Password";
        String emailBody = "http://localhost:8080/assignmentJava4_v1_war_exploded/ForgotPasswordServlet/resetPassword";

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(usernmae));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(emailTo)

            );
            message.setSubject(emailSubject);
            message.setText(emailBody);
            Transport.send(message);
            System.out.println("Done");

            request.setAttribute("message", "SuccessFully!");
        } catch (Exception e) {
            // TODO: handle exception
            request.setAttribute("error", "ERROR: " + e.getMessage());
            e.printStackTrace();
        }
        request.setAttribute("views", "/views/admin/Login/forGotPassword.jsp");
        request.getRequestDispatcher("/views/admin/Login/index.jsp").forward(request, response);
    }
}
