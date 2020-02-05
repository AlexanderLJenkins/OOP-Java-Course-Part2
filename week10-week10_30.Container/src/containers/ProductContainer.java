package containers;

/**
 * A class for a product container.
 * Extends container by adding a name for a product in the container.
 * @author Alex Jenkins
 */
public class ProductContainer extends Container {
    
    private String productName;
    
    public ProductContainer(String productName, double capacity) {
        super(capacity);
        this.productName = productName;
    }

    public String getName() {
        return productName;
    }

    public void setName(String productName) {
        this.productName = productName;
    }

    @Override
    public String toString() {
        return productName + ": " + super.toString(); //To change body of generated methods, choose Tools | Templates.
    } 
}
