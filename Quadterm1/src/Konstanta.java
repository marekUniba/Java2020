public class Konstanta extends  Vyraz {
    int c;

    public Konstanta(int c) {
        this.c = c;
    }

    @Override
    public String toString() {
        return ""+c;
    }

    @Override
    Integer eval() {
        return c;
    }
}
