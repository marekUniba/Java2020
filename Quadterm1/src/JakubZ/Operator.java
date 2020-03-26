package JakubZ;

public class Operator  extends Vyraz {
    Vyraz left, right;
    char op;

    public Operator(char _op, Vyraz _left, Vyraz _right) {  // dodefinuj
        left = _left;
        right = _right;
        op = _op;
    }

    @Override
    Integer eval() {        // dodefinuj
        if ( left.eval() == null || right.eval() == null ) {
            return null;
        }
        if ( op == '/' ) {
            if ( right.eval() == 0 ) {
                return null;
            }
            return left.eval() / right.eval();
        } else if ( op == '*' ) {
            return left.eval() * right.eval();
        } else if ( op == '-' ) {
            return left.eval() - right.eval();
        }
        return left.eval() + right.eval();
    }

    @Override
    public String toString() {
        return left + "" + op + "" + right;
//        return (left != null ? left instanceof Konstanta ? left.toString():"(" + left.toString() + ")":null) + op + (right != null ? right instanceof Konstanta ? right.toString():"(" + right.toString() + ")":null);
    }
}
