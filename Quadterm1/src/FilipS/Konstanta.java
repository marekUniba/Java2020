package FilipS;

public class Konstanta extends Vyraz {

    int hodnota;
    public Konstanta(int c) {
        hodnota = c;
    }     // dodefinuj

    @Override
    Integer eval(){
        return hodnota;
    }

    @Override
    public String toString() {
        return ""+hodnota;
    }
}
