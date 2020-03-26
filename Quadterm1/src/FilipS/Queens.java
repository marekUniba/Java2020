package FilipS;

import java.util.Arrays;

public class Queens implements Comparable<Queens>{
    int[] riesenie;     // !!! tento riadok NEMENTE, pouziva ho testovac
    
    public Queens(int[] riesenie) {     // dodefinujte podla zadania
        this.riesenie = riesenie.clone();
    }
    public Queens horizontalFlip() {    // dodefinujte podla zadania
        int[] kopia = new int[riesenie.length];
        int pocet = riesenie.length-1;
        for(int i = 0; i < riesenie.length; i++){
            kopia[i] = pocet - riesenie[i];
        }
        return new Queens(kopia);
    }
    public Queens verticalFlip() {      // dodefinujte podla zadania
        int[] kopia = new int[riesenie.length];

        for(int i = 0; i < riesenie.length/2; i++){
            int index = i;
            int opacny = riesenie.length-i-1;

            int hodnota1 = riesenie[i];
            int hodnota2 = riesenie[opacny];
            kopia[i] = hodnota2;
            kopia[opacny] = hodnota1;

        }
        return new Queens(kopia);
    }
    public Queens clockwise90() {       // dodefinujte podla zadania
        int[] kopia = new int[riesenie.length];
        for(int i = 0; i < riesenie.length; i++){
            kopia[riesenie.length - riesenie[i] - 1] = i;
        }
        return new Queens(kopia);
    }
    public static void main(String[] args) {
        Queens q = new Queens(new int[]{0,1,2,3,4});    // maly priklad, 5 dam na hlavnej uhlopriecke
        System.out.println(q);
        System.out.println(q.horizontalFlip());
        System.out.println(q.clockwise90());
    }


    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
       for(int i : riesenie){
          sb.append(i);
          sb.append(" ");
       }
       return sb.toString();
    }


    @Override
    public int compareTo(Queens t) {



        Queens other = (Queens) t;


        return Arrays.compare(riesenie, other.riesenie);
    }
}
