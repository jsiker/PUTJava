package Ch4;

import org.junit.Test;

import static org.junit.Assert.*;

public class PasswordValidatorTest {
    PasswordValidator VALID_PASSWORD = new PasswordValidator("validPassword1234_+)(*&^%!@#$%^!");
    PasswordValidator INVALID_PASSWORD = new PasswordValidator("weak");

    @Test
    public void passwordShouldBeMoreThanSixChars(){
        assertTrue(VALID_PASSWORD.isValidForLength());
        assertFalse(INVALID_PASSWORD.isValidForLength());
    }

    @Test
    public void passwordShouldHaveNumbersAndLettersAndACapitalLetter() {
        assertTrue(VALID_PASSWORD.hasNumbersAndLettersandASpecialChar());
        assertFalse(INVALID_PASSWORD.hasNumbersAndLettersandASpecialChar());
    }
}