package Kika;

import java.util.*;

public class FaceHook<E> {

    final private HashMap<E, Set<E>> siet;

    //konštruktor
    public FaceHook() {
        this.siet = new HashMap<>();
    }

    //nejaká textová reprezentácia siete priateľov
    public String toString() {
        String out = "";
        for (E elem : siet.keySet()) {
            out += elem.toString() + " " + siet.get(elem).toString() + "\n";
        }
        return out;
    }

    public void pridajMeno(E m) {
        if (this.siet.containsKey(m)) {
            throw new IllegalArgumentException("Vertex already exists.");
        }
        this.siet.put(m, new HashSet<>());
    }

    //pridá informáciu, že meno1 a meno2 sú blízki priatelia, ak sú rôzni, teda platí meno1.equals(meno2)==false.
    // Pozn.: relácia je reflexívna, takže meno je automaticky blízkym priateľom meno.
    // blizkiPriatelia(meno1, meno2) je vlastne neorientovaná hrana medzi vrcholmi meno1 a meno2.
    //pridaj hranu
    public void blizkiPriatelia(E meno1, E meno2) {
        if (!siet.containsKey(meno1))
            pridajMeno(meno1);
        if (!siet.containsKey(meno2))
            pridajMeno(meno2);
        siet.get(meno1).add(meno2);
        siet.get(meno2).add(meno1);
    }

    //vráti množinu všetkých mien osôb/objektov v celom FaceHook, a to bez opakovania.
    // Na poradí prvkov v poli nezáleží. Je to vlastne množina vrcholov grafu.
    public Set<E> vsetci() {
        return siet.keySet();
    }

    //vráti počet blízkych priateľov mena. V grafoch sa to volá stupeň vrchola v grafe.
    public int pocetPriatelov(E meno) {
        return (siet.containsKey(meno)) ? siet.get(meno).size() : 0;
    }

    //vráti počet spoločných blízkych priateľov meno1 a meno2. Sú to vrcholy, kam vedie hrana aj z meno1 aj z meno2.
    public int spolocniPriatelia(E meno1, E meno2) {
        Set<E> prienik = new HashSet<>(siet.get(meno1)); // use the copy constructor
        prienik.retainAll(siet.get(meno2));
        return prienik.size();
    }

    //vráti true, ak meno1 a meno2 sú vzdialení priatelia.
    // Vzdialený priateľ je alebo blízky priateľ, alebo je to vzdialeným priateľom nejakého môjho blízkeho priateľa.
    // Hint: tu sa myslí tranzitívny uzáver relácie blizkyPriatel, alebo cesta v grafe, podľa vášho uhlu pohľadu.
    public boolean vzdialenyPriatel(E meno1, E meno2) {
        if (siet.get(meno1).contains(meno2)) {
//            System.out.println(meno1.toString() + " je priamy priatel " + meno2.toString());
            return true;
        }
        Queue<E> todo = new LinkedList<>();
        Set<E> visited = new HashSet<>();
        todo.add(meno1);
        while (!todo.isEmpty()) {
            E priatel = todo.poll();
            visited.add(priatel);
            for (E priatel2 : siet.get(priatel)) {
                if (siet.get(meno2).contains(priatel2)) {
//                    System.out.println(meno1.toString() + " je nepriamy priatel " + meno2.toString());
                    return true;
                }
                if (!visited.contains(priatel2) && !todo.contains(priatel2)) {
                    todo.add(priatel2);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
//        FaceHook<String> fk = new FaceHook<>();
//        fk.blizkiPriatelia("a", "b");
//        fk.blizkiPriatelia("a", "c");
//        fk.blizkiPriatelia("e", "f");
//        System.out.println(fk.toString());
//        System.out.println(fk.vsetci());                    // nejaká permutácia "a","b","c","e","f"
//        System.out.println(fk.pocetPriatelov("c"));        // 1
//        System.out.println(fk.pocetPriatelov("a"));        // 2
//        System.out.println(fk.spolocniPriatelia("b", "c"));    // 1 ... "a"
//        System.out.println(fk.vzdialenyPriatel("b", "c"));            // true
//        System.out.println(fk.vzdialenyPriatel("a", "e"));            // false

        FaceHook<Objekt> fk = new FaceHook<>();
        Objekt a = new Objekt("a"); Objekt aa = new Objekt("a");
        Objekt b = new Objekt("b"); Objekt bb = new Objekt("b");
        Objekt c = new Objekt("c"); Objekt cc = new Objekt("c");
        Objekt d = new Objekt("d"); Objekt dd = new Objekt("d");
        Objekt e = new Objekt("e"); Objekt ee = new Objekt("e");
        Objekt f = new Objekt("f"); Objekt ff = new Objekt("f");
        fk.blizkiPriatelia(a, b);
        fk.blizkiPriatelia(a, c);
        fk.blizkiPriatelia(e, f);
        System.out.println(fk); // nejaká reprezentacia grafu
        System.out.println(fk.vsetci()); // nejaká permutácia "a","b","c","e","f"
        System.out.println(fk.pocetPriatelov(cc)); // 1
        System.out.println(fk.pocetPriatelov(aa)); // 2
        System.out.println(fk.spolocniPriatelia(bb, cc)); // 1
        System.out.println(fk.vzdialenyPriatel(bb, cc)); // true
        System.out.println(fk.vzdialenyPriatel(aa, ee)); // false
    }

}
