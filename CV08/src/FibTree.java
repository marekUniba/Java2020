import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class FibTree {

    public static long sum(String fileName) {
        Node t = (Node)load(fileName);
        return 0;
    }
    public static <E> E load(String fileName) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            return (E)ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("nieco zle sa stalo pri citani suboru " + fileName);
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        Node t = (Node)load("du8.bin");
        System.out.println(t);
    }

}
