package movingfigure;

import java.awt.Graphics;

/**
 * A class for a circle a type of figure.
 * @author Alex Jenkins
 */
public class Circle extends Figure {

    private int diameter;
    
    public Circle(int x, int y, int diameter) {
        super(x, y);
        this.diameter = diameter;
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.fillOval(super.getX(), super.getY(), diameter, diameter);
    }
    
}
