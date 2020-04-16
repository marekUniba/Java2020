import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 *  5.priklad, 4 podulohy, 5 bodov
 */

public class Streams {
    /**
     * @return - vrati IntStream celych cisel -n..n v poradi 0,-1,1,-2,2, ..., -n,n
     */
    public static IntStream striedavo(int n) {
        return IntStream.range(0,2*n+1).map(i -> -(((i&1)<<1)-1)*((i+1)>>1));
    }

    /**
     * @return - prefiltruje input stream a vysledkom su len prvocisla v tom istom poradi
     * prvocislo je prirodzene cislo > 1, ktore nema delitela
     */
    public static IntStream prvocisla(IntStream input) {
        return input.filter(n -> n > 1 && IntStream.range(2, 1+(int)Math.floor(Math.sqrt(n))).allMatch(d -> n % d > 0));
    }
    public static Map<Integer, Long> najvyssiaCifra(List<Integer> vstup) {
        return IntStream.range(0,10).boxed().collect(Collectors.toMap(
                                        e->e,
                                        e->vstup.stream().filter(cislo -> (""+cislo).startsWith(""+e)).count()
                                      ));
    }
    /**
     * @return - pre prvky x streamu input vyrobi mapu, ktorej x je klucom a
     * hodnotou je zoznamj jeho delitelov z intervalu 1..x,
     * 1 je prvy prvok, a x je urcite posledny vysledneho prvok zoznamu
     */
    public static Map<Integer, List<Integer>> delitele(IntStream input) {
        return input.boxed().collect(Collectors.toMap(e -> e ,
                       e -> Stream.iterate(1, i->i+1).limit(e).
                               filter(d -> e % d == 0).collect(Collectors.toList())));
    }
    public static void main(String[] args) {
//        for(int i = 0; i < 10; i++) {
//            IntStream is = IntStream.range(1, 10*i).map(e->2*e+1);
//            System.out.println(
//                    Streams.prvocisla(is).boxed().collect(Collectors.toList()));
//        }

//        for(int i = 0; i < 10; i++) {
//            List<Integer> ls = IntStream.range(1, 10*i).map(e->5*e+13).boxed().collect(Collectors.toList());
//            System.out.println(Streams.najvyssiaCifra(ls).get(3));
//        }

        for(int i = 0; i < 10; i++) {
            IntStream is = IntStream.range(1, 10*i).map(e->2*e+1);
            System.out.println(Streams.delitele(is).get(2*i-1));
        }


        System.out.println(striedavo(10).boxed().collect(Collectors.toList()));
        System.out.println(prvocisla(IntStream.range(0,100)).boxed().collect(Collectors.toList()));
        System.out.println(delitele(IntStream.range(0,100)));
        System.out.println(najvyssiaCifra(IntStream.range(0,100).boxed().collect(Collectors.toList())));
    }
}
