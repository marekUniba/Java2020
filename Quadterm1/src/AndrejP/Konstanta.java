package AndrejP;

public class Konstanta extends Vyraz {
    int value;
    public Konstanta(int c) {
        value = c;
    }

    @Override
    Integer eval(){
        return (Integer)value;
    }

    public String toString(){
        if(value < 0){
            return "("+ value +")";
        }
        return ""+value;
    }
}
