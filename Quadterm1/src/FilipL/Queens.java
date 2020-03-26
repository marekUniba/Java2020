package FilipL;

import java.util.Arrays;

public class Queens implements Comparable<Queens> {
    int[] riesenie;     // !!! tento riadok NEMENTE, pouziva ho testovac
    
    public Queens(int[] riesenie) {     // dodefinujte podla zadania
        this.riesenie = Arrays.copyOf(riesenie, riesenie.length);
    }

    @Override
    public String toString() {
        return "Queens{" +
                "riesenie=" + Arrays.toString(riesenie) +
                '}';
    }

    public Queens horizontalFlip() {    // dodefinujte podla zadania
        int[] result = Arrays.copyOf(riesenie, riesenie.length);
        for (int i = 0; i < result.length; i ++) {
            result[i] = riesenie.length - (result[i] + 1);
        }

        return new Queens(result);
    }
    public Queens verticalFlip() {      // dodefinujte podla zadania
        int[] result = new int[riesenie.length];
        for (int i = 0; i < riesenie.length; i++) {
            result[i] = riesenie[riesenie.length - 1 - i];
        }
        return new Queens(result);
    }
    public Queens clockwise90() {       // dodefinujte podla zadania
        int[] result = new int[riesenie.length];
        for (int i = 0; i < riesenie.length; i++) {
            result[riesenie.length - riesenie[i] - 1] = i;
        }
        return new Queens(result);
    }
    public static void main(String[] args) {
        Queens q = new Queens(new int[]{0,1,2,3,4});    // maly priklad, 5 dam na hlavnej uhlopriecke
        System.out.println(q);
        System.out.println(q.horizontalFlip());
        System.out.println(q.clockwise90());
    }

    @Override
    public int compareTo(Queens other) {
        if (riesenie.length > other.riesenie.length) return 1;
        else if (riesenie.length < other.riesenie.length) return -1;

        for (int i = 0; i < riesenie.length; i++) {
            if (Integer.compare(riesenie[i], other.riesenie[i]) != 0) return Integer.compare(riesenie[i], other.riesenie[i]);
        }

        return 0;
    }
}
