import java.io.*;

import jakarta.servlet.http.*;

public class CookieServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Cookie[] cookies = request.getCookies();

        Integer visit_times = 1;

        // trouver le nombre des visits s'il existe
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("visited_times")) {
                    try {
                        visit_times += Integer.parseInt(cookie.getValue());
                    } catch (NumberFormatException e) {

                    }
                    break;
                }
            }
        }

        // mis à jour de nombre des visits

        Cookie c = new Cookie("visited_times", visit_times.toString());
        c.setMaxAge(60 * 60 * 24 * 7);
        c.setPath("/");
        response.addCookie(c);

        response.setContentType("text/html,charset=utf-8");
        PrintWriter out = response.getWriter();

        out.print("<html><head><title>show cookies</title></head><body><table>");
        if (cookies == null) {
            out.print("n'y a pas des cookies");
        } else {
            for (Cookie cookie : cookies) {

                out.print("<tr><td>" + cookie.getName() + "</td><td>" + cookie.getValue() + "</td></tr>");
            }
        }

        out.print("</table></body></html>");
        out.close();

    }

}