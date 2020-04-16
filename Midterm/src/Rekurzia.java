import com.sun.security.jgss.GSSUtil;

import java.util.Random;

/**
 *  1.priklad, 2 podulohy, 4 body
 */

public class Rekurzia {
    /**
     * funkcia foo rata nejake cislo pre dva vstupne argmenty a, b >= 0
     * je vsak mimoriadne neefektivna. vasou ulohou je napisat funkciu, ktora pocita to iste
     * ale za zlomok sekundy. Hint: technika sa vola memorizacia, raz vypocitanu hodnotu pre arguemtny
     * a,b si zapamatajte a nepozitajte znova
     */
    public static long foo(int a, int b) {
//        if (a == 0 || b == 0)
//            return 1;
//        else
//            return foo(a-1,b) + foo(a-1, b-1) + foo(a, b-1);
        long pole[][] = new long[a+1][b+1];
        for(int i = 0; i <= a; i++)
            for(int j = 0; j <= b; j++)
                pole[i][j] = (i * j == 0)?1:(pole[i-1][j]+pole[i][j-1]+pole[i-1][j-1]);
        return pole[a][b];
    }
// riesenie:
//    public static long foo(int a, int b) {
//        long pole[][] = new long[a+1][b+1];
//        for(int i = 0; i <= a; i++)
//            for(int j = 0; j <= b; j++)
//                pole[i][j] = (i * j == 0)?1:(pole[i-1][j]+pole[i][j-1]+pole[i-1][j-1]);
//        return pole[a][b];
//    }

    /**
     * Asi ste si vsimli, ze nebyt clena foo(a-1, b-1), tak su to kombinacne cisla..
     * Ale nie su... Definujte funkciu zOboduHodnuot, ktora pre lubovolne cislo n, vrati true, ak existuju a,b, ze
     * foo(a,b) = n. Hint: namalujte si cast tabulky...
     */
    public static boolean zOboruHodnot(long n) {
        //return false; // dodefinujte
        return (n & 1) > 0;
    }
// riesenie :)
//    public static boolean zOboduHodnot(long n) {
//        return (n&1)>0;
//    }
    public static void main(String[] args) {
        Random rnd = new Random();
        for (int i = 0; i < 100; i++) {
            int a = rnd.nextInt(27);
            int b = rnd.nextInt(27);
            System.out.println("assertTrue(\"zOboruHodnot(" + foo(a,b) + ")\", " +
                    ", Rekurzia.zOboruHodnot(" + foo(a,b) + "));");
            System.out.println("assertFalse(\"zOboruHodnot(" + 2*foo(a,b)+4 + ")\" " +
                    ", Rekurzia.zOboruHodnot(" + 2*foo(a,b)+4 + "));");
        }
    }
}
