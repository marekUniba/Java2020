package Kika;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Slova {

    public static List<String> slova(int n) {
        if (n <= 0)
            return Stream.of("").collect(Collectors.toList());
        List<String> kratsieSlova = slova(n-1);
        List<String> result = Stream.of('0', '1').flatMap(x -> kratsieSlova.stream().map(y -> x + y)).collect(Collectors.toList());
//        System.out.println(n + ": " + result);
        return result;
    }

    public static List<String> slova(int n, String abeceda) {
        if (n <= 0)
            return Stream.of("").collect(Collectors.toList());
        List<String> kratsieSlova = slova(n-1, abeceda);
        List<String> result = abeceda.chars().mapToObj(c -> (char) c).flatMap(x -> kratsieSlova.stream().map(y -> x + y)).collect(Collectors.toList());
//        System.out.println(n + ": " + result);
        return result;
    }

    public static Stream<String> slovaStream(int n, String abeceda) {
        return (n <= 0) ? Stream.of("") : abeceda.chars().mapToObj(c -> (char) c).flatMap(x -> slovaStream(n-1, abeceda).map(y -> x + y));
    }

    public static Stream<String> slovaKratsieStream(int n, String abeceda) {
        return IntStream.range(0, n+1).mapToObj(i -> Integer.valueOf(i))
                .flatMap(i -> slovaStream(i, abeceda));
    }

    public static void main(String[] args) {
        for(int n = 0; n < 5; n++) {
            System.out.println();
            System.out.println(n);
            System.out.println(slova(n));
            System.out.println(slova(n, "abc"));
            System.out.println(slovaStream(n, "abc").collect(Collectors.toList()));
            System.out.println(slovaStream(n, "abc").count());
            System.out.println(slovaKratsieStream(n, "abc").collect(Collectors.toList()));
            System.out.println(slovaKratsieStream(n, "abc").count());
        }
    }

}
