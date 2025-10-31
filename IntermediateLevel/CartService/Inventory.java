package IntermediateLevel.CartService;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class Inventory {
    private final Map<String, AtomicInteger> stock = new ConcurrentHashMap<>();
    private final Map<String, ReentrantLock> locks = new ConcurrentHashMap<>();

    public void setStock(String productId, int qty){
        stock.put(productId, new AtomicInteger(qty));
        locks.put(productId, new ReentrantLock());
    }

    public int getStock(String productid){
        AtomicInteger a = stock.get(productid);
        return a == null ? 0 : a.get(); 
    }

    public ReentrantLock getLock(String productId){
        return locks.computeIfAbsent(productId, k -> new ReentrantLock());
    }

    public boolean tryReserve(String productid, int qty){
        AtomicInteger a = stock.get(productid);
        if(a == null) return false;
        while(true){
            int current = a.get();
            if(current < qty) return false;
            if (a.compareAndSet(current, current - qty)) return true;
        }
    }

    public void release(String productId, int qty) {
        AtomicInteger a = stock.get(productId);
        if (a != null) a.addAndGet(qty);
    }
}
