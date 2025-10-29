package SingleLevelParkingSlot;

public class ParkService {
    private final ParkingLot parkingLot;

    public ParkService(ParkingLot parkingLot){
        this.parkingLot = parkingLot;
    }

    public void ParkVehicle(String vehicleNumber){
        ParkingSlot nearestAvailableSlot = parkingLot.getNearestAvailable();
        if(nearestAvailableSlot == null){
            System.out.println("no free slot available");
            return;
        }
        nearestAvailableSlot.parkVehicle(vehicleNumber);
        System.out.printf("✅ Vehicle %s parked at Slot %d%n", vehicleNumber, nearestAvailableSlot.getSlotId());
    }

    public void UnparkVehicle(String vehicleNumber){
        for(ParkingSlot slot : parkingLot.getSlots()){
            if(slot.isOccupied()==true && slot.getVehicleNumber()==vehicleNumber){
                slot.unParkVehicle(vehicleNumber);
                System.out.printf("🚙 Vehicle %s left from Slot %d%n", vehicleNumber, slot.getSlotId());
                return;
            }
        }
        System.out.println("❌ Vehicle not found in parking: " + vehicleNumber);
    }

    public void showStatus() {
        parkingLot.showStatus();
    }
}
