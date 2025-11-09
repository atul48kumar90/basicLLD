package CodeWithBunny.CarRentalSystem;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReservationSystem {
    List<User> users;
    List<Car> cars;
    List<Location> location;
    Map<Location, Car> carsAtLocationMap = new HashMap<>();
}
