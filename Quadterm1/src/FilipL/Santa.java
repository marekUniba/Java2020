package FilipL;

import java.util.*;

public class Santa {
    public static int basement(String log) {
        int result = -1;
        int aktualnePoschodie = 0;
        for (int i = 0; i < log.length(); i++) {
            if (log.charAt(i) == '^') {
                aktualnePoschodie++;
            } else if (log.charAt(i) == 'v') aktualnePoschodie--;

            if (aktualnePoschodie == -1) return i + 1;
        }
        return -1;      // dodefinuj podla zadania
    }
    public static int range(String log) {
        Set<Integer> poschodia = new HashSet<>();

        int aktualnePoschodie = 0;
        poschodia.add(0);
        for (int i = 0; i < log.length(); i++) {
            if (log.charAt(i) == '^') {
                aktualnePoschodie++;
            } else if (log.charAt(i) == 'v') aktualnePoschodie--;
            poschodia.add(aktualnePoschodie);
        }
        return poschodia.size();      // dodefinuj podla zadania
    }
    public static String direct(String log) {
        int aktualnePoschodie = 0; //tu skonci
        for (int i = 0; i < log.length(); i++) {
            if (log.charAt(i) == '^') {
                aktualnePoschodie++;
            } else if (log.charAt(i) == 'v') aktualnePoschodie--;
        }

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < Math.abs(aktualnePoschodie); i++) {
            if (aktualnePoschodie < 0) sb.append('v');
            else sb.append('^');
        }
        return sb.toString();    // dodefinuj podla zadania
    }
    public static int mostVisited(String log) {
        List<Integer> navstiveniaPoschodi = new ArrayList<>();
        int aktualnePoschodie = 0; //tu skonci
        navstiveniaPoschodi.add(aktualnePoschodie);
        for (int i = 0; i < log.length(); i++) {
            if (log.charAt(i) == '^') {
                aktualnePoschodie++;
            } else if (log.charAt(i) == 'v') aktualnePoschodie--;
            navstiveniaPoschodi.add(aktualnePoschodie);
        }
        Set<Integer> poschodia = Set.copyOf(navstiveniaPoschodi);

        int najnavstevovanejsiePoschodie = navstiveniaPoschodi.get(0);
        int poc = 1;
        for (Integer poschodie : poschodia) {
            int tempPoc = 0;
            for (Integer navsteva : navstiveniaPoschodi) {
                if (navsteva.equals(poschodie)) {
                    tempPoc++;
                }
            }
            if (tempPoc > poc) {
                poc = tempPoc;
                najnavstevovanejsiePoschodie = poschodie;
            }
        }


        return poc;      // dodefinuj podla zadania
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
