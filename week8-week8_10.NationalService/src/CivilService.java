/**
 *
 * @author Alex Jenkins
 */

public class CivilService implements NationalService {

    private int daysLeft;
    
    public CivilService() {
        this.daysLeft = 362;
    }
    
    public int getDaysLeft() {
        // Returns the number of days left on service
        return this.daysLeft;
    }
    
    public void work() {
        // Reduces the working days by one
        
        if (this.daysLeft > 0) {
            this.daysLeft--;
        }
    }
}
