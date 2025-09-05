package model.polynomial.Form3;

import model.polynomial.Polynomial;

public class Form3 extends Polynomial<Form3, Form3Node> {

    public Form3(int degree, int[] preparedPolynomial) {
        super(degree, preparedPolynomial);
        this.form = "form3";
    }

    protected Form3(int DU, int degree, Form3Node structure) {
        super(DU, degree, structure);
        this.form = "form3";
    }

    @Override
    protected void generateForm(int[] preparedPolynomial) {
        Form3Node newNode = null, auxNode = null;
        this.DU = 0;

        for (int i = 0; i < preparedPolynomial.length; i++) {
            if (preparedPolynomial[i] != 0) {
                newNode = new Form3Node(preparedPolynomial[i], i);
                newNode.setNext(auxNode);
                auxNode = newNode;

                this.DU += 1;
            }
        }

        this.structure = newNode;
        this.degree = newNode.getExp();
    }

    @Override
    protected void adjust() {
        Form3Node auxNode = this.structure;
        int count = 0;

        while (super.structure != null && auxNode.getCoef() == 0) {
            auxNode = auxNode.getNext();
            count++;
        }

        super.structure = auxNode;
        super.DU -= count;
        super.degree = auxNode.getExp();
    }

    @Override
    protected void resize() {
        Form3Node auxNode = this.structure, checkNode = this.structure;
        int count = 0;

        while (auxNode != null) {
            if (auxNode.getCoef() != 0) {
                checkNode = auxNode;
            } else {
                count++;
            }

            auxNode = auxNode.getNext();
            checkNode.setNext(auxNode);
        }

        super.DU -= count;
    }

    @Override
    public void insertTerm(int coef, int exp) {
        Form3Node newNode, auxNode = this.structure;

        if (auxNode == null || auxNode.getExp() < exp) {
            newNode = new Form3Node(coef, exp);
            newNode.setNext(auxNode);

            this.structure = newNode;
            this.DU += 1;
            this.degree = newNode.getExp();
        } else {
            while (auxNode != null) {
                if (auxNode.getExp() == exp) {
                    auxNode.setCoef(auxNode.getCoef() + coef);
                } else if (auxNode.getExp() > exp && (auxNode.getNext() == null || auxNode.getNext().getExp() < exp)) {
                    newNode = new Form3Node(coef, exp);
                    newNode.setNext(auxNode.getNext());
                    auxNode.setNext(newNode);
                    auxNode = auxNode.getNext();

                    this.DU += 1;
                }

                auxNode = auxNode.getNext();
            }

            adjust();
            resize();
        }
    }

    @Override
    public void deleteTerm(int degree) {
        Form3Node auxNode = this.structure;

        while (auxNode != null) {
            if (auxNode.getExp() == degree) {
                auxNode.setCoef(0);

                adjust();
                resize();

                return;
            }

            auxNode = auxNode.getNext();
        }
    }

    @Override
    public String showForm() {
        StringBuilder form = new StringBuilder(" 3 <br> <b>DU (Número de Nodos):</b> " + super.DU + "<br><ul class=\"list-group list-group-horizontal justify-content-center mb-2\">");
        Form3Node auxNode = this.structure;
        int count = 0;

        while (auxNode != null) {
            count++;

            form.append("<li style=\"width:200px !important;\" class=\"list-group-item\">").append("<b>Nodo:</b> ").append(count).append("</li>");
            form.append("<li style=\"width:200px !important;\" class=\"list-group-item\">").append("<b>Coeficiente:</b> ").append(auxNode.getCoef()).append("</li>");
            form.append("<li style=\"width:200px !important;\" class=\"list-group-item\">").append("<b>Exponente:</b> ").append(auxNode.getExp()).append("</li>");

            form.append("</ul>");
            form.append("<ul class=\"list-group list-group-horizontal justify-content-center mb-2\">");

            auxNode = auxNode.getNext();
        }

        return form.append("</ul>").toString();
    }

    @Override
    public String showPolynomial() {
        StringBuilder polynomial = new StringBuilder();
        Form3Node auxNode = this.structure;

        while (auxNode != null) {
            polynomial.append(auxNode.getCoef());

            if (auxNode.getExp() != 0) {
                polynomial.append("x");
            }

            if (auxNode.getExp() > 1) {
                polynomial.append("^").append(auxNode.getExp());
            }

            if (auxNode.getNext() != null) {
                polynomial.append(" + ");
            }

            auxNode = auxNode.getNext();
        }

        return polynomial.toString();
    }

