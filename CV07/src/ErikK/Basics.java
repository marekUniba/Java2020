package ErikK;

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
        return input.filter(p -> p % (2*2*2*3*3*5*7) == 0);
    }

    public static IntStream dokonale(IntStream input) {
        IntPredicate dokonale = c -> c != 1 && IntStream
                .range(1, (int) Math.sqrt(c) + 1)
                .filter(p -> c % p == 0)
                .map(p -> (c / p != p && p != 1) ? p + c / p : p)
                .sum() == c;
        return input.filter(dokonale);
    }

    public static IntStream prepona(IntStream input) {
        IntPredicate jeStvorec = c -> Math.pow(((int)Math.sqrt(c)), 2) == c;
        IntPredicate prepona = c -> IntStream
                .range(1, c)
                .filter(n -> jeStvorec.test((int)(Math.pow(c, 2 ) - Math.pow(n, 2))))
                .count() != 0;
        return input.filter(prepona);
    }

    public static Stream<String> dobreUzatvorkovane(Stream<String> input) {
        Predicate<String> jeOK = str -> str.chars()
                .boxed()
                .reduce(0, (sum, p) -> p == '(' ? (sum < 0 ? sum :sum + 1 ) : sum - 1) == 0;
        return input.filter(jeOK);
    }

    public static Stream<Stream<String>> abecedaStream(List<String> words) {
        Stream<String> abeceda = IntStream.range('a', 'z' + 1).mapToObj(s -> String.valueOf((char)s));
        return abeceda.map(s1 -> words.stream().filter(s2 -> s2.charAt(0) == s1.charAt(0)));
    }

    public static Map<String, Stream<String>> abecedaMap(List<String> words) {
        Stream<String> abeceda = IntStream.range('a', 'z' + 1).mapToObj(s -> String.valueOf((char)s));
        return abeceda.collect(Collectors.toMap(s -> s, s -> words.stream().filter(s2 -> s2.charAt(0) == s.charAt(0))));
    }
}