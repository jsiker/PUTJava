package Ch4;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * Created by m805958 on 5/14/15.
 */
public class ThreeNumbers {
    ThreeNumbers threeNumbers;
    String string;

    public String getThreeNumbers() {
        String holdingString = "";

        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            if (Character.isDigit(c)) {
                holdingString += c;
            }
        }

        if (holdingString.length() >= 3) {
            return holdingString;
        } else {
            return null;
        }
    }

    public String addACommaBetweenGroupsOfThreeNumbers() {
        String holdingString = "";

        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);

            if (Character.isDigit(c)) {
                holdingString += c;
            }
        }

        holdingString = NumberFormat.getIntegerInstance(Locale.US).format(Integer.parseInt(holdingString));
        return holdingString;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ThreeNumbers)) return false;

        ThreeNumbers that = (ThreeNumbers) o;

        if (!threeNumbers.equals(that.threeNumbers)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return threeNumbers.hashCode();
    }

    public ThreeNumbers(String string) {

        this.string = string;
    }

}
