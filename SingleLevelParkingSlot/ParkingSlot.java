package SingleLevelParkingSlot;

public class ParkingSlot {
    private final int slotId;
    private boolean isOcuupied;
    private String vehicleNumber;

    public ParkingSlot(int slotId, boolean isOcuupied){
        this.slotId = slotId;
        this.isOcuupied = isOcuupied;
    }

    public int getSlotId(){
        return slotId;
    }

    public boolean isOccupied(){
        return isOcuupied;
    }

    public boolean parkVehicle(String vehicleNumber){
        isOcuupied = true;
        this.vehicleNumber = vehicleNumber;
        return isOcuupied;
    }

    public boolean unParkVehicle(String vehicleNumber){
        this.vehicleNumber = null;
        isOcuupied = false;
        return true;
    }

    public String getVehicleNumber(){
        return vehicleNumber;
    }
}
