/**
 * Created by m805958 on 5/12/15.
 */
public class FahrenheitCelciusConverter {

    public static int toFahrenheit(int c) {
        return c * 9 / 5 + 32;
    }

    public static int toCelcius(int f) {
        return (f - 32) * 5 / 9;
    }
}
