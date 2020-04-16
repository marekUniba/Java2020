package FilipL;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class TestNode {
    @BeforeClass
    public static void initScoring() {
    }

    Node<Integer> t1 = new Node<>(null, 1, null);
    Node<Integer> t2 = new Node<>(t1, 2, t1);
    Node<Integer> t3 = new Node<>(t1, 3, null);
    Node<Integer> t4 = new Node<>(t2, 4, t3);

    Node<Integer> obr1 = new Node<>(new Node<>(new Node<>(null,6,null),2,new Node<>(null,1,null)), 4, new Node<>(null,7,new Node<>(null,9,null)));
    Node<Integer> obr2 = new Node<>(new Node<>(new Node<>(null,6,null),2,new Node<>(null,1,null)), 4, new Node<>(null,7, null));
    Node<Integer> obr3 = new Node<>(new Node<>(null,2,null), 4, new Node<>(new Node<>(null,6,null),7, new Node<>(null,1,null)));
    Node<Integer> obr4 = new Node<>(new Node<>(null,2,null), 4, new Node<>(null,7, new Node<>(null,1,new Node<>(null,6,null))));
    Node<Integer> obr5 = new Node<>(new Node<>(null, 1, new Node<>(null, 2, null)), 3, new Node<>(new Node<>(null, 6, null), 8, new Node<>(null, 9, null)));
    Node<Integer> obr6 = new Node<>(new Node<>(new Node<>(null, 1, null), 1, new Node<>(null, 2, null)), 3, new Node<>(new Node<>(null, 6, null), 8, new Node<>(null, 9, null)));
    Node<Integer> obr7 = new Node<>(new Node<>(new Node<>(null, 1, null), 2, new Node<>(null, 2, null)), 3, new Node<>(new Node<>(null, 6, null), 8, new Node<>(null, 9, null)));

    List<Node<Integer>> tests = List.of(t1, t2, t3, t4, obr1, obr2, obr3, obr4, obr5, obr6, obr7);

    @Test
    public void testhodnotyVlistoch() {
        List<List<Integer>> results =
                List.of(List.of(1), List.of(1,1), List.of(1), List.of(1,1,1),
                        List.of(6,1,9), List.of(6,1,7), List.of(2,6,1), List.of(2,6),
                        List.of(2,6,9), List.of(1,2,6,9), List.of(1,2,6,9)
                );
        int i = 0;
        for(Node<Integer> t : tests) {
            List<Integer> r1 = new ArrayList<>(results.get(i++)); r1.sort(Integer::compareTo);
            List<Integer> r2 = new ArrayList<>(t.hodnotyVlistoch()); r2.sort(Integer::compareTo);
            assertArrayEquals("hodnotyVListoch " + t,
                  r1.toArray(new Integer[0]), r2.toArray(new Integer[0]));
        }
    }

    @Test
    public void testuplny() {
        List<Boolean> results =
                List.of(true, true, false, false, false, true, true, false, false, true, true);
        int i = 0;
        for(Node<Integer> t : tests) {
            boolean r1 = results.get(i++);
            boolean r2 = t.uplny();
            assertEquals("uplny " + t, r1, r2);
        }
    }

    @Test
    public void testvyvazeny() {
        List<Boolean> results =
                List.of(true, true, true, true, true,true,true, false, true, true, true);
        int i = 0;
        for(Node<Integer> t : tests) {
            boolean r1 = results.get(i++);
            boolean r2 = t.vyvazeny();
            assertEquals("vyvazeny " + t, r1, r2);
        }
    }

    @Test
    public void testmnozina() {
        List<Boolean> results =
                List.of(true, false, true, false, false, false, false, false, true, false, false);
        int i = 0;
        for(Node<Integer> t : tests) {
            boolean r1 = results.get(i++);
            boolean r2 = t.mnozina();
            assertEquals("mnozina " + t, r1, r2);
        }
    }
}