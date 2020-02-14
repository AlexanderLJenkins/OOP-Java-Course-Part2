
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * A class to simulate a ski jumping competition between different jumpers.
 * @author Alex Jenkins
 */
public class Simulator {
    
    private Scanner reader;
    private int roundNumber;
    private List<Jumper> athletes;
    
    public Simulator() {
        this.reader = new Scanner(System.in);
        this.roundNumber = 1;
        this.athletes = new ArrayList<Jumper>();
    }
    
    private boolean startRound() {
        // Ask if the user wants to start the round or not
        System.out.print("Write \"jump\" to jump; otherwise you quit: ");
        if (this.reader.nextLine().toLowerCase().equals("jump")) {
            // Quit
            return true;
        }
        return false;
    }
    
    private void round() {
        // A round of jumpers jumping
        System.out.println("");
        System.out.println("Round " + this.roundNumber);
        System.out.println("");
        
        // Display jumping order
        int num = 1;
        Collections.sort(this.athletes);
        System.out.println("Jumping order:");
        for (Jumper athlete : this.athletes) {
            System.out.println("  " + num + ". " + athlete);
            athlete.jump();
            num++;
        }
        
        System.out.println("");
        System.out.println("Results of round " + this.roundNumber);
        for (Jumper athlete : this.athletes) {
            athlete.printJump();
        }
        System.out.println("");
        this.roundNumber++;
    }
    
    private void results() {
        // Display the results of the competition
        System.out.println("Tournament results: ");
        Collections.sort(this.athletes, new SortByPoints());
        System.out.println("Position    Name");
        
        int num = 1;
        for (Jumper athlete : this.athletes) {
            System.out.println("" + num + "           " + athlete);
            System.out.println("            jump lengths: " + athlete.printAllJumps());
            num++;
        }
    }
    
    public void start() {
        // Initiate the simulator
        System.out.println("Kumpula ski jumping week");
        System.out.println("");
        
        System.out.println("Write the names of the participants one at a time; "
                + "an empty string brings you to the jumping phase.");
        while(true) {
            // Get each participant name from user input
            System.out.print("  Participant name: ");
            String name = this.reader.nextLine();
            
            if (name.isEmpty()) {
                // Finished adding jumpers, continue to the jumping phase
                break;
            }
            this.athletes.add(new Jumper(name));
        }
        System.out.println("");
        System.out.println("The tournament begins!");
        System.out.println("");
        
        // Continue rounds of jumping until user quits
        while(startRound()) {
            this.round();
        }
        
        System.out.println("");
        System.out.println("Thanks!");
        System.out.println("");
        this.results();
    }
    
    
}
