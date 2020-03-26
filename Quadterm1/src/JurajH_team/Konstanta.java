package JurajH_team;

public class Konstanta extends Vyraz {

    private int c;

    public Konstanta(int c) {
        this.c = c;
    }

    @Override
    Integer eval() {
        return c;
    }

    @Override
    protected String myToString(char parent, boolean iAmLeft) {
        return "" + c;
    }

}
