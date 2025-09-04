package controller.polinomios;

import java.util.Objects;

public class PreparedPolynomial {
    private final String input;
    private final int[] polynomial;
    private final int degree;

    public PreparedPolynomial(String input) {
        this.input = input.replace("-", "+-");
        this.degree = _getDegree();
        this.polynomial = new int[this.degree + 1];

        this.preparePolynomial();
    }

    private void preparePolynomial() {
        boolean hasVariable;
        int coef, exp;
        String[] term, terms;
        String cleanInput = input;

        if(cleanInput.charAt(0) == '+') cleanInput = cleanInput.substring(1);

        terms = cleanInput.split("[+]");

        for (String s : terms) {
            hasVariable = s.contains("x");
            term = s.split("\\^");

            if (Objects.equals(term[0], "-x") || Objects.equals(term[0], "x"))
                coef = Integer.parseInt(term[0].replace("x", "1"));
            else
                coef = Integer.parseInt(term[0].replace("x", ""));

            if(term.length == 2)
                exp = Integer.parseInt(term[1]);
            else if(hasVariable)
                exp = 1;
            else
                exp = 0;

            polynomial[exp] += coef;
        }
    }

    private int _getDegree() {
        int majorDegree = 0;
        String[] polynomial, term;

        if(!input.contains("^")){
            if(input.contains("x"))
                majorDegree = 1;
        } else {
            polynomial = input.split("\\+");

            for (int i = 0; i < polynomial.length; i++) {
                System.out.println(polynomial[i]);
            }

            for (int i = 0; i < polynomial.length; i++) {
                term = polynomial[i].split("\\^");

                if(term.length == 2 && Integer.parseInt(term[1]) > majorDegree) {
                    majorDegree = Integer.parseInt(term[1]);
                };
            }
        }

        return majorDegree;
    }

    public int getDegree() {
        return degree;
    }


    public int[] getPolynomial() {
        return polynomial;
    }

    public int[] getTerm() {
        return new int[]{polynomial[polynomial.length - 1], this.degree};
    }
}
