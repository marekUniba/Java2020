package Lukas;

public class Zajac implements Comparable<Zajac> {
    int n;

    public Zajac(int n) {
        this.n = n;
    }

    @Override
    public boolean equals(Object obj) {
        return (obj instanceof Zajac &&  ((Zajac)obj).n == n);
    }

    @Override
    public int hashCode() {
        return n;
    }

    @Override
    public int compareTo(Zajac zajac) {
        return Integer.compare(n, zajac.n);
    }
}
