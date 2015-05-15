import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class) //******* NEED JUNIT 4.11!!!!!! TO RUN
public class FahrenheitCelciusConverterTest {

    public Object[] convertToCelcius() {
        return new Integer[][] {
                { 32, 0 },
                { 98, 36 }, //yells when 37
                { 212, 100 }
        };
    }

    public Object[] getInputToConvertToFahrenheit() {
        return new Integer[][] {
                { 0, 32 },
                { 37, 98 },
                { 100, 212 }
        };
    }

    @Test
    @Parameters(method = "convertToCelcius")
    public void shouldConvertFahrenheitToCelcius(int F, int C) {
        assertEquals(C, FahrenheitCelciusConverter.toCelcius(F));
    }

    @Test
    @Parameters(method = "getInputToConvertToFahrenheit")
    public void shouldConvertCelciusToFahrenheit(int C, int F) {
        assertEquals(F, FahrenheitCelciusConverter.toFahrenheit(C));
    }
}