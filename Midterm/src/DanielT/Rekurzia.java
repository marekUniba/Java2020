package DanielT;
import java.util.*;

/**
 * 1.priklad, 2 podulohy, 4 body
 */

public class Rekurzia {
    /**
     * funkcia foo rata nejake cislo pre dva vstupne argmenty a, b >= 0
     * je vsak mimoriadne neefektivna. vasou ulohou je napisat funkciu, ktora pocita to iste
     * ale za zlomok sekundy. Hint: technika sa vola memorizacia, raz vypocitanu hodnotu pre arguemtny
     * a,b si zapamatajte a nepozitajte znova
     */
    private static  Map<List<Integer>, Long> m = new HashMap<>();
    public static long foo(int a, int b) {
        if(m.containsKey(List.of(a,b))){
            return m.get(List.of(a,b));
        }
        if(m.containsKey(List.of(b,a))){
            return m.get(List.of(b,a));
        }
        if (a == 0 || b == 0) {
            m.put(List.of(a, b), 1L);
            return m.get(List.of(a, b));
        }
        else
            m.put(List.of(a,b) , foo(a - 1, b) + foo(a - 1, b - 1) + foo(a, b - 1));
            return m.get(List.of(a,b));
    }

    /**
     * Asi ste si vsimli, ze nebyt clena foo(a-1, b-1), tak su to kombinacne cisla..
     * Ale nie su... Definujte funkciu zOboduHodnuot, ktora pre lubovolne cislo n, vrati true, ak existuju a,b, ze
     * foo(a,b) = n. Hint: namalujte si cast tabulky...
     */
    public static boolean zOboruHodnot(long n) {
        return m.values().stream().anyMatch(value -> value == n);
    }

    public static void main(String[] args) {
        for(int i = 0; i < 11; i++){
            for(int j = 0; j < 11; j++){
                System.out.println(i + " " + j + "  " +foo(i,j));
            }
        }
    }
}
