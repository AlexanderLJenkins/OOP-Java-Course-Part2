
import java.util.Scanner;

/**
 * A class to 
 * 
 * @author Alex Jenkins
 */
public class Reader {
    
    private Scanner userInput;

    public Reader() {
        userInput = new Scanner(System.in);
    }
    
    public String readString() {
        return userInput.nextLine(); 
    }
    
    public int readInteger() {
        return Integer.parseInt(userInput.nextLine());
    }
}
