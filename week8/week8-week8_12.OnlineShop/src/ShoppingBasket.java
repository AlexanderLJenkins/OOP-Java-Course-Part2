
import java.util.ArrayList;
import java.util.List;

/**
 * A class for a shopping basket, you can purchase items available in the storehouse
 * @author Alex Jenkins
 */
public class ShoppingBasket {
    
    private List<Purchase> basket;

    public ShoppingBasket() {
        this.basket = new ArrayList<Purchase>();
    }
    
    public void add(String product, int price) {
        // Add a purchase to the shopping basket
        Purchase item = new Purchase(product, 1, price);
        
        if (!this.basket.contains(item)) {
            // If not in the basket, just add the item
            this.basket.add(item);
            return;
        }
        
        // Item is in the basket, update the amount being purchased
        int index = this.basket.indexOf(item);
        this.basket.get(index).increaseAmount();
    }
    
    public int price() {
        // Return the price of the shopping basket
        int price = 0;
        for (Purchase item : this.basket) {
            price += item.price();
        }
        return price;
    }
    
    public void print() {
        // Prints all purchase objects which are in the basket
        for (Purchase item : this.basket){
            System.out.println(item);
        }
    }
    
}
