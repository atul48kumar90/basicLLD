package CodeWithBunny.HotelBookingSystem;

public class Location {
    private final String latitude;
    private final String longitude;
    private final int zipCode;
    private String address;
    private final String state;

    public Location(String latitude, String longitude, int zipCode, String address, String state){
        this.latitude = latitude;
        this.longitude = longitude;
        this.zipCode = zipCode;
        this.address = address;
        this.state = state;
    }
}
