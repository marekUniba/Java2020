package MichalS;

public class Santa {
    public static int basement(String log) {
        if (log == null) return -1;

        int floor = 0;

        for (int i = 0; i < log.length(); i++) {
            if (log.charAt(i) == '^') {
                floor++;
            }
            else {
                floor--;
            }

            if (floor < 0) {
                return i + 1;
            }
        }

        return -1;
    }

    public static int range(String log) {
        if (log == null) return -1;

        int min_floor = 0;
        int max_floor = 0;
        int floor = 0;

        for (int i = 0; i < log.length(); i++) {
            if (log.charAt(i) == '^') {
                floor++;
            }
            else {
                floor--;
            }

            if (floor > max_floor) {
                max_floor = floor;
            }
            else if (floor < min_floor) {
                min_floor = floor;
            }
        }

        return max_floor - min_floor + 1;
    }

    public static String direct(String log) {
        if (log == null) return null;

        int floor = 0;

        for (int i = 0; i < log.length(); i++) {
            if (log.charAt(i) == '^') {
                floor++;
            }
            else {
                floor--;
            }
        }

        StringBuilder s = new StringBuilder();
        char c = '^';
        if (floor < 0) {
            c = 'v';
            floor *= -1;
        }

        s.append(String.valueOf(c).repeat(floor));

        return s.toString();
    }

    public static int mostVisited(String log) {
        if (log == null) return -1;

        int floor = 0;
        int length = 2 * log.length();
        int[] visited = new int[length];
        visited[0] = 1;

        for (int i = 0; i < log.length(); i++) {
            if (log.charAt(i) == '^') {
                floor++;
            }
            else {
                floor--;
            }

            if (floor < 0) {
                visited[length + floor]++;
            }
            else {
                visited[floor]++;
            }
        }

        int max = visited[0];

        for (int i = 1; i < visited.length; i++) {
            if (visited[i] > max) {
                max = visited[i];
            }
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
