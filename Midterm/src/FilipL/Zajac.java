package FilipL;
import java.util.Objects;

public class Zajac implements Comparable {
    public int n;
    public Zajac(int n) { this.n = n; }

    @Override
    public int compareTo(Object o) {
        return Integer.compare(n, ((Zajac) o).n);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Zajac zajac = (Zajac) o;
        return n == zajac.n;
    }

    @Override
    public int hashCode() {
        return Objects.hash(n);
    }
}
