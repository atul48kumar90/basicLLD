package CodeWithBunny.FoodDeliverySystem;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private final String cartId;
    private List<FoodItems> foodItems;

    public Cart(String cartId){
        this.cartId = cartId;
        this.foodItems = new ArrayList<>();
    }
}
