package JurajH_team;

import java.util.HashMap;
import java.util.Map;

public class Santa {
    public static int basement(String log) {
        int poschodie = 0;
        for (int i = 0; i < log.length(); i++) {
            if (log.charAt(i) == '^') {
                poschodie++;
            } else if (log.charAt(i) == 'v') {
                poschodie--;
                if (poschodie < 0) {
                    return i + 1;
                }
            }
        }
        return -1;
    }

    public static int range(String log) {
        int poschodie = 0;
        int min = 0;
        int max = 0;
        for (int i = 0; i < log.length(); i++) {
            if (log.charAt(i) == '^') {
                poschodie++;
            } else if (log.charAt(i) == 'v') {
                poschodie--;
            }
            min = Math.min(min, poschodie);
            max = Math.max(max, poschodie);
        }
        return max - min + 1;
    }

    public static String direct(String log) {
        int poschodie = 0;
        for (int i = 0; i < log.length(); i++) {
            if (log.charAt(i) == '^') {
                poschodie++;
            } else if (log.charAt(i) == 'v') {
                poschodie--;
            }
        }

        StringBuilder sb = new StringBuilder();
        char ch = '^';
        if (poschodie < 0) {
            ch = 'v';
            poschodie *= -1;
        }
        for (int i = 0; i < poschodie; i++) {
            sb.append(ch);
        }
        return sb.toString();
    }

    public static int mostVisited(String log) {
        HashMap<Integer, Integer> count = new HashMap<>();
        int poschodie = 0;
        count.put(0, 1);
        for (int i = 0; i < log.length(); i++) {
            if (log.charAt(i) == '^') {
                poschodie++;
            } else if (log.charAt(i) == 'v') {
                poschodie--;
            }
            count.put(
                    poschodie,
                    count.getOrDefault(poschodie, 0) + 1
            );
        }
        int max = 0;
        // Java 9: for (var e : count.entrySet()) {
        for (Map.Entry<Integer,Integer> e : count.entrySet()) {
            max = Math.max(max, e.getValue());
        }
        return max;
    }

    public static void main(String[] args) {
        String[] examples = {
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
