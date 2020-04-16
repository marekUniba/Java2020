package Lukas;

import java.util.*;

/**
 *  4.priklad, 3 podulohy, 5 bodov
 */

// 6min
public class Graf {
    Map<String, Map<Character, String>> graf;

    public Graf(Map<String, Map<Character, String>> graf) {
        this.graf = graf;
    }

    @Override
    public String toString() {
        return graf.toString();
    }

    /**
     * @return hlada koncovy stav/vrchol, ak zacneme vo vychodzom a znaky cesty ukazuju na hrany, po ktorych mame ist
     */
    public String simuluj(String vychodzi, String cesta) {
        String aktualny = vychodzi;
        for (char znak : cesta.toCharArray()) {
            if (!graf.containsKey(aktualny) || !graf.get(aktualny).containsKey(znak))
                return null;
            aktualny = graf.get(aktualny).get(znak);
        }
        return aktualny;
    }

    /**
     * @return mena vsetkych Stringov v strukture grafu, a z toho mnozina
     */
    public Set<String> menaVrcholov() {
        Set<String> zber = new HashSet<>(graf.keySet());
        for (String stav : graf.keySet())
            zber.addAll(graf.get(stav).values());
        return zber;
    }

    /**
     * @return mena vsetkych Charakterov v strukture grafu, a z toho mnozina
     */
    public Set<Character> menaHran() {
        Set<Character> zber = new HashSet<>();
        for (String stav : graf.keySet())
            zber.addAll(graf.get(stav).keySet());
        return zber;
    }

    public static void main(String[] args) {
        Graf g1 = new Graf(
                Map.of(
                        "q0",
                        Map.of('a', "q0", 'b', "q1"),
                        "q1",
                        Map.of('b', "q1", 'a', "q0")));
        Graf g2 = new Graf(
                Map.of(
                        "q0",
                        Map.of('a', "q0", 'b', "q1")));
        Graf g3 = new Graf(
                Map.of(
                        "q0",
                        Map.of('x', "q0")));
        Graf g4 = new Graf(
                Map.of(
                        "q0",
                        Map.of('a', "q0", 'b', "q0")));
        Graf du3 = new Graf(Map.of(
                "a",
                Map.of('0', "b", '1', "a"),
                "b",
                Map.of('0', "b", '1', "c"),
                "c",
                Map.of('0', "d", '1', "a"),
                "d",
                Map.of('0', "d", '1', "d")
        ));
        List<Graf> tests = List.of(g1,g2,g3,g4,du3);
        int i = 0;
        for(Graf g :  tests) {
            for(String path : List.of("","a", "ab", "bb", "abba", "x", "aaaaaaaa")) {
                for(String vychodzi : List.of("q0", "q1", "a")) {
                    String x = g.simuluj(vychodzi,path);
                    if (x == null) System.out.print(x + ",");
                    else System.out.print("\"" + x + "\",");
                }
            }
        }

    }
}
