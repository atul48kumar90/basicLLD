package OrderTrackerService;

import java.util.ArrayList;
import java.util.List;

public class User {
    private final String userId;
    private final String name;
    private final List<String> orderHistory = new ArrayList<>();

    public User(String userId, String name){
        this.userId = userId;
        this.name = name;
    }

    public String getUserId(){ return userId;}

    public String getName(){ return name;}

    public void addOrder(String orderid){orderHistory.add(orderid);}

    public List<String> getOrderHistory(){ return orderHistory;}

}
