
import java.util.HashMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alex Jenkins
 */
public class PromissoryNote {

    private HashMap<String, Double> people;
    
    public PromissoryNote() {
        this.people = new HashMap<String, Double>();
    }

    public void setLoan(String toWhom, double value) {
        
        this.people.put(toWhom, value);
    }
    
    public double howMuchIsTheDebt(String whose) {
        // Returns debt of whose
        
        if (this.people.get(whose) == null) {
            return 0;
        }
        
        return this.people.get(whose);
    }
    
}
