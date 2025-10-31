package IntermediateLevel.CartService;

import java.util.HashMap;
import java.util.Map;

class Cart {
    private final String userId;
    private final Map<String, CartItems> items = new HashMap<>(); // productId -> CartItem

    public Cart(String userId) { this.userId = userId; }

    public synchronized void addItem(Product p, int qty) {
        if (qty <= 0) return;
        items.compute(p.getProductId(), (k, existing) -> {
            if (existing == null) return new CartItems(p, qty);
            existing.setQuantity(existing.getQuantity() + qty);
            return existing;
        });
    }

    public synchronized void updateItem(String productId, int qty) {
        CartItems it = items.get(productId);
        if (it == null) return;
        if (qty <= 0) items.remove(productId);
        else it.setQuantity(qty);
    }

    public synchronized void removeItem(String productId) {
        items.remove(productId);
    }

    public synchronized double getTotal() {
        return items.values().stream().mapToDouble(CartItems::getTotalPrice).sum();
    }

    public synchronized Map<String, Integer> snapshotItems() {
        Map<String, Integer> snap = new HashMap<>();
        for (CartItems i : items.values()) snap.put(i.getProduct().getProductId(), i.getQuantity());
        return snap;
    }

    public synchronized void clear() { items.clear(); }

    public synchronized void showCart() {
        System.out.println("\n🛒 Cart for " + userId + ":");
        if (items.isEmpty()) { System.out.println("  (empty)"); return; }
        items.values().forEach(i -> System.out.printf(" - %s x%d = $%.2f%n", i.getProduct().getProductName(), i.getQuantity(), i.getTotalPrice()));
        System.out.printf(" Total items: %d | Total cost: $%.2f%n",
                items.values().stream().mapToInt(CartItems::getQuantity).sum(), getTotal());
    }

    public String getUserId() { return userId; }
}