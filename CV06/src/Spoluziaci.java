import java.util.*;

public class Spoluziaci {

    public static List<String> rozneMena(String[] mena) {
        return new ArrayList<>(new TreeSet<>(Arrays.asList(mena)));
    }
    public static List<String> rozneMenaPodlaDlzky(String[] mena) {
        List<String> ls =  rozneMena(mena);
        ls.sort((String a, String b) -> {
                    int res = Integer.compare(a.length(), b.length());
                    return (res == 0) ? a.compareTo(b) : res;
                });
        return ls;
    }
    public static List<String> najcastejsie(String[] mena) {
        String[] a = Arrays.copyOf(mena, mena.length);
        Arrays.sort(a);
        int maxVyskyt = -1;
        Set<String> res = new TreeSet<>();
        int occ = 0;
        String last = null;
        for(var s : a) {
            if (s.equals(last)) occ++;
            else {
                occ = 1;
                last = s;
            }
            if (occ > maxVyskyt) {
                maxVyskyt = occ;
                res = new TreeSet<>();
                res.add(s);
            } else if (occ == maxVyskyt)
                res.add(s);
        }
        return new ArrayList<>(res);
    }
    public static void main(String[] args) {
        System.out.println(rozneMena(DataForYou.spoluziaci).size());
        System.out.println(rozneMena(DataForYou.spoluziaci));
        System.out.println(rozneMena(DataForYou.spoluziaciCelejSkoly).size());

        System.out.println(rozneMenaPodlaDlzky(DataForYou.spoluziaci));
        System.out.println(rozneMenaPodlaDlzky(DataForYou.spoluziaciCelejSkoly));

        System.out.println(najcastejsie(DataForYou.spoluziaci));
        System.out.println(najcastejsie(DataForYou.spoluziaciCelejSkoly));
    }
}
