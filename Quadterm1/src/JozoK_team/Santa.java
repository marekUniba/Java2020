package JozoK_team;

import java.util.*;


public class Santa {
    public static int basement(String log) {
        int curr = 0;
        for(int i = 0; i < log.length(); i++){
            if (log.charAt(i) == 'v'){
                curr -= 1;
            }
            else{
                curr += 1;
            }
            if (curr < 0){
                return i+1;
            }
        }
        return -1;
    }
    public static int range(String log) {
        int curr = 0;
        Set<Integer> posch = new HashSet<Integer>();
        posch.add(0);
        for(int i = 0; i < log.length(); i++) {
            if (log.charAt(i) == 'v') {
                curr -= 1;
            } else {
                curr += 1;
            }
            posch.add(curr);
        }
        return posch.size();
    }
    public static String direct(String log) {
        int curr = 0;
        for(int i = 0; i < log.length(); i++) {
            if (log.charAt(i) == 'v') {
                curr -= 1;
            } else {
                curr += 1;
            }
        }
        StringBuffer res = new StringBuffer();
        if (curr == 0) {
            return "";
        }
        else if (curr > 0){
            for(int j = 0; j < curr; j++){
                res.append("^");
            }
        }
        else {
            for(int j = 0; j > curr; j--){
                res.append("v");
            }
        }
        return res.toString();
    }
    public static int mostVisited(String log) {
        int curr = 0;
        int maxo = 0;
        int max_inde = 0;
        Map<Integer, Integer> mapa = new HashMap<>();
        mapa.put(0, 1);
        for(int i = 0; i < log.length(); i++) {
            if (log.charAt(i) == 'v') {
                curr -= 1;
            } else {
                curr += 1;
            }
            if (mapa.containsKey(curr)){
                mapa.put(curr, mapa.get(curr)+1);
            }
            else{
                mapa.put(curr, 1);
            }
            if (mapa.get(curr) >= maxo){
                max_inde = curr;
                maxo = mapa.get(curr);
            }
        }

        return mapa.get(max_inde);
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
