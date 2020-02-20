public class Kruh {

    public static int mrezoveBody(double sx, double sy, double r) {
        int count = 0;
        for(long x = (int)Math.ceil(sx-r); x <= (int)Math.floor(sx+r); x++ ) {
            for(long y = (int)Math.ceil(sy-r); y <= (int)Math.floor(sy+r); y++ ) {
                if ((x-sx)*(x-sx)+(y-sy)*(y-sy) <= r*r) count++;
            }

        }
        return count;
    }
    public static void main(String[] args) {
        //System.out.println(mrezoveBody(0,0,2));
        System.out.println(mrezoveBody(0.5,0.5,3));
    }
}
