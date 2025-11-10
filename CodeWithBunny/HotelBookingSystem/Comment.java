package CodeWithBunny.HotelBookingSystem;

public class Comment {
    private final String email;
    private final String username;
    private String comment;

    public Comment(String email, String username, String comment){
        this.email = email;
        this.username = username;
        this.comment = comment;
    }
}
