package AndrejP;

import java.util.Arrays;

import static org.junit.Assert.fail;

public class Queens implements Comparable<Queens> {
    int[] riesenie;     // !!! tento riadok NEMENTE, pouziva ho testovac
    
    public Queens(int[] rieseniee) {
        riesenie = Arrays.copyOf(rieseniee, rieseniee.length);
    }

    public Queens horizontalFlip() {
        int[] pole = new int[riesenie.length];
        for(int i = 0; i < pole.length; i++){
            pole[i] =  pole.length - 1 - riesenie[i];
        }
        Queens vysl = new Queens(pole);
        return vysl;
    }
    public Queens verticalFlip() {
        int[] pole = new int[riesenie.length];
        for(int i = 0; i < pole.length; i++){
            pole[i] =  riesenie[pole.length - i - 1];
        }
        Queens vysl = new Queens(pole);
        return vysl;
    }
    public Queens clockwise90() {
        int[] pole = new int[riesenie.length];
        for(int i = 0; i < pole.length; i++){
            pole[pole.length - 1 - riesenie[i]] = i;
        }
        Queens vysl = new Queens(pole);
        return vysl;
    }

    public String toString(){
        /*String vysl = "[ ";
        for(int i = 0; i < riesenie.length; i++){
            if(i != riesenie.length - 1){
                vysl += i + ", ";
            }else{
                vysl += i + " ";
            }
        }
        vysl += "]";
        return vysl;*/
        return  Arrays.toString(riesenie);
    }

    @Override
    public int compareTo(Queens o) {
        int len = riesenie.length;

        if(o.riesenie.length < len){
            len = o.riesenie.length;
        }
        for(int i = 0; i < len; i++){
            if(riesenie[i] < o.riesenie[i]){
                return -1;
            }else if(riesenie[i] > o.riesenie[i]){
                return 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        /*Queens q = new Queens(new int[]{0,1,2,3,4});    // maly priklad, 5 dam na hlavnej uhlopriecke
        System.out.println(q);
        System.out.println(q.horizontalFlip());
        System.out.println(q.clockwise90());*/
        int[] perm = new int[]{0, 1, 2, 3, 4};
        Queens q1 = new Queens(perm);
        perm[0] = 1;
        perm[1] = 0;
        Queens q2 = new Queens(perm);
        System.out.println(q1.toString());
        System.out.println(q2.toString());
    }
}
