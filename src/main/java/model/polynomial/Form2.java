package model.polynomial;

public class Form2 extends Polynomial<Form2, int[]> {
    public Form2(int degree, int[] preparedPolynomial) {
        super(degree, preparedPolynomial);
        this.form = "form2";
    }

    protected Form2(int DU, int degree, int[] structure) {
        super(DU, degree, structure);
        this.form = "form2";
    }

    @Override
    protected void generateForm(int[] preparedPolynomial) {
        int count = 0, k = 2;

        for (int i = 0; i < preparedPolynomial.length; i++) {
            if (preparedPolynomial[i] != 0)
                count += 1;
        }

        super.DU = count * 2;
        structure = new int[DU + 1];
        structure[0] = count * 2;

        for (int i = preparedPolynomial.length - 1; i >= 0; i--) {
            if (preparedPolynomial[i] != 0) {
                structure[k] = i;
                structure[k - 1] = preparedPolynomial[i];
                k += 2;
            }
        }
    }

    @Override
    protected void adjust() {
        int count = 0, k = 2;

        for (int i = 2; i <= super.DU; i += 2) {
            if (structure[i - 1] == 0) {
                count += 1;
            } else {
                structure[k - 1] = structure[i - 1];
                structure[k] = structure[i];
                k += 2;
            }
        }

        while (k <= structure.length) {
            structure[k - 1] = 0;
            structure[k] = 0;
            k += 2;
        }

        super.degree = structure[2];
        super.DU = super.DU - count * 2;
        super.structure[0] = super.DU;
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
        int[] newPolynomial;
        boolean hasTerm = false, addedTerm = false;
        int newDU, k = 2, j = 2;

        for (int i = 2; i <= super.DU; i += 2) {
            if (exp == super.structure[i]) {
                super.structure[i - 1] += coef;
                hasTerm = true;
                break;
            }
        }

        if (!hasTerm) {
            newDU = super.DU + 2;
            newPolynomial = new int[newDU + 1];

            while (j <= super.DU) {
                if (!addedTerm && exp > super.structure[j]) {
                    newPolynomial[k] = exp;
                    newPolynomial[k - 1] = coef;
                    k += 2;
                    addedTerm = true;
                }

                newPolynomial[k] = super.structure[j];
                newPolynomial[k - 1] = super.structure[j - 1];
                j += 2;
                k += 2;
            }

            if (!addedTerm) {
                newPolynomial[k] = exp;
                newPolynomial[k - 1] = coef;
            }

            newPolynomial[0] = structure[0] + 1;
            super.DU = newDU;
            structure = newPolynomial;
        }

        adjust();
        resize();
    }

    @Override
    public void deleteTerm(int degree) {
        for (int i = 2; i <= super.DU; i = i + 2) {
            if (structure[i] == degree) {
                structure[i - 1] = 0;
            }
        }

        adjust();
        resize();
    }

    @Override
    public String showForm() {
        StringBuilder form = new StringBuilder(" 2 <br/> <b>DU:</b> " + this.DU + " <br/> <b>Número de Términos:</b> " + structure[0] / 2 + "<br/><ul class=\"list-group list-group-horizontal justify-content-center mb-2\">");

        for (int i = 2; i <= super.DU; i += 2) {
            form.append("<li style=\"width:200px !important;\" class=\"list-group-item\">").append("<b>Posición:</b> ").append(i - 1).append("-").append(i).append("</li>");
            form.append("<li style=\"width:200px !important;\" class=\"list-group-item\">").append("<b>Coeficiente:</b> ").append(structure[i - 1]).append("</li>");
            form.append("<li style=\"width:200px !important;\" class=\"list-group-item\">").append("<b>Exponente:</b> ").append(structure[i]).append("</li>");

            form.append("</ul><ul class=\"list-group list-group-horizontal justify-content-center mb-2\">");
        }

        return form.append("</ul>").toString();
    }

