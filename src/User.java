import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;

public class User {
    private String email;
    private String name;
    private List<Booking> bookings;


    public User(String email, String name){
        this.email = email;
        this.name = name;
        this.bookings = new ArrayList<>();
    }

    public void addBooking(Booking booking) {
        bookings.add(booking);
    }

}
