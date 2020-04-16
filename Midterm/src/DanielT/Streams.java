package DanielT;
import java.util.*;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

/**
 * 5.priklad, 4 podulohy, 5 bodov
 */

public class Streams {
    /**
     * @return - vrati IntStream celych cisel -n..n v poradi 0,-1,1,-2,2, ..., -n,n
     */
    public static IntStream striedavo(int n) {
        return IntStream.range(0, n+1).boxed().map(i -> List.of(-i, i)).flatMap(x -> x.stream()).mapToInt(a -> a).distinct();
    }

    /**
     * @return - prefiltruje input stream a vysledkom su len prvocisla v tom istom poradi
     * prvocislo je prirodzene cislo > 1, ktore nema delitela
     */
    public static IntStream prvocisla(IntStream input) {
        IntPredicate i = (x) -> IntStream.range(2, x).filter(z -> x % z == 0).count() == 0;
        IntPredicate i1 = (x) -> x > 1;
        return input.filter(i1).filter(i);
    }

    public static Map<Integer, Long> najvyssiaCifra(List<Integer> vstup) {
        Map<Integer, Long> res = new HashMap<>(Map.of(0,0L,1,0L,2,0L,3,0L,4,0L,5,0L,6,0L,7,0L,8,0L,9,0L));
        vstup.stream().forEach(x -> {
            String p = x.toString();
            int key = Integer.parseInt(String.valueOf(p.charAt(0)));
            if(res.containsKey(key)){
                long l = res.get(key) + 1;
                res.remove(key);
                res.put(key, l);
            }
            else{
                res.put(key, 1L);
            }
        });
        return res;
    }

    /**
     * @return - pre prvky x streamu input vyrobi mapu, ktorej x je klucom a
     * hodnotou je zoznamj jeho delitelov z intervalu 1..x,
     * 1 je prvy prvok, a x je urcite posledny vysledneho prvok zoznamu
     */
    public static Map<Integer, List<Integer>> delitele(IntStream input) {
        Map<Integer, List<Integer>> res = new HashMap<>();
        input.forEach(i -> {
            List<Integer> list = new ArrayList<>();
            IntStream.range(1, i + 1).forEach(n -> {
                if(i % n == 0){
                    list.add(n);
                }
            });
            res.put(i,list);
        });


        return res;
    }
}
