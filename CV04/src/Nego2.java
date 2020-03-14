
// https://www.youtube.com/playlist?list=PLVpBcJZqpp5844gsnMpI0HpF7UupRpaym
public class Nego2 {
    // -32, 16, -8, 4, -2, 1
    //              1   1  0 = 2
    //  "1" + "1" = "110"

    //https://en.wikipedia.org/wiki/Modulo_operation
    //https://torstencurdt.com/tech/posts/modulo-of-negative-numbers
    //https://stackoverflow.com/questions/11720656/modulo-operation-with-negative-numbers
    private static int mymodulo(int a, int b) {
        int m = a % b;
        if (m < 0) {
            m = (b < 0) ? m - b : m + b;
        }
        return m;
    }
    private static int mydiv(int a, int b) {
        return (a-mymodulo(a,b))/b;
    }
    public static String toNego(int i) {
        final int base = -2;
        String res = "";
        while (i != 0) {
            int m = mymodulo(i, base);
            res = "" + m + res;
            i = mydiv(i, base);
        }
        return res;
    }
    public static int fromNego(String s) {
        StringBuffer sb = new StringBuffer(s);
        sb.reverse();
        int w = 1;
        int sum = 0;
        final int base = -2;
        for(char ch:sb.toString().toCharArray()) {
            sum += (ch-'0')*w;
            w *= base;
        }
        return sum;
    }
    public static String sucet(String a, String b) {
        return toNego(fromNego(a) + fromNego(b));
    }

    public static String opacne(String a) {
        return toNego(-fromNego(a));
    }

    public static void main(String[] args) {
        System.out.println(fromNego("110"));
        System.out.println(toNego(2));
        System.out.println(sucet("1", "1"));
        System.out.println(opacne("1100")); //  je "100"  // lebo -4 -> 4
        System.out.println(opacne("110011")); // je "10001"  // lebo -17 -> 17
    }
}

