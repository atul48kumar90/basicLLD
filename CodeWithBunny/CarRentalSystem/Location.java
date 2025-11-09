package CodeWithBunny.CarRentalSystem;

public class Location {
    private final String name;
    private final String zipCode;
    private final double lang;
    private final double lat;

    public Location(String name, String zipCode, double lang, double lat){
        this.name = name;
        this.zipCode = zipCode;
        this.lang = lang;
        this.lat = lat;
    }
}
