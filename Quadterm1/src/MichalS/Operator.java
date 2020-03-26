package MichalS;

public class Operator  extends Vyraz {
    public Vyraz pravy;
    public Vyraz lavy;
    public char operacia;

    public Operator(char op, Vyraz left, Vyraz right) {
        operacia = op;
        pravy = right;
        lavy = left;
    }

    @Override
    Integer eval() {
        Integer pr = pravy.eval();
        Integer la = lavy.eval();

        if (pr == null || la == null) {
            return null;
        }

        switch (operacia) {
            case '+':
                return la + pr;
            case '-':
                return la - pr;
            case '*':
                return la * pr;
            case '/':
                if (pr == 0) {
                    return null;
                }
                return la / pr;
            default:
                return null;
        }
    }

    @Override
    public String toString() {
        String pr, la;
        if (pravy instanceof Konstanta) {
            pr = pravy.toString();
        }
        else {
            Operator p = (Operator) pravy;
            switch (operacia) {
                case '+':
                    pr = p.toString();
                    break;
                case '-':
                    if (p.operacia == '-') {
                        pr = p.toString();
                    }
                    else {
                        pr = "(" + p.toString() + ")";
                    }
                    break;
                case '*':
                case '/':
                    if (p.operacia != '*') {
                        pr = "(" + p.toString() + ")";
                    }
                    else {
                        pr = p.toString();
                    }
                    break;
                default:
                    return null;
            }
        }
        if (lavy instanceof Konstanta) {
            la = lavy.toString();
        }
        else {
            Operator p = (Operator) lavy;
            switch (operacia) {
                case '+':
                    la = p.toString();
                    break;
                case '-':
                    if (p.operacia == '-') {
                        la = p.toString();
                    }
                    else {
                        la = "(" + p.toString() + ")";
                    }
                    break;
                case '*':
                case '/':
                    if (p.operacia != '*' && p.operacia != '/') {
                        la = "(" + p.toString() + ")";
                    }
                    else {
                        la = p.toString();
                    }
                    break;
                default:
                    return null;
            }
        }
        return la + operacia + pr;
    }
}
