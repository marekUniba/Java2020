package MichalS;

public class Konstanta extends Vyraz {
    int konst;

    public Konstanta(int c) {
        konst = c;
    }

    @Override
    Integer eval() {
        return konst;
    }

    @Override
    public String toString() {
        return Integer.toString(konst);
    }
}
