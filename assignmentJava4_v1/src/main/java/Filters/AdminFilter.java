package Filters;

import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebFilter(filterName = "AdminFilter",
        urlPatterns = {
                "/admin/*",
                "/ProductServlet/*",
                "/CategoryServlet/*",
                "/SupplierServlet/*",
        })

public class AdminFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        System.out.println("Admin");
        chain.doFilter(request, response);
    }
}
