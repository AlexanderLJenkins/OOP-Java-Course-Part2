package farmsimulator;

/**
 * A class for a milking robot.
 * Collects milk from cows and deposits in the connected bulk tank.
 * @author Alex Jenkins
 */
public class MilkingRobot {

    private BulkTank tank;
    
    public MilkingRobot() {
        // Initially a bulktank is not connected
        tank = null;
    }
    
    public BulkTank getBulkTank() {
        // Returns the connected bulktank
        return tank;
    }
    
    public void setBulkTank(BulkTank tank) {
        this.tank = tank;
    }
    
    public void milk(Milkable milkable) {
        // Milk the cow and fill the tank, if possible
        if (tank == null) {
            throw new IllegalStateException("The MilkingRobot hasn't been installed");
        }
        tank.addToTank(milkable.milk());
    }
    
}
