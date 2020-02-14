package movable;

import java.util.ArrayList;
import java.util.List;

/**
 * A class for a group of movable objects.
 * @author Alex Jenkins
 */
public class Group implements Movable{

    private List<Movable> inGroup;

    public Group() {
        this.inGroup = new ArrayList<Movable>();
    }
     
    public void addToGroup(Movable movable) {
        this.inGroup.add(movable);
    }
    
    @Override
    public String toString() {
        String groupString = "";
        for (Movable item : this.inGroup) {
            groupString += item.toString() +"\n";
        }
        return groupString;
    }

    @Override
    public void move(int dx, int dy) {
        // Moves the group, thus each group member, by dx, dy
        for (Movable item : this.inGroup) {
            item.move(dx, dy);
        }
    }
}
