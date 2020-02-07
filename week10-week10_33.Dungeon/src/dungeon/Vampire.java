package dungeon;

import java.util.Random;

/**
 * A class for the vampire game character.
 * A vampire starts at a defined location.
 * @author Alex Jenkins
 */
public class Vampire extends GameCharacter {

    private Random random;
    
    public Vampire(int x, int y) {
        super(x, y, 'v');
        random = new Random();
    }
    
    @Override
    public void move(String operations, Dungeon game) {
        // Vampires move in a random direction for every move the person makes
        // i.e. the number of characters in the operations string
        int numberOfMoves = operations.length();
        char[] possibleOperations = {'w','a','s','d'};
        for (int i = 0; i < numberOfMoves; i++) {
            // Chose a random direction
            char operation = possibleOperations[random.nextInt(3)];
            switch (operation) {
                case 'w':
                    super.moveYIfLegal(super.getY()-1, game);
                    break;
                case 'a':
                    super.moveXIfLegal(super.getX()-1, game);
                    break;
                case 's':
                    super.moveYIfLegal(super.getY()+1, game);
                    break;
                case 'd':
                    super.moveXIfLegal(super.getX()+1, game);
                    break;
                default:
                    break;
            }
        }  
    }

    @Override
    public boolean equals(Object obj) {
        // Two vampires are equal is they satisfy the same x, y coordinates
        if (obj == null) {
            return false;
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }
        Vampire object = (Vampire) obj;
        return super.atSamePosition(object);
    }

    @Override
    public int hashCode() {
        return super.getX()*10 + super.getY()*10;
    }
}
