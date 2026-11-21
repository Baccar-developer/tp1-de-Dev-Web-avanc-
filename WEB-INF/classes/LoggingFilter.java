import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebFilter;
import java.io.*;

@WebFilter("/*")
public class LoggingFilter implements Filter {
    @Override
    public void init(FilterConfig config) {
        String prefix = config.getInitParameter("logPrefix");
        System.out.println(prefix + " LoggingFilter initialized");
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        System.out.println("Before: " + request.getRequestURL());
        chain.doFilter(req, res); // continue to servlet
        System.out.println("After: servlet finished processing");
    }

    @Override
    public void destroy() {
        System.out.println("LoggingFilter destroyed");
    }
}