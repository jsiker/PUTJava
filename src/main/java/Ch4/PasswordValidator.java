package Ch4;

/**
 * Created by m805958 on 5/13/15.
 */
public class PasswordValidator {
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public PasswordValidator(String password) {
        this.password = password;

    }

    public boolean isValidForLength() {
        return password.length() > 8;
    }

    public boolean hasNumbersAndLettersandASpecialChar() {
        boolean valid = false;
        int letters = 0;
        int capitalLetter = 0;
        int numbers = 0;
        int specialChar = 0;
        for (int i = 0; i < password.length(); i++) {

            char c = password.charAt(i);

            if (Character.isDigit(c)) {
                numbers += 1;
            } else if (Character.isUpperCase(c)) {
                capitalLetter += 1;
            } else if (Character.isLetter(c)) {
                letters += 1;
            } else {
                specialChar += 1;
            }
            if (numbers > 3 && letters > 3 && capitalLetter > 0 && specialChar > 0) {
                valid = true;
            }
        }
        return valid;
    }
}
