package MatejK;

public class Santa {
    public static int basement(String log) {
        int res = -1;
        int poschodie = 0;
        int krok = 1;
        for(char ch: log.toCharArray()){
            if(ch == 'v'){
                poschodie --;
            }
            else if(ch == '^'){
                poschodie ++;
            }
            if(poschodie < 0){
                res = krok;
                break;
            }
            krok ++;
        }
        return res;
    }
    public static int range(String log) {
        int res = 0;
        int poschodie = 0;
        int maxPoschodie = 0;
        int minPoschodie = 0;
        for(char ch: log.toCharArray()){
            if(ch == 'v'){
                poschodie --;
            }
            else if(ch == '^'){
                poschodie ++;
            }
            if(poschodie > maxPoschodie){
                maxPoschodie = poschodie;
            }
            if(poschodie < minPoschodie){
                minPoschodie = poschodie;
            }
        }
        return maxPoschodie - minPoschodie + 1;
    }
    public static String direct(String log) {
        StringBuilder res = new StringBuilder("");
        int poschodie = 0;
        for(char ch: log.toCharArray()){
            if(ch == 'v'){
                poschodie --;
            }
            else if(ch == '^'){
                poschodie ++;
            }
        }
        if(poschodie > 0){
            for (int i = 0; i < poschodie; i++) {
                res.append('^');
            }
        }
        else if(poschodie < 0){
            for (int i = 0; i < -poschodie; i++) {
                res.append('v');
            }
        }
        return res.toString();
    }
    public static int mostVisited(String log) {
        int[] tab = new int[2*log.length() + 1];
        for (int i = 0; i < tab.length; i++) {
            tab[i] = 0;
        }
        int stred = tab.length / 2;
        tab[stred] = 1;
        int poschodie = 0;
        for(char ch: log.toCharArray()){
            if(ch == 'v'){
                poschodie --;
            }
            else if(ch == '^'){
                poschodie ++;
            }
            if(poschodie == 0) tab[stred] ++;
            if(poschodie < 0) tab[stred - (-poschodie)] ++;
            if(poschodie > 0) tab[stred + poschodie] ++;
        }
        int max = tab[0];
        for (int i = 0; i < tab.length; i++) {
            if(tab[i] > max){
                max = tab[i];
            }
        }
        return max;
    }
    public static void main(String[] args) {
        /*String[] examples = {   // male testovacie priklady
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
        }*/
        System.out.println(direct("vvv^"));
    }
}
