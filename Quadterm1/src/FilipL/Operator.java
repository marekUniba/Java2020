package FilipL;

public class Operator  extends Vyraz {
    char operator;
    Vyraz l;
    Vyraz r;

    public Operator(char op, Vyraz left, Vyraz right) {
        operator = op;
        l = left;
        r = right;
    }   // dodefinuj

    @Override
    Integer eval() {        // dodefinuj
        if (operator == '+') {
            if (l != null && r != null && l.eval() != null && r.eval() != null) {
                return l.eval() + r.eval();
            }
        }
        if (operator == '-') {
            if (l != null && r != null  && l.eval() != null && r.eval() != null) {
                return l.eval() - r.eval();
            }
        }
        if (operator == '/') {
            if (l != null && r != null) {
                if (r.eval() == null || r.eval() == 0) return null;
                return l.eval() / r.eval();
            }
        }
        if (operator == '*') {
            if (l != null && r != null && l.eval() != null && r.eval() != null) {
                return l.eval() * r.eval();
            }
        }
        return null;
    }

    @Override
    public String toString() {
        if (operator == '*' || operator == '/') { //ospravedlnujem sa tomu co toto cita :(
            return (l instanceof Operator ? (lessEqual(((Operator) l).operator, operator) ? l.toString() : "(" + l.toString() + ")") : l.toString()) + operator + (r instanceof Operator ? (lessEqual(((Operator) r).operator, operator) ? r.toString() : "(" + r.toString() + ")") : r.toString());
        } else {
            return l.toString() + operator + r.toString();
        }
    }
}
