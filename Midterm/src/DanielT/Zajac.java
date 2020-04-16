package DanielT;
import java.util.Objects;

public class Zajac implements Comparable<Zajac>{
    int n;
    public Zajac(int n) {
        this.n = n;
    }

    @Override
    public int compareTo(Zajac zajac) {
        return Integer.compare(n, zajac.n);
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
