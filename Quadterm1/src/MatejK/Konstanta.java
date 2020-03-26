package MatejK;

public class Konstanta extends Vyraz {
    int c;

    public Konstanta(int c) {
        this.c = c;
    }     // dodefinuj

    @Override
    Integer eval() {        // dodefinuj
        return c;
    }

    @Override
    public String toString() {
        return "" + c;
    }
}
