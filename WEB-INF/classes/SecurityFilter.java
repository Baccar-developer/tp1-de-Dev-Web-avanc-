import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebFilter;
import java.io.*;

public class SecurityFilter implements Filter {
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("user") != null) {
            chain.doFilter(req, res);
            long start = System.nanoTime();
            chain.doFilter(req, res);
            long elapsedMs = (System.nanoTime() - start) / 1_000_000;
            System.out.println("Execution time: " + elapsedMs + " ms");
        } else {

            res.setContentType("text/html, charset=utf-8");
            PrintWriter out = res.getWriter();
            out.println("access refusé");
            out.close();
        }
    }
}