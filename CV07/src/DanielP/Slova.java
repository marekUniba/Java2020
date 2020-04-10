package DanielP;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.math.*;

public class Slova {

    public static List<String> slova(int n) {
        List<String> result = new ArrayList<>();
        if(n == 0) {return new ArrayList<>(List.of(""));}
        result = IntStream.range(0, (int) Math.pow(2,n)).mapToObj(num -> {
            var words = new Object() {
                String word = Integer.toBinaryString(num);
                String prefix = "";
            };
            IntStream.range(0,n-words.word.length()).forEach(number -> words.prefix +="0");
            words.word = words.prefix + words.word;
            return words.word;
        }).collect(Collectors.toList());
        return result;
    }


    // pri slovaStream to bolo zakazane. Ale naopak to plati tiez ? Ak ano nevadi, aspon som skusil :)
    public static List<String> slova(int n, String abeceda) {
        return slovaStream(n,abeceda).collect(Collectors.toList());
    }


    public static String insert(int i, String s,String abeceda) {
        return abeceda.toCharArray()[i] + s;
    }


    public static Stream<String> slovaStream(int n, String abeceda) {
        if (n == 0) { return Stream.of(""); }
        else {
            return slovaStream(n-1,abeceda).flatMap(s -> IntStream.range(0,abeceda.length()).mapToObj(i -> insert(i,s,abeceda)));
        }
    }

    public static Stream<String> slovaKratsieStream(int n, String abeceda) {
        if(n == 0) {return Stream.of("");}
        return Stream.concat(slovaStream(n,abeceda),slovaKratsieStream(n-1,abeceda));

    }

    public static void main(String[] args) {
        System.out.println(slova(1,"abc"));
        System.out.println(slovaStream(1,"abc").collect(Collectors.toList()));
        System.out.println(slovaKratsieStream(2,"abc").collect(Collectors.toList()));
    }
}
