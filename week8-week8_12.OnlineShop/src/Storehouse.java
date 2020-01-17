
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * A class for a storehouse, used to keep a stock of products
 * @author Alex Jenkins
 */
public class Storehouse {
    
    private Map<String, Integer> storedProducts;
    private Map<String, Integer> productStock;
    
    public Storehouse() {
        this.storedProducts = new HashMap<String, Integer>();
        this.productStock = new HashMap<String, Integer>();
    }
    
    public void addProduct(String product, int price, int stock) {
        // Add a product stock to the storehouse
        this.storedProducts.put(product, price);
        this.productStock.put(product, stock);
    }
    
    public int stock(String product) {
        // Return the stock of the product
        if (this.productStock.get(product) == null) {
            // Not in stock
            return 0;
        }
        return this.productStock.get(product);
    }
    
    public boolean take(String product) {
        // A class to decrease the stock by 1
        int stock = this.stock(product);
        if (stock == 0) {
            // Out of stock
            return false;
        }
        this.productStock.put(product, stock-1);
        return true;
    }
    
    public int price(String product) {
        // Return the price of product
        if (this.storedProducts.get(product) == null) {
            // Product not availible
            return -99;
        }
        return this.storedProducts.get(product); 
    }
    
    public Set<String> products() {
        // Returns a set of names of products in the storehouse
        return this.storedProducts.keySet();
    }
    
}
