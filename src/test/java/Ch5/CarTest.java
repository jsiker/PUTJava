package Ch5;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by m805958 on 5/14/15.
 */

public class CarTest {

    private Car myFerrari = mock(Car.class);

    @Test
    public void testIfCarIsACar() {
        assertTrue(myFerrari instanceof Car);
    }

    @Test
    public void testDefaultBehaviorOfTestDouble() {
        assertFalse("new test double should return false as boolean", myFerrari.needsFuel());
        assertTrue(myFerrari.getEngineTemperature() == 0.0);
    }

    @Test
    public void testStubbing() {
        assertFalse("new dpuble should return false as boolean", myFerrari.needsFuel());
        // stub desired behavior of method (needsFuel previously returned as True, by default
        when(myFerrari.needsFuel()).thenReturn(true);

        assertTrue("after instructed test double should return what we want", myFerrari.needsFuel());
    }

    @Test(expected = RuntimeException.class)
    public void throwException() {
        // stub exception handling
        when(myFerrari.needsFuel()).thenThrow(new RuntimeException());

        myFerrari.needsFuel();
    }

    @Test
    public void testVerification() {
        myFerrari.driveTo("Omaha");
        myFerrari.needsFuel();
        // Verifying above methods we actually called with same params-- not the syntax of (Object).method
        verify(myFerrari).driveTo("Omaha");
        verify(myFerrari).needsFuel();

    }
}
