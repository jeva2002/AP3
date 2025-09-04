package view.polynomial;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.polynomial.Polynomial;

import java.io.IOException;

@WebServlet(name = "delete-term", value = "/delete-term")
public class DeleteTerm extends HttpServlet {
    public void init() {
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        ServletContext context = request.getServletContext();
        int degree = Integer.parseInt(request.getParameter("degree"));

        Polynomial form = (Polynomial) context.getAttribute("Form");

        form.deleteTerm(degree);

        response.sendRedirect("describe-polynomial.jsp");
    }
}
