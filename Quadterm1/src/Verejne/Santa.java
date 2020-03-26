package Verejne;

public class Santa {
    public static int basement(String log) {
        return -1;
    }
    public static int range(String log) {
        return -1;
    }
    public static String direct(String log) {
        return null;
    }
    public static int mostVisited(String log) {
        return -1;
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
