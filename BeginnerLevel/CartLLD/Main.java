package CartLLD;

public class Main {
    public static void main(String[] args) {
        CartService service = new CartService();

        // Add products
        service.addProduct("P1", "Laptop", 800);
        service.addProduct("P2", "Mouse", 25);
        service.addProduct("P3", "Keyboard", 45);

        // User adds items
        service.addToCart("U1", "P1", 1);
        service.addToCart("U1", "P2", 2);
        service.addToCart("U1", "P3", 1);
        service.showCart("U1");

        // Update quantity
        service.updateQuantity("U1", "P2", 3);
        service.showCart("U1");

        // Remove item
        service.removeFromCart("U1", "P3");
        service.showCart("U1");

        // Invalid product
        service.addToCart("U1", "P99", 1);
    }
}
