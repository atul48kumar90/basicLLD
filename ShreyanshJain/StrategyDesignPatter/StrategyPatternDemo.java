package ShreyanshJain.StrategyDesignPatter;

public class StrategyPatternDemo {
    public static void main(String[] args) {
        Vehicle sedan = new PassangerCar();
        sedan.drive(); // Driving normally...

        Vehicle ferrari = new SportsCar();
        ferrari.drive(); // Driving fast with sports mode!

        Vehicle jeep = new OffRoadVehicle();
        jeep.drive(); // Driving off-road on rough terrain!

        // ✅ Change behavior dynamically at runtime
        System.out.println("\nChanging jeep's strategy dynamically...");
        jeep.driveStrategy = new SportsDriveStrategy();
        jeep.drive(); // Driving fast with sports mode!
    }
}

