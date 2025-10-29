package OrderTrackerService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
    private final String orderId;
    private OrderStatus status;
    private final Date createdAt;
    private final String userId;
    private final List<String> itemList;

    public Order(String orderId, String userId, List<String> items){
        this.orderId = orderId;
        this.userId = userId;
        itemList = items;
        this.createdAt = new Date();
        this.status = OrderStatus.PLACED;
    }

    public String getOrderId(){
        return orderId;
    }

    public String getUserId(){
        return userId;
    }

    public OrderStatus getOrderStatus() {return status;}
    
    public List<String> getListItem() {return itemList;}

    public Date getCreatedAt() { return createdAt; }

    public void updateStatus(OrderStatus updateStatus){
        if(status==OrderStatus.DELIVERED || status == OrderStatus.CANCELLED){
            System.out.println("can not update status");
            return;
        }
        this.status = updateStatus;
        System.out.println(" order status updated");
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", userId='" + userId + '\'' +
                ", items=" + itemList +
                ", status=" + status +
                ", createdAt=" + createdAt +
                '}';
    }
}
