package ProductRating;

public class Main {
    public static void main(String[] args) {
        RatingService service = new RatingService();

        // Add products
        service.addProduct("P1", "Wireless Earbuds");
        service.addProduct("P2", "Smart Watch");

        // Users rate products
        service.rateProduct("U1", "P1", 5);
        service.rateProduct("U2", "P1", 4);
        service.rateProduct("U3", "P1", 3);
        service.showProductStats("P1"); // Avg: 4.0 (3 ratings)

        // Same user updates rating
        service.rateProduct("U2", "P1", 2);
        service.showProductStats("P1"); // Avg recalculated (5 + 2 + 3) / 3 = 3.33

        // Ratings for another product
        service.rateProduct("U1", "P2", 4);
        service.rateProduct("U2", "P2", 5);
        service.showProductStats("P2"); // Avg: 4.5 (2 ratings)

        // Edge case: invalid product
        service.rateProduct("U1", "P99", 4);
    }
}
