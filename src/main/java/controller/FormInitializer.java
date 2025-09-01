package controller;

import model.Form1;
import model.Form2;
import model.Form3.Form3;
import model.Polynomial;
import model.PreparedPolynomial;

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

        System.out.println(form);
        for (int i = 0; i < prepol.getPolynomial().length; i++) {
            System.out.println(prepol.getPolynomial()[i]);
        }

        result = switch (this.form) {
            case "form1" -> new Form1(prepol.getDegree(), prepol.getPolynomial());
            case "form2" -> new Form2(prepol.getDegree(), prepol.getPolynomial());
            case "form3" -> new Form3(prepol.getDegree(), prepol.getPolynomial());
            default -> result;
        };

        return result;
    }
}
