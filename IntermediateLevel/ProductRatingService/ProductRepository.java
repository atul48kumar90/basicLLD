package IntermediateLevel.ProductRatingService;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

public class ProductRepository {
    private final Map<String, Product> products = new HashMap<>();
    private final Map<String, ReentrantLock> locks = new HashMap<>();

    public void addProduct(Product p){
        products.put(p.getname(), p);
        locks.put(p.getname(), new ReentrantLock());
    }

    public Product getProduct(String productId){
        return products.get(productId);
    }

    public void removeProduct(String productId){
        products.remove(productId);
    }

    public Collection<Product> getAll(){
        return products.values();
    }

    public ReentrantLock getLock(String name){
        return locks.get(name);
    }
}
