package JurajH_team;

import java.util.Arrays;

public class Queens implements Comparable<Queens>{
    int[] riesenie;

    public Queens(int[] riesenie) {
        this.riesenie = Arrays.copyOf(riesenie, riesenie.length);
    }

    public Queens clockwise90() {
        Queens q = new Queens(riesenie);
        int len = riesenie.length;
        for (int i = 0; i < riesenie.length; i++) {
            q.riesenie[riesenie[i]] = len - i - 1;
        }
        return q;
    }

    public Queens horizontalFlip() {
        Queens q = new Queens(riesenie);
        int len = riesenie.length;
        for (int i = 0; i < riesenie.length; i++) {
            q.riesenie[i] = len - q.riesenie[i] - 1;
        }
        return q;
    }

    public Queens verticalFlip() {
        Queens q = new Queens(riesenie);
        int len = riesenie.length;
        for (int i = 0; i < riesenie.length; i++) {
            q.riesenie[i] = riesenie[len - i - 1];
        }
        return q;
    }

    @Override
    public String toString() {
        return "Queens{" +
                "riesenie=" + Arrays.toString(riesenie) +
                '}';
    }

    public static void main(String[] args) {
        Queens q = new Queens(new int[]{0, 1, 2, 3, 4});
        System.out.println(q);
        System.out.println(q.horizontalFlip());
        System.out.println(q.clockwise90());
    }

    @Override
    public int compareTo(Queens o) {
        for (int i = 0; i < riesenie.length; i++) {
            int comp = Integer.compare(riesenie[i], o.riesenie[i]);
            if (comp != 0) {
                return comp;
            }
        }
        return 0;
    }
}
