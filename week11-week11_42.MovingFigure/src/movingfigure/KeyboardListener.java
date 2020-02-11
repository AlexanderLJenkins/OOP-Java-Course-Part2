package movingfigure;

import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * A class to listen to keyboard commands and perform the appropriate actions.
 * @author Alex Jenkins
 */
public class KeyboardListener implements KeyListener {

    private Component component;
    private Figure figure;

    public KeyboardListener(Component component, Figure figure) {
        this.figure = figure;
        this.component = component;
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // Listen to arrow keys
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                figure.move(-1, 0);
                break;
            case KeyEvent.VK_RIGHT:
                figure.move(1, 0);
                break;
            case KeyEvent.VK_DOWN:
                figure.move(0, 1); 
                break;
            case KeyEvent.VK_UP:
                figure.move(0, -1);
                break;
            default:
                break;
        }
        component.repaint(); // Updates the painted GUI.
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
    
}
