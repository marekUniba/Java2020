package MarioH;

import java.util.Arrays;

public class Queens implements Comparable<Queens> {
    int[] riesenie;     // !!! tento riadok NEMENTE, pouziva ho testovac
    
    public Queens(int[] riesenie) {
        // dodefinujte podla zadania
        this.riesenie = riesenie.clone();
    }
    public Queens horizontalFlip() {    // dodefinujte podla zadania
        int[] temp = new int[riesenie.length];

        for(int i = 0; i < riesenie.length; i++) {
            temp[i] = riesenie.length - 1 - riesenie[i];
        }

        return new Queens(temp);
    }
    public Queens verticalFlip() {      // dodefinujte podla zadania
        int[] temp = new int[riesenie.length];

        for(int i = 0; i < riesenie.length; i++) {
            temp[i] = riesenie[riesenie.length - i - 1];
        }

        return new Queens(temp);
    }
    public Queens clockwise90() {       // dodefinujte podla zadania
        int[] temp = new int[riesenie.length];

        for(int i = 0; i < riesenie.length; i++) {
            temp[riesenie.length - 1 - riesenie[i]] = i;
        }

        return new Queens(temp);
    }

    @Override
    public String toString() {
        return "Queens{" +
                "riesenie=" + Arrays.toString(riesenie) +
                '}';
    }

    public static void main(String[] args) {
        Queens q = new Queens(new int[]{0,1,2,3,4});    // maly priklad, 5 dam na hlavnej uhlopriecke
        System.out.println(q);
        System.out.println(q.horizontalFlip());
        System.out.println(q.clockwise90());
    }

    @Override
    public int compareTo(Queens o) {
        for(int i = 0; i < riesenie.length; i++) {
            if(riesenie[i] < o.riesenie[i]) return -1;
            else if(riesenie[i] > o.riesenie[i]) return 1;
        }

        return 0;
    }
}
