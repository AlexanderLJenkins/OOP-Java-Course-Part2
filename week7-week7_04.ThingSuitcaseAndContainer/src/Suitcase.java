
import java.util.ArrayList;

/**
 * A class for a suitcase that contains things.
 * 
 * @author Alex Jenkins
 */

public class Suitcase {
    
    private ArrayList<Thing> thingsInSuitcase;
    private final int TOTAL_ALLOWED_WEIGHT;

    public Suitcase(int TOTAL_ALLOWED_WEIGHT) {
        this.thingsInSuitcase = new ArrayList<Thing>();
        this.TOTAL_ALLOWED_WEIGHT = TOTAL_ALLOWED_WEIGHT;
    }
    
    public void addThing(Thing thing) {
        
        if (totalWeight() + thing.getWeight() <= this.TOTAL_ALLOWED_WEIGHT) {
            this.thingsInSuitcase.add(thing);
        }
        
    }
    
    public int totalWeight() {
        // Calculate the current weight of the suitcase
        
        int weightOfThings = 0;
        for (Thing thing : this.thingsInSuitcase) {
            weightOfThings += thing.getWeight();
        }
        
        return weightOfThings;
    }
    
    public void printThings() {

        for (Thing thing : this.thingsInSuitcase) {
            System.out.println(thing);
        }
        
    }
    
    public Thing heaviestThing() {
        // Return a reference to the heaviest thing in the suitcase
        
        if (this.thingsInSuitcase.isEmpty()) {
            return null;
        }
        
        Thing heaviestThing = this.thingsInSuitcase.get(0);
        
        for (Thing thing : this.thingsInSuitcase) {
            if (thing.getWeight() > heaviestThing.getWeight()) {
                heaviestThing = thing;
            }
        }
        
        return heaviestThing;
    }
    
    public String toString() {
        
        if (this.thingsInSuitcase.isEmpty()) {
            return "empty (0 kg)";
        }
        
        if (this.thingsInSuitcase.size() == 1) {
            return "" + this.thingsInSuitcase.size() + " thing (" + totalWeight() + " kg)";
        }
        
        return "" + this.thingsInSuitcase.size() + " things (" + totalWeight() + " kg)";
    }
}
