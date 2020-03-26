import java.util.Arrays;

public class Queens implements Comparable<Queens>{
    int[] riesenie;
    public Queens(int[] riesenie) {
        this.riesenie = Arrays.copyOf(riesenie, riesenie.length);
        //ZLE this.riesenie = riesenie; // konsturktor si nevytvori kopiu pola

    }
    @Override
    public String toString() {
        //ZLE riesenie, return super.toString();
        return Arrays.toString(riesenie);
    }
    @Override
    public int compareTo(Queens o) {
        // toto funguje, len ak su rovnako dlhe a najviac 10, teda cifry 0..9
        //return Arrays.toString(riesenie).compareTo(Arrays.toString(o.riesenie));
        int min = Math.min(riesenie.length, o.riesenie.length);
        for(int i = 0; i < min; i++) {
            if (riesenie[i] < o.riesenie[i]) return -1;
            if (riesenie[i] > o.riesenie[i]) return 1;
        }
        if (riesenie.length == o.riesenie.length)
            return 0;
        else
            return (riesenie.length < o.riesenie.length)?-1:1;
    }
    public Queens clockwise90() {
        int[] nriesenie = new int[riesenie.length];
        for(int i = 0; i < riesenie.length; i++) {
            // nriesenie[riesenie[i]] = riesenie.length-(i+1); //anticlockwise
            nriesenie[riesenie.length-(riesenie[i]+1)] = i;
        }
        return new Queens(nriesenie);
    }
    public Queens horizontalFlip() {
        int[] nriesenie = new int[riesenie.length];
        for(int i = 0; i < riesenie.length; i++) {
            nriesenie[i] = riesenie.length-riesenie[i]-1;
        }
        return new Queens(nriesenie);
    }
    public Queens verticalFlip() {
        int[] nriesenie = new int[riesenie.length];
        for(int i = 0; i < riesenie.length; i++) {
            nriesenie[riesenie.length-i-1] = riesenie[i];
        }
        return new Queens(nriesenie);
    }
    public static void main(String[] args) {
        Queens q = new Queens(new int[]{0,1,2,3});//{3,1,6,2,5,7,4,0}); //{0,1,2,3,4});
        System.out.println(q);
        //System.out.println(q.clockwise90());
        System.out.println(q.horizontalFlip());

    }
}
