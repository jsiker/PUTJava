package Ch4;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;

/**
 * Created by m805958 on 5/14/15.
 */
public class NumberTest {
    private static final ThreeNumbers THREE_NUMBER_STRING = new ThreeNumbers("123abc");
    private static final ThreeNumbers FIVE_NUMBER_STRING = new ThreeNumbers("123abc45");
    private static final ThreeNumbers TWO_NUMBER_STRING = new ThreeNumbers("abc45");

    @Test
    public void threeNumbersMethodShouldReturnThreeNumbers() {
        assertEquals(THREE_NUMBER_STRING.getThreeNumbers(), "123");
        assertNotEquals(THREE_NUMBER_STRING.getThreeNumbers(), "123abc");
    }

    @Test
    public void threeNumberMethodShouldNotReturnLessThanThreeNumbers() {
        assertNull(TWO_NUMBER_STRING.getThreeNumbers());
    }

    @Test
    public void addACommaMethodAddsACommaAfterThreeDigits() {
        assertEquals("12,345", FIVE_NUMBER_STRING.addACommaBetweenGroupsOfThreeNumbers());
        assertEquals("123", THREE_NUMBER_STRING.addACommaBetweenGroupsOfThreeNumbers());
    }

    // Test misplaced commas (123,21)
}
