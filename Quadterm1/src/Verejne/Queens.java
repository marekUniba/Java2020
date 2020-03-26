package Verejne;

public class Queens {
    int[] riesenie;
    public Queens(int[] riesenie) {
    }
    public Queens clockwise90() {
        return null;
    }
    public Queens horizontalFlip() {
        return null;
    }
    public Queens verticalFlip() {
        return null;
    }
    public static void main(String[] args) {
        Queens q = new Queens(new int[]{0,1,2,3,4});
        System.out.println(q);
        System.out.println(q.horizontalFlip());
        System.out.println(q.clockwise90());
    }
}
