
import java.util.Comparator;

/**
 * A class to sort jumpers in descending order according to their points
 * @author Alex Jenkins
 */
public class SortByPoints implements Comparator<Jumper> {
    
    @Override
    public int compare(Jumper o1, Jumper o2) {
        // Compare jumpers in descending order
        return o2.getPoints() - o1.getPoints();
    }
}
