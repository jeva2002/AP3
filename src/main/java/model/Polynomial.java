package model;

public abstract class Polynomial<Form, Entry> {
    protected int degree;
    protected int DU;
    protected Entry structure;
    protected String form;

    public Polynomial(int degree, int[] preparedPolynomial) {
        this.DU = degree + 1;
        this.degree = degree;

        generateForm(preparedPolynomial);
        adjust();
        resize();
    }

    protected Polynomial(int DU, int degree, Entry structure) {
        this.DU = DU;
        this.degree = degree;
        this.structure = structure;

        adjust();
        resize();
    }

    protected abstract void generateForm(int[] preparedPolynomial);

    protected abstract void adjust();

    protected abstract void resize();

    public abstract void insertTerm(int coef, int exp);

    public abstract void deleteTerm(int degree);

    public abstract String showForm();

    public abstract String showPolynomial();

    public abstract int eval(int x);

    public abstract Form addPolynomial(Form polynomialB);

    public abstract Form multiplyPolynomial(Form polynomialB);

    protected abstract Form[] orderOperations(Form polynomialB);

    public abstract Entry getStructure();

    public int getDU() {
        return DU;
    }

    public int getDegree() {
        return degree;
    }

    public String getFormName() {
        return form;
    }
}
