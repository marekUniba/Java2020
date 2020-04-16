package Jozo;
import java.util.Arrays;

/**
 *  3.priklad, 5 poduloh, 5 bodov
 */
public class OpravMa {

    /**
     * kod, ktory chcel utriedit pole nejakym sortom, ale netriedi. Opravte ho !
     * Upresnenie: mate najst chybu v tomto kode, opravit ju, a nie napisat Arrays.sort(s).
     * Upresnenie2: Kolekcie ani streamy nie su dovolene v tomto priklade.
     */
    public static void Uloha1(int[] s) {
        /*for(int i = 0; i < s.length; i++)
            // riesenie :
            // for(int j = i+1; j < s.length; j++)
            for(int j = 0; j < s.length; j++)
                if (s[i] > s[j]) {
                    int temp = s[i]; s[i] = s[j]; s[j] = temp;
                }*/
        for(int i = 0; i < s.length; i++)
            for(int j = 0; j < s.length; j++)
                if (s[i] < s[j]) {
                    int temp = s[i]; s[i] = s[j]; s[j] = temp;
                }
    }
    //-----------------------------------------------------------------------
    /**
     * vrati matixu 2x2 s hodnotami a, teda {{a,a}, {a,a}}
     * lenze test pada, opravte Ulohu2, tak aby test nepadal
     *
     * assertEquals("[0][0]=[1][0]", matrix[0][0], matrix[1][0]);
     * String[][] matrix = OpravMa.Uloha2(randomString());
     * matrix[0][0] = randomString();
     * assertNotEquals("ak nemam stastie, tak [0][0] a [1][0] musia byt rozne, lenze nie su :(", matrix[0][0], matrix[1][0]);
     */
    public static String[][] Uloha2(String a) {
        String[] row = new String[]{a,a};
        return new String[][]{row.clone(),row.clone()};
    }
    //-----------------------------------------------------------------------
    // Uloha3: dodefinujte triedy Zviera, Psicek, Macicka, aby presiel tento test
//        assertEquals("psicek poslucha", Psicek.a, Zviera.a);
//        assertNotEquals("macicka neposlucha", Macicka.a, Zviera.a);
//        Zviera[] zoo = new Zviera[]{ new Psicek(), new Macicka() };
//        assertEquals("zvuky ",2, Stream.of(zoo).map(z->z.sound()).distinct().count());

    //-----------------------------------------------------------------------
    // Uloha4: dodefinujte triedu Zajac, aby zbehol tento test:
//        List<Zajac> ls = List.of(new Zajac(1), new Zajac(2), new Zajac(1), new Zajac(2));
//        TreeSet<Zajac> ts = new TreeSet(ls);
//        HashSet<Zajac> hs = new HashSet<>(ls);
//        assertEquals("len dvaja", 2, ts.size());
//        assertEquals("mensi ", new Zajac(1), ts.first());
//        assertEquals("vacsi ", new Zajac(2), ts.last());
//        assertEquals("len dvaja", 2, hs.size());
    //-----------------------------------------------------------------------

    /**
     * ak metoda Uloha5 dostane ako argument null, alebo pole nolovej dlzky, vyhodi Exception("nieco zle")
     */
    public static void Uloha5(int[] a) throws Exception {
        // dodefinujte
        if (a == null || a.length == 0){
            throw new Exception("Smola teda!");
        }
    }
}
