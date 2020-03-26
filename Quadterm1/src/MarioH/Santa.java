package MarioH;

public class Santa {

    public static int basement(String log) {
        int floor = 0, i = 0;

        for(char c: log.toCharArray()) {
            if(c == 'v') floor--;
            else if(c == '^') floor++;

            i++;
            if(floor < 0) return i;
        }

        return -1;      // dodefinuj podla zadania
    }

    public static int range(String log) {
        int floor = 0, min = 0, max = 0;

        for(char c: log.toCharArray()) {
            if(c == 'v') floor--;
            else if(c == '^') floor++;

            if(floor > max) max = floor;
            if(floor < min) min = floor;
        }

        return max - min + 1;      // dodefinuj podla zadania
    }

    public static String direct(String log) {
        int floor = 0;

        for(char c: log.toCharArray()) {
            if(c == 'v') floor--;
            else if(c == '^') floor++;
        }

        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < Math.abs(floor); i++) {
            if(floor > 0) {
                sb.append("^");
            }
            else if(floor < 0) {
                sb.append("v");
            }
        }

        return sb.toString();    // dodefinuj podla zadania
    }

    public static int mostVisited(String log) {
        int[] arr = new int[2*log.length()+1];

        int floor = 0;
        int i = log.length()+1;
        arr[i+floor]++;

        for(char c: log.toCharArray()) {
            if(c == 'v') floor--;
            else if(c == '^') floor++;
            arr[i+floor]++;
        }

        int max = 0;
        for(i = 0; i < arr.length; i++) {
            if(i == 0 || max < arr[i]) {
                max = arr[i];
                floor = i;
            }
        }

        return arr[floor];

        //return -1;      // dodefinuj podla zadania
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
