package view;

import controller.FormInitializer;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "intro", value = "/menu")
public class Menu extends HttpServlet {


    public void init() {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        String polinomio = request.getParameter("polinomio");
        String form = request.getParameter("form");

        FormInitializer initializer = new FormInitializer(form, polinomio);
        session.setAttribute("Form", initializer.initForm());

        response.sendRedirect("describe.jsp");
    }

    public void destroy() {
    }
}