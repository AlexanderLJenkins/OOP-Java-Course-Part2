
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * A class to represent a ski jumper.
 * The jumper has a name and gains points upon each jump.
 * @author Alex Jenkins
 */
public class Jumper implements Comparable<Jumper> {

    private String name;
    private int points;
    private int[] votes;
    private List<Integer> lengths;
    private Random random;
    
    public Jumper(String name) {
        this.name = name;
        this.points = 0;
        this.random = new Random();
        this.votes = new int[5];
        this.lengths = new ArrayList<Integer>();
    }

    public String getName() {
        return name;
    }

    public int getPoints() {
        return points;
    }
    
    public void jump() {
        // A method for a ski jump, consists of jump length and voting by judges
        
        // Random number between 60-120 represents jump length
        int length = random.nextInt(60 + 1) + 60;
        this.lengths.add(length);
        
        // Five judges vote. Each vote is a random number between 10-20. 
        int[] sorted = new int[5];
        for (int judge = 0; judge < 5; judge++) {
            int vote = random.nextInt(10 + 1) + 10;
            this.votes[judge] = vote;
            sorted[judge] = vote;
        }

        // Add jump distance and the judge's votes. Smallest and largest votes do not count.
        Arrays.sort(sorted);
        this.points += length + sorted[1] + sorted[2] + sorted[3];
    }
    
    public void printJump() {
        // Prints the jump details in the required format
        System.out.println("  " + this.name);
        System.out.println("    length: " + this.lengths.get((this.lengths.size()-1)));
        System.out.println("    judge votes: " + this.getVotes());
    }
    
    public String printAllJumps() {
        // Print all jumps as a string
        String display = "";
        for (int jump : this.lengths) {
            if (this.lengths.get((this.lengths.size()-1)) == jump) {
                display += jump + "m";
            } else {
                display += jump + "m, ";
            } 
        }
        return display;
    }
    
    public String getVotes() {
        return "[" + this.votes[0] + ", " + this.votes[1] + ", " + this.votes[2] + ", " + this.votes[3] + ", " + this.votes[4] + "]";
    }

    @Override
    public String toString() {
        return this.name + " (" + this.points + " points)";
    }

    @Override
    public int compareTo(Jumper o) {
        // Standard is to sort in reverse by points 
        return this.points - o.getPoints();
    }
    
}
