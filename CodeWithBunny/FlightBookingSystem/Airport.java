package CodeWithBunny.FlightBookingSystem;

import java.lang.reflect.AccessFlag.Location;
import java.util.List;

public class Airport {
    private final String name;
    private final Location location;
    List<Flight> flights;

    public Airport(String name, Location location){
        this.name = name;
        this.location = location;
    }
}
