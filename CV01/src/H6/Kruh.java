package H6;

import java.util.Random;

public class Kruh {
    public static int mrezoveBody(double sx, double sy, double r) {
        int count = 0;
        for (int x = (int) (Math.floor(sx - r)); x <= (int) (Math.ceil(sx + r)); x++) {
            for (int y = (int) (Math.floor(sy - r)); y<= (int) (Math.ceil(sy + r)); y++) {
                if((x - sx) * (x - sx) + (y - sy) * (y - sy) <= r * r){
                    count++;
                }
            }

        }

        return count;
    }

    public static void main(String[] args) {
        //System.out.println(mrezoveBody(6.3, 5.2, 3));

        int [] a = new int[] {1, 3, 7, 11, 13};
        int sum = 0;
        for(int i = 0; i < a.length; i++){
            sum += a[i];
        }
        int result = sum / a.length;
        //System.out.println(result);

        Random rnd = new Random();
        int len = rnd.nextInt(10);
        int [] b = new int[len];
        for(int i = 0; i < b.length; i++){
            b[i] = rnd.nextInt(20);
        }
        for(int i : b){
            System.out.println(i);
            //System.out.println("i*i = " + i*i);
        }
    }
}