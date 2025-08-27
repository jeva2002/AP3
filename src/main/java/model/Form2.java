package model;

public class Form2  extends Polynomial<Form2, int[]> {
    public Form2(int degree, int[] preparedPolynomial) {
        super(degree, preparedPolynomial);
        super.DU = degree * 2;
        super.form = "form2";
    }

    protected Form2(int DU, int degree, int[] structure) {
        super(DU, degree, structure);
        super.form = "form2";
    }

    @Override
    protected void generateForm(int[] preparedPolynomial) {
        int k = 2;
        structure = new int[DU + 1];
        structure[0] = DU;

        for (int i = preparedPolynomial.length - 1; i >= 0; i--) {
            structure[k - 1] = i + 1;
            structure[k - 1] = preparedPolynomial[i];
            k += 2;
        }
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
