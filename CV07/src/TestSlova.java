import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import LISTTestScoring.LISTTestScoring;

import static org.junit.Assert.*;

public class TestSlova {
    private static LISTTestScoring scoring = null;
    @BeforeClass
    public static void initScoring() {
        scoring = new LISTTestScoring();
        scoring.setScore("lang:common_list_test_scoring_name", 0, 100);
    }

    @Test
    public void slova() {
        for(int i = 0; i < 15; i++) {
            List<String> myres =myslova(i); myres.sort(String::compareTo);
            List<String> res = Slova.slova(i); res.sort(String::compareTo);
            assertArrayEquals("slova 0,1", myres.toArray(new String[0]), res.toArray(new String[0]));
        }
        scoring.updateScore("lang:common_list_test_scoring_name", 25);
    }

    @Test
    public void testSlova() {
        for(int i = 0; i < 15; i++) {
            for (int j = 1; i < 6; i++) {
                String abeceda = "abcdefgh".substring(0, j);
                List<String> myres = myslova(i, abeceda);
                myres.sort(String::compareTo);
                List<String> res = Slova.slova(i, abeceda);
                res.sort(String::compareTo);
                assertArrayEquals("slova dlzky " + i + " nad abecdou " + abeceda,
                        myres.toArray(new String[0]), res.toArray(new String[0]));
            }
        }
        scoring.updateScore("lang:common_list_test_scoring_name", 25);
    }

    @Test
    public void slovaStream() {
        for(int i = 0; i < 15; i++) {
            for (int j = 1; i < 6; i++) {
                String abeceda = "abcdefgh".substring(0, j);
                List<String> myres = myslovaStream(i, abeceda).collect(Collectors.toList());
                myres.sort(String::compareTo);
                List<String> res = Slova.slovaStream(i, abeceda).collect(Collectors.toList());
                res.sort(String::compareTo);
                assertArrayEquals("slovaStream dlzky " + i + " nad abecdou " + abeceda,
                        myres.toArray(new String[0]), res.toArray(new String[0]));
            }
        }
        scoring.updateScore("lang:common_list_test_scoring_name", 25);
    }

    @Test
    public void slovaKratsieStream() {
        for(int i = 0; i < 15; i++) {
            for (int j = 1; i < 6; i++) {
                String abeceda = "abcdefgh".substring(0, j);
                List<String> myres = myslovaKratsieStream(i, abeceda).collect(Collectors.toList());
                myres.sort(String::compareTo);
                List<String> res = Slova.slovaKratsieStream(i, abeceda).collect(Collectors.toList());
                res.sort(String::compareTo);
                assertArrayEquals("slovaStream dlzky " + i + " nad abecdou " + abeceda,
                        myres.toArray(new String[0]), res.toArray(new String[0]));
            }
        }
        scoring.updateScore("lang:common_list_test_scoring_name", 25);
    }

    public static List<String> myslova(int n) {
        return
                IntStream.range(1<<n,2<<n)  // riesenie venujem Jurajovi :)
                        .mapToObj(i ->Integer.toBinaryString(i).substring(1))
                        .collect(Collectors.toList());
    }
    public static List<String> myslova(int n, String abeceda) {
        if (n == 0)
            return Arrays.asList(""); // epsilon
        else {
            List<String> res = new ArrayList<>();
            for(String s : myslova(n-1, abeceda))
                for (char ch : abeceda.toCharArray())
                    res.add(s + ch);
            return res;
        }
    }
    public static Stream<String> myslovaStream(int n, String abeceda) {
        return (n == 0)?
                Stream.of("") // epsilon
                :
                myslovaStream(n-1, abeceda)
                        .flatMap(s -> abeceda.chars().mapToObj(c -> (char) c)
                                .flatMap(ch -> Stream.of(s + ch)));
    }
    public static Stream<String> myslovaKratsieStream(int n, String abeceda) {
        return //IntStream.range(0,n+1).boxed()
                Stream.iterate(0, i->i+1).limit(n+1)
                        .flatMap(i -> myslovaStream(i, abeceda));
    }
}