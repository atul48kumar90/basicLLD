package SingleLevelParkingSlot;

public class Main {
    public static void main(String[] args) {
        ParkingLot lot = new ParkingLot(3); // 3 parking slots
        ParkService service = new ParkService(lot);

        service.ParkVehicle("KA-01-AB-1234");
        service.ParkVehicle("KA-02-CD-5678");
        service.showStatus();

        service.ParkVehicle("KA-03-EF-9999");
        service.showStatus();

        // Lot is now full
        service.ParkVehicle("KA-04-GH-0001");

        // Vehicle leaves
        service.UnparkVehicle("KA-02-CD-5678");
        service.showStatus();

        // Another vehicle parks in the freed slot
        service.ParkVehicle("KA-05-IJ-2222");
        service.showStatus();
    }
}

