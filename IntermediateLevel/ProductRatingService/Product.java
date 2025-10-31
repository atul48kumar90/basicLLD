package IntermediateLevel.ProductRatingService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class Product {
    private final String productId;
    private final String name;
    private final ProductCategory category;
    private final Map<String, Rating> productMap = new HashMap<>();
    public final AtomicInteger totalStar = new AtomicInteger(0);
    public final AtomicInteger totalRating = new AtomicInteger(0);
    private double cachedAverage = 0.0;

    public Product(String productId, String name, ProductCategory category){
        this.productId = productId;
        this.name = name;   
        this.category = category;
    }

    public String getProductId(){ return productId; }
    public String getname(){ return name; }
    public ProductCategory getCategory(){ return category; }

    public synchronized void rateProduct(String userId, int star, String comment){
        Rating old = productMap.get(userId);
        if(old == null){
            totalRating.incrementAndGet();
            totalStar.addAndGet(star);
        } else{
            totalStar.addAndGet((star - old.getStar()));
        }

        productMap.put(userId, new Rating(userId, star, comment));
        cachedAverage = totalStar.get() / (double) totalRating.get();
    }

    public synchronized int getTotalRating(){
        return totalRating.get();
    }

    public synchronized double getAverageRating(){
        return cachedAverage;
    }

    public synchronized List<Rating> getAllReviews(){
        return new ArrayList<>(productMap.values());
    }
}
