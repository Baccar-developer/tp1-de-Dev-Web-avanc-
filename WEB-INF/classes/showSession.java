import java.io.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

public class showSession extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        HttpSession session = request.getSession(false);
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<html><head></head><body>");

        if (session == null) {
            session = request.getSession(true);
            session.setAttribute("visit_times", 1);
            out.print("<p>Welcome on my site</p>");
        } else {
            Integer stored = (Integer) session.getAttribute("visit_times");
            int visit_times = (stored == null) ? 1 : stored + 1;
            session.setAttribute("visit_times", visit_times);
            session.setMaxInactiveInterval(30 * 60);
            out.println("<p>Welcome back</p>");
            out.println("<p>visit times: " + visit_times + "</p>");
        }

        Integer active = (Integer) session.getServletContext().getAttribute("activeSessions");
        out.println("<p>Active sessions: " + (active == null ? 0 : active) + "</p>");

        out.println("</body></html>");
        out.close();
    }
}