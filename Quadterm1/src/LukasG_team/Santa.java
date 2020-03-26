package LukasG_team;

import java.util.Arrays;

//20min
public class Santa
{
    public static int basement(String log)
    {
        int level = 0;
        int step = 0;
        while (step < log.length() && level >= 0)
        {
            level += (log.charAt(step++) == 'v') ? -1 : 1;
        }
        return (level >= 0) ? -1 : step;
    }

    public static int range(String log)
    {
        int [] visited = new int[log.length()*2 + 1];
        int zero = log.length();
        visited[zero] = 1;
        int level = 0;
        int step = 0;
        while (step < log.length())
        {
            level += (log.charAt(step++) == 'v') ? -1 : 1;
            visited[zero + level] = 1;
        }
        return Arrays.stream(visited).sum();
    }

    public static String direct(String log)
    {
        int level = 0;
        int step = 0;
        while (step < log.length())
        {
            level += (log.charAt(step++) == 'v') ? -1 : 1;
        }
        return ((level < 0) ? "v" : "^").repeat(Math.abs(level));
    }

    public static int mostVisited(String log)
    {
        int [] visited = new int[log.length()*2 + 1];
        int zero = log.length();
        visited[zero] = 1;
        int level = 0;
        int step = 0;
        while (step < log.length())
        {
            level += (log.charAt(step++) == 'v') ? -1 : 1;
            visited[zero + level] += 1;
        }
        return Arrays.stream(visited).max().getAsInt();
    }

    public static void main(String[] args)
    {
        System.out.println("BASEMENT:");
        System.out.println(basement("^^vv"));
        System.out.println(basement("^v^v"));
        System.out.println(basement("^^^"));
        System.out.println(basement("^vv"));
        System.out.println(basement("vvv"));

        System.out.println("RANGE:");
        System.out.println(range("^^vv"));
        System.out.println(range("^v^v"));
        System.out.println(range("^^^"));
        System.out.println(range("^vv"));
        System.out.println(range("vvv"));

        System.out.println("DIRECT:");
        System.out.println(direct("^^vv"));
        System.out.println(direct("^v^v"));
        System.out.println(direct("^^^"));
        System.out.println(direct("^vv"));
        System.out.println(direct("vvv"));

        System.out.println("MOST VISITED:");
        System.out.println(mostVisited("^^vv"));
        System.out.println(mostVisited("^v^v"));
        System.out.println(mostVisited("^^^"));
        System.out.println(mostVisited("^vv"));
        System.out.println(mostVisited("vvv"));
    }
}
