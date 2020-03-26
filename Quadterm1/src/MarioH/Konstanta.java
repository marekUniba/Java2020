package MarioH;

public class Konstanta extends Vyraz {

    private int c;

    public Konstanta(int c) {
        this.c = c;
    }     // dodefinuj

    @Override
    Integer eval() {        // dodefinuj
        return c;
    }

    @Override
    public String brackets(boolean bracket) {
        return c + "";
    }

    @Override
    public String toString() {
        return c + "";
    }
}
