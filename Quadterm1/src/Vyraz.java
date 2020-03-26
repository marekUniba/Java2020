abstract class Vyraz {
    abstract Integer eval();

    public static boolean lessEqual(char op1, char op2) {
        int p1 = (op1 == '+' || op1 == '-')?1:2;
        int p2 = (op2 == '+' || op2 == '-')?1:2;
        return p1 <= p2;
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
        Vyraz v34 = new Operator('*', v3, v4);
        Vyraz v43 = new Operator('/', v4, v3);
        Vyraz v3443 = new Operator('*', v34, v43);
        Vyraz v34_43 = new Operator('/', v34, v43);
        Vyraz v12 = new Operator('/', v1, v2);
        Vyraz v23 = new Operator('*', v2, v3);
        Vyraz v1223 = new Operator('*', v12, v23);
        Vyraz v4j = new Operator('*',
                new Operator('-', new Konstanta(1), new Konstanta(1)),
                new Operator('*', new Konstanta(1), new Konstanta(1))
        );

        Vyraz[] vyrazy = {v0, v1, v2, v3, v4,
            v34, v43, v3443,v34_43, v12, v23, v1223, v4j
        };
        for(Vyraz v : vyrazy) {
            System.out.println(v + ",\teval=" + v.eval());
        }
        for(Vyraz v : vyrazy) {
            System.out.println(v.toString().length());
        }
    }
}
