package JakubZ;

public class Konstanta extends Vyraz {
    int c;

    public Konstanta(int _c) { // dodefinuj
        c = _c;
    }

    @Override
    Integer eval() {        // dodefinuj
        return c;
    }

    @Override
    public String toString() {
        return c + "";
    }
}
