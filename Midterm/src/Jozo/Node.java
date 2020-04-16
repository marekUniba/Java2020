package Jozo;
import java.util.*;
/**
 *  2.priklad, 4 podulohy, 6 bodov
 */

public class Node<E extends Comparable<E>>{
    private E value;
    private Node<E>left, right;
    static int maxo;
    static int mino;

    public Node(Node<E> left, E value,  Node<E> right) {
        this.value = value; this.left = left; this.right = right;
    }

    /**
     * list v strome je vrchol, ktory nema ziadneho syna
     * @return - vrati hodnoty vo vsetkych listoch stromu v lubovolnom poradi
     */
    public List<E> hodnotyVlistoch() {
        //return null;
        ArrayList<E> pole = new ArrayList<>();
        if (this.left == null && this.right == null){
            pole.add(this.value);
        }
        if (this.left != null){
            pole.addAll(this.left.hodnotyVlistoch());
        }
        if (this.right != null){
            pole.addAll(this.right.hodnotyVlistoch());
        }
        return pole;
    }
    /**
     * strom je uplny, ak vsetky vrcholy maju dvoch synov, alebo su list
     * @return - vrati true, ak binarny strom je uplny
     */
    public boolean uplny() {
        //return false;
        if (this.left == null  && this.right == null){
            return true;
        }
        if (this.left != null  && this.right != null){
            return this.left.uplny() && this.right.uplny();
        }
        return false;
    }

    /**
     * strom je vyvazeny, ak vzdialenost vsetkych listov od korena sa lisi najviac o 1
     * @return - vrati true, ak binarny strom je vyvazeny
     * @see "http://struct.input.sk/06.html#vyvazovanie-vyhladavacich-stromov"
     */
    public boolean vyvazeny() {
        //return false;
        this.maxo = 0;
        this.mino = 100000;
        int d = 0;
        rec(d);
        return (maxo - mino) <= 1;

    }
    public void rec(int d){
        if (this.left == null && this.right == null){
            this.maxo = Math.max(this.maxo, d);
            this.mino = Math.min(this.mino, d);
        }
        if (this.left != null){
            this.left.rec(d+1);
        }
        if (this.right != null){
            this.right.rec(d+1);
        }
    }

    /**
     * strom reprezentuje množinu uloženú v Binárnom vyhľadávacom strome. To znamená že zároveň platí:
      * strom je BVS: 
      * pre každý vrchol v platí, že všetky prvky v ľavom podstrome sú menšie ako hodnota v, 
      * a všetky prvky v pravom podstrome sú väčšie ako hodnota v prvky sa v strome neopakujú
     */
    public boolean mnozina() {
       // return false;
        if (this.left == null  && this.right == null){
            return true;
        }
        if (this.left != null  && this.right != null){
            if (this.left.value.compareTo(value) >= 0){
                return false;
            }
            if (this.right.value.compareTo(value) <= 0){
                return false;
            }
            return this.left.mnozina() && this.right.mnozina();
        }
        if (this.left == null){
            if (this.right.value.compareTo(value) <= 0){
                return false;
            }
        }
        if (this.right == null){
            if (this.left.value.compareTo(value) >= 0){
                return false;
            }
        }
        return true;
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
