package pl.sdacademy.filter;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoggedUserFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req =(HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        String user = (String) req.getSession().getAttribute("user");
        if(user ==null){
            resp.sendRedirect("/login");
            return;
        }

        filterChain.doFilter(servletRequest,servletResponse);


    }

    @Override
    public void destroy() {

    }
}
