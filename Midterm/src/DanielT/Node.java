package DanielT;
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
        List<Node<E>> listy = listy(this);
        List<E> res = new ArrayList<>();
        listy.forEach(list -> res.add(list.value));
        return res;


    }
    private List<Node<E>> listy(Node<E> koren){
        List<Node<E>> res = new ArrayList<>();
        if(koren == null){
            return res;
        }
        if(koren.left == null && koren.right == null){
            res.add(koren);
        }
        else {
            res.addAll(listy(koren.left));
            res.addAll(listy(koren.right));
        }
        return res;
    }

    /**
     * strom je uplny, ak vsetky vrcholy maju dvoch synov, alebo su list
     * @return - vrati true, ak binarny strom je uplny
     */
    public boolean uplny() {
        return uplnyR(this);
    }
    private boolean uplnyR(Node<E> koren){
        if(koren.left == null && koren.right == null){
            return true;
        }
        if(koren.left != null && koren.right != null){
            return uplnyR(koren.left) && uplnyR(koren.right);
        }
        return false;

    }

    /**
     * strom je vyvazeny, ak vzdialenost vsetkych listov od korena sa lisi najviac o 1
     * @return - vrati true, ak binarny strom je vyvazeny
     * @see "http://struct.input.sk/06.html#vyvazovanie-vyhladavacich-stromov"
     */
    public boolean vyvazeny() {
        return vyvazenyR(this);
    }
    public boolean vyvazenyR(Node<E> koren){
        if(koren == null) return true;
        return Math.abs(podstrom(koren.right) - podstrom(koren.left)) < 2 && vyvazenyR(koren.left) && vyvazenyR(koren.right);
    }
    private int podstrom(Node<E> koren){
        if(koren == null) return 0;
        return 1 + Integer.max(podstrom(koren.left) , podstrom(koren.right));
    }

    /**
     * strom reprezentuje mnozinu ulozenu v Binarnom vyhladavacom strome. To znamena ze zaroven plati:
     * - strom je BVS: pre kazdy vrchol V plati, ze vsetky prvky v lavom podstrome su mensie ako hodnota V,
     *   a vsetky prvky v pravom podstrome su vacsie ako hodnota V
     * - prvky sa v strome neopakuju
     */
    public boolean mnozina() {
        return BVS(this) && SET(this);
    }
    private boolean BVS(Node<E> koren){
        if(koren.left == null && koren.right == null){
            return true;
        }
        if(koren.left != null && koren.right != null){
            return koren.left.value.compareTo(koren.value) < 0 && koren.right.value.compareTo(koren.value) > 0 && BVS(koren.left) && BVS(koren.right);
        }
        if(koren.left != null){
            return koren.left.value.compareTo(koren.value) < 0  && BVS(koren.left);
        }
        return koren.right.value.compareTo(koren.value) > 0  && BVS(koren.right);
    }
    private boolean SET(Node<E> koren){
        List<Node<E>> parents = new ArrayList<>(List.of(koren));
        List<E> values = new ArrayList<>(List.of());
        while(!parents.isEmpty()){
            List<Node<E>> children = new ArrayList<>();
            for(Node<E> n : parents){
                if(values.contains(n.value)){
                    return false;
                }
                values.add(n.value);
                if(n.left != null){
                    children.add(n.left);
                }if(n.right != null){
                    children.add(n.right);
                }
            }
            parents = new ArrayList<>(children);
        }


        return true;
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
