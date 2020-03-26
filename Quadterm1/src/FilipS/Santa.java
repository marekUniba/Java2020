package FilipS;

public class Santa {
    public static int basement(String log) {
        int poschodie = 0;
        int krok = 0;
        for(char c : log.toCharArray()){
            if(c == '^'){
                poschodie ++;
            }
            else if(c == 'v'){
                poschodie --;
            }
            krok ++;
            if(poschodie < 0){
                return krok;
            }
        }
        return -1;
    }
    public static int range(String log) {
        int max = 0;
        int min = 0;
        int aktualnaPoloha = 0;

        for(char c : log.toCharArray()){
            if(c == '^'){
                aktualnaPoloha ++;
                if(aktualnaPoloha > max){
                    max ++;
                }
            }
            else if(c == 'v'){
                aktualnaPoloha --;
                if(aktualnaPoloha < min){
                    min --;
                }
            }
        }
        return max - min +1;
    }

    public static String direct(String log) {
        StringBuffer sb = new StringBuffer();
        int poschodie = 0;

        for(char c : log.toCharArray()){
            if(c == '^'){
                poschodie ++;
            }
            if(c == 'v'){
                poschodie --;
            }
        }

        if(poschodie == 0){
            return "";
        }

        if(poschodie < 0){
            for(int i = 0; i < Math.abs(poschodie); i++){
                sb.append('v');
            }
            return sb.toString();
        }
        else{
            for(int i = 0; i < Math.abs(poschodie); i++){
                sb.append('^');
            }
            return sb.toString();
        }
    }
    public static int mostVisited(String log) {
        int[] pole = new int[2*log.length()+1];
        int stred = pole.length / 2;
        int poschodie = 0;
        pole[stred] = 1;

        for(char c : log.toCharArray()){
            if(c == 'v'){
                poschodie --;
            }
            else{
                poschodie ++;
            }
            if(poschodie == 0){
                pole[stred] ++;
            }
            else if(poschodie < 0){
                int index = stred-(poschodie*-1);
                pole[index] ++;
            }
            else{
                int index = stred + poschodie;
                pole[index] ++;
            }
        }

        int max = 0;
        for(int i : pole){
            if(i > max){
                max = i;
            }
        }
        return max;
    }
    public static void main(String[] args) {
//        String[] examples = {   // male testovacie priklady
//                "^^vv",
//                "^v^v",
//                "^^^",
//                "^vv",
//                "vvv",
//                "vv^^v",
//                "vv^^^"
//        };
//        for (String e : examples) {
//            System.out.println(e
//                    + "\tbasement=" + basement(e)
//                    + "\trange=" + range(e)
//                    + "\tdirect=" + direct(e)
//                    + "\tmostVisited=" + mostVisited(e)
//            );
//        }

        System.out.println(Santa.direct("v^"));
    }
}
