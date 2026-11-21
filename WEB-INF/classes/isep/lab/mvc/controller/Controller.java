package isep.lab.mvc.controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import isep.lab.mvc.model.Person;

public class Controller extends HttpServlet {

    private static final int CUTOFF_YEAR = 1990;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String date_naiss = request.getParameter("date_naiss");
        String sex = request.getParameter("sex");

        Person person = new Person(nom, prenom, date_naiss, sex);

        request.setAttribute("person", person);

        int year = person.getBirthYear();
        String view;
        if (year > 0 && year < CUTOFF_YEAR) {
            view = "/old.jsp";
        } else {
            view = "/young.jsp";
        }

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(view);

        if (dispatcher != null) {
            dispatcher.include(request, response);
        } else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND,
                    "View not found: " + view);
        }
    }

}