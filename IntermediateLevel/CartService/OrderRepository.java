package IntermediateLevel.CartService;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class OrderRepository {
    private final Map<String, Order> orders = new ConcurrentHashMap<>();
    public void save(Order o) { orders.put(o.toString(), o); } 
    public Collection<Order> all() { return orders.values(); }
}
