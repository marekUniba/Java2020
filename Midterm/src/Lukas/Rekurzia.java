package Lukas;

import java.util.HashMap;
import java.util.Map;

/**
 *  1.priklad, 2 podulohy, 4 body
 */

// 12 min
public class Rekurzia {
    /**
     * funkcia foo rata nejake cislo pre dva vstupne argmenty a, b >= 0
     * je vsak mimoriadne neefektivna. vasou ulohou je napisat funkciu, ktora pocita to iste
     * ale za zlomok sekundy. Hint: technika sa vola memorizacia, raz vypocitanu hodnotu pre arguemtny
     * a,b si zapamatajte a nepozitajte znova
     */

    static Map<Integer, Map<Integer, Long>> memo = new HashMap<>();
    public static long foo(int a, int b) {
        if (a == 0 || b == 0)
            return 1;

        if (!memo.containsKey(a))
            memo.put(a, new HashMap<>());

        if (!memo.get(a).containsKey(b))
            memo.get(a).put(b,  foo(a-1,b) + foo(a-1, b-1) + foo(a, b-1));

        return memo.get(a).get(b);
    }

    /**
     * Asi ste si vsimli, ze nebyt clena foo(a-1, b-1), tak su to kombinacne cisla..
     * Ale nie su... Definujte funkciu zOboduHodnuot, ktora pre lubovolne cislo n, vrati true, ak existuju a,b, ze
     * foo(a,b) = n. Hint: namalujte si cast tabulky...
     */
    public static boolean zOboruHodnot(long n) {
        return n % 2 != 0;
    }

    public static void main(String[] args) {
        for (int a = 0; a < 100; a++)
            for (int b = 0; b < 100; b++)
                System.out.println(foo(a, b));

        System.out.println(foo(1,2));
        System.out.println(zOboruHodnot(3));
        System.out.println(zOboruHodnot(2));
    }
}
