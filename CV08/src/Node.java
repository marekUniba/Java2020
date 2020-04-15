import java.io.Serializable;

public class Node implements Serializable {
    private static final long serialVersionUID = 918972645L;
    Integer value;
    Node left;
    Node right;

    public Node(Node left, Integer value, Node right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
    /**
     * Fibonacciho strom radu n,
     * ak n < 2 je value = n, left=right=null
     * inak left = fibstrom n-2, right = fibstrom n-1 a value = fib.cislo n
     */
    public Node(int n) {
        if (n < 2) {
            this.value = n;
            this.left = null;
            this.right = null;
        } else {
            this.left = new Node(n - 2);
            this.right = new Node(n - 1);
            this.value = this.left.value + this.right.value;
        }

    }

    public String toString() {
        return "(" + (this.left != null ? this.left : ".") + "," + (this.value != null ? this.value : "+") + "," + (this.right != null ? this.right : ".") + ")";
    }
}
