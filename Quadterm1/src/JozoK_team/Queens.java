package JozoK_team;

import java.util.Arrays;
;

public class Queens implements Comparable<Queens>{
    int[] riesenie;
    public Queens(int[] riesenie) {
        this.riesenie = riesenie.clone();
    }
    public String toString(){
        return Arrays.toString(riesenie);
    }
    public Queens clockwise90() {
        int[] res = new int[riesenie.length];
        for (int i = 0; i < res.length; i++){
            res[riesenie.length-1-riesenie[i]] = i;
        }
        return new Queens(res);
    }
    public Queens horizontalFlip() {
        int[] res = new int[riesenie.length];
        for (int i = 0; i < riesenie.length; i++){
            res[i] = 8-riesenie[i];
        }
        return new Queens(res);
    }
    public Queens verticalFlip() {
        int[] res = new int[riesenie.length];
        for (int i = riesenie.length-1; i >=0; i--){
            res[i] = riesenie[riesenie.length-1-i];
        }
        return new Queens(res);
    }
    public static void main(String[] args) {
        Queens q = new Queens(new int[]{0,1,2,3,4});
        System.out.println(q);
        System.out.println(q.horizontalFlip());
        System.out.println(q.clockwise90());
    }

    @Override
    public int compareTo(Queens o) {
        for(int i = 0; i < riesenie.length; i++){
            if(riesenie[i] != o.riesenie[i]){
                return Integer.compare(riesenie[i], o.riesenie[i]);
            }
        }
        return 0;
    }
}
