package movable;

/**
 * A class for an organism.
 * An organism's position is given in 2D coordinates (x,y), and is movable.
 * @author Alex Jenkins
 */
public class Organism implements Movable {
    
    private int x;
    private int y;

    public Organism(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "x: " + this.x + "; y: " + this.y;
    }
    
    
    @Override
    public void move(int dx, int dy) {
        this.x+=dx;
        this.y+=dy;
    }
    
}
