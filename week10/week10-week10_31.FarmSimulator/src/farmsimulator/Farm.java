package farmsimulator;

import java.util.ArrayList;
import java.util.Collection;

/**
 * A class for a farm.
 * Farms have an owner, a barn and a heard of cows.
 * @author Alex Jenkins
 */
public class Farm implements Alive {

    private String owner;
    private Barn barn;
    private Collection<Cow> cows;

    public Farm(String owner, Barn barn) {
        this.owner = owner;
        this.barn = barn;
        this.cows = new ArrayList<Cow>();
    }
    
    public void installMilkingRobot(MilkingRobot robot) {
        barn.installMilkingRobot(robot);
    }
    
    public void addCow(Cow cow) {
        cows.add(cow);
    }
    
    public void manageCows() {
        // Milk all cows in the heard
        barn.takeCareOf(cows);
    }

    public String getOwner() {
        return owner;
    }
    
    @Override
    public void liveHour() {
        // Makes all cows on the farm live one hour
        for (Cow cow : cows) {
            cow.liveHour();
        }
    }

    @Override
    public String toString() {
        String farmString = "Farm owner " + owner + "\n";
        farmString += "Barn bulk tank: " + barn.getBulkTank().toString() + "\n";
        if (cows.isEmpty()) {
            farmString += "No cows.";
        } else {
            farmString += "Animals: \n";
            for (Cow cow : cows) {
                farmString += "        " + cow.toString() + "\n";
            }
        }
        return farmString;
    }
    
    
    
}
