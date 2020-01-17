
import java.util.ArrayList;

/**
 * A class for a box, which stores things that are to be stored.
 * @author Alex Jenkins
 */
public class Box implements ToBeStored {
    private double maxWeight;
    private ArrayList<ToBeStored> items;
    
    public Box(double maxWeight) {
        this.maxWeight = maxWeight;
        this.items = new ArrayList<ToBeStored>();
    }
    
    public void add(ToBeStored item) {
        // A method to add an item to the box if weight restriction permits
        double itemWeight = item.weight();
        
        if (itemWeight + this.weight() <= this.maxWeight) {
            this.items.add(item);
        }
    }
    
    public double weight() {
        // A method to calculate the weight of the box currently
        double weight = 0;
        
        for (ToBeStored item : items) {
            weight += item.weight();
        }
        
        return weight;
    }
    
    @Override
    public String toString() {
        return "Box: " + this.items.size() + " things, total weight " + this.weight() + " kg";
    }
}
