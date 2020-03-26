package LukasG_team;

import java.util.Arrays;

//35min
public class Queens implements Comparable<Queens>
{
    int [] r;

    Queens(int[] riesenie)
    {
        r = riesenie.clone();
    }

    public String toString()
    {
        return Arrays.toString(r);
    }

    @Override
    public int compareTo(Queens o)
    {
        if (r.length != o.r.length)
            return (r.length < o.r.length) ? -1 : 1;
        for (int i = 0; i < r.length; i++)
        {
            if (r[i] != o.r[i])
                return (r[i] < o.r[i]) ? -1 : 1;
        }
        return 0;
    }

    public Queens clockwise90()
    {
        int [] n = new int[r.length];
        for (int i = 0; i < r.length; i++)
            n[r.length - 1 - r[i]] = i;
        return new Queens(n);
    }

    public Queens horizontalFlip()
    {
        int [] n = new int[r.length];
        for (int i = 0; i < r.length; i++)
            n[i] = r.length - 1 - r[i];
        return new Queens(n);
    }

    public Queens verticalFlip()
    {
        int [] n = new int[r.length];
        for (int i = 0; i < r.length; i++)
            n[n.length - i - 1] = r[i];
        return new Queens(n);
    }

    public static void main(String[] args)
    {
        Queens q = new Queens(new int[]{3,1,6,2,5,7,4,0});

        System.out.println(q.verticalFlip().toString());
        System.out.println(q.horizontalFlip().toString());
        System.out.println(q.clockwise90().toString());

        System.out.println(new Queens(new int[]{2,0,3,1}).clockwise90().compareTo(new Queens(new int[]{2,0,3,1})));
        System.out.println(new Queens(new int[]{0,1,2,3}).compareTo(new Queens(new int[]{1,0,3,2})));
    }
}
