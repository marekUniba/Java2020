package DanielT;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 4.priklad, 3 podulohy, 5 bodov
 */
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
        String vrchol = vychodzi;
        for(Character ch : cesta.toCharArray()){
            if(!graf.containsKey(vrchol)) return null;
            if(!graf.get(vrchol).containsKey(ch)) return null;
            vrchol = graf.get(vrchol).get(ch);
        }
        return vrchol;
    }

    /**
     * @return mena vsetkych Stringov v strukture grafu, a z toho mnozina
     */
    public Set<String> menaVrcholov() {
        Set<String> res = new HashSet<>(graf.keySet());
        graf.values().forEach(g -> res.addAll(g.values()));
        return res;

    }

    /**
     * @return mena vsetkych Charakterov v strukture grafu, a z toho mnozina
     */
    public Set<Character> menaHran() {
        Set<Character> res = new HashSet<>();
        graf.values().forEach(g -> res.addAll(g.keySet()));
        return res;
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
        List<Graf> tests = List.of(g1, g2, g3, g4, du3);
        int i = 0;
        for (Graf g : tests) {
            for (String path : List.of("", "a", "ab", "bb", "abba", "x", "aaaaaaaa")) {
                for (String vychodzi : List.of("q0", "q1", "a")) {
                    String x = g.simuluj(vychodzi, path);
                    if (x == null) System.out.print(x + ",");
                    else System.out.print("\"" + x + "\",");
                }
            }
        }

    }
}
