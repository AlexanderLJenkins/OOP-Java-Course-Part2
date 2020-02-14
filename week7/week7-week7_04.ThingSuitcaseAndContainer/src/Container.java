
import java.util.ArrayList;

/**
 * A class for a container (stores suitcases)
 * @author Alex Jenkins
 */
public class Container {
    
    private ArrayList<Suitcase> suitcasesInContainer;
    private final int TOTAL_ALLOWED_WEIGHT;
    
    public Container(int TOTAL_ALLOWED_WEIGHT) {
        this.suitcasesInContainer = new ArrayList<Suitcase>();
        this.TOTAL_ALLOWED_WEIGHT = TOTAL_ALLOWED_WEIGHT;
    }
    
    public void addSuitcase(Suitcase suitcase) {
        // Add if allowed by weight restrictions
        
        if (totalWeight() + suitcase.totalWeight() <= this.TOTAL_ALLOWED_WEIGHT) {
            this.suitcasesInContainer.add(suitcase);
        }
    }
    
    public int totalWeight() {
        // Calculate the current weight of the container

        int weightOfSuitcases = 0;
        for (Suitcase suitcase : this.suitcasesInContainer) {
            weightOfSuitcases += suitcase.totalWeight();
        }

        return weightOfSuitcases;
    }
    
    public void printThings() {
        
        for (Suitcase suitcase : this.suitcasesInContainer) {
            suitcase.printThings();
        }
                
    }
        
    public String toString() {
        return "" + suitcasesInContainer.size() + " suitcases (" + totalWeight() + " kg)";
    }
    
    
    
}
