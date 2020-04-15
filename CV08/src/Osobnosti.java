import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Osobnosti {
    /**
     * konvertuje String mesiaca na int
     */
    private  static int monthConvertor(String m) {
        switch (m) {
            case "januara":
            case "januar":
                return 0;
            case "februara":
            case "februar":
                return 1;
            case "marca":
            case "marec":
                return 2;
            case "aprila":
            case "april":
                return 3;
            case "maja":
            case "maj":
                return 4;
            case "juna":
            case "jun":
                return 5;
            case "jula":
            case "jul":
                return 6;
            case "augusta":
            case "august":
                return 7;
            case "septembra":
            case "september":
                return 8;
            case "oktobra":
            case "oktober":
                return 9;
            case "novembra":
            case "november":
                return 10;
            case "decembra":
            case "december":
                return 11;
            default:
                return 0;
        }
    }
    /**
     * vyrobi Date z troch stringov
     */
    private static Date makeDate(String yyyy, String month, String dd) {
        return new GregorianCalendar(
                            Integer.parseInt(yyyy),
                            monthConvertor(month),
                            Integer.parseInt(dd)
                    ).getTime();
    }
    // vráti niektorý z najčastejších dátumov v súbore
    public static Date najcastejsiDatum(String fileName) {
        try (Scanner sc = new Scanner(new File(fileName))) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                Pattern pat = Pattern.compile(".*(januar[a]|februar[a])\\s*(\\d{4}).*");
                Matcher m = pat.matcher(line);
                if (m.find()) {
                    //m.group(0)
                    //System.out.println(m.group(1) + ", " + m.group(2));
                    System.out.println(makeDate(m.group(2), m.group(1), "15"));
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("nieco sa stalo pri citani suboru " + fileName);
            e.printStackTrace();
        }


        return null;  // dorobte
    }
    public static void main(String[] args) {
        System.out.println(najcastejsiDatum("osobnosti.txt"));
    }
}
