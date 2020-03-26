package DanielT;

import java.util.HashSet;
import java.util.Set;

public class Santa {
    public static int basement(String log) {
        int res = -1;
        int pos = 0;
        for(int i = 0; i < log.length(); i++){
            if('^' == log.charAt(i)){
                pos++;
            }
            if('v' == log.charAt(i)){
                pos--;
            }
            if(pos < 0){
                res = i + 1;
                break;
            }
        }
        return res;      // dodefinuj podla zadania
    }
    public static int range(String log) {
        int ph = 0;
        Set<Integer> pos = new HashSet<>();
        pos.add(0);
        for(int i = 0; i < log.length(); i++){
            if('^' == log.charAt(i)){
                ph++;
            }
            if('v' == log.charAt(i)){
                ph--;
            }
            pos.add(ph);
        }
        return pos.size();
        // dodefinuj podla zadania
    }
    public static String direct(String log) {
        StringBuffer s = new StringBuffer();
        int pos = 0;
        for(int i = 0; i < log.length(); i++){
            if('^' == log.charAt(i)){
                pos++;
            }
            if('v' == log.charAt(i)){
                pos--;
            }
        }
        while (pos != 0){
            if(pos < 0){
                s.append("v");
                pos++;
            }
            else {
                s.append("^");
                pos--;
            }
        }
        return s.toString();
            // dodefinuj podla zadania
    }
    public static int mostVisited(String log) {
        int [] p = new int[2 * log.length() + 1];
        int pos = 0;
        p[log.length()] += 1;
        for(int i = 0; i < log.length(); i++){
            if('^' == log.charAt(i)){
                pos++;
            }
            if('v' == log.charAt(i)){
                pos--;
            }
            p[log.length() + pos] += 1;
        }
        int m = 0;
        for(int i = 0; i < p.length; i++){
            if (p[i] > p[m]){
                m = i;
            }
        }
        return p[m];      // dodefinuj podla zadania
    }
    public static void main(String[] args) {
        String[] examples = {   // male testovacie priklady
                "^^vv",
                "^v^v",
                "^^^",
                "^vv",
                "vvv",
                "vv^^v",
                "vv^^^"
        };
        for (String e : examples) {
            System.out.println(e
                    + "\tbasement=" + basement(e)
                    + "\trange=" + range(e)
                    + "\tdirect=" + direct(e)
                    + "\tmostVisited=" + mostVisited(e)
            );
        }
    }
}
