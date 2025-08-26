package view;

import controller.FormInitializer;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Polynomial;

import java.io.IOException;

@WebServlet(name = "add-term", value = "/add-term")
public class AddTerm extends HttpServlet {
    public void init() {}

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        ServletContext context = request.getServletContext();
        int exp = Integer.parseInt(request.getParameter("exp"));
        int coef = Integer.parseInt(request.getParameter("coef"));

        Polynomial form = (Polynomial) context.getAttribute("Form");

        form.insertTerm(coef, exp);

        response.sendRedirect("describe.jsp");
    }
}
