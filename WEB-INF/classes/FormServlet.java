import java.io.*;

import jakarta.servlet.http.*;

public class FormServlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String date = request.getParameter("date_naissance");
        String sex = request.getParameter("sex");

        addCookie(response, "nom", nom);
        addCookie(response, "prenom", prenom);
        addCookie(response, "date_naissance", date);
        addCookie(response, "sex", sex);

        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();

        out.print("<html><head><meta charset=\"utf-8\"><title>afficher</title></head><body><table>");
        out.print("<tr><td>nom</td><td>" + nom + "</td></td>");
        out.print("<tr><td>prénom</td><td>" + prenom + "</td></td>");
        out.print("<tr><td>date naissance</td><td>" + date + "</td></td>");
        out.print("<tr><td>sex</td><td>" + sex + "</td></td>");
        out.print("</table></body></html>");

        out.close();

    }

    private void addCookie(HttpServletResponse response, String attribut, String value) {
        Cookie cookie = new Cookie(attribut, value);
        cookie.setMaxAge(60 * 60 * 24 * 7);
        cookie.setPath("/");
        response.addCookie(cookie);
    }

}