package CodeWithBunny.FlightBookingSystem;

import java.util.List;

public class Flight {
    private final String id;
    private final Airline airline;
    private List<Seat> seats;
    List<Schedule> schedules;
    private final int capacity;

    public Flight(String id, Airline airline, int capacity){
        this.id = id;
        this.airline = airline;
        this.capacity = capacity;
    }
}
