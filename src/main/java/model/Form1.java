package model;

public class Form1 extends Polynomial<Form1, int[]> {
    public Form1(int degree, int[] preparedPolynomial) {
        super(degree, preparedPolynomial);
        super.DU = super.degree + 1;
        super.form = "form1";
    }

    protected Form1(int DU, int degree, int[] structure) {
        super(DU, degree, structure);
        super.form = "form1";
    }

    @Override
    protected void generateForm(int[] preparedPolynomial) {
        structure = new int[super.DU + 1];
        structure[0] = super.degree;

        for (int i = 1; i <= super.DU; i++) {
            structure[i] = preparedPolynomial[super.DU - i];
        }
    }

    @Override
    protected void adjust() {
        if (structure[1] == 0) {
            int counter = 0;

            for (int i = 1; i <= super.DU; i++) {
                if (structure[i] != 0) {
                    break;
                }
                counter++;
            }

            for (int i = counter; i <= super.DU; i++) {
                structure[i - counter] = structure[i];
            }

            super.DU = super.DU - counter;
            structure[0] = super.DU - 1;
            super.degree = structure[0];
        }
    }

    @Override
    protected void resize() {
        int[] newVector;

        if (super.DU + 1 != structure.length) {
            newVector = new int[super.DU + 1];

            System.arraycopy(structure, 0, newVector, 0, newVector.length);

            structure = newVector;
        }
    }

    @Override
    public void insertTerm(int coef, int exp) {
        int newDU, degree;
        int[] newVector;

        if (structure[0] >= exp) {
            structure[super.DU - exp] += coef;
        } else {
            newDU = exp + 1;
            newVector = new int[newDU + 1];

            newVector[0] = exp;
            newVector[1] = coef;

            for (int i = 1; i <= super.DU; i++) {
                degree = super.DU - i;

                newVector[newDU - degree] = structure[i];
            }

            structure = newVector;
        }

        adjust();
        resize();
    }

    @Override
    public void deleteTerm(int degree) {
        if (degree > this.degree || degree < 0) {
            throw new IllegalArgumentException("Invalid degree");
        } else {
            structure[super.DU - degree] = 0;

            adjust();
            resize();
        }
    }

    @Override
    public String showForm() {
        StringBuilder form = new StringBuilder("Grado: " + structure[0] + "<br><ul class=\"list-group list-group-horizontal justify-content-center\">");

        for (int i = 1; i <= super.DU; i++) {
            form.append("<li style=\"max-width:200px !important;\" class=\"list-group-item\">").append("Coeficiente: ").append(structure[i]).append(", Exponente: ").append(DU - i).append("</li>");

            if(i % 6 == 0){
                form.append("</ul><ul class=\"list-group list-group-horizontal justify-content-center\">");
            }
        }

        return form.append("</ul>").toString();
    }

    @Override
    public String showPolynomial() {
        StringBuilder polynomial = new StringBuilder();
        String exp, concat, variable = "x";

        for (int i = 1; i <= super.DU; i++) {
            if (structure[i] != 0) {
                exp = (DU - i) + "";

                if (i == 1)
                    concat = "";
                else
                    concat = " + ";

                if (exp.equals("0")) {
                    variable = "";
                }

                if (exp.equals("1") || exp.equals("0"))
                    exp = "";
                else
                    exp = "^" + exp;

                polynomial.append(concat).append(" ").append(structure[i]).append(variable).append(exp).append(" ");
            }
        }

        return polynomial.toString();
    }

    @Override
    public int eval(int x) {
        int coef, exp;
        int res = 0;

        for (int i = 1; i <= super.DU; i++) {
            coef = structure[i];
            exp = super.DU - i;
            res = (int) (res + coef * Math.pow(x, exp));
        }

        return res;
    }

    @Override
    public Form1 addPolynomial(Form1 polynomialB) {
        int[] vectorA, vectorB;
        int expB, DUA, DUB;
        Form1[] order = orderOperations(polynomialB);

        vectorA = order[0].getStructure();
        vectorB = order[1].getStructure();
        DUA = order[0].getDU();
        DUB = order[1].getDU();

        for (int i = 1; i <= DUB; i++) {
            expB = DUB - i;
            vectorA[DUA - expB] = vectorA[DUA - expB] + vectorB[i];
        }

        return new Form1(DUA, vectorA[0], vectorA);
    }

    @Override
    public Form1 multiplyPolynomial(Form1 polynomialB) {
        int[][] matriz;
        int[] vectorA, vectorB, vectorC;
        int DUA, DUB, DUC, expA, expB, degC;
        Form1[] order = orderOperations(polynomialB);
        Form1 acumForm, auxForm;

        vectorA = order[0].getStructure();
        vectorB = order[1].getStructure();

        DUA = order[0].getDU();
        DUB = order[1].getDU();

        matriz = new int[DUB][];

        for (int i = 1; i <= DUB; i++) {
            expB = DUB - i;
            degC = (DUB - i) + (DUA - 1);
            DUC = degC + 1;
            vectorC = new int[DUC + 1];
            vectorC[0] = degC;

            for (int j = 1; j <= DUA; j++) {
                expA = DUA - j;
                vectorC[DUC - (expA + expB)] = vectorA[j] * vectorB[i];
            }

            matriz[i - 1] = vectorC.clone();
        }

        acumForm = new Form1(matriz[0][0] + 1, matriz[0][0], matriz[0]);
        for (int i = 1; i < matriz.length; i++) {
            auxForm = new Form1(matriz[i][0] + 1, matriz[i][0], matriz[i]);
            acumForm = acumForm.addPolynomial(auxForm);
        }

        return acumForm;
    }

    @Override
    public int[] getStructure() {
        return structure.clone();
    }

    protected Form1[] orderOperations(Form1 polynomialB) {
        Form1 primary, secondary;

        if (getDegree() > polynomialB.getDegree()) {
            primary = this;
            secondary = polynomialB;
        } else {
            primary = polynomialB;
            secondary = this;
        }

        return new Form1[]{primary, secondary};
    }
}
