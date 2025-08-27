package view;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Polynomial;

import java.io.IOException;

@WebServlet(name = "eval", value = "/eval")
public class EvalPolynomial extends HttpServlet {
    public void init() {}

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        ServletContext context = request.getServletContext();
        String value = request.getParameter("value");

        Polynomial form = (Polynomial) context.getAttribute("Form");

        String evaluation = form.showPolynomial().replace("x", "(" + Integer.parseInt(value) + ")") +
                " = " +
                form.eval(Integer.parseInt(value));

        context.setAttribute("evaluation", evaluation);

        response.sendRedirect("evaluated-polynomial.jsp");
    }
}
