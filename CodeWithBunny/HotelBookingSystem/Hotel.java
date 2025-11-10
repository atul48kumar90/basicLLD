package CodeWithBunny.HotelBookingSystem;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private final String hotelId;
    private final String hotelName;
    private final int noOfRooms;
    Location location;
    List<Room> rooms = new ArrayList<>();
    private double rating;
    List<Comment> comments = new ArrayList<>();

    public Hotel(String hotelId, String hotelName, int noOfRooms){
        this.hotelId = hotelId;
        this.hotelName = hotelName;
        this.noOfRooms = noOfRooms;
    }
}
