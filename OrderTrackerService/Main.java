package OrderTrackerService;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        FoodDeliveryService service = new FoodDeliveryService();

        // Register users
        service.registerUser("U1", "Alice");
        service.registerUser("U2", "Bob");

        // Place some orders
        service.placeOrder("U1", Arrays.asList("Burger", "Fries", "Coke"));
        service.placeOrder("U1", Arrays.asList("Pizza", "Garlic Bread"));
        service.placeOrder("U2", Arrays.asList("Biryani", "Raita"));

        // Update order status
        service.updateOrderStatus("O1", OrderStatus.CONFIRMED);
        service.updateOrderStatus("O1", OrderStatus.IN_PROGRESS);
        service.updateOrderStatus("O1", OrderStatus.OUT_FOR_DELIVERY);
        service.updateOrderStatus("O1", OrderStatus.DELIVERED);

        // Cancel one order
        service.updateOrderStatus("O3", OrderStatus.CANCELLED);
        service.updateOrderStatus("O3", OrderStatus.IN_PROGRESS); // should not update

        // Show details
        service.showOrderDetails("O1");
        service.showUserOrders("U1");
        service.showUserOrders("U2");

        // Edge case
        service.updateOrderStatus("O99", OrderStatus.IN_PROGRESS);
    }
}
