package CartLLD;

import java.util.HashMap;
import java.util.Map;

public class Cart {
     private final String userId;
     private final Map<String, CartItem> items = new HashMap<>();

     public Cart(String userId) {
        this.userId = userId;
     }

     public void addItemToCart(Product product, int quantity) {
        items.compute(product.getId(),(id, existingItem) -> {
            if(existingItem == null) {
                return new CartItem(product, quantity);
            }
            else {
                existingItem.setQuantity(existingItem.getQuantity() + quantity);
                return existingItem;
            }
        });
     }

     public void removeItemfromCart(String productId){
        items.remove(productId);
     }

     public void updateQuantity(String productid, int quantity) {
        CartItem item = items.get(productid);
        if(item != null){
            if(quantity <= 0){
                items.remove(productid);
            } else {
                item.setQuantity(quantity);
            }
        }
     }

     public int getTotalCost(){
        return items.values().stream().mapToInt(CartItem::getTotalPrice).sum();
     }
     public int getTotalItem(){
        return items.values().stream().mapToInt(CartItem::getQuantity).sum();
     }

     public void showCart() {
        if (items.isEmpty()) {
            System.out.println("🛒 Cart is empty for user " + userId);
            return;
        }
        System.out.println("\n🛒 Cart for user " + userId + ":");
        for (CartItem item : items.values()) {
            System.out.printf("- %s x %d = $%.2f%n",
                    item.getproduct().getname(),
                    item.getQuantity(),
                    item.getTotalPrice());
        }
        System.out.printf("Total Items: %d | Total Cost: $%.2f%n",
                getTotalItem(), getTotalCost());
    }
}
