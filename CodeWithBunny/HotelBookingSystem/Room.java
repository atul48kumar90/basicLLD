package CodeWithBunny.HotelBookingSystem;

public class Room {
    private final String roomId;
    private final String hotelId;
    private final Type roomType;
    private Status status;
    private int price;

    public Room(String roomId, String hotelId, Type roomType, Status status, int price){
        this.roomId = roomId;
        this.hotelId = hotelId;
        this.roomType = roomType;
        this.status = status;
        this.price = price;
    }

}
