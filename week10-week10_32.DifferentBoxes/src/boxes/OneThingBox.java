package boxes;

/**
 * A class for a box which can contain only one thing.
 * @author Alex Jenkins
 */
public class OneThingBox extends Box {

    private Thing item;
    private boolean added;
    
    public OneThingBox() {
        added = false;
    }
    
    @Override
    public void add(Thing thing) {
        if (!added) {
            item = thing;
            added = true;
        }
    }

    @Override
    public boolean isInTheBox(Thing thing) {
        if (!added) {
            // Nothing added to the box
            return false;
        }
        
        return item.equals(thing);
    }
    
}
