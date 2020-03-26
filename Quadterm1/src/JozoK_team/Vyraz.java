package JozoK_team;

abstract class Vyraz {
    abstract Integer eval();

    public static boolean lessEqual(char op1, char op2) {
        if (op1 == '+' || op1 == '-'){
            return true;
        }
        if (op2 == '+' || op2 == '-'){
            return false;
        }
        return true;
    }

    public static boolean less(char op1, char op2){
        if (op1 == '+' || op1 == '-'){
            if (op2 == '/' || op2 == '*'){
                return true;
            }
        }
        return false;
    }

    public abstract String toString();

    public static void main(String[] args) {
        Vyraz v0 = new Operator('+',
                new Operator('*', new Konstanta(3), new Konstanta(4)),
                new Operator('-', new Konstanta(1), new Konstanta(2))
        );
        Vyraz v1 = new Operator('-',
                new Operator('-', new Konstanta(3), new Konstanta(4)),
                new Operator('-', new Konstanta(1), new Konstanta(2))
        );
        Vyraz v2 = new Operator('-',
                new Operator('-', new Konstanta(3), new Konstanta(4)),
                new Operator('+', new Konstanta(1), new Konstanta(2))
        );
        Vyraz v3 = new Operator('/',
                new Operator('-', new Konstanta(3), new Konstanta(4)),
                new Operator('*', new Konstanta(1), new Konstanta(0))
        );
        Vyraz v4 = new Operator('*',
                new Operator('-', new Konstanta(1), new Konstanta(1)),
                new Operator('*', new Konstanta(1), new Konstanta(1))
        );
        Vyraz[] vyrazy = {v0, v1, v2, v3, v4};
        for(Vyraz v : vyrazy) {
            System.out.println(v + ",\teval=" + v.eval());
        }
    }
}
