package MichalS;

import java.util.Arrays;

public class Queens implements Comparable<Queens> {
    int[] riesenie;
    
    public Queens(int[] riesenie) {
        if (riesenie == null) {
            return;
        }

        this.riesenie = new int[riesenie.length];
        System.arraycopy(riesenie, 0, this.riesenie, 0, riesenie.length);
    }

    public Queens horizontalFlip() {
        if (riesenie == null) return null;

        int dlzka = riesenie.length;
        int[] pole = new int[dlzka];
        for (int i = 0; i < dlzka; i++) {
            pole[i] = dlzka - riesenie[i] - 1;
        }

        return new Queens(pole);
    }

    public Queens verticalFlip() {
        if (riesenie == null) return null;

        int dlzka = riesenie.length;
        int[] pole = new int[dlzka];
        for (int i = 0; i < dlzka; i++) {
            pole[i] = riesenie[dlzka - i - 1];
        }

        return new Queens(pole);
    }

    private int indexOf(int i) {
        for (int j = 0; j < riesenie.length; j++) {
            if (i == riesenie[j]) {
                return j;
            }
        }
        return -1;
    }

    public Queens clockwise90() {
        if (riesenie == null) return null;

        int dlzka = riesenie.length;
        int[] pole = new int[dlzka];
        for (int i = 0; i < dlzka; i++) {
            pole[i] = indexOf(dlzka - i - 1);
        }

        return new Queens(pole);
    }

    @Override
    public String toString() {
        return Arrays.toString(riesenie);
    }

    @Override
    public int compareTo(Queens q) {
        for (int i = 0; i < riesenie.length; i++) {
            if (riesenie[i] < q.riesenie[i]) {
                return -1;
            }
            if (riesenie[i] > q.riesenie[i]) {
                return 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Queens q = new Queens(new int[]{0,1,2,3,4});
        System.out.println(q);
        System.out.println(q.horizontalFlip());
        System.out.println(q.clockwise90());
    }
}
