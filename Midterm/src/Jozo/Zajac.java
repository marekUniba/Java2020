package Jozo;
public class Zajac implements Comparable{
    static boolean a = false;
    int num = 0;
    Zajac(int n){
        num = n;
    }

    @Override
    public int compareTo(Object o) {
        Zajac oj = (Zajac)o;
        return Integer.compare(num, oj.num);
    }

    @Override
    public boolean equals(Object o) {
        Zajac oj = (Zajac)o;
        return num == oj.num;
    }

    @Override
    public int hashCode() {
        return num;
    }

    @Override
    public String toString() {
        return "Zajac{" +
                "num=" + num +
                '}';
    }
}