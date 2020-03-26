package FilipS;

public class Operator  extends Vyraz {

    char op;
    Vyraz lavy;
    Vyraz pravy;

    public Operator(char op, Vyraz left, Vyraz right) {
        this.op = op;
        lavy =left;
        pravy = right;
    }

    @Override
    Integer eval() {        // dodefinuj
        if(lavy == null || pravy == null){
            return null;
        }
        if(lavy.eval() == null || pravy.eval() == null){
            return null;
        }
       if(op == '+'){
           return lavy.eval() + pravy.eval();
       }
       if(op == '-'){
           return lavy.eval() - pravy.eval();
       }
       if(op == '*'){
           return lavy.eval() * pravy.eval();
       }
       else{
           if(pravy.eval() == 0){
               return null;
           }
           return lavy.eval() / pravy.eval();
       }
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        if(lavy == null || pravy == null){
            return null;
        }
        if(lavy.toString() == null || pravy.toString() == null){
            return null;
        }

        sb.append(lavy.toString());
        sb.append(op);
        sb.append(pravy.toString());

        return sb.toString();

    }
}
