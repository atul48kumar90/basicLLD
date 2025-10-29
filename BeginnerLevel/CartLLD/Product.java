package CartLLD;

public class Product {
    private final String productId;
    private final String productName;
    private final int price;

    public Product(String productId, String productName, int price) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
    }

    public String getId(){
        return productId;
    }

    public String getname(){
        return productName;
    }

    public int getPrice(){
        return price;
    }

    @Override
    public String toString() {
        return productName + " ($" + price + ")";
    }
}
