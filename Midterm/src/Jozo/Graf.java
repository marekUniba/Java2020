package Jozo;

import java.util.*;

import static org.junit.Assert.assertEquals;

/**
 *  4.priklad, 3 podulohy, 5 bodov
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
        //return null; // doprogramujte
        String curr = vychodzi;
        for (int i = 0; i < cesta.length(); i++){
            char znak = cesta.charAt(i);
            Map<Character, String> moznosti = graf.get(curr);
            if (moznosti == null){
                return null;
            }
            String novy = moznosti.get(znak);
            if(novy == null){
                return null;
            }
            curr = novy;
        }
        return curr;
    }

    /**
     * @return mena vsetkych Stringov v strukture grafu, a z toho mnozina
     */
    public Set<String> menaVrcholov() {   //spravene s checkmi; stači aj addAll použiť
        //return null; // doprogramujte
        HashSet<String> vysledok = new HashSet<>();
        for (Map.Entry<String, Map<Character, String>> entry : graf.entrySet()) {
            if (!vysledok.contains(entry.getKey())){
                vysledok.add(entry.getKey());
            }
            for (Map.Entry<Character, String> ent : entry.getValue().entrySet()){
                if (!vysledok.contains(ent.getValue())){
                    vysledok.add(ent.getValue());
                }
            }
        }
        return vysledok;
    }

    /**
     * @return mena vsetkych Charakterov v strukture grafu, a z toho mnozina
     */
    public Set<Character> menaHran() {   //spravene s checkmi; stači aj addAll použiť
        //return null; // doprogramujte
        HashSet<Character> vysledok = new HashSet<>();
        for (Map.Entry<String, Map<Character, String>> entry : graf.entrySet()) {

            for (Map.Entry<Character, String> ent : entry.getValue().entrySet()){
                if (!vysledok.contains(ent.getKey())){
                    vysledok.add(ent.getKey());
                }
            }
        }
        return vysledok;
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
