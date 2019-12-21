
import java.util.ArrayList;


/**
 * A class to change one single character to another
 * 
 * @author Alex Jenkins
 */
public class Changer {

    private ArrayList<Change> changeList;
    
    public Changer() {
        changeList = new ArrayList<Change>();
    }
     
    public void addChange(Change change) {
        // Adds a new change to the changer
        changeList.add(change);
    }
    
    public String change(String characterString) {
        // Takes string and implements all changes to it stored in changeList

        for (Change change : changeList) {
            characterString = change.change(characterString);
        }
        
        return characterString;
        
    }
    
}
