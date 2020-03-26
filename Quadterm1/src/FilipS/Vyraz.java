package FilipS;

abstract class Vyraz {

    abstract Integer eval();        // abstraktnu metodu treba dodefinovat

    public static boolean prvyOperator(char operator){
        if(operator == '+' || operator == '-'){
            return true;
        }
        return false;
    }

    public static boolean druhyOperator(char operator){
        if(operator == '*' || operator == '/'){
            return true;
        }
        return false;
    }



    public static boolean lessEqual(char op1, char op2) {
        if(prvyOperator(op1) && prvyOperator(op2)){
            return true;
        }
        if(prvyOperator(op1) && druhyOperator(op2)){
            return true;
        }
        if(druhyOperator(op1) && druhyOperator(op2)){
            return true;
        }
        return false;

    }

    public static void main(String[] args) {    // male testovacie priklady
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
        for(Vyraz v : vyrazy) {
            System.out.println(v + ",\teval=" + v.eval());
        }
    }
}
