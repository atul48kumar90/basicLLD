package CodeWithBunny.FoodDeliverySystem;

import java.util.List;

public class Order {
    private final String orderId;
    private Cart cart;
    private final String orderTime;
    Payment payment;
    Status status;

    public Order(String orderId, String orderTime){
        this.orderId = orderId;
        this.orderTime = orderTime;
    }
}
