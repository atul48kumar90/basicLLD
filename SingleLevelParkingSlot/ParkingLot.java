package SingleLevelParkingSlot;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    List<ParkingSlot> slotList = new ArrayList<>();

    public ParkingLot(int capacity){
        for(int i=0; i<capacity;i++){
            slotList.add(new ParkingSlot(i, false));
        }
    }

    public ParkingSlot getNearestAvailable(){
        for(ParkingSlot slot : slotList){
            if(slot.isOccupied() == false){
                return slot;
            }
        }
        return null;
    }

    public List<ParkingSlot> getSlots(){
        return slotList;
    }

    public void showStatus() {
        System.out.println("\n🚗 Parking Lot Status:");
        for (ParkingSlot slot : slotList) {
            if (slot.isOccupied()) {
                System.out.printf("Slot %d → Occupied by %s%n", slot.getSlotId(), slot.getVehicleNumber());
            } else {
                System.out.printf("Slot %d → Available%n", slot.getSlotId
                ());
            }
        }
    }
}
