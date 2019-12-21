
import java.util.Scanner;

/**
 * A class for a user interface on the terminal
 * 
 * @author Alex Jenkins
 */
public class TextUserInterface {
    
    private Scanner reader;
    private Dictionary dictionary;
    
    public TextUserInterface(Scanner reader, Dictionary dictionary) {
        this.dictionary = dictionary;
        this.reader = reader;
    }
    
    public void start() {
        
        while(true) {
            
            System.out.print("Statement: ");
            String statement = this.reader.nextLine();
            
            if (statement.equals("quit")) {
                System.out.println("Cheers!");
                break;
            } else if (statement.equals("add")) {
                add();
            } else if (statement.equals("translate")) {
                translation();
            } else {
                System.out.println("Unknown statemnt");
            }
            
            System.out.println("");
        }
        
    }
    
    public void add() {
        // Add a translation via the user interface
        
        System.out.print("Give a word: ");
        String word = this.reader.nextLine();
        System.out.print("Translation: ");
        String translation = this.reader.nextLine();
        
        this.dictionary.add(word, translation);
    }
    
    public void translation() {
        // Get the translation of a given word
        
        System.out.print("Give a word: ");
        String word = this.reader.nextLine();
        String translation = this.dictionary.translate(word);
        System.out.println("Translation: " + translation);
    }
}
