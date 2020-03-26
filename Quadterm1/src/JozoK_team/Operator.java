package JozoK_team;

public class Operator  extends Vyraz {
    char op;
    Vyraz left;
    Vyraz right;

    public Operator(char op, Vyraz left, Vyraz right) {
        this.op = op;
        this.left = left;
        this.right = right;
    }

    @Override
    Integer eval() {
        if (this.left.eval() == null || this.right.eval() == null){
            return null;
        }
        switch (op) {
            case '+':
                return this.left.eval() + this.right.eval();
            case '-':
                return this.left.eval() - this.right.eval();
            case '*':
                return this.left.eval() * this.right.eval();
            case '/': {
                if (this.right.eval() != 0) {
                    return this.left.eval() / this.right.eval();
                }
            }
            default:
                return null;
        }
    }

    public String toString(){
        StringBuffer res = new StringBuffer();
        switch(op){
            case '+':
               res.append(this.left.toString());
               res.append(op);
               res.append(this.right.toString());
               return res.toString();
            case '-':
                res.append(this.left.toString());
                res.append(op);
                if (this.right instanceof Operator){
                    res.append("(");
                    res.append(this.right.toString());
                    res.append(")");
                }
                else{
                    res.append(this.right.toString());
                }
                return res.toString();
            case '*':
                if (this.left instanceof Operator){
                    if(this.less(((Operator) this.left).op, this.op)){
                        res.append("(");
                        res.append(this.left.toString());
                        res.append(")");
                    }
                    else{
                        res.append(this.left.toString());
                    }
                }
                else{
                    res.append(this.left.toString());
                }
                res.append(op);
                if (this.right instanceof Operator){
                    res.append("(");
                    res.append(this.right.toString());
                    res.append(")");
                }
                else{
                    res.append(this.right.toString());
                }
                return res.toString();
            case '/':
                if (this.left instanceof Operator){
                    if(this.less(((Operator) this.left).op, this.op)){
                        res.append("(");
                        res.append(this.left.toString());
                        res.append(")");
                    }
                    else{
                        res.append(this.left.toString());
                    }
                }
                else{
                    res.append(this.left.toString());
                }
                res.append(op);
                if (this.right instanceof Operator){
                    res.append("(");
                    res.append(this.right.toString());
                    res.append(")");
                }
                else{
                    res.append(this.right.toString());
                }
                return res.toString();
            default:
                return res.toString();
        }
    }

}
