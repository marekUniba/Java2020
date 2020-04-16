package Lukas;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class TestGraf {
    @BeforeClass
    public static void initScoring() {
    }

    Graf g1 = new Graf(
            Map.of(
                    "q0",
                    Map.of('a', "q0", 'b', "q1"),
                    "q1",
                    Map.of('b', "q1", 'a', "q0")));
    Graf g2 = new Graf(
            Map.of(
                    "q0",
                    Map.of('a', "q0", 'b', "q1")));
    Graf g3 = new Graf(
            Map.of(
                    "q0",
                    Map.of('x', "q0")));
    Graf g4 = new Graf(
            Map.of(
                    "q0",
                    Map.of('a', "q0", 'b', "q0")));
    Graf du3 = new Graf(Map.of(
            "a",
            Map.of('0', "b", '1', "a"),
            "b",
            Map.of('0', "b", '1', "c"),
            "c",
            Map.of('0', "d", '1', "a"),
            "d",
            Map.of('0', "d", '1', "d")
    ));
    List<Graf> tests = List.of(g1, g2, g3, g4, du3);

    @Test
    public void testsimuluj() {
        List<String> res = Arrays.asList(new String[]{"q0", "q1", "a", "q0", "q0", null, "q1", "q1", null, "q1", "q1", null, "q0", "q0", null, null, null, null, "q0", "q0", null, "q0", "q1", "a", "q0", null, null, "q1", null, null, null, null, null, null, null, null, null, null, null, "q0", null, null, "q0", "q1", "a", null, null, null, null, null, null, null, null, null, null, null, null, "q0", null, null, null, null, null, "q0", "q1", "a", "q0", null, null, "q0", null, null, "q0", null, null, "q0", null, null, null, null, null, "q0", null, null, "q0", "q1", "a", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null});
        int i = 0;
        for (Graf g : tests) {
            for (String path : List.of("", "a", "ab", "bb", "abba", "x", "aaaaaaaa")) {
                for (String vychodzi : List.of("q0", "q1", "a")) {
                    assertEquals("simuluj " + g + ", vychodzi: " + vychodzi + ", cesta: " + path,
                            res.get(i++), g.simuluj(vychodzi, path));
                }
            }
        }
    }

    @Test
    public void testmenaVrcholov() {
        List<List<String>> res = List.of(
                List.of("q1", "q0"),
                List.of("q1", "q0"),
                List.of("q0"),
                List.of("q0"),
                List.of("a", "b", "c", "d")
        );
        int i = 0;
        for (Graf g : tests) {
            assertArrayEquals("menaVrcholov " + g, res.get(i++).toArray(new String[0]),
                    g.menaVrcholov().toArray(new String[0]));
        }
    }

    @Test
    public void testmenaHran() {
        List<List<Character>> res = List.of(
                List.of('a', 'b'),
                List.of('a', 'b'),
                List.of('x'),
                List.of('a', 'b'),
                List.of('0', '1')
        );
        int i = 0;
        for (Graf g : tests) {
            assertArrayEquals("menaHran " + g, res.get(i++).toArray(new Character[0]),
                    g.menaHran().toArray(new Character[0]));
        }
    }
}