package dungeon;

/**
 * In this exercise, you implement a dungeon game. 
 * In the game, the player is in a dungeon full of vampires. 
 * The player has to destroy the vampires before his lamp runs out of battery
 * and the vampires can suck his blood in the darkness.
 * The player can see the vampires with a blinking of their lamp,
 * after which they have to move blind before the following blinking.
 * With one move, the player can walk as many steps as they want.
 * @author Alex Jenkins
 */
public class Main {
    public static void main(String[] args) {
        new Dungeon(10,10,5,14,true).run();
    }
}
