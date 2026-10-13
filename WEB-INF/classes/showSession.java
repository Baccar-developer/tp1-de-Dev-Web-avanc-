import java.io.*;

import jakarta.servlet.http.*;

public class showSession extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession(false);
        response.setContentType("text/html, charset=utf-8");
        PrintWriter out = response.getWriter();
        if (session == null) {
            request.getSession();
            session = request.getSession(false);
            out.print("Welcome on my site");
            session.setAttribute("visit_times", 1);
        } else {
            out.println("<p>Welcome back<p>");
            Integer visit_times = (Integer) session.getAttribute("visit_times") + 1;
            out.println("<p>visit times:" + visit_times.toString() + "</p>");

            session.setAttribute("visit_times", visit_times);
        }

        session.setMaxInactiveInterval(30 * 60);
        out.close();
    }
}
