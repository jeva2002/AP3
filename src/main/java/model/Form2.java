package model;

public class Form2  extends Polynomial<Form2, int[]> {
    public Form2(int degree, int[] preparedPolynomial) {
        super(degree, preparedPolynomial);
    }

    protected Form2(int DU, int degree, int[] structure) {
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
    public Form2 addPolynomial(Form2 polynomialB) {
        return null;
    }

    @Override
    public Form2 multiplyPolynomial(Form2 polynomialB) {
        return null;
    }

    @Override
    protected Form2[] orderOperations(Form2 polynomialB) {
        return new Form2[0];
    }

    @Override
    public int[] getStructure() {
        return new int[0];
    }
}
