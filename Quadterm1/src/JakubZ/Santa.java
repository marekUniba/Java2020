package JakubZ;

import java.util.HashMap;
import java.util.Map;

public class Santa {

    public static int basement(String log) {
        int current = 0;
        for ( int i = 0; i < log.length(); i++ ) {
            if ( log.charAt(i) == '^' ) {
                current++;
            } else {
                if ( log.charAt(i) == 'v' ) {
                    current--;
                }
            }
            if ( current < 0 ) {
                return i+1;
            }
        }
        return -1;      // dodefinuj podla zadania - done
    }
    public static int range(String log) {
        int greatest = 0;
        int lowest = 0;
        int current = 0;
        for ( int i = 0; i < log.length(); i++) {
            if ( log.charAt(i) == '^' ) {
                current++;
                if ( current > greatest ) {
                    greatest = current;
                }
            } else {
                if ( log.charAt(i) == 'v' ) {
                    current--;
                    if ( current < lowest ) {
                        lowest = current;
                    }
                }
            }
        }
        return Math.abs(lowest - greatest)+1;      // dodefinuj podla zadania - done
    }
    public static String direct(String log) {
        StringBuilder output = new StringBuilder();
        int current = 0;
        for ( int i = 0; i < log.length(); i++ ) {
            if ( log.charAt(i) == '^' ) {
                current++;
            } else {
                if ( log.charAt(i) == 'v' ) {
                    current--;
                }
            }
        }
        int goal = current;
        current = 0;
        while ( current != goal ) {
            if ( goal < current ) {
                current--;
                output.append('v');
            } else {
                current++;
                output.append('^');
            }
        }
        return output.toString();    // dodefinuj podla zadania - done
    }
    public static int mostVisited(String log) {
        Map<Integer, Integer> pairs = new HashMap<>();
        for ( int i = -log.length(), j = 0; i <= log.length(); i++, j++ ) {
            if ( i == 0 ) {
                pairs.put(i, 1);
            } else {
                pairs.put(i, 0);
            }
        }
        int top = 0;
        int topCount = 0;
        int current = 0;
        for ( int k = 0; k < log.length(); k++ ) {
            if ( log.charAt(k) == '^' ) {
                current++;
                pairs.put(current, pairs.get(current)+1);
                if ( pairs.get(current) > topCount ) {
                    topCount = pairs.get(current);
                    top = current;
                }
            } else {
                if ( log.charAt(k) == 'v' ) {
                    current--;
//                    System.out.println(pairs);
//                    System.out.println(current);
                    pairs.put(current, pairs.get(current)+1);
                    if ( pairs.get(current) > topCount ) {
                        topCount = pairs.get(current);
                        top = current;
                    }
                }
            }
        }
//        pairs.put(-1, pairs.get(-1)+1);
//        System.out.println(pairs);
        return topCount;      // dodefinuj podla zadania
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
