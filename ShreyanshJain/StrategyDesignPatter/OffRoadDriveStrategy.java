package ShreyanshJain.StrategyDesignPatter;

public class OffRoadDriveStrategy implements DriveStrategy{
    
    @Override
    public void drive(){
        System.out.println(" off road drive strategy");
    }
}
