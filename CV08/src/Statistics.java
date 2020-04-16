//import java.io.BufferedReader;
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.net.URL;
//import java.util.Arrays;
//import java.util.List;
//import java.util.stream.Collectors;
//import java.util.stream.Stream;
//
//public class Statistics {
//    static final String url = "https://raw.githubusercontent.com/datasets/covid-19/master/data/countries-aggregated.csv?fbclid=IwAR2iKFpJVdryhZx5A6h_T66-eLZ0kcgciEbGxvZLdnQvW3b-fo2vvVvbiTY";
//
//    private static Stream<String> fetch(String path) {
//        try {
//            BufferedReader read = new BufferedReader(
//                new InputStreamReader(
//                        //new FileInputStream(path)));
//                        new URL(path).openStream()));
//            return read.lines();
//        } catch (IOException e) {
//            System.out.println("nieco zle sa stalo: " + e.getMessage());
//            e.printStackTrace();
//            return null;
//        }
//    }
//    public static void main(String[] args) {
//        //List<String> lines = fetch(url).collect(Collectors.toList());
//        //System.out.println(lines.size());
//        Stream<String> lines = fetch(url);
//        //for (String line : lines) {}
//        // dalej pokracujte vy...
//        lines.forEach( line -> {
//            line = line.replaceAll("\"Korea, South\"", "Korea South");
//            String[] parts = line.split(",");
//            try {
//                int n = Integer.parseInt(parts[2]);
//                if (n != 0) {
//                    //System.out.println((n / Math.log10(n)) % 10);
//                    System.out.println((""+n).charAt(0));
//                }
//            } catch(NumberFormatException e) {
//                System.err.println(parts[2]);
//            }
//
//        });
//    }
//}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Statistics {
    static final String url = "https://raw.githubusercontent.com/datasets/covid-19/master/data/countries-aggregated.csv?fbclid=IwAR2iKFpJVdryhZx5A6h_T66-eLZ0kcgciEbGxvZLdnQvW3b-fo2vvVvbiTY";
    List<String> lines;

    public Statistics(List<String> lines){
        this.lines = lines;
    }
    private static Stream<String> fetch(String path) {
        try {
            BufferedReader read = new BufferedReader(
                    new InputStreamReader(
                            new URL(path).openStream()));
            return read.lines();
        } catch (IOException e) {
            System.out.println("nieco zle sa stalo: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
    public static char najcastesia(){
        int f[] = new int[9];
        Stream<String> lines = fetch(url);
        lines.forEach(line->{
            line = line.replaceAll("Korea, South", "Korea South");
            String [] l = line.split(",");
            try{
                if (Integer.parseInt(String.valueOf(l[2].charAt(0))) != 0){
                    f[Integer.parseInt(String.valueOf(l[2].charAt(0))) - 1]++;
                }
            }catch (Exception e){
            }
        });
        int m = 0;
        for(int i = 0; i < 9; i++){
            if(f[i] > f[m]){
                m = i;
            }
        }
        return (""+ (m + 1)).charAt(0);
    }
    public static double pravdepodobnost(){
        int f[] = new int[9];
        Stream<String> lines = fetch(url);
        lines.forEach(line->{
            line = line.replaceAll("Korea, South", "Korea South");
            String [] l = line.split(",");
            try{
                if (Integer.parseInt(String.valueOf(l[2].charAt(0))) != 0){
                    f[Integer.parseInt(String.valueOf(l[2].charAt(0))) - 1]++;
                }
            }catch (Exception e){
            }
        });
        int m = 0;
        for(int i = 0; i < 9; i++){
            if(f[i] > f[m]){
                m = i;
            }
        }
        int j = 0;
        for(int i = 0; i < 9; i++){
            j += f[i];
        }
        return (double)f[m] / j;
        //return (double)f[m + 1] / j;
    }
    public static void main(String[] args) {
        System.out.println(pravdepodobnost());
    }
}