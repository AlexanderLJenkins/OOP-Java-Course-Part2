package clicker.applicationlogic;

/**
 * A class for a click calculator. 
 * Adds one to the value stored for every time increase is called.
 * @author Alex Jenkins
 */
public class PersonalCalculator implements Calculator {

    private int numberOfClicks;

    public PersonalCalculator() {
        this.numberOfClicks = 0;
    }
    
    @Override
    public int giveValue() {
        return numberOfClicks;
    }

    @Override
    public void increase() {
        numberOfClicks++;
    }
}
