package FilipL;

public class Konstanta extends Vyraz {
    int cislo;
    public Konstanta(int c) { cislo = c; }     // dodefinuj

    @Override
    Integer eval() {        // dodefinuj
        return cislo;
    }

    @Override
    public String toString() {
        return String.valueOf(cislo);
    }
}
