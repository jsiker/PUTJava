import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.Assert.assertEquals;

/**
 * Created by m805958 on 5/11/15.
 */
@RunWith(JUnitParamsRunner.class)
public class TestReversedString {
    private StringReverse stringReverse;
    private String testString = "testString";

    private static final Object[] getInvalidArg() {
        return new Object[]{(""), (124)};
    }

    @Test
    public void testStringIsReversed() {
        assertEquals(testString, stringReverse.reverse("gnirtStset"));
    }

    @Test(expected = RuntimeException.class)
    @Parameters(method = "getInvalidArg")
    public void shouldThrowIllegalExceptionForInvalidArg(Object invalidArg) {
//        stringReverse = new StringReverse(invalidArg);
        stringReverse.reverse("sl");
//        stringReverse.reverse(invalidArg);
    }
}
