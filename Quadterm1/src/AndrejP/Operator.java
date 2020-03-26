package AndrejP;

public class Operator  extends Vyraz {
    char operator;
    Vyraz l,p;
    public Operator(char op, Vyraz left, Vyraz right){
        operator = op;
        l = left;
        p = right;
    }

    @Override
    Integer eval() {
        if(l.eval() == null || p.eval() == null){
            return null;
        }

        if(operator == '+'){
            return l.eval() + p.eval();
        }
        if(operator == '-'){
            return l.eval() - p.eval();
        }
        if(operator == '*'){
            return l.eval() * p.eval();
        }
        if(p.eval() == 0){
            return null;
        }
        return l.eval() / p.eval();
    }

    public String toString(){
        /*if(operator == '+' || operator == '-'){
            return "("+l.toString() +operator+ p.toString()+")";
        }*/
        return l.toString() +operator+ p.toString();
    }
}
