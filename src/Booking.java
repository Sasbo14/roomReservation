import java.time.LocalDateTime;

public class Booking implements Comparable<Booking>{
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Room room;
    private User user;

    public Booking(LocalDateTime startTime, LocalDateTime endTime, Room room, User user) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.room = room;
        this.user = user;
    }

    @Override
    public int compareTo(Booking other) {
        return this.startTime.compareTo(other.startTime);
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public Room getRoom() {
        return room;
    }

    public User getUser() {
        return user;
    }
}
