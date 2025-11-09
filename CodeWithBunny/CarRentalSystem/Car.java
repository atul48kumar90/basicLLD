package CodeWithBunny.CarRentalSystem;

import java.sql.Date;

public class Car {
    private final String carNumber;
    private final CarType type;
    private final String chesisNumber;
    private double kmDriven;
    private Location currentLocation;
    private Status status;
    private final int price;
    private final Date manfDate;

    public Car(String carNumber, CarType type, String chesisNumber, double kmDriven, Location currLocation, int price, Date manfDate){
        this.carNumber = carNumber;
        this.type = type;
        this.chesisNumber = chesisNumber;
        this.kmDriven = kmDriven;
        this.currentLocation = currLocation;
        this.price = price;
        this.manfDate = manfDate;
    }
    
    public Reservation reserve(){
        return new Reservation();
    }

    public void updateCarDetails(){

    }
}
