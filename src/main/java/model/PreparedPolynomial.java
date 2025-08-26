package model;

import java.util.Objects;

public class PreparedPolynomial {
    private final String input;
    private final int[] polynomial;
    private final int degree;

    public PreparedPolynomial(String input) {
        this.input = input;
        this.degree = _getDegree();
        this.polynomial = new int[this.degree + 1];

        this.preparePolynomial();
    }

    private void preparePolynomial() {
        boolean hasVariable;
        int coef, exp;
        String[] term, terms;
        String cleanInput = input.replace("-", "+-");

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

            polynomial[exp] = polynomial[exp] + coef;
        }
    }

    private int _getDegree() {
        int majorDegree = 0;
        int exp;

        if(!input.contains("^")){
            if(input.contains("x"))
                majorDegree = 1;
        } else {
            for (int i = 0; i < input.length(); i++) {
                if(input.charAt(i) == '^'){
                    exp = Character.getNumericValue(input.charAt(i + 1));
                    if(exp > majorDegree){
                        majorDegree = exp;
                    }
                }
            }
        }

        return majorDegree;
    }

    public int getDegree() {
        return degree;
    }

    public String getInput() {
        return input;
    }

    public int[] getPolynomial() {
        return polynomial;
    }

    public int[] getTerm() {
        return new int[]{polynomial[polynomial.length - 1], this.degree};
    }
}
