package OrderTrackerService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FoodDeliveryService {
    Map<String, User> usermap = new HashMap<>();
    Map<String, Order> orderMap = new HashMap<>();

    public void registerUser(String userId, String name){
        usermap.put(userId, new User(userId, name));
    }

    public void placeOrder(String userId, List<String> items){
        User user = usermap.get(userId);

        if(user == null){ System.out.println(" user not found");}
        String orderId = "0" + items.size();
        Order order = new Order(orderId, userId, items);
        orderMap.put(orderId, order);
        user.addOrder(orderId);
    }

    public void updateOrderStatus(String orderId, OrderStatus newStatus) {
        Order order = orderMap.get(orderId);
        if (order == null) {
            System.out.println("❌ Order not found: " + orderId);
            return;
        }
        order.updateStatus(newStatus);
    }

    public void showOrderDetails(String orderId) {
        Order order = orderMap.get(orderId);
        if (order == null) {
            System.out.println("❌ Invalid order ID");
            return;
        }
        System.out.println(order);
    }

    public void showUserOrders(String userId) {
        User user = usermap.get(userId);
        if (user == null) {
            System.out.println("❌ Invalid user ID");
            return;
        }

        System.out.println("📦 Orders for " + user.getName() + ":");
        for (String orderId : user.getOrderHistory()) {
            Order order = orderMap.get(orderId);
            System.out.println(" - " + order.getOrderId() + " [" + order.getOrderStatus() + "] Items: " + order.getListItem());
        }
    }
}