    @Override
    public String showPolynomial() {
        StringBuilder polynomial = new StringBuilder();

        for (int i = 2; i <= super.DU; i += 2) {
            polynomial.append(structure[i - 1]);

            if (super.structure[i] > 0)
                polynomial.append("x");
            if (super.structure[i] > 1)
                polynomial.append("^").append(super.structure[i]);

            if (i != super.DU)
                polynomial.append(" + ");
        }

        return polynomial.toString();
    }

    @Override
    public int eval(int x) {
        int result = 0;

        for (int i = 2; i <= super.DU; i = i + 2) {
            result += (int) (super.structure[i - 1] * Math.pow(x, super.structure[i]));
        }

        return result;
    }

    @Override
    public Form2 addPolynomial(Form2 polynomialB) {
        int i = 2, j = 2, k = 2;
        int DUC = super.structure[0] + polynomialB.structure[0];
        int[] vectorA, vectorB, vectorC = new int[DUC + 1];

        vectorC[0] = super.structure[0] + polynomialB.structure[0];
        Form2[] order = orderOperations(polynomialB);

        vectorA = order[0].structure;
        vectorB = order[1].structure;

        while (j <= order[1].DU && i <= order[0].DU) {
            if (vectorA[i] < vectorB[j]) {
                vectorC[k] = vectorB[j];
                vectorC[k - 1] = vectorB[j - 1];
                j += 2;
            } else if (vectorA[i] > vectorB[j]) {
                vectorC[k] = vectorA[i];
                vectorC[k - 1] = vectorA[i - 1];
                i += 2;
            } else {
                vectorC[k] = vectorA[i];
                vectorC[k - 1] = vectorA[i - 1] + vectorB[j - 1];
                i += 2;
                j += 2;

                if (vectorC[k - 1] == 0){
                    DUC -= 2;
                }
            }
            k += 2;
        }

        if(i > order[0].DU) {
            while (j <= order[1].DU) {
                vectorC[k] = vectorB[j];
                vectorC[k - 1] = vectorB[j - 1];
                j += 2;
                k += 2;
            }
        } else {
            while (i <= order[0].DU) {
                vectorC[k] = vectorA[i];
                vectorC[k - 1] = vectorA[i - 1];
                i += 2;
                k += 2;
            }
        }

        return new Form2(DUC, vectorA[3], vectorC);
    }

    @Override
    public Form2 multiplyPolynomial(Form2 polynomialB) {
        int[][] matrix;
        int[] vectorA, vectorB, vectorC;
        int m = 0;
        Form2[] order = orderOperations(polynomialB);
        Form2 acumForm, auxForm;

        vectorA = order[0].structure;
        vectorB = order[1].structure;

        matrix = new int[order[1].DU / 2][];

        for (int i = 2; i <= order[1].DU; i += 2) {
            vectorC = new int[order[0].DU + 1];
            vectorC[0] = vectorA[0];

            for (int j = 2; j <= order[0].DU; j += 2) {
                vectorC[j - 1] = vectorA[j - 1] * vectorB[i - 1];
                vectorC[j] = vectorA[j] + vectorB[i];
            }

            matrix[m] = vectorC;
            m++;
        }

        acumForm = new Form2(matrix[0][0], matrix[0][2], matrix[0]);
        for (int i = 1; i < matrix.length; i++) {
            auxForm = new Form2(matrix[i][0], matrix[i][2], matrix[i]);
            acumForm = acumForm.addPolynomial(auxForm);
        }

        return acumForm;
    }

    @Override
    protected Form2[] orderOperations(Form2 polynomialB) {
        Form2 primary, secondary;

        if (super.DU > polynomialB.DU) {
            primary = this;
            secondary = polynomialB;
        } else {
            primary = polynomialB;
            secondary = this;
        }

        return new Form2[]{primary, secondary};
    }

    @Override
    public int[] getStructure() {
        return structure;
    }
}