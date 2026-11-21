
import java.io.*;

import jakarta.servlet.http.*;
import listeners.*;

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws IOException {
        String user = req.getParameter("username");
        HttpSession session = req.getSession(true);

        session.setAttribute("user", user);

        res.setContentType("text/html");
        res.getWriter().println("Welcome " + user +
                "! <a href='items.html'>Go to items</a>");
    }
}