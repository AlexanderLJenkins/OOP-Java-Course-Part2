package movingfigure;

import java.awt.Graphics;
import javax.swing.JPanel;

/**
 * A class for a drawing board.
 * Will draw figures to a JPanel GUI.
 * @author Alex Jenkins
 */
public class DrawingBoard extends JPanel {

    private Figure figure;

    public DrawingBoard(Figure figure) {
        this.figure = figure;
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        figure.draw(g);
    }
}
