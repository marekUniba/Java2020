package JurajH_team;

public class Operator extends Vyraz {
    private char op;
    private Vyraz left;
    private Vyraz right;

    public Operator(char op, Vyraz left, Vyraz right) {
        this.op = op;
        this.left = left;
        this.right = right;
    }

    @Override
    Integer eval() {
        Integer l = left.eval();
        Integer r = right.eval();
        if (l == null || r == null) {
            return null;
        }
        switch (op) {
            case '+':
                return l + r;
            case '-':
                return l - r;
            case '*':
                return l * r;
            case '/':
                if (r == 0) {
                    return null;
                }
                return l / r;
            default:
                return null;
        }
    }

    @Override
    protected String myToString(char parent, boolean iAmLeft) {
        String l = left.myToString(op, true);
        String r = right.myToString(op, false);

        switch (op) {
            case '+':
                return l + "+" + r;
            case '-':
                return l + "-" + wrapOperator(right, r);
            case '*':
                return wrapPlusMinus(left, l) + "*" + wrapPlusMinus(right, r);
            case '/':
                return wrapPlusMinus(left, l) + "/" + wrapOperator(right, r);
            default:
                return null;
        }
    }

    private String wrapOperator(Vyraz v, String vString) {
        if (v instanceof Operator) {
            return "(" + vString + ")";
        }
        return vString;
    }

    private String wrapPlusMinus(Vyraz v, String vString) {
        if (v instanceof Operator) {
            Operator vOp = (Operator) v;
            if (vOp.op == '+' || vOp.op == '-') {
                return "(" + vString + ")";
            }
            return vString;
        }
        return vString;
    }
}
