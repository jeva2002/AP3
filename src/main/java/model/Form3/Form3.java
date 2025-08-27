package model.Form3;

import model.Polynomial;

public class Form3 extends Polynomial<Form3, Form3Node> {
    public Form3(int degree, int[] preparedPolynomial) {
        super(degree, preparedPolynomial);
    }

    protected Form3(int DU, int degree, Form3Node structure) {
        super(DU, degree, structure);
    }

    @Override
    protected void generateForm(int[] preparedPolynomial) {

    }

    @Override
    protected void adjust() {

    }

    @Override
    protected void resize() {

    }

    @Override
    public void insertTerm(int coef, int exp) {

    }

    @Override
    public void deleteTerm(int degree) {

    }

    @Override
    public String showForm() {
        return "";
    }

    @Override
    public String showPolynomial() {
        return "";
    }

    @Override
    public int eval(int x) {
        return 0;
    }

    @Override
    public Form3 addPolynomial(Form3 polynomialB) {
        return null;
    }

    @Override
    public Form3 multiplyPolynomial(Form3 polynomialB) {
        return null;
    }

    @Override
    protected Form3[] orderOperations(Form3 polynomialB) {
        return new Form3[0];
    }

    @Override
    public Form3Node getStructure() {
        return null;
    }
}
