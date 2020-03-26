import java.util.Arrays;
import java.util.Random;

public class Santa {
    public static int basement(String log) {
        int level = 0;
        for(int step = 0; step < log.length(); step++) {
            level += (log.charAt(step) == '^')?1:-1;
            if (level < 0)
                return step+1;
        }
        return -1;
    }
    public static int range(String log) {
        int min = 0, max = 0, level = 0;
        for(int step = 0; step < log.length(); step++) {
            level += (log.charAt(step) == '^')?1:-1;
            min = Math.min(level, min);
            max = Math.max(level, max);
        }
        return max - min + 1;
    }
    public static String direct(String log) {
        int level = 0;
        for(int step = 0; step < log.length(); step++) {
            level += (log.charAt(step) == '^')?1:-1;
        }
        return new String(new char[Math.abs(level)]).replace('\0',(level<0)?'v':'^');
    }
    public static int mostVisited(String log) {
        int max = 1, level = 0;
        int[] visited = new int[log.length()*2+1];
        // level->index: 0 -> 0
        //               i -> 2*i,       i > 0
        //               i -> 2*(-i)-1,  i < 0
        visited[0] = 1;
        for(int step = 0; step < log.length(); step++) {
            level += (log.charAt(step) == '^')?1:-1;
            max = Math.max(++visited[(level<0)?-2*level-1:2*level], max);
            //System.out.println(level + Arrays.toString(visited));
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
        generator();
    }
    public static void generator() {
        for(int i = 0; i < 100; i++) {
            String rs = randomString(i+1);
            System.out.println("assertEquals(\""+rs+"\"," + basement(rs)+", Santa.basement(\""+rs+"\") );");
        }
        System.out.println("//----------------------------------------");
        for(int i = 0; i < 100; i++) {
            String rs = randomString(i+1);
            System.out.println("assertEquals(\""+rs+"\"," + range(rs)+", Santa.range(\""+rs+"\") );");
        }
        System.out.println("//----------------------------------------");
        for(int i = 0; i < 100; i++) {
            String rs = randomString(i+1);
            System.out.println("assertEquals(\""+rs+"\",\"" + direct(rs)+"\", Santa.direct(\""+rs+"\") );");
        }
        System.out.println("//----------------------------------------");
        for(int i = 0; i < 100; i++) {
            String rs = randomString(i+1);
            System.out.println("assertEquals(\""+rs+"\"," + mostVisited(rs)+", Santa.mostVisited(\""+rs+"\") );");
        }
    }
    static Random rnd = new Random();
    private static String randomString(int len) {
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < len; i++) {
            sb.append(rnd.nextBoolean()?"^":"v");
        }
        return sb.toString();
    }
}
