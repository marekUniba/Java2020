package MatejK;

public class Operator  extends Vyraz {
    char op;
    Vyraz left,right;

    public Operator(char op, Vyraz left, Vyraz right) {
        this.op = op;
        this.left = left;
        this.right = right;
    }   // dodefinuj

    @Override
    Integer eval() {        // dodefinuj
        if(left == null || right == null || left.eval() == null || right.eval() == null){
            return null;
        }
        if(op == '+'){
            return left.eval() + right.eval();
        }
        if(op == '-'){
            return left.eval() - right.eval();
        }
        if(op == '*'){
            return left.eval() * right.eval();
        }
        if(op == '/'){
            if(right.eval() == 0){
                return null;
            }
            return left.eval() / right.eval();
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(left.toString());
        res.append(op);
        res.append(right.toString());
        return res.toString();
    }
}
