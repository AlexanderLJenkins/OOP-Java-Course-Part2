package drawing.ui;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class DrawingBoard extends JPanel {

    public DrawingBoard() {
        super.setBackground(Color.WHITE);
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        graphics.setColor(Color.BLACK);
        graphics.fillRect(80, 40, 60, 60);
        graphics.fillRect(260, 40, 60, 60);
        graphics.fillRect(40, 200, 60, 60);
        graphics.fillRect(300, 200, 60, 60);
        graphics.fillRect(100, 260, 200, 60);
    }
}
