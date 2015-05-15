package Ch4;

/**
 * Created by m805958 on 5/14/15.
 */
public class BookingSystem {
    BookingSystem bookingSystem;

    public BookingSystem(BookingSystem bookingSystem) {
        this.bookingSystem = bookingSystem;
    }

    private int[] hours = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12,
                    13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24};

    private String bookableThings = "guitar";


}
