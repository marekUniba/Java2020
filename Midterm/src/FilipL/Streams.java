package FilipL;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 5.priklad, 4 podulohy, 5 bodov
 */

public class Streams {
    /**
     * @return - vrati IntStream celych cisel -n..n v poradi 0,-1,1,-2,2, ..., -n,n
     */
    public static IntStream striedavo(int n) {
        return IntStream.range(0, n+1).boxed().map(i -> List.of(-i, i)).flatMap(Collection::stream).mapToInt(a -> a).distinct();
    }

    /**
     * @return - prefiltruje input stream a vysledkom su len prvocisla v tom istom poradi
     * prvocislo je prirodzene cislo > 1, ktore nema delitela
     */
    public static IntStream prvocisla(IntStream input) {
        return input.filter(cislo -> ! IntStream.range(2, cislo).anyMatch(cislo2 -> cislo % cislo2 == 0));
    }

    public static Map<Integer, Long> najvyssiaCifra(List<Integer> vstup) {
        Map<Integer, Long> mapa = new HashMap<>(Map.of(0,0L, 1,0L,2,0L,3,0L,4,0L,5,0L,6,0L,7,0L,8,0L,9,0L));
        vstup.stream().forEach(cislo -> mapa.put(Character.getNumericValue(String.valueOf(cislo).charAt(0)), mapa.get(Character.getNumericValue(String.valueOf(cislo).charAt(0))) + 1));
        return mapa;
    }

    /**
     * @return - pre prvky x streamu input vyrobi mapu, ktorej x je klucom a
     * hodnotou je zoznamj jeho delitelov z intervalu 1..x,
     * 1 je prvy prvok, a x je urcite posledny vysledneho prvok zoznamu
     */
    public static Map<Integer, List<Integer>> delitele(IntStream input) {
        return input.boxed().collect(Collectors.toMap(cislo -> cislo,cislo -> IntStream.range(1, cislo + 1).filter(a -> cislo % a == 0).boxed().collect(Collectors.toList())));
    }
}
