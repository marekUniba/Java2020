 import java.util.Objects;

public class Zajac implements Comparable<Zajac> {
    int n;
    public Zajac(int n) //{}
    { this.n = n; }

    @Override
    public int compareTo(Zajac o) {
        return Integer.compare(n, o.n);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Zajac) return n == ((Zajac)obj).n;
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(n);
    }
}
