package CodeWithBunny.HotelBookingSystem;

public class User {
    private final String name;
    private final String id;
    private final String email;
    private String phoneNo;
    private String password;

    public User(String name, String id, String email, String phoneNo, String password){
        this.name = name;
        this.id = id;
        this.email = email;
        this.phoneNo = phoneNo;
        this.password = password;
    }
}
