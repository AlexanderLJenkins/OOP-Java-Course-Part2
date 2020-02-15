package wormgame.domain;

import java.util.ArrayList;
import java.util.List;
import wormgame.Direction;

/**
 * A class for the worm in our game.
 * The worm starts off as one piece. Matures to three. Then as it eats it increases
 * in pieces. The worms head is the piece at the end of the piece list.
 * @author Alex Jenkins
 */
public class Worm {
 
    private int headX;
    private int headY;
    private Direction currentDirection;
    private List<Piece> worm;
    
    public Worm(int originalX, int originalY, Direction originalDirection) {
        this.headX = originalX;
        this.headY = originalY;
        this.currentDirection = originalDirection;
        this.worm = new ArrayList<Piece>();
        this.worm.add(new Piece(this.headX, this.headY));
    }
    
    public Direction getDirection() {
        return this.currentDirection;
    }
    
    public void setDirection(Direction dir) {
        // Set a new direction for the worm to take
        this.currentDirection = dir;
    }
    
    public int getLength() {
        // Returns the length of the worm
        return this.worm.size();
    }
    
    public List<Piece> getPieces() {
        return this.worm;
    }
    
    public void move() {
        // Generally when moving, a piece is created in front of the head in the
        // direction of worm motion. Once a piece is created, one tends to be 
        // deleted.
        
        if (Math.abs(headX - worm.get(worm.size()-1).getX()) >= 1 ||
                Math.abs(headY - worm.get(worm.size()-1).getY()) >= 1) {
            // Growth already planned. Implement growth as the move.
            worm.add(new Piece(headX, headY));
            return;
        }
                
        if (worm.size() < 3) {
            // Grow a new piece in front of the head until the worm reaches 
            // maturity (3 pieces in size).
            grow();
            worm.add(new Piece(headX, headY));
        } else {
            // Move the worm by deleting the tail and growing a new piece in front
            // of the head.
            grow();
            worm.remove(0);
            worm.add(new Piece(headX, headY));
        }
    }
    
    public void grow() {
        // Grows the worm by one piece in front of the head, depending on the 
        // current direction. Worm only grows as it moves.
        
        switch(currentDirection) {
            case UP:
                headY-=1;
                break;
            case DOWN:
                headY+=1;
                break;
            case LEFT:
                headX-=1;
                break;
            case RIGHT:
                headX+=1;
                break;
            default:
                break;
        }
    }
    
    public boolean runsInto(Piece piece) {
        // Checks whether the worm runs into the parameter piece.
        for (Piece p : worm) {
            if ((p.getX() == piece.getX()) && (p.getY() == piece.getY())){
                return true;
            } 
        }
        return false;
    }
    
    public boolean runsIntoItself() {
        // Has one of the worm's pieces ran into another one of the worm's pieces?
        if (worm.size() == 1 || worm.isEmpty()) {
            return false;
        }
        for (int p = 0; p < worm.size()-1; p++) {
            // If the head has the same (x,y) as a worm piece, return true
            if ((worm.get(p).getX() == headX) && (worm.get(p).getY() == headY)) {
                return true;
            }
        }
        return false;
    }
}
