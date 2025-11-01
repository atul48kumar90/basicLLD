package ShreyanshJain.StrategyDesignPatter;

public class PassangerCar extends Vehicle{

    public PassangerCar() {
        super(new NormalDriveStrategy());
    }
    
}

class SportsCar extends Vehicle {
    public SportsCar() {
        super(new SportsDriveStrategy());
    }
}

class OffRoadVehicle extends Vehicle {
    public OffRoadVehicle() {
        super(new OffRoadDriveStrategy());
    }
}