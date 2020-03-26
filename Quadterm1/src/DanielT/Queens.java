package DanielT;

import java.util.Arrays;

public class Queens implements Comparable<Queens> {
    int[] riesenie;     // !!! tento riadok NEMENTE, pouziva ho testovac
    
    public Queens(int[] riesenie) {
        this.riesenie = riesenie.clone();
    }
    public String toString(){
       return Arrays.toString(riesenie);
    }
    public Queens horizontalFlip() {    // dodefinujte podla zadania

        int [] pole = new int[riesenie.length];
        for(int i = 0; i < riesenie.length; i++){
            pole[i] = riesenie.length - riesenie[i] - 1;
        }
        return new Queens(pole);
    }
    public Queens verticalFlip() {
        int [] pole = new int[riesenie.length];
        for(int i = riesenie.length - 1; i >= 0; i--){
            pole[riesenie.length - i - 1] = riesenie[i];
        }
        return new Queens(pole);
    }
    public Queens clockwise90() {       // dodefinujte podla zadania
        int [] pole = new int[riesenie.length];
        for(int i = 0; i < riesenie.length; i++){
            pole[riesenie.length - riesenie[i] - 1] = i;
        }
        return new Queens(pole);
    }
    public static void main(String[] args) {
        Queens q = new Queens(new int[]{0,1,2,3,4});    // maly priklad, 5 dam na hlavnej uhlopriecke
        System.out.println(q);
        System.out.println(q.horizontalFlip());
        System.out.println(q.clockwise90());
    }

    @Override
    public int compareTo(Queens o) {
        for(int i = 0; i < o.riesenie.length; i++){
            if(this.riesenie[i] < o.riesenie[i]){
                return -1;
            }
            if(this.riesenie[i] > o.riesenie[i]){
                return 1;
            }
        }
        return 0;
    }
}
