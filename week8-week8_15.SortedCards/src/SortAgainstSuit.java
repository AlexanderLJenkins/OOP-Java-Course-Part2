
import java.util.Comparator;

/**
 * A class to sort cards depending on suit
 * @author Alex Jenkins
 */
public class SortAgainstSuit implements Comparator<Card> {
    
    public int compare(Card card1, Card card2) {
        return card1.getSuit()-card2.getSuit();
    }
}
