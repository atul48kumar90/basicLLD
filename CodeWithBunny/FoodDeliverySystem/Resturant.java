package CodeWithBunny.FoodDeliverySystem;

import java.util.List;

public class Resturant {
    private final String resturantId;
    private final String name;
    private final Address address;
    private Menu menu;
    private double rating;
    private List<Review> reviews;

    public Resturant(String resturantId, String name, Address address){
        this.resturantId = resturantId;
        this.name = name;
        this.address = address;
        this.menu = new Menu();
    }

    public void updateResturantInfo(){}
    public void updateMenu(Menu menu){}
}
