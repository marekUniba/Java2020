package JurajH_team;

abstract class Vyraz {
    abstract Integer eval();

    public static boolean lessEqual(char op1, char op2) {
        int prio1 = 0;
        if (op1 == '*' || op1 == '/') {
            prio1 = 1;
        }
        int prio2 = 0;
        if (op2 == '*' || op2 == '/') {
            prio2 = 2;
        }
        return prio1 <= prio2;
    }

    abstract protected String myToString(char parent, boolean iAmLeft);

    @Override
    public String toString() {
        return myToString('#', false);
    }

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
        Vyraz v4 = new Operator('/',
                new Operator('-', new Konstanta(1), new Konstanta(1)),
                new Operator('-', new Konstanta(1), new Konstanta(1))
        );
        Vyraz[] vyrazy = {v0, v1, v2, v3, v4};
        for (Vyraz v : vyrazy) {
            System.out.println(v + ",\teval=" + v.eval());
        }
    }
}
