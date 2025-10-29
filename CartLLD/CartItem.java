package CartLLD;

public class CartItem {
    private final Product product;
    private int quantity;

    public CartItem(Product product, int quantity){
        this.product = product;
        this.quantity = quantity;
    }

    public Product getproduct(){
        return product;
    }

    public int getQuantity(){
        return quantity;
    }

    public void setQuantity(int quantity){
        this.quantity = quantity;
    }

    public int getTotalPrice(){
        return product.getPrice()*quantity;
    }
}
