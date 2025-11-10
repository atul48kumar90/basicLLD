package CodeWithBunny.FoodDeliverySystem;

public class Review {
    private final String username;
    private final String email;
    private String comment;

    public Review(String username, String email, String comment){
        this.username = username;
        this.email = email;
        this.comment = comment;
    }
}
