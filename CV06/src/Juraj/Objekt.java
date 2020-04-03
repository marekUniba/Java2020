package Juraj;
import java.util.Objects;

public class Objekt {
    int id;
    String firstName;
    String lastName;
    int age;

    public Objekt(int id, String firstName, String lastName, int age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Objekt objekt = (Objekt) o;
        return id == objekt.id &&
                age == objekt.age &&
                firstName.equals(objekt.firstName) &&
                lastName.equals(objekt.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, age);
    }

    @Override
    public String toString() {
        return "Objekt{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }
}
