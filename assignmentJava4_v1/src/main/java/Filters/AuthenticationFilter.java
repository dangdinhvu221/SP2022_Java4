package Filters;

import poly.Entity.Users;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "AuthenticationFilter",
        urlPatterns = {
                "/AdminServlet/*",
                "/ProductServlet/*",
                "/CategoryServlet/*",
                "/SupplierServlet/*",
                "/OrderControlServlet/*",
        })
public class AuthenticationFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {


    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        HttpSession session = req.getSession();
        Users user =  (Users) session.getAttribute("users");
        if(user == null) {
            resp.sendRedirect("/assignmentJava4_v1_war_exploded/HomePagesServlet/login");
            return;
        }
        chain.doFilter(request, response);
    }
}
