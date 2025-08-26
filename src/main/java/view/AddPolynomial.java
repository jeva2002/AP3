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

@WebServlet(name = "add-polynomial", value = "/add-polynomial")
public class AddPolynomial extends HttpServlet {
    public void init() {}

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        ServletContext context = request.getServletContext();
        String polynomial = request.getParameter("polinomio");

        Polynomial form = (Polynomial) context.getAttribute("Form");

        FormInitializer initializer = new FormInitializer(form.getFormName(), polynomial);
        Polynomial form2 = initializer.initForm();

        Polynomial form3 = (Polynomial) form.addPolynomial(form2);

        context.setAttribute("Form2", form2);
        context.setAttribute("Form3", form3);

        response.sendRedirect("added-polynomial.jsp");
    }
}
