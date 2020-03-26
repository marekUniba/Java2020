public class Operator  extends  Vyraz {
    char op;
    Vyraz left, right;

    public Operator(char op, Vyraz left, Vyraz right) {
        this.op = op;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        String res = "";
        if (left!=null) {
            res += (left instanceof Konstanta || lessEqual(op,((Operator)left).op))?
                    left:"("+left+")";
        }
        res += op;
        if (right!=null) {
            if (right instanceof  Konstanta
                ||
                lessEqual(op,((Operator)right).op)
                        &&
                        !(
                                op == '-' && ((Operator)right).op == '-' || ((Operator)right).op == '+'
                                ||
                                op == '/' && ((Operator)right).op == '/' || ((Operator)right).op == '*'
                        )
                )
                res += right;
            else
                res += "("+right+")";
        }
        return res;
    }

    @Override
    Integer eval() {
        Integer l = (left!=null)?left.eval():null;
        Integer r = (right!=null)?right.eval():null;
        if (l == null || r == null) return null;
        switch (op) {
            case '+': return l+r;
            case '-': return l-r;
            case '*': return l*r;
            case '/': return (r==0)?null:l/r;
            case '%': return (r==0)?null:l%r;
            default: return null;
        }
    }
}
