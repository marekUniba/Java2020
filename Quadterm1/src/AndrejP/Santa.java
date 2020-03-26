package AndrejP;

public class Santa {

    public static int basement(String log) {
        int vysl = -1;
        int poschodie = 0;
        for(int i = 0; i < log.length(); i++){
            if(log.charAt(i) == '^'){
                poschodie++;
            }else{
                poschodie--;
            }
            if(poschodie < 0){
                return i + 1;
            }
        }
        return vysl;
    }

    public static int range(String log) {
        int poschodie = 0;
        int min = 0;
        int max = 0;
        for(int i = 0; i < log.length(); i++){
            if(log.charAt(i) == '^'){
                poschodie++;
            }else{
                poschodie--;
            }
            if(poschodie > max){
                max = poschodie;
            }else if(poschodie < min){
                min = poschodie;
            }
        }
        return max - min + 1;
    }

    public static String direct(String log) {
        int hore_pocet = 0;
        for(int i = 0; i < log.length(); i++){
            if(log.charAt(i) == '^'){
                hore_pocet++;
            }
        }
        int poschodie = 2* hore_pocet - log.length();
        StringBuilder  vysl = new StringBuilder("");
        if(poschodie > 0){
            for(int i = 0; i < poschodie; i++){
                vysl.append('^');
            }
        }else{
            for(int i = 0; i < (-1)*poschodie; i++){
                vysl.append('v');
            }
        }
        return vysl.toString();
    }

    public static int mostVisited(String log) {
        int[] pole = new int[2*log.length()+1];
        pole[log.length()]  = 1;
        int poschodie = 0;
        for(int i = 0; i < log.length(); i++){
            if(log.charAt(i) == '^'){
                poschodie++;
            }else{
                poschodie--;
            }
            pole[log.length() - poschodie]++;
        }
        int max = 0;
        for(int i = 0; i < pole.length; i++){
           if(pole[i] > max){
               max = pole[i];
           }
        }
        return max;
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
