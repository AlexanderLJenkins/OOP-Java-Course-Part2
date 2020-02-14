package farmsimulator;

/**
 * A class for a bulk tank, used to store a volume of milk.
 * This has a capacity and a current volume of milk stored.
 * @author Alex Jenkins
 */
public class BulkTank {
    
    private double capacity;
    private double volume = 0.0;
    
    public BulkTank() {
        this.capacity = 2000; // Standard
    }

    public BulkTank(double capacity) {
        this.capacity = capacity;
    }

    public double getCapacity() {
        return capacity;
    }
    
    public double getVolume() {
        return volume;
    }
    
    public double howMuchFreeSpace() {
        return capacity - volume;
    }
    
    public void addToTank(double amount) {
        if (amount < 0) {
            return;
        }
        if (volume + amount > capacity) {
            volume = capacity;
            return;
        }
        volume += amount;
    }
    
    public double getFromTank(double amount) {
        if (amount < 0) {
            return 0.0;
        }
        
        if (amount > volume) {
            double everything = volume;
            volume = 0.0;
            return everything;
        }
        volume -= amount;
        return amount;
    }

    @Override
    public String toString() {
        return "" + Math.ceil(volume) + "/" + Math.ceil(capacity);
    }
}
