package MatejK;

import java.util.Arrays;

public class Queens implements Comparable<Queens>{
    int[] riesenie;     // !!! tento riadok NEMENTE, pouziva ho testovac
    
    public Queens(int[] riesenie) {
        this.riesenie = riesenie.clone();
    }

    public Queens horizontalFlip() {    // dodefinujte podla zadania
        Queens res = new Queens(riesenie); //klon
        int dlzka = riesenie.length;
        for (int i = 0; i < res.riesenie.length; i++) {
            res.riesenie[i] = dlzka -1 -res.riesenie[i];
        }
        return res;
    }

    public Queens verticalFlip() {
        Queens res = new Queens(riesenie); //klon
        for (int i = 0; i < res.riesenie.length/2; i++) {
            swap(res.riesenie, i, res.riesenie.length-1-i);
        }
        return res;
    }

    private void swap(int[] pole, int i, int j){
        int temp = pole[i];
        pole[i] = pole[j];
        pole[j] = temp;
    }

    public Queens clockwise90() {       // dodefinujte podla zadania
        Queens res = new Queens(riesenie); //klon
        int dlzka = riesenie.length;
        for (int i = 0; i < res.riesenie.length; i++) {
            int index = dlzka - 1 - riesenie[i];
            res.riesenie[index] = i;
        }
        return res;
    }

    @Override
    public int compareTo(Queens o) {
        return Arrays.compare(riesenie, o.riesenie);
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
}
