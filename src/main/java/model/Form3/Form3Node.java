package model.Form3;

public class Form3Node {
    private int coef, exp;
    private Form3Node next;

    public Form3Node(int coef, int exp) {
        this.coef = coef;
        this.exp = exp;
        this.next = null;
    }

    public Form3Node getCopy() {
        return new Form3Node(coef, exp);
    }

    public int getCoef() {
        return coef;
    }

    public int getExp() {
        return exp;
    }

    public Form3Node getNext() {
        return next;
    }

    public void setCoef(int coef) {
        this.coef = coef;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public void setNext(Form3Node next) {
        this.next = next;
    }
}

