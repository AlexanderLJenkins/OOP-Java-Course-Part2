package farmsimulator;

import java.util.Collection;

/**
 * Cows are kept and milked in a barn.
 * A standard barn has one milking robot. Each barn has one specific bulk tank.
 * @author Alex Jenkins
 */
public class Barn {
    
    private BulkTank tank;
    private MilkingRobot milkingRobot;

    public Barn(BulkTank tank) {
        this.tank = tank;
        this.milkingRobot = null;
    }

    public BulkTank getBulkTank() {
        return tank;
    }
    
    public void installMilkingRobot(MilkingRobot milkingRobot) {
        // Install a milking robot and connect it to the bulk tank.
        this.milkingRobot = milkingRobot;
        this.milkingRobot.setBulkTank(tank);
    }
    
    public void takeCareOf(Cow cow) {
        // Milks the cow if milking robot installed
        if (milkingRobot == null) {
            throw new IllegalStateException("The MilkingRobot hasn't been installed");
        }
        milkingRobot.milk(cow);
    }
    
    public void takeCareOf(Collection<Cow> cows) {
        // Milks cows using milking robot
        for (Cow cow : cows) {
            takeCareOf(cow);
        }
    }

    @Override
    public String toString() {
        return "Barn: " + tank.toString();
    }  
}
