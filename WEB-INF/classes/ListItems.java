
import java.io.*;
import java.util.ArrayList;
import jakarta.servlet.http.*;

public class ListItems extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        ArrayList<String> items = session.getAttribute("items") != null
                ? (ArrayList<String>) session.getAttribute("items")
                : new ArrayList<String>();

        String new_item = request.getParameter("newItem");
        items.add(new_item);

        session.setAttribute("items", items);
        session.setMaxInactiveInterval(60 * 30);

        response.setContentType("text/html,charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println("<h1>All items</h1><ul>");
        for (String item : items) {
            out.print("<li>" + item + "</li>");
        }
        out.print("</ul>");

        /* afficher la taille ne nouveau element */
        out.println("<p>la taille d'elemnt est" + new_item.length() + "</p>");

        out.close();
    }

}
