package CodeWithBunny.FoodDeliverySystem;

public class FoodItems {
    private final String name;
    private String description;
    private int price;
    private double rating;

    public FoodItems(String name, String description, int price, double rating){
        this.name = name;
        this.description = description;
        this.price = price;
        this.rating = rating;
    }
}
