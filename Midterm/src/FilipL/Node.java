package FilipL;

import java.util.ArrayList;
import java.util.List;

/**
 * 2.priklad, 4 podulohy, 6 bodov
 */

public class Node<E extends Comparable<E>> {
    private E value;
    private Node<E> left, right;

    public Node(Node<E> left, E value, Node<E> right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    /**
     * list v strome je vrchol, ktory nema ziadneho syna
     * @return - vrati hodnoty vo vsetkych listoch stromu v lubovolnom poradi
     */
    public List<E> hodnotyVlistoch() {
        List<E> res = new ArrayList<>();
        if (left == null && right == null) {
            res.add(value);
        }
        if (left != null) {
            res.addAll(left.hodnotyVlistoch());
        }
        if (right != null) {
            res.addAll(right.hodnotyVlistoch());
        }
        return res;
    }

    /**
     * strom je uplny, ak vsetky vrcholy maju dvoch synov, alebo su list
     * @return - vrati true, ak binarny strom je uplny
     */
    public boolean uplny() {
        return Boolean.compare(left != null, right != null) == 0 && (left != null ? left.uplny() : true) && (right != null ? right.uplny() : true);
    }

    /**
     * strom je vyvazeny, ak vzdialenost vsetkych listov od korena sa lisi najviac o 1
     * @return - vrati true, ak binarny strom je vyvazeny
     * @see "http://struct.input.sk/06.html#vyvazovanie-vyhladavacich-stromov"
     */
    public boolean vyvazeny() {
        int hlbkaLaveho = left != null ? left.hlbka() : 0;
        int hlbkaPraveho = right != null ? right.hlbka() : 0;
        return Math.abs(hlbkaLaveho - hlbkaPraveho) <= 1;
    }

    public boolean jeList() {
        return left == null && right == null;
    }

    public int hlbka() {
        return Math.max(left != null ? 1 + left.hlbka() : 0, right != null ? 1 + right.hlbka() : 0);
    }

    /**
     * strom reprezentuje mnozinu ulozenu v Binarnom vyhladavacom strome. To znamena ze zaroven plati:
     * - strom je BVS: pre kazdy vrchol V plati, ze vsetky prvky v lavom podstrome su mensie ako hodnota V,
     *   a vsetky prvky v pravom podstrome su vacsie ako hodnota V
     * - prvky sa v strome neopakuju
     */
    public boolean mnozina() {
        return (left != null ? value.compareTo(left.value) > 0 : true ) && (right != null ? value.compareTo(right.value) < 0 : true) && (right != null ? right.mnozina() : true) && (left != null ? left.mnozina() : true);
    }

    public static void main(String[] args) {
        Node<Integer> t1 = new Node<>(null, 1, null);
        Node<Integer> t2 = new Node<>(t1, 2, t1);
        Node<Integer> t3 = new Node<>(t1, 3, null);
        Node<Integer> t4 = new Node<>(t2, 4, t3);

        Node<Integer> obr1 = new Node<>(new Node<>(new Node<>(null, 6, null), 2, new Node<>(null, 1, null)), 4, new Node<>(null, 7, new Node<>(null, 9, null)));
        Node<Integer> obr2 = new Node<>(new Node<>(new Node<>(null, 6, null), 2, new Node<>(null, 1, null)), 4, new Node<>(null, 7, null));
        Node<Integer> obr3 = new Node<>(new Node<>(null, 2, null), 4, new Node<>(new Node<>(null, 6, null), 7, new Node<>(null, 1, null)));
        Node<Integer> obr4 = new Node<>(new Node<>(null, 2, null), 4, new Node<>(null, 7, new Node<>(null, 1, new Node<>(null, 6, null))));
        List<Node<Integer>> tests = List.of(t1, t2, t3, t4, obr1, obr2, obr3, obr4);

        for (Node<Integer> t : tests) {
            System.out.println(
                    "vlisoch: " + t.hodnotyVlistoch() +
                            ",\t uplny: " + t.uplny() +
                            ",\t vyvazeny: " + t.vyvazeny() +
                            ",\t mnozina: " + t.mnozina() +
                            ",\t strom: " + t
            );
        }
    }


    @Override
    public String toString() {
        return "(" +
                ((left != null) ? left : ".") +
                "," +
                ((value != null) ? value : "+") +
                "," +
                ((right != null) ? right : ".") +
                ')';
    }
}
