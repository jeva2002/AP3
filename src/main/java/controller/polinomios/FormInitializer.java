package controller.polinomios;

import model.polinomios.Form1;
import model.polinomios.Form2;
import model.polinomios.Form3.Form3;
import model.polinomios.Polynomial;

public class FormInitializer {
    String form;
    String polynomial;

    public FormInitializer(String form, String polynomial) {
        this.form = form;
        this.polynomial = polynomial;
    }

    public Polynomial initForm() {
        Polynomial result = null;
        PreparedPolynomial prepol = new PreparedPolynomial(this.polynomial);

        result = switch (this.form) {
            case "form1" -> new Form1(prepol.getDegree(), prepol.getPolynomial());
            case "form2" -> new Form2(prepol.getDegree(), prepol.getPolynomial());
            case "form3" -> new Form3(prepol.getDegree(), prepol.getPolynomial());
            default -> result;
        };

        return result;
    }
}
