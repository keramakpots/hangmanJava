/** This class is responsible for checking if user input match searched value
or if it choose searched option. */
package operators;
import java.lang.StringBuilder;

public class Validator {

    public static Boolean validateChar(Character ch, String capitalToFind) {
        Boolean validate = false;
        if (capitalToFind.contains(Character.toString(ch))){
            validate = true;
        }
        return validate;
    }

    public static boolean validateWord(String word, String capitalToFind) {
        if (word.equals(capitalToFind)) {
            return true;
        } else {return false;}
    }

    public static String findChar(Character ch, String current, String capitalToFind) {
        StringBuilder currentSb = new StringBuilder(current);
        Integer lenCurrent = current.length();
        Integer lenCapitaltoFind = capitalToFind.length();
        Integer chToChange = 0;
        for (Integer x = 0; x<lenCapitaltoFind; x++) {
            chToChange = capitalToFind.indexOf(ch, x);

            for (Integer i = 0; i<lenCurrent; i++) {
                if (i==(chToChange*2+1)) {
                    currentSb.setCharAt(i, ch);
                }
            current = currentSb.toString();
            }
        }
        return current;
    }
}
