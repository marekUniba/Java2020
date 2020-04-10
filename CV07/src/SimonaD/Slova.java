package SimonaD;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Slova {

    public static List<String> slova(int n) {
        return slovaStream(n, "01").collect(Collectors.toList());
    }

    public static List<String> slova(int n, String abeceda) {
        return slovaStream(n, abeceda).collect(Collectors.toList());
    }

    public static Stream<String> slovaStream(int n, String abeceda) {
        if (n == 0) {
            return Stream.of("");
        } else {
            return abeceda.chars()
                    .boxed()
                    .map(c -> (char) (int) c)
                    .map(c -> slovaStream(n - 1, abeceda)
                            .map(s -> s + c))
                    .flatMap(s -> s);
        }
    }

    public static Stream<String> slovaKratsieStream(int n, String abeceda) {
        return IntStream.range(0, n+1)
                .boxed()
                .map(i -> slovaStream(i, abeceda))
                .flatMap(s -> s);
    }
}
