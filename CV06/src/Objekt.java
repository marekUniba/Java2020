import java.util.Objects;  //-- delete

public class Objekt {
    String id;

    public Objekt(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return id;
    }
    //-- delete
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Objekt objekt = (Objekt) o;
        return Objects.equals(id, objekt.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
