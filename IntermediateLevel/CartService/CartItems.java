package IntermediateLevel.CartService;


public class CartItems {
    private Product product;
    private int quantity;

    public CartItems(Product product, int quantity){
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct(){ return product; }
    public int getQuantity(){ return quantity; }
    public void setQuantity(int q ){ this.quantity = q; }
    public double getTotalPrice(){ return product.getProductPrice() * quantity; }
}
