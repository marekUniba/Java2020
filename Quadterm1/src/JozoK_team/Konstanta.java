package JozoK_team;

public class Konstanta extends Vyraz {
        int c;
    public Konstanta(int c) {
        this.c = c;
    }

    @Override
    Integer eval() {
        return c;
    }

    public String toString(){
        return c + "";
    }
}
