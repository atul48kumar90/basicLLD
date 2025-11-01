package ShreyanshJain.StrategyDesignPatter;

public abstract class Vehicle {
    protected DriveStrategy driveStrategy;

    public Vehicle(DriveStrategy driveStrategy){
        this.driveStrategy = driveStrategy;
    }

    public void drive(){
        driveStrategy.drive();
    }
}
