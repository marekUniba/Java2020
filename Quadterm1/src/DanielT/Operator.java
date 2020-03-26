package DanielT;

public class Operator  extends Vyraz {
    char op;
    Vyraz left, right;
    public Operator(char op, Vyraz left, Vyraz right) {
        this.op = op;
        this.left = left;
        this.right = right;
    }

    @Override
    Integer eval() {
        if(left.eval() == null || right.eval() == null){
            return null;
        }
        switch (op){
            case '+' : return left.eval() + right.eval();
            case '-' : return left.eval() - right.eval();
            case '*' : return left.eval() * right.eval();
            case '/' : {
                if(right.eval() == 0) return null;
                return left.eval() / right.eval();
            }
        }
        return 0;
    }
    public String toString(){
        switch (op){
            case '+' : return left.toString() + "+" + right.toString();
            case '-' : {
                if(right.getClass() == this.getClass()){
                    return left.toString() + "-(" + right.toString() + ")";
                }
                return left.toString() + "-" + right.toString();
            }
            case '*' : return left.toString() + "*" + right.toString();
            case '/' : {
                if(right.getClass() == this.getClass() && left.getClass() == this.getClass()){
                    Operator l = (Operator) left;
                    Operator r = (Operator) right;
                    if(l.op == '+' || l.op == '-') {
                        return "(" + left.toString() + ")/(" + right.toString() + ")";
                    }
                    return left.toString() + "/(" + right.toString() + ")";
                }
                if(right.getClass() == this.getClass()){
                    return left.toString() + "/(" + right.toString() + ")";
                }
                if(left.getClass() == this.getClass()){
                    return "(" + left.toString() + ")/" + right.toString();
                }
                return left.toString() + "/" + right.toString();
            }
        }
        return "";
    }
}
