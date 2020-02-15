package wormgame.domain;

/**
 * A class for a piece in the worm game. 
 * The piece position is represented by coordinates x, y in 2D.
 * @author Alex Jenkins
 */
public class Piece {
    
    private int x;
    private int y;

    public Piece(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    public boolean runsInto(Piece piece) {
        // Returns true if the object has the same coordinates as the Piece 
        // instance passed as the parameter
        return (this.x == piece.getX() && this.y == piece.getY());
    }

    @Override
    public String toString() {
        return "(" + this.x + "," + this.y + ")";
    }
}

