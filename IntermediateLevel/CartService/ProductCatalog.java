package IntermediateLevel.CartService;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ProductCatalog {
    private final Map<String, Product> products = new ConcurrentHashMap<>();

    public void addProduct(Product p){ products.put(p.getProductId(), p);}
    public Product getProduct(String productId){ return products.get(productId);}
    public Collection<Product> getAllProduct(){ return products.values();}
}
