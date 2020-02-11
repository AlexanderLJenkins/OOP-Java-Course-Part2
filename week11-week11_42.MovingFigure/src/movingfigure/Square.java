package movingfigure;

/**
 * A class for a square type of box.
 * @author Alex Jenkins
 */
public class Square extends Box {

    private int sideLength;
    
    public Square(int x, int y, int sideLength) {
        super(x, y, sideLength, sideLength);
        this.sideLength = sideLength;
    }
}
