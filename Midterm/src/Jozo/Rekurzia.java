package Jozo;
import com.sun.security.jgss.GSSUtil;

import java.util.Arrays;
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
    static long[][]memo = new long[1000][1000];

    public static long foo(int a, int b) {
        /*if (a == 0 || b == 0)
            return 1;
        else
            return foo(a-1,b) + foo(a-1, b-1) + foo(a, b-1);*/
        if (a == 0 || b == 0){
            return 1;
        }
        if (memo[a][b] != 0){
            return memo[a][b];
        }
        memo[a][b] = foo(a-1,b) + foo(a-1, b-1) + foo(a, b-1);
        return memo[a][b];
    }

    /**
     * Asi ste si vsimli, ze nebyt clena foo(a-1, b-1), tak su to kombinacne cisla..
     * Ale nie su... Definujte funkciu zOboduHodnuot, ktora pre lubovolne cislo n, vrati true, ak existuju a,b, ze
     * foo(a,b) = n. Hint: namalujte si cast tabulky...
     */
    public static boolean zOboruHodnot(long n) {
        return (n%2 != 0);
    }
}
