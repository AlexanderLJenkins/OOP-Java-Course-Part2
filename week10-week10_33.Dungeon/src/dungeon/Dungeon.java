package dungeon;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;
import java.util.Scanner;

/**
 * A class for the dungeon game.
 * Rules:
 * 1) Vampires move randomly, and take one step for every player move.
 * 2) If the player and vampire run into each other, vampire is destroyed.
 * 3) Game characters cannot move out of the dungeon.
 * 4) Vampires cannot step into the same place.
 * 4) Game is won by destroying all vampires before lamp life (moves) = 0
 * @author Alex Jenkins
 */
public class Dungeon {

    private final int LENGTH;
    private final int HEIGHT;
    private final int VAMPIRES;
    private final boolean VAMPIRES_MOVE;
    private int moves;
    private Random random;
    private Person player;
    private Scanner reader;
    private Collection<Vampire> vampires;

    
    public Dungeon(int LENGTH, int HEIGHT, int VAMPIRES, int moves, boolean VAMPIRES_MOVE) {
        this.LENGTH = LENGTH;
        this.HEIGHT = HEIGHT;
        this.VAMPIRES = VAMPIRES;
        this.VAMPIRES_MOVE = VAMPIRES_MOVE;
        this.moves = moves;
        this.random = new Random();
        this.player = new Person();
        this.reader = new Scanner(System.in);
        this.vampires = initialiseVampires();
    }
    
    private Collection<Vampire> initialiseVampires() {
        // A class to initialise the positions of the vampires
        Collection<Vampire> collectionOfVampires = new ArrayList<Vampire>(); 
        
        int vampiresAdded = 0;
        while (vampiresAdded < VAMPIRES) {
            Vampire newVampire = new Vampire(random.nextInt(LENGTH), random.nextInt(HEIGHT));
            if (!newVampire.atSamePosition(player)) {
                if (!collectionOfVampires.contains(newVampire)) {
                    collectionOfVampires.add(newVampire);
                    vampiresAdded++;
                }    
            }
        }
        return collectionOfVampires;
    }
    
    public void run() {
        // A function to run the dungeon game
        while(true) {
            if (moves == 0) {
                // Out of moves!
                break;
            }
            printUI();
            String operations = reader.nextLine();
            runOperations(operations);
            vampires = remainingVampiresAfterMove();
            if (vampires.isEmpty()) {
                System.out.println("YOU WIN");
                break;
            }
            moves--;
        }
        System.out.println("YOU LOSE");
    }

    public int getHEIGHT() {
        return HEIGHT;
    }

    public int getLENGTH() {
        return LENGTH;
    }

    private void printUI() {
        // A function to display the interfaces after every round
        System.out.println(moves);
        System.out.println("");
        System.out.println(player);
        for (Vampire vampire : vampires) {
            System.out.println(vampire);
        }
        System.out.println("");
        printDungeon();
        System.out.println("");
    }

    private void printDungeon() {
        // A function to display the dungeon floor with the character symbols
        String dungeon = "";
        
        for (int y = 0; y < HEIGHT; y++) {
            for (int x = 0; x < LENGTH; x++) {
                boolean characterAtPosition = false;
                if (player.getX() == x && player.getY() == y) {
                    dungeon += player.getSYMBOL();
                    characterAtPosition = true;
                } else {
                    for (Vampire vampire : vampires) {
                        if (vampire.getX() == x && vampire.getY() == y) {
                            dungeon += vampire.getSYMBOL();
                            characterAtPosition = true;
                        }
                    }
                }
                if (!characterAtPosition) {
                    dungeon += ".";
                }
            }
            dungeon += "\n";
        }
        System.out.println(dungeon);
    }

    private void runOperations(String operations) {
        // Operation string consist of w (up), a (left), s (down), d (right)
        // This function changes the positions of each game character
        player.move(operations, this);
        if (VAMPIRES_MOVE) {
            for (Vampire vampire : vampires) {
                vampire.move(operations, this);
            }
        }
    }

    private Collection<Vampire> remainingVampiresAfterMove() {
        // A function to check is player has destroyed a vampire
        // Returns a collection of remaining vampires
        Collection<Vampire> remainingVampires = new ArrayList<Vampire>();
        for (Vampire vampire : vampires) {
            if (!vampire.atSamePosition(player)) {
                remainingVampires.add(vampire);
            }
        }
        return remainingVampires;
    }
    
}
