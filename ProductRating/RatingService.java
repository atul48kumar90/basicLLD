package ProductRating;

import java.util.HashMap;
import java.util.Map;

public class RatingService {
    Map<String, Product> productMap = new HashMap<>();

    public void addProduct(String productId, String name) {
        productMap.putIfAbsent(productId, new Product(productId, name));
    }

    public void rateProduct(String userId, String productId, int star) {
        if(productMap.get(productId) == null) {
            System.out.println("Product not found");
        } else {

        Product product = productMap.get(productId);
        product.rate(userId, star);

        System.out.println("✅ " + userId + " rated " + product.getName() + " with " + star + " stars");
        }
    }

    public void showProductStats(String productId) {
        Product product = productMap.get(productId);
        if (product == null) {
            System.out.println("❌ Product not found");
            return;
        }
        System.out.printf("⭐ %s -> Avg: %.2f (%d ratings)%n",
                product.getName(),
                product.getAverageRating(),
                product.getTotalRatings());
    }
}
