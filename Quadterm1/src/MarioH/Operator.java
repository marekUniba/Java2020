package MarioH;

public class Operator  extends Vyraz {

    private char op;
    private Vyraz left;
    private Vyraz right;

    public Operator(char op, Vyraz left, Vyraz right) {
        this.op = op;
        this.left = left;
        this.right = right;
    }   // dodefinuj

    @Override
    Integer eval() {        // dodefinuj
        if(left.eval() == null || right.eval() == null) return null;
        switch (op) {
            case '+':
                return left.eval() + right.eval();
            case '-':
                return left.eval() - right.eval();
            case '*':
                return left.eval() * right.eval();
            case '/':
                if(right.eval() == 0) return null;
                return left.eval() / right.eval();
        }
        return null;

    }

    @Override
    public String brackets(boolean bracket) {
        String result;

        if(op == '-' && right instanceof Operator) result = left.brackets(false) + "" + op + "" + right.brackets(true);
        else result = left.brackets(false) + "" + op + "" + right.brackets(false);

        if(bracket) return "(" + result + ")";
        return result;
    }

    @Override
    public String toString() {
        String result;

        if(op == '-' && right instanceof Operator) result = left.brackets(false) + "" + op + "" + right.brackets(true);
        else if(op == '/' && right instanceof Operator) result = left.brackets(true) + "" + op + "" + right.brackets(true);
        else result = left.brackets(false) + "" + op + "" + right.brackets(false);

        return result;
    }
}
