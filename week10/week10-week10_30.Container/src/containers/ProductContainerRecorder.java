package containers;

/**
 * A class to record the contents of products being stored.
 * Inherits properties from ProductContainer.
 * @author Alex Jenkins
 */
public class ProductContainerRecorder extends ProductContainer {
    
    private ContainerHistory recorder;
    
    public ProductContainerRecorder(String productName, double capacity, double 
            initialVolume) {
        super(productName, capacity);
        super.addToTheContainer(initialVolume);
        this.recorder = new ContainerHistory();
        this.recorder.add(initialVolume);
    }
    
    public String history() {
        return recorder.toString();
    }

    public void printAnalysis() {
        // Prints all analysis results
        System.out.println("Product: " + super.getName());
        System.out.println("History: " + history());
        System.out.println("Greatest product amount: " + recorder.maxValue());
        System.out.println("Smallest product amount: " + recorder.minValue());
        System.out.println("Average: " + recorder.average());
        System.out.println("Greatest change: " + recorder.greatestFluctuation());
        System.out.println("Variance: " + recorder.variance());
    }
    
    @Override
    public void addToTheContainer(double amount) {
        // Over-ride method but now adds value to history.
        super.addToTheContainer(amount);
        recorder.add(super.getOriginalCapacity() - super.getCurrentCapacity());
    }

    @Override
    public double takeFromTheContainer(double amount) {
        // Over-ride method but now adds value to history.
        double val = super.takeFromTheContainer(amount);
        recorder.add(super.getOriginalCapacity() - super.getCurrentCapacity());
        return val;
    }
    
    
    
}