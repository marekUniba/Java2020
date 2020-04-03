/*import java.util.*;

public class FaceHookMY<E> {
    HashMap<E,HashSet<E>> g;	            // reprezentacia grafu
    public FaceHookMY() {
        g = new HashMap<E,HashSet<E>>();
    }
    @Override
    public String toString() {
        return g.toString();
    }

    public void blizkiPriatelia_(E meno1, E meno2) {
        if (meno1.equals(meno2))
            return;
        HashSet<E> blizkiPriatelia = g.get(meno1);
        if (blizkiPriatelia == null)
            blizkiPriatelia = new HashSet<E>();
        blizkiPriatelia.add(meno2);
        g.put(meno1,blizkiPriatelia);
    }
    public void blizkiPriatelia(E meno1, E meno2) {
        blizkiPriatelia_(meno1, meno2);
        blizkiPriatelia_(meno2, meno1);
    }
    public Set<E> vsetci() {
        return g.keySet();
    }
    public int pocetPriatelov(E meno) {
        HashSet<E> blizkiPriatelia = g.get(meno);
        return (blizkiPriatelia == null)?0:blizkiPriatelia.size();
    }
    public int spolocniPriatelia(E meno1, E meno2) {
        HashSet<E> blizkiPriatelia1 = g.get(meno1);
        HashSet<E> blizkiPriatelia2 = g.get(meno2);
        if (blizkiPriatelia1 == null || blizkiPriatelia2 == null)
            return 0;
        else {
            blizkiPriatelia1.retainAll(blizkiPriatelia2);
            return blizkiPriatelia1.size();
        }
    }
    public boolean vzdialenyPriatel(E meno1, E meno2) {
        HashSet<E>visited = new HashSet<>();
        visited.add(meno1);
        List<E> queue = new ArrayList<>();
        queue.add(meno1);
        while (queue.size() > 0) {
            E first = queue.remove(0);
            if (first.equals(meno2))
                return true;
            if (g.get(first) != null)
                for(E next : g.get(first)) {
                    if (!visited.contains(next)) {
                        visited.add(next);
                        queue.add(next);
                    }
                }
        }
        return false;
    }
    public static void main(String[] args) {
        {   // FaceHook<String>
            FaceHookMY<String> fk = new FaceHookMY<>();
            fk.blizkiPriatelia("a", "b");
            fk.blizkiPriatelia("a", "c");
            fk.blizkiPriatelia("e", "f");
            System.out.println(fk);                                  // nejaká reprezentacia grafu
            System.out.println(fk.vsetci());                         // nejaká permutácia "a","b","c","e","f"
            System.out.println(fk.pocetPriatelov("c"));        // 1
            System.out.println(fk.pocetPriatelov("a"));        // 2
            System.out.println(fk.spolocniPriatelia("b", "c"));     // 1
            System.out.println(fk.vzdialenyPriatel("b", "c"));      // true
            System.out.println(fk.vzdialenyPriatel("a", "e"));      // false
        }
        {   // FaceHook<Objekt>
            FaceHookMY<Objekt> fk = new FaceHookMY<>();
            Objekt a = new Objekt(1, "a", "a", 18);
            Objekt b = new Objekt(2, "b", "b", 19);
            Objekt c = new Objekt(3, "c", "c", 20);
            Objekt d = new Objekt(4, "d", "d", 21);
            Objekt e = new Objekt(5, "e", "e", 22);
            Objekt f = new Objekt(6, "f", "f", 23);

            Objekt aa = new Objekt(1, "a", "a", 18);
            Objekt bb = new Objekt(2, "b", "b", 19);
            Objekt cc = new Objekt(3, "c", "c", 20);
            Objekt dd = new Objekt(4, "d", "d", 21);
            Objekt ee = new Objekt(5, "e", "e", 22);
            Objekt ff = new Objekt(6, "f", "f", 23);

            fk.blizkiPriatelia(a, b);
            fk.blizkiPriatelia(a, c);
            fk.blizkiPriatelia(e, f);
            System.out.println(fk);                                 // nejaká reprezentacia grafu
            System.out.println(fk.vsetci());                        // nejaká permutácia "a","b","c","e","f"
            System.out.println(fk.pocetPriatelov(cc));              // 1
            System.out.println(fk.pocetPriatelov(aa));              // 2
            System.out.println(fk.spolocniPriatelia(bb, cc));       // 1
            System.out.println(fk.vzdialenyPriatel(bb, cc));        // true
            System.out.println(fk.vzdialenyPriatel(aa, ee));        // false
        }
    }
}
*/