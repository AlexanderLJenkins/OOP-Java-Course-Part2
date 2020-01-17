
import java.util.Comparator;

/**
 * A class to compare cards by suit and value
 * @author Alex Jenkins
 */
public class SortAgainstSuitAndValue implements Comparator<Card> {

    @Override
    public int compare(Card o1, Card o2) {
        // Compare cards by suit and value
        
        if (o1.getSuit() - o2.getSuit() != 0) {
            return o1.getSuit() - o2.getSuit();
        }
        
        return o1.getValue() - o2.getValue();
    }
    
}
