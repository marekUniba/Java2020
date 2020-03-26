package JakubZ;

import java.util.Arrays;
import java.util.Queue;

public class Queens implements Comparable<Queens> {
    int[] riesenie;     // !!! tento riadok NEMENTE, pouziva ho testovac

    public Queens(int[] _riesenie) {     // dodefinujte podla zadania
        riesenie = Arrays.copyOf(_riesenie, _riesenie.length);
    }
    public Queens horizontalFlip() {    // dodefinujte podla zadania - done
        int[] res = new int[riesenie.length];
        for ( int i = 0; i < riesenie.length; i++ ) {
            res[i] = riesenie.length-1 - riesenie[i];
        }
        return new Queens(res);
    }
    public Queens verticalFlip() {      // dodefinujte podla zadania - done
        int[] res = new int[riesenie.length];
        for ( int i = 0; i < riesenie.length; i++ ) {
            res[i] = riesenie[riesenie.length-1-i];
        }
        return new Queens(res);
    }
    public Queens clockwise90() {       // dodefinujte podla zadania - done
        int[] res = new int[riesenie.length];
        for ( int i = 0; i < riesenie.length; i++ ) {
            res[riesenie.length-1 - riesenie[i]] = i;
        }
        return new Queens(res);
    }

    @Override
    public int compareTo(Queens other) {
        for ( int i = 0; i < riesenie.length; i++ ) {
            if ( riesenie[i] < other.riesenie[i] ) {
                return -1;
            } else if ( riesenie[i] > other.riesenie[i] ) {
                return 1;
            }
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Queens{" +
                "riesenie=" + Arrays.toString(riesenie) +
                '}';
    }

    public static void main(String[] args) {
        Queens q = new Queens(new int[] {0,1,2,3,4});    // maly priklad, 5 dam na hlavnej uhlopriecke
        System.out.println(q);
        System.out.println(q.verticalFlip());
        System.out.println(q.horizontalFlip());
        System.out.println(q.clockwise90());
    }
}
