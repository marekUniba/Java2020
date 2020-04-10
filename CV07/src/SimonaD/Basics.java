package SimonaD;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Basics {

    static Collector<Object, ?, List<Object>> toList = Collectors.toList();

    public static void main(String[] args) {
        System.out.println(" Delitelne");
        delitele23456789(IntStream.range(1, 10000))  // vyrobim si stream cisel 1..9999, poslem ho do funkcie delitelne
                .forEach(System.out::println);       // s kazdym prvkom vo vysledom streame spravim System.out.println(prvok)
        // prve je okolo 2500, potom okolo 5000

        System.out.println("\n Dokonale");
        dokonale(IntStream.range(1, 1000))
                .forEach(System.out::println);

        System.out.println("\n Prepona");
        prepona(IntStream.range(1, 30))
                .forEach(System.out::println);
        // 5, 10, 13, 15, 17, ...

        System.out.println("\n Dobre uzatvorkovane");
        dobreUzatvorkovane(Stream.of("()()()", "", "((()))()", "())(()", "()(()", "()())"))
                .forEach(System.out::println);  // maju sa vypisat iba dobre uzatvorkovane vyrazy, teda prve tri

        System.out.println("\n Abeceda stream");
        List<String> words = List.of("ahoj", "hello", "aloha", "bye bye", "bon jour", "zdrastvuj", "dobry den", "nazdar", "guten tag", "good morning");
        abecedaStream(words).forEach(s -> System.out.println(s.collect(toList)));

        System.out.println("\n Abeceda mapa");
        abecedaMap(words).forEach((k, v) -> System.out.println(k + ": " + v.collect(toList)));
    }


    public static IntStream delitele23456789(IntStream input) {
        return input.filter(dva -> dva%2520==0);
    }

    public static IntStream dokonale(IntStream input) {
        IntPredicate dokonale = n -> IntStream.range(1, n).filter(d -> n%d == 0).sum() == n;
        return input.filter(dokonale);
    }

    public static IntStream prepona(IntStream input) {
        IntPredicate jeStvorec = n -> Math.sqrt(n)==Math.floor(Math.sqrt(n));
        // System.out.println("Je 144 stovrec? Malo by byt true, je " + jeStvorec.test(144));
        // System.out.println("Je 97 stovrec? Malo by byt false, je " + jeStvorec.test(97));

        IntPredicate prepona = c -> IntStream.range(1, c)
                .filter(b -> Math.sqrt(Math.pow(c, 2) - Math.pow(b, 2)) == Math.floor(Math.sqrt(Math.pow(c, 2) - Math.pow(b, 2)))).count() != 0;
        // System.out.println("Je 13 prepona? Malo by byt true, je " + prepona.test(13));
        // System.out.println("Je 9 prepona? Malo by byt false, je " + prepona.test(9));

        return input.filter(prepona);
    }

    public static Stream<String> dobreUzatvorkovane(Stream<String> input) {
        Predicate<String> jeOK = str -> str.chars().boxed()
                .reduce(0, (sucet, zatvorka) -> zatvorka == '(' && sucet >= 0 ? ++sucet : --sucet) == 0;
        return input.filter(jeOK);
    }

    public static Stream<Stream<String>> abecedaStream(List<String> words) {

        Stream<String> abeceda = IntStream.range('a', 'z'+1).mapToObj(i -> (char)i + "");
        // Ak je nasledujuci riadok aktivny, tak pri dalsej praci s 'abeceda' vam to padne.
        // Ak ste teda dobre vygenerovali abecedu, zakomentujte/zmazte tento vypis.
        // System.out.println(abeceda.collect(Collectors.toList()));

        return abeceda.map(a -> words.stream().filter(s -> s.startsWith(a)));
    }

    public static Map<String, Stream<String>> abecedaMap(List<String> words) {
        Stream<String> abeceda = IntStream.range('a', 'z'+1).mapToObj(i -> (char)i + "");
        return abeceda.collect(Collectors.toMap(s -> s, a -> words.stream().filter(s -> s.startsWith(a))));
    }
}
