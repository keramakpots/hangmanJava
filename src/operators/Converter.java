package operators;
import java.lang.StringBuilder;

public class Converter {

    public Converter() {}

    public static String converterToUp(String toUpperCaseString) {
        String converted = toUpperCaseString.toUpperCase();
        return converted;
    }

    public static Character convertCharacterToUp(Character ch) {
        Character letter = Character.toUpperCase(ch);
        return letter;
    }

    public static String convertToDashes(String capital) {
        Integer len = capital.length();
        Integer i = 0;
        Integer whitespaceindex = 100;
        String hiddenCap = "";
        StringBuilder sb = new StringBuilder(30);
        if (capital.contains(" ")) {
            whitespaceindex = capital.indexOf(" ");
        }
        while (i<len) {
            if (i == whitespaceindex) {
                hiddenCap = sb.append("  ").toString();
            } else {
            hiddenCap = sb.append(" _").toString();
            }
            i++;
        }

        return hiddenCap;
    }
}
