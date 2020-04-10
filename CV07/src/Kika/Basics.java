package Kika;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Basics {

    public static IntStream delitele23456789(IntStream input) {
        return input.filter(x -> IntStream.range(2, 10).allMatch(i -> x % i == 0));
    }

    public static IntStream dokonale(IntStream input) {
        IntPredicate dokonale = x -> IntStream.range(1, x).filter(i -> x % i == 0).sum() == x;
        return input.filter(dokonale);
    }

    public static IntStream prepona(IntStream input) {
        IntPredicate jeStvorec = a -> (int) Math.sqrt(a) * (int) Math.sqrt(a) == a;
        IntPredicate prepona = c -> IntStream.range(1, c-1).anyMatch(b -> jeStvorec.test(c * c - b * b));
        return input.filter(prepona);
    }

    public static Stream<String> dobreUzatvorkovane(Stream<String> input) {
        Predicate<String> jeOK = str -> str.chars().boxed().reduce(0, (a,b) -> {
            if (b == '(') a++;
            if (b == ')') a--;
            if (a < 0) a = Integer.MIN_VALUE;
            return a;
        }) == 0;
        return input.filter(jeOK);
    }

    public static Stream<Stream<String>> abecedaStream(List<String> words) {
        Stream<Character> abeceda = Stream.iterate('a', i -> ++i).limit(26);
        return abeceda.map(ch -> words.stream().filter(x -> x.charAt(0) == ch));
    }

    public static Map<String, Stream<String>> abecedaMap(List<String> words) {
        Stream<Character> abeceda = Stream.iterate('a', i -> ++i).limit(26);
        return abeceda.collect(Collectors.toMap(ch -> ch.toString() , ch -> words.stream().filter(x -> x.charAt(0) == ch)));
    }

    public static void main(String[] args) {
//        for (int m = 0; m <Integer.MAX_VALUE; m++) {
//            IntPredicate jeStvorec1 = n -> Math.sqrt(n) - Math.floor(Math.sqrt(n)) == 0;
//            IntPredicate jeStvorec = n -> Math.abs(Math.floor(Math.sqrt(n)) - Math.sqrt(n)) < 0.000001;
//            if (jeStvorec.test(m) != jeStvorec1.test(m))
//                System.out.println("kontrepriklad " + m);
//        }
        System.out.println(
                delitele23456789(IntStream.range(0,10000)).boxed().collect(Collectors.toList())
        );
        System.out.println(
                delitele23456789(
                        Stream
                                .iterate(0, i->i+4)
                                .limit(10000)
                                .mapToInt(e -> (int)e)
                ).boxed().collect(Collectors.toList())
        );
//        System.out.println(
//                dokonale(IntStream.range(0,10000)).boxed().collect(Collectors.toList())
//        );
//        System.out.println(
//                prepona(IntStream.range(0,10000)).boxed().collect(Collectors.toList())
//        );
//        System.out.println(
//                dobreUzatvorkovane(Stream.of("()", ")(", "(()")).collect(Collectors.toList())
//        );
////
//        abecedaMap(words).forEach((k, v) -> System.out.println(k + ": " + v.collect(toList)));
//        // "a": ["ahoj", "aloha"]
//        // "b": ["bye bye", "bon jour"]
//        // "c": ...

        System.out.println("\n Abeceda stream");
        List<String> words = Arrays.asList("ahoj", "hello", "aloha", "bye bye", "bon jour", "zdrastvuj", "dobry den", "nazdar", "guten tag", "good morning");
        abecedaStream(words).forEach(s -> System.out.println(s.collect(Collectors.toList())));

    }

}
