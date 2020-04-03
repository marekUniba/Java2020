package Kika;

public class Objekt {
    String id;

    public Objekt(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        return (o instanceof Objekt) ? this.id == ((Objekt) o).id : false;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
