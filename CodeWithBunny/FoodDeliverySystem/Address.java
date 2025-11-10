package CodeWithBunny.FoodDeliverySystem;

public class Address {
    private final String longitude;
    private final String latitude;
    private final int zipCode;
    private final String state;
    private final String country;

    public Address(String longitude, String latitude, int zipCode, String state, String country){
        this.longitude = longitude;
        this.latitude = latitude;
        this.zipCode = zipCode;
        this.state = state;
        this.country = country;
    }
}
