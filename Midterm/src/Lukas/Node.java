package Lukas;

import java.util.*;
/**
 *  2.priklad, 4 podulohy, 6 bodov
 */

// 20 min
public class Node<E extends Comparable<E>> {
    private E value;
    private Node<E>left, right;

    public Node(Node<E> left, E value,  Node<E> right) {
        this.value = value; this.left = left; this.right = right;
    }

    /**
     * list v strome je vrchol, ktory nema ziadneho syna
     * @return - vrati hodnoty vo vsetkych listoch stromu v lubovolnom poradi
     */
    public List<E> hodnotyVlistoch() {
        List<E> zber = new ArrayList<>();
        pozbierajListy(zber);
        return zber;
    }

    private void pozbierajListy(List<E> zber) {
        if (left == null && right == null)
           zber.add(value);
        if (left != null)
            left.pozbierajListy(zber);
        if (right != null)
            right.pozbierajListy(zber);
    }
    /**
     * strom je uplny, ak vsetky vrcholy maju dvoch synov, alebo su list
     * @return - vrati true, ak binarny strom je uplny
     */
    public boolean uplny() {
        return ((left == null) == (right == null))
                && (left == null || left.uplny())
                && (right == null || right.uplny());
    }

    /**
     * strom je vyvazeny, ak vzdialenost vsetkych listov od korena sa lisi najviac o 1
     * @return - vrati true, ak binarny strom je vyvazeny
     * @see "http://struct.input.sk/06.html#vyvazovanie-vyhladavacich-stromov"
     */
    private static int maximum;
    private static int minimum;
    public boolean vyvazeny() {
        maximum = 0;
        minimum = 9999;
        prehladaj(0);
        return ((maximum - minimum) <= 1);
    }

    private void prehladaj(int hlbka) {
        if (left == null && right == null) {
            maximum = Math.max(hlbka, maximum);
            minimum = Math.min(hlbka, minimum);
        }
        if (left != null)
            left.prehladaj(hlbka + 1);
        if (right != null)
            right.prehladaj(hlbka + 1);
    }

    /**
     * strom reprezentuje množinu uloženú v Binárnom vyhľadávacom strome. To znamená že zároveň platí:
      * strom je BVS: 
      * pre každý vrchol v platí, že všetky prvky v ľavom podstrome sú menšie ako hodnota v, 
      * a všetky prvky v pravom podstrome sú väčšie ako hodnota v prvky sa v strome neopakujú
     */
    public boolean mnozina() {
        return bvs(new HashSet<>());
    }

    private boolean bvs(Set<E> bolo) {
        if (bolo.contains(value))
            return false;
        bolo.add(value);
        return (left == null || (left.value.compareTo(value) <= 0) && left.bvs(bolo))
                && (right == null || (right.value.compareTo(value) >= 0 && right.bvs(bolo)));
    }

    public static void main(String[] args) {
        Node<Integer> t1 = new Node<>(null, 1, null);
        Node<Integer> t2 = new Node<>(t1, 2, t1);
        Node<Integer> t3 = new Node<>(t1, 3, null);
        Node<Integer> t4 = new Node<>(t2, 4, t3);

        Node<Integer> obr1 = new Node<>(new Node<>(new Node<>(null,6,null),2,new Node<>(null,1,null)), 4, new Node<>(null,7,new Node<>(null,9,null)));
        Node<Integer> obr2 = new Node<>(new Node<>(new Node<>(null,6,null),2,new Node<>(null,1,null)), 4, new Node<>(null,7, null));
        Node<Integer> obr3 = new Node<>(new Node<>(null,2,null), 4, new Node<>(new Node<>(null,6,null),7, new Node<>(null,1,null)));
        Node<Integer> obr4 = new Node<>(new Node<>(null,2,null), 4, new Node<>(null,7, new Node<>(null,1,new Node<>(null,6,null))));
        List<Node<Integer>> tests = List.of(t1, t2, t3, t4, obr1, obr2, obr3, obr4);

        for(Node<Integer> t : tests) {
            System.out.println(
                    "vlisoch: " + t.hodnotyVlistoch() +
                    ",\t uplny: " +t.uplny() +
                    ",\t vyvazeny: " +t.vyvazeny() +
                    ",\t mnozina: " +t.mnozina() +
                    ",\t strom: " +t
            );
        }
    }

    @Override
    public String toString() {
        return "(" +
                ((left!=null)?left:".") +
                "," +
                ((value!=null)?value:"+") +
                "," +
                ((right!=null)?right:".") +
                ')';
    }

    public E getValue() {
        return value;
    }

    public void setValue(E value) {
        this.value = value;
    }

    public Node<E> getLeft() {
        return left;
    }

    public void setLeft(Node<E> left) {
        this.left = left;
    }

    public Node<E> getRight() {
        return right;
    }

    public void setRight(Node<E> right) {
        this.right = right;
    }
}
