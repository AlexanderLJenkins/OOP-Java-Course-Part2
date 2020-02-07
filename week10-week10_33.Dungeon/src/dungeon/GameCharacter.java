package dungeon;

/**
 * An abstract class for a character in the game.
 * Stores their coordinates in the game
 * @author Alex Jenkins
 */
public abstract class GameCharacter {
    
    private int x;
    private int y;
    private final char SYMBOL;

    public GameCharacter(int x, int y, char SYMBOL) {
        this.x = x;
        this.y = y;
        this.SYMBOL = SYMBOL;
    }
    
    public abstract void move(String operations, Dungeon game);

    protected void moveYIfLegal(int moveTo, Dungeon game) {
        if (moveTo >= 0 && moveTo < game.getHEIGHT()) {
            y = moveTo;
        }
    }
    
    protected void moveXIfLegal(int moveTo, Dungeon game) {
        if (moveTo >= 0 && moveTo < game.getLENGTH()) {
            x = moveTo;
        }
    }
    
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    public boolean atSamePosition(GameCharacter character) {
        if (character.getX() != x) {
            return false;
        }
        return character.getY() == y;
    }
    
    public char getSYMBOL() {
        return SYMBOL;
    }
    
    @Override
    public String toString() {
        return SYMBOL + " " + x + " " + y;
    }
}
