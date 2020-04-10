import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Slova {
    public static List<String> slova(int n) {
        return
            IntStream.range(1<<n,2<<n)  // riesenie venujem Jurajovi :)
                    .mapToObj(i ->Integer.toBinaryString(i).substring(1))
                    .collect(Collectors.toList());
    }
    public static List<String> slova(int n, String abeceda) {
        if (n == 0)
            return Arrays.asList(""); // epsilon
        else {
            List<String> res = new ArrayList<>();
            for(String s : slova(n-1, abeceda))
                for (char ch : abeceda.toCharArray())
                    res.add(s + ch);
            return res;
        }
    }

    public static Stream<String> slovaStream(int n, String abeceda) {
        return (n == 0)?
            Stream.of("") // epsilon
            :
            slovaStream(n-1, abeceda)
                    .flatMap(s -> abeceda.chars().mapToObj(c -> (char) c)
                                .flatMap(ch -> Stream.of(s + ch)));
    }

    public static Stream<String> slovaKratsieStream(int n, String abeceda) {
            return //IntStream.range(0,n+1).boxed()
                    Stream.iterate(0, i->i+1).limit(n+1)
                            .flatMap(i -> slovaStream(i, abeceda));
    }

    public static void main(String[] args) {
//        System.out.println(oslovaStream(1, "a").collect(Collectors.toList()));
        for(int n = 1; n < 5; n++) {
            System.out.println(slova(n));
            System.out.println(slova(n, "abc"));
            System.out.println(slovaStream(n, "a").collect(Collectors.toList()));
            System.out.println(slovaStream(n, "a").count());
            System.out.println(slovaKratsieStream(n, "abc").collect(Collectors.toList()));
            System.out.println(slovaKratsieStream(n, "abc").count());
        }
    }
}
