import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Statistics {
    static final String url = "https://raw.githubusercontent.com/datasets/covid-19/master/data/countries-aggregated.csv?fbclid=IwAR2iKFpJVdryhZx5A6h_T66-eLZ0kcgciEbGxvZLdnQvW3b-fo2vvVvbiTY";

    private static Stream<String> fetch(String path) {
        try {
            BufferedReader read = new BufferedReader(
                new InputStreamReader(
                        //new FileInputStream(path)));
                        new URL(path).openStream()));
            return read.lines();
        } catch (IOException e) {
            System.out.println("nieco zle sa stalo: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
    public static void main(String[] args) {
        //List<String> lines = fetch(url).collect(Collectors.toList());
        //System.out.println(lines.size());
        Stream<String> lines = fetch(url);
        //for (String line : lines) {}
        // dalej pokracujte vy...
        lines.forEach( line -> {
            line = line.replaceAll("\"Korea, South\"", "Korea South");
            String[] parts = line.split(",");
            try {
                int n = Integer.parseInt(parts[2]);
                if (n != 0) {
                    //System.out.println((n / Math.log10(n)) % 10);
                    System.out.println((""+n).charAt(0));
                }
            } catch(NumberFormatException e) {
                System.err.println(parts[2]);
            }

        });
    }
}
