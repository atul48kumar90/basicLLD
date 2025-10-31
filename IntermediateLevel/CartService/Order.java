package IntermediateLevel.CartService;

import java.sql.Date;
import java.util.Map;

import OrderTrackerService.OrderStatus;

public class Order {
    private final String orderId;
    private final String userId;
    private final Map<String, Integer> items;
    private final double total;
    private final OrderStatus status;
    private final Date cratedAt;

    public Order(String orderId, String userId, Map<String, Integer> items, double total, OrderStatus status){
        this.orderId = orderId;
        this.userId = userId;
        this.items = items;
        this.total = total;
        this.status = status;
        this.cratedAt = new Date(0);
    }
}
