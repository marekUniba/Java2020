package Jozo;
import java.util.*;
import java.util.function.Function;
import java.util.stream.*;

import static java.util.stream.Collectors.*;
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
        // return null;
        return IntStream.range(-n, n+1)
                .boxed()
                .sorted(Comparator.comparingInt(Math::abs))
                .mapToInt(i -> i);
    }

    /**
     * @return - prefiltruje input stream a vysledkom su len prvocisla v tom istom poradi
     * prvocislo je prirodzene cislo > 1, ktore nema delitela
     */
    public static IntStream prvocisla(IntStream input) {
       // return null;
        return input.filter(n -> IntStream.range(2,n).filter(i->n%i == 0).sum() == 0);
    }
    public static Map<Integer, Long> najvyssiaCifra(List<Integer> vstup) {
        //return null;
        return List.of('1', '2', '3', '4', '5', '6', '7', '8', '9')
                .stream()
                .collect(Collectors.toMap(Character::getNumericValue, x ->vstup.stream().filter(v -> v.toString().charAt(0) == x).count()));
    }
    /**
     * @return - pre prvky x streamu input vyrobi mapu, ktorej x je klucom a
     * hodnotou je zoznamj jeho delitelov z intervalu 1..x,
     * 1 je prvy prvok, a x je urcite posledny vysledneho prvok zoznamu
     */
    public static Map<Integer, List<Integer>> delitele(IntStream input) {
        //return null;
        return  input
                .boxed()
                .collect(Collectors.toMap(x -> x, Streams::factors));
    }

    public static List<Integer> factors(int number){
        return IntStream.range(1, number+1)
                .boxed()
                .filter(v -> number%v == 0)
                .collect(Collectors.toList());
    }
}
