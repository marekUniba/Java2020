package DanielT;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class TestOpravMa {
    @BeforeClass
    public static void initScoring() {
    }

    Random rnd = new Random();

    @Test
    public void testUloha1() {
        for (int pokus = 0; pokus < 1000; pokus++) {
            int[] s = randomIntArray();
            int[] r = Arrays.copyOf(s, s.length);
            OpravMa.Uloha1(s);
            int min = Integer.MIN_VALUE;
            for (int i = 0; i < s.length; i++)
                if (min <= s[i])
                    min = s[i];
                else
                    fail("pole nie je utriedene");
            Arrays.sort(s);
            Arrays.sort(r);
            assertArrayEquals("vysledne pole ma ine hodnoty ako povodne", r, s);
        }
    }

    @Test
    public void testUloha2() {
        String[][] matrix = OpravMa.Uloha2(randomString());
        assertEquals("[0][0]=[1][0]", matrix[0][0], matrix[1][0]);
        matrix[0][0] = randomString();
        assertNotEquals("[0][0] a [1][0] musia byt rozne, lenze nie su :(", matrix[0][0], matrix[1][0]);
    }

    @Test
    public void testUloha3() {
// make this test great again
//        assertEquals("psicek poslucha", Psicek.a, Zviera.a);
//        assertNotEquals("macicka neposlucha", Macicka.a, Zviera.a);
//        Zviera[] zoo = new Zviera[]{ new Psicek(), new Macicka() };
//        assertEquals("zvuky ",2, Stream.of(zoo).map(z->z.sound()).distinct().count());
    }

    @Test
    public void testUloha4() {
// make this test great again
        List<Zajac> ls = List.of(new Zajac(1), new Zajac(2), new Zajac(1), new Zajac(2));
        TreeSet<Zajac> ts = new TreeSet(ls);
        HashSet<Zajac> hs = new HashSet<>(ls);
        assertEquals("len dvaja", 2, ts.size());
        assertEquals("mensi ", new Zajac(1), ts.first());
        assertEquals("vacsi ", new Zajac(2), ts.last());
        assertEquals("len dvaja", 2, hs.size());
    }

    @Test
    public void testUloha5() {
        try {
            OpravMa.Uloha5(null);
            fail("mala byt throw new Exception()");
        } catch (Exception e) {
            // looks ok
        }
        try {
            OpravMa.Uloha5(new int[0]);
            fail("mala byt throw new Exception()");
        } catch (Exception e) {
            // looks ok
        }
        try {
            OpravMa.Uloha5(new int[]{1});
        } catch (Exception e) {
            fail("nemala byt Exception()");
        }
    }

    private String randomString() {
        return Integer.toHexString(rnd.nextInt());
    }

    private int[] randomIntArray() {
        int len = 1 + rnd.nextInt(100);
        int[] s = new int[len];
        for (int i = 0; i < len; i++) s[i] = rnd.nextInt(255);
        return s;
    }
}