package Juraj;

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
//        dobreUzatvorkovane(Stream.of("((()))()", "())(()", "()(()", "()())")).forEach(System.out::println);
        List<String> words = List.of("ahoj", "hello", "aloha", "bye bye", "bon jour", "zdrastvuj");

        abecedaStream(words).forEach(s -> System.out.println(s.collect(toList)));
        System.out.println("----------");

        abecedaMap(words).forEach((k, v) -> System.out.println(k + ": " + v.collect(toList)));
    }

    public static IntStream delitele23456789(IntStream input){
  //      return input.filter(n -> IntStream.range(2, 10).anyMatch(d -> n%d == 0));
        return input.filter(n -> IntStream.range(2, 10).allMatch(d -> n%d == 0));
    }

    public static IntStream dokonale(IntStream input) {
        IntPredicate dokonale = n -> IntStream.range(1, n).filter(d -> n%d == 0).sum() == n;
        return input.filter(dokonale);
    }

    public static IntStream prepona(IntStream input) {
        IntPredicate jeStvorec = n -> Math.sqrt(n) == (int)Math.sqrt(n);
        IntPredicate prepona = c -> IntStream.range(1, c).anyMatch(a -> jeStvorec.test(c*c - a*a));
        return input.filter(prepona);
    }

    public static Stream<String> dobreUzatvorkovane(Stream<String> input) {
        Predicate<String> jeOK = str -> str.chars().boxed().reduce(0,
                (count, ch) -> {
                    if(ch == '(') return count + 1;
                    if(count <= 0) return - str.length();
                    else return count - 1;
                }
        ) == 0;
        return input.filter(jeOK);
    }

    public static Stream<Stream<String>> abecedaStream(List<String> words){
        Stream<String> abeceda = IntStream.range('a', 'z'+1).mapToObj(s -> ""+(char)s);
        return abeceda.map(a -> words.stream().filter(str -> str.startsWith(a)));
    }

//    public static Stream<Stream<String>> prefixyStream(List<String> words){
//        return words.stream().map(prefix -> words.stream().filter(str -> str.startsWith(prefix)));
//    }

    public static Map<String, Stream<String>> abecedaMap(List<String> words){
        Stream<String> abeceda = IntStream.range('a', 'z'+1).mapToObj(s -> ""+(char)s);
        return abeceda.collect(Collectors.toMap(k -> k, v -> words.stream().filter(str -> str.startsWith(v))));
    }
}
