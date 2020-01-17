/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alex Jenkins
 */
public class MilitaryService implements NationalService {
    
    private int daysLeft;

    public MilitaryService(int daysLeft) {
        this.daysLeft = daysLeft;
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
