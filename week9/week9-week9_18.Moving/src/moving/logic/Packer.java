package moving.logic;

import java.util.ArrayList;
import java.util.List;
import moving.domain.*;

/**
 * A class to pack things.
 * @author Alex Jenkins
 */
public class Packer {
    private int boxesVolume;

    public Packer(int boxesVolume) {
        // Pass the size of the box being used
        this.boxesVolume = boxesVolume;
    }
    
    public List<Box> packThings(List<Thing> things) {
        // Put the things into as many new boxes as required
        List<Box> packedBoxes = new ArrayList<Box>();
        
        for (Thing thing : things) {
            Box box = new Box(this.boxesVolume);
            box.addThing(thing);
            packedBoxes.add(box);
        }
        return packedBoxes;
    }
   
    
    
}
