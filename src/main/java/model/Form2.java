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
        int position = 0;
        int[] newPolynomial;

        for (int i = 2; i <= super.DU; i = i + 2) {
            if(structure[i] == exp){
                position = i;
                structure[i - 1] += coef;
            }
        }

        if(position != 0){
            super.DU = super.DU + 3;
            newPolynomial = new int[super.DU];

            for(int i = 2; i <= super.DU; i += 2){
                if(structure[i] == exp){
                    newPolynomial[i - 1] = coef;
                    newPolynomial[i] = exp;

                    i += 2;
                }

                newPolynomial[i - 1] = structure[i - 1];
                newPolynomial[i] = structure[i];
            }

            structure = newPolynomial;
        }

        adjust();
        resize();
    }

    @Override
    public void deleteTerm(int degree) {
        for (int i = 2; i <= super.DU; i = i + 2) {
            if(structure[i] == degree){
                structure[i - 1] = 0;
            }
        }

        adjust();
        resize();
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
        int result = 0;

        for (int i = 2; i <= super.DU; i = i + 2) {
            result += (int) (super.structure[i - 1] * Math.pow(x, super.structure[i]));
        }

        return result;
    }

    @Override
    public Form2 addPolynomial(Form2 polynomialB) {
        int majorDegree, i = 2, j = 2, k = 2;
        int DUC = (super.structure[0] + polynomialB.structure[0]) * 2;
        int[] vectorA, vectorB, vectorC = new int[DUC + 1];

        vectorC[0] = super.structure[0] + polynomialB.structure[0];
        Form2[] order = orderOperations(polynomialB);

        vectorA = order[0].structure;
        vectorB = order[1].structure;

        while(j <= order[1].DU){
            if(vectorA[i] > vectorB[j]){
                vectorC[k] = vectorA[i];
                vectorC[k - 1] = vectorA[i - 1];
                i += 2;
            } else if(vectorA[i] < vectorB[j]){
                vectorC[k] = vectorB[j];
                vectorC[k - 1] = vectorB[j - 1];
                j += 2;
            } else {
                vectorC[k] = vectorA[i];
                vectorC[k] = vectorA[i - 1] + vectorB[j - 1];
                i += 2;
                j += 2;
            }

            k += 2;
        }

        while (i <= order[0].DU){
            vectorC[k] = vectorA[i];
            vectorC[k - 1] = vectorA[i - 1];
            i += 2;
        }

        return new Form2(DUC, vectorA[3], vectorC);
    }

    @Override
    public Form2 multiplyPolynomial(Form2 polynomialB) {
        return null;
    }

    @Override
    protected Form2[] orderOperations(Form2 polynomialB) {
        Form2 primary, secondary;
        Form2[] order;

        if (super.structure[super.structure.length - 1] > polynomialB.structure[polynomialB.structure.length - 1]) {
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
