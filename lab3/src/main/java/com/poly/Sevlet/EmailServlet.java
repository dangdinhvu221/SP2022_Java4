package com.poly.Sevlet;

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
@WebFilter("/*")
@WebServlet("/EmailServlet")
public class EmailServlet extends HttpServlet implements Filter{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        request.getRequestDispatcher("view/email/form.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        final String usernmae = request.getParameter("form");
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

        String emailTo = request.getParameter("to");
        String emailSubject = request.getParameter("subject");
        String emailBody = request.getParameter("body");

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

            try (PrintWriter out = response.getWriter()) {
                out.println("<h1>SuccessFully!!!</h1>");
            }

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        request.getRequestDispatcher("view/email/form.jsp").forward(request, response);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding("utf-8");
        servletResponse.setCharacterEncoding("utf-8");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
    }
}
