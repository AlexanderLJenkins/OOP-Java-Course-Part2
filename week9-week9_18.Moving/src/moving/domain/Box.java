package moving.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * A class for a box, which can store things.
 * @author Alex Jenkins
 */
public class Box implements Thing {
    private int maximumCapacity;
    private List<Thing> thingsInBox;
    
    public Box(int maximumCapacity) {
        this.maximumCapacity = maximumCapacity;
        this.thingsInBox = new ArrayList<Thing>();
    }
    
    public boolean addThing(Thing thing) {
        if (thing.getVolume() + this.getVolume() <= this.maximumCapacity) {
            this.thingsInBox.add(thing);
            return true;
        } 
        return false;
    }

    @Override
    public int getVolume() {
        // Return the volume of objects in the box
        int vol = 0;
        for(Thing thing : this.thingsInBox) {
            vol += thing.getVolume();
        }
        return vol;
    }
    
}
