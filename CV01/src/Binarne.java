public class Binarne {
    /*
     * Napíšte program, ktorý pre zadané èíslo
     * vypíše poèet jednotiek v jeho binárnom zápise.
     * Napríklad, pre 10 vypíše 2.
     */

    public static int pocetJednotiek(long n) {
        int pocet = 0;
        long tmp = n;
        while (tmp != 0) {
            if ((tmp & 1) == 1) {
                pocet++;
            }
            tmp = tmp >>> 1;
        }
        return pocet;
    }

    public static void main(String[] args) {
        System.out.println(pocetJednotiek(10));
    }
}