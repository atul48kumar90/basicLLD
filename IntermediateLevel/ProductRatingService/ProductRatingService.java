package IntermediateLevel.ProductRatingService;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

public class ProductRatingService {
    ProductRepository repo ;

    public ProductRatingService(ProductRepository repo){
        this.repo = repo;
    }

    public Product addproduct(String id, String name, ProductCategory category){
        Product p = new Product(id, name, category);
        repo.addProduct(p);
        return p;
    }

    public void RateProduct(String productId, String userid, int star){
        Product p = repo.getProduct(productId);
        if(p == null){
            System.out.println(" there is no product available");
            return;
        }

        ReentrantLock lock = repo.getLock(p.getname());
        lock.lock();

        try {
            p.rateProduct(userid, star, null);
        } finally {
            lock.unlock();
        }
    }

    public void showProductStat(String productId){
        Product p = repo.getProduct(productId);
        if (p == null) {
            System.out.println("❌ Product not found");
            return;
        }
        System.out.printf("⭐ %s -> Avg: %.2f (%d ratings)%n",
                p.getname(),
                p.getAverageRating(),
                p.getTotalRating());
    }
    
}
