package view;

import controller.polinomios.FormInitializer;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "initial", value = "/initial")
public class Initial extends HttpServlet {


    public void init() {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String polinomio = request.getParameter("polinomio");
        String form = request.getParameter("form");
        ServletContext context = request.getServletContext();

        FormInitializer initializer = new FormInitializer(form, polinomio);

        context.setAttribute("Entry", polinomio);
        context.setAttribute("Form", initializer.initForm());

        response.sendRedirect("describe.jsp");
    }

    public void destroy() {
    }
}