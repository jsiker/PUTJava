import java.util.ArrayList;
import java.util.List;

/**
 * Created by m805958 on 5/11/15.
 */
public class StringReverse {
    private final String string;

    public StringReverse(String string) {
        if (string == null || string.isEmpty() || string.matches("\\d+")) {
            throw new IllegalArgumentException("need a string. got: " + string);
        }

        this.string = string;
    }

    public String getString() { return string; }

    public static String reverse(String s) {
        List<String> tempArray = new ArrayList<String>(s.length());
        for (int i = 0; i < s.length(); i++) {
            tempArray.add(s.substring(i, i+1));
        }

        StringBuilder reversedString = new StringBuilder(s.length());
        for (int i = tempArray.size() - 1; i >= 0; i--) {
            reversedString.append(tempArray.get(i));
        }

        return reversedString.toString();

    }
}
