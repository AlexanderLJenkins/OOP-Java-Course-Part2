package movingfigure;

import java.awt.Graphics;
import java.awt.List;
import java.util.ArrayList;

/**
 * A class for a figure which is a group of figures.
 * @author Alex Jenkins
 */
public class CompoundFigure extends Figure {
    
    private ArrayList<Figure> figureGroup;

    public CompoundFigure() {
        super(0, 0);
        this.figureGroup = new ArrayList<Figure>();
    }

    public void add(Figure f) {
        // Add figure to the group of figures.
        figureGroup.add(f);
    }
    @Override
    public void draw(Graphics graphics) {
        for (Figure fig : figureGroup) {
            fig.draw(graphics);
        }
    }
    
    @Override
    public void move(int dx, int dy) {
        // Compound figures move by telling each figure to move.
        for (Figure fig : figureGroup) {
            fig.move(dx, dy);
        }
    }
}
