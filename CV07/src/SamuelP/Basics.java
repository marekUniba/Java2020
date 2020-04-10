package SamuelP;

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
        return input.filter(n -> IntStream.range(2,10).allMatch(c -> n % c == 0));
    }
    //input.filter(a -> IntStream.range(2,10).anyMatch(b -> a%10==b)).forEach(System.out::println);
    public static IntStream dokonale(IntStream input) {
        IntPredicate dokonale = n -> IntStream.range(1,n/2+1).filter(a -> n%a ==0).sum() == n;// TODO
        return input.filter(dokonale);
    }

    public static IntStream prepona(IntStream input) {
        IntPredicate jeStvorec = n -> Math.sqrt(n) == (int)Math.sqrt(n); // ak je na druhu
        // System.out.println("Je 144 stovrec? Malo by byt true, je " + jeStvorec.test(144));
        // System.out.println("Je 97 stovrec? Malo by byt false, je " + jeStvorec.test(97));

        IntPredicate prepona = a -> IntStream.range(1,a).anyMatch(b -> jeStvorec.test(a*a - b*b)); // TODO
        // System.out.println("Je 13 prepona? Malo by byt true, je " + prepona.test(13));
        // System.out.println("Je 9 prepona? Malo by byt false, je " + prepona.test(9));

        return input.filter(prepona);
    }

    public static Stream<String> dobreUzatvorkovane(Stream<String> input) {
        Predicate<String> jeOK = str -> str.chars().boxed().reduce(0, (pocet, a) -> { if (a == '(') return pocet + 1;if (pocet <= 0) return -str.length();else return pocet - 1; })== 0;
        return input.filter(jeOK);
    }

    public static Stream<Stream<String>> abecedaStream(List<String> words) {
       // Stream<String> abeceda = IntStream.range('a','z').collect(a->);
        //Stream<String> abeceda = IntStream.rangeClosed('a', 'z').forEach(c -> System.out.println((char)c));
        Stream<String> abeceda = Stream.iterate('a', i -> ++i).limit(26).map(String::valueOf);
       // Stream<String> abeceda = Stream.iterate('a', i ->(char) i + 1).limit(26);z
        return abeceda.map(pis -> words.stream().filter(a -> (a.charAt(0) + "").equals(pis)));


    }

    public static Map<String, Stream<String>> abecedaMap(List<String> words) {
        Stream<String> abeceda = Stream.iterate('a', i -> ++i).limit(26).map(String::valueOf);
        // Stream<String> abeceda = Stream.iterate('a', i ->(char) i + 1).limit(26);z
        return abeceda.collect(Collectors.toMap(pis -> pis, pis -> words.stream().filter(a -> (a.charAt(0) + "").equals(pis))   /* TODO */));
    }
}
