package FilipL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    static Map<List<Integer>, Long> map = new HashMap<>();

    public static long foo(int a, int b) {
        List<Integer> l = new ArrayList<>(List.of(a, b));
        if (map.keySet().stream().anyMatch(list -> list.get(0).compareTo(l.get(0)) == 0 && list.get(1).compareTo(l.get(1)) == 0)) {
            long res = map.get(map.keySet().stream().filter(list -> list.get(0).compareTo(l.get(0)) == 0 && list.get(1).compareTo(l.get(1)) == 0).findAny().get());
            return res;
        }

        if (a == 0 || b == 0) {
            map.put(List.of(a, b), 1L);
            return 1;
        }
        else {
            long ress = foo(a - 1, b) + foo(a - 1, b - 1) + foo(a, b - 1);
            map.put(List.of(a, b), ress);
            return ress;
        }
    }

    /**
     * Asi ste si vsimli, ze nebyt clena foo(a-1, b-1), tak su to kombinacne cisla..
     * Ale nie su... Definujte funkciu zOboduHodnuot, ktora pre lubovolne cislo n, vrati true, ak existuju a,b, ze
     * foo(a,b) = n. Hint: namalujte si cast tabulky...
     */
    public static boolean zOboruHodnot(long n) {
        return map.values().stream().anyMatch(value -> value == n); // dodefinujte
    }
}
