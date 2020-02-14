
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * A class for a hand of cards
 * @author Alex Jenkins
 */
public class Hand implements Comparable<Hand> {
    
    private List<Card> cards;

    public Hand() {
        this.cards = new ArrayList<Card>();
    }
    
    public void add(Card card) {
        // Adds a card to the hand
        this.cards.add(card);
    }
    
    public void print() {
        // Prints the cards in the hand in the same order as they were added
        for (int i = 0; i < this.cards.size(); i++) {
            System.out.println(this.cards.get(i));
        }
    }
    
    public void sort() {
        // Sort the hand by card value and suit
        Collections.sort(this.cards);
    }
    
    private int sumValues() {
        // Sum the values of the cards
        int sumValues = 0;
        for (Card card : this.cards) {
            sumValues += card.getValue();
        }
        return sumValues;
    }

    @Override
    public int compareTo(Hand other) {
        // Compare by sum of card values in hand
        int sumThisHand = this.sumValues();
        int sumOtherHand = other.sumValues();
        return sumThisHand - sumOtherHand;
    }
    
    public void sortAgainstSuit() {
        Collections.sort(this.cards, new SortAgainstSuitAndValue());
    }
    
}
