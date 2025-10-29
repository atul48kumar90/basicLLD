package CartLLD;

import java.util.HashMap;
import java.util.Map;

public class CartService {
    private final Map<String, Product> products = new HashMap<>();
    private final Map<String, Cart> carts = new HashMap<>();

    public void addProduct(String id, String name, int price) {
        products.put(id, new Product(id, name, price));
    }

    public void addToCart(String userId, String productId, int quantity) {
        Product product = products.get(productId);
        if (product == null) {
            System.out.println("❌ Product not found: " + productId);
            return;
        }
        carts.computeIfAbsent(userId, Cart::new)
             .addItemToCart(product, quantity);
    }

    public void updateQuantity(String userId, String productId, int quantity) {
        Cart cart = carts.get(userId);
        if (cart != null) {
            cart.updateQuantity(productId, quantity);
        }
    }

    public void removeFromCart(String userId, String productId) {
        Cart cart = carts.get(userId);
        if (cart != null) {
            cart.removeItemfromCart(productId);
        }
    }

    public void showCart(String userId) {
        Cart cart = carts.get(userId);
        if (cart == null) {
            System.out.println("🛒 No cart found for user " + userId);
            return;
        }
        cart.showCart();
    }
}
