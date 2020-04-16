import java.util.*;
/**
 *  2.priklad, 4 podulohy, 6 bodov
 */

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
//        return null; // dodefinujte
                List<E> res = new ArrayList<>();
        if (left == null && right == null)
            res.add(value);
        else {
            if (left != null) res.addAll(left.hodnotyVlistoch());
            if (right != null) res.addAll(right.hodnotyVlistoch());
        }
        return res;

    }
// riesenie:
//        List<E> res = new ArrayList<>();
//        if (left == null && right == null)
//            res.add(value);
//        else {
//            if (left != null) res.addAll(left.hodnotyVlistoch());
//            if (right != null) res.addAll(right.hodnotyVlistoch());
//        }
//        return res;


    /**
     * strom je uplny, ak vsetky vrcholy maju dvoch synov, alebo su list
     * @return - vrati true, ak binarny strom je uplny
     */
    public boolean uplny() {
        if (left == null && right == null)
            return true;
        else if (left != null && right != null)
            return left.uplny() && right.uplny();
        return false;
    }

    /**
     * strom je vyvazeny, ak vzdialenost vsetkych listov od korena sa lisi najviac o 1
     * @return - vrati true, ak binarny strom je vyvazeny
     * @see "http://struct.input.sk/06.html#vyvazovanie-vyhladavacich-stromov"
     */
    public boolean vyvazeny() {
        List<Integer>res = new ArrayList<>();
        hlbkyListov(0,res);
        TreeSet<Integer>set = new TreeSet<>(res);
        return set.size() == 0 || Math.abs(set.first() - set.last()) <= 1;
    }

    private void hlbkyListov(int d, List<Integer> res) {
        if (left == null && right == null)
            res.add(d);
        else {
            if (left != null) left.hlbkyListov(d+1, res);
            if (right != null) right.hlbkyListov(d+1, res);
        }
    }

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
                    ",\t halda: " +t.mnozina() +
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
