package SamuelP;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Slova {

    static void vytvorSlovo(List<String> slova, char[] set, String prefix, int n, int k) {  //https://www.geeksforgeeks.org/print-all-combinations-of-given-length/
        if (k == 0) {
            slova.add(prefix);
            return;
        }
        for (int i = 0; i < n; ++i) {
            String newPrefix = prefix + set[i];
            vytvorSlovo(slova,set, newPrefix, n, k - 1);
        }
    }


    public static List<String> slova(int n) {
       // List<String> slova = new ArrayList<>();
       // vytvorSlovo(slova, new char[]{'0', '1'},"",2,n);
       // return slova;
        return slova(n,"01");
    }

    public static List<String> slova(int n, String abeceda) {
        List<String> slova = new ArrayList<>();
        vytvorSlovo(slova,abeceda.toCharArray(),"",abeceda.length(),n);
        return slova;
    }

    public static Stream<String> slovaStream(int n, String abeceda) {
        return (n == 0)?Stream.of(""):
                slovaStream(n-1, abeceda).flatMap(s -> abeceda.chars().mapToObj(c -> s + (char) c));
    }

    public static Stream<String> slovaKratsieStream(int n, String abeceda) {
        return n == 0 ? slovaStream(n, abeceda) : Stream.concat(slovaStream(n, abeceda),slovaKratsieStream(n-1, abeceda));
    }

    public static void main(String[] args)
    {
       // System.out.println(slova(3));
        System.out.println(slovaKratsieStream(3,"abc").collect(Collectors.toList()));

    }

}