    @Override
    public int eval(int x) {
        Form3Node auxNode = this.structure;
        int result = 0;

        while (auxNode != null) {
            result += (int) (auxNode.getCoef() * Math.pow(x, auxNode.getExp()));

            auxNode = auxNode.getNext();
        }

        return result;
    }

    @Override
    public Form3 addPolynomial(Form3 polynomialB) {
        Form3 A, B;
        Form3Node AuxA, AuxB, AuxC, HeadC;
        int DUC = 1;

        A = orderOperations(polynomialB)[0];
        B = orderOperations(polynomialB)[1];

        AuxA = A.getStructure();
        AuxB = B.getStructure();

        if (A.degree == B.degree) {
            HeadC = new Form3Node(AuxA.getCoef() + AuxB.getCoef(), AuxA.getExp());
            AuxA = AuxA.getNext();
            AuxB = AuxB.getNext();
        } else {
            HeadC = A.getStructure().getCopy();
            AuxA = A.getStructure().getNext();
        }

        AuxC = HeadC;

        while (AuxA != null && AuxB != null) {
            if (AuxA.getExp() > AuxB.getExp()) {
                AuxC.setNext(AuxA.getCopy());
                AuxA = AuxA.getNext();
            } else if (AuxA.getExp() < AuxB.getExp()) {
                AuxC.setNext(AuxB.getCopy());
                AuxB = AuxB.getNext();
            } else {
                AuxC.setNext(new Form3Node(AuxA.getCoef() + AuxB.getCoef(), AuxB.getExp()));

                AuxA = AuxA.getNext();
                AuxB = AuxB.getNext();
            }

            AuxC = AuxC.getNext();
            DUC++;
        }

        if (AuxA == null) {
            while (AuxB != null) {
                AuxC.setNext(AuxB.getCopy());

                AuxB = AuxB.getNext();
                AuxC = AuxC.getNext();
                DUC++;

            }
        } else {
            while (AuxA != null) {
                AuxC.setNext(AuxA.getCopy());

                AuxA = AuxA.getNext();
                AuxC = AuxC.getNext();
                DUC++;
            }
        }

        return new Form3(DUC, HeadC.getExp(), HeadC);
    }

    @Override
    public Form3 multiplyPolynomial(Form3 polynomialB) {
        Form3[] matrix;
        Form3 A, B, acumForm, auxForm;
        Form3Node AuxA, AuxB, AuxC, HeadC;
        int DUC;

        A = orderOperations(polynomialB)[0];
        B = orderOperations(polynomialB)[1];

        AuxA = A.getStructure();

        matrix = new Form3[A.DU];

        for (int i = 0; i < matrix.length; i++) {
            DUC = 1;
            AuxB = B.getStructure();

            HeadC = new Form3Node(AuxA.getCoef() * AuxB.getCoef(), AuxA.getExp() + AuxB.getExp());
            AuxC = HeadC;

            AuxB = AuxB.getNext();

            while (AuxB != null) {
                AuxC.setNext(new Form3Node(AuxA.getCoef() * AuxB.getCoef(), AuxA.getExp() + AuxB.getExp()));

                AuxC = AuxC.getNext();
                AuxB = AuxB.getNext();
                DUC++;
            }

            matrix[i] = new Form3(DUC, HeadC.getExp(), HeadC);
            AuxA = AuxA.getNext();
        }

        acumForm = matrix[0];
        for (int i = 1; i < matrix.length; i++) {
            auxForm = matrix[i];

            acumForm = acumForm.addPolynomial(auxForm);
        }

        return acumForm;
    }

    @Override
    protected Form3[] orderOperations(Form3 polynomialB) {
        Form3 primary, secondary;

        if (super.degree > polynomialB.degree) {
            primary = this;
            secondary = polynomialB;
        } else {
            primary = polynomialB;
            secondary = this;
        }

        return new Form3[]{primary, secondary};
    }

    @Override
    public Form3Node getStructure() {
        return structure;
    }
}
