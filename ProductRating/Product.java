package ProductRating;

import java.util.HashMap;
import java.util.Map;

public class Product {
    private final String productId;
    private final String name;
    private final Map<String, Rating> userratings = new HashMap<>();
    private int totalRating = 0;

    public Product (String productId, String name) {
        this.productId = productId;
        this.name = name;
    }

    public synchronized void rate(String userId, int star) {
        Rating oldRating = userratings.get(userId);

        if(oldRating != null) {
            totalRating -= oldRating.getStar();
        }

        Rating newRating = new Rating(userId, star);
        userratings.put(userId, newRating);

        totalRating += star;
    }

    public synchronized double getAverageRating() {
        if(userratings.isEmpty()) return 0.0;
        return (double) totalRating / userratings.size();
    }

    public synchronized int getTotalRatings() {
        return userratings.size();
    }

    public String getName() {
        return name;
    }

    public String getProductId() {
        return productId;
    }
}
