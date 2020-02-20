package H6;

public class Binarne {
    public static int pocetJednotiek(long n) {

            int count = 0;
            while (n > 0) {
                if ((n & 1) == 1) count++;
                n >>= 1;  // n = n >> 1;
            }
            return count;
        }

    public static int pocetJednotiek_verzia2(long n) {

        int count = 0;
        while (n > 0) {
            if ((n % 2) > 1) count++;
            n /= 2;   // n = n / 2;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(pocetJednotiek(10));
        System.out.println(pocetJednotiek_verzia2(10));
    }
}
