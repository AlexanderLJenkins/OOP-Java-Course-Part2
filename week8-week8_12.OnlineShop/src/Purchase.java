/**
 * A class for purchasing products
 * @author Alex Jenkins
 */
public class Purchase {
    
    private String product;
    private int amount;
    private int unitPrice;

    public Purchase(String product, int amount, int unitPrice) {
        this.product = product;
        this.amount = amount;
        this.unitPrice = unitPrice;
    }
    
    public int price() {
        // Returns the price of purchasing the products
        return this.amount * this.unitPrice;
    }
    
    public void increaseAmount() {
        // Increase the amount by 1
        this.amount++;
    }

    public String getProduct() {
        return product;
    }
    
    @Override
    public String toString() {
        return this.product + ": " + this.amount;
    }

    @Override
    public boolean equals(Object object) {
        
        if (object == null) {
            return false;
        }

        if (getClass() != object.getClass()) {
            return false;
        }

        Purchase compared = (Purchase) object;

        if (this.product == null || !this.product.equals(compared.getProduct())) {
            return false;
        }
        
        return true;
    }

    
    
    
}
