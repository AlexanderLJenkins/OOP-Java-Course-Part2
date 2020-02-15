package wormgame.game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.Timer;
import wormgame.Direction;
import wormgame.domain.Apple;
import wormgame.domain.Piece;
import wormgame.domain.Worm;
import wormgame.gui.Updatable;

/**
 * A class for the worm game GUI and functionality.
 * @author Alex Jenkins
 */
public class WormGame extends Timer implements ActionListener {

    private final int width;
    private final int height;
    private Worm worm;
    private Apple apple;
    private final Random random;
    private boolean continues;
    private Updatable updatable;

    public WormGame(int width, int height) {
        super(1000, null);
        this.width = width;
        this.height = height;
        this.continues = true;

        // Create the worm in the middle of the space
        this.worm = new Worm(width/2, height/2, Direction.DOWN);
        this.random = new Random();
        
        // Apple spawns randomly in the space, but make sure it doesn't spawn on
        // worm
        while(true) {
            this.apple = new Apple(this.random.nextInt(width), 
                this.random.nextInt(height));
            if (!this.worm.runsInto(this.apple)) {
                break;
            }
        }

        addActionListener(this);
        setInitialDelay(2000);
    }

    public boolean continues() {
        return continues;
    }

    public void setUpdatable(Updatable updatable) {
        this.updatable = updatable;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public Worm getWorm() {
        return this.worm;
    }
    
    public void setWorm(Worm worm) {
        this.worm = worm;
    }

    public Apple getApple() {
        return apple;
    }

    public void setApple(Apple apple) {
        this.apple = apple;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (!continues) {
            // Game over
            return;
        }
        // Move the worm
        worm.move();
        Piece head = worm.getPieces().get(worm.getLength()-1);
        if ((head.getX() < 0) || (head.getX() >= width)) {
            continues = false;
        }
        if ((head.getY() < 0) || (head.getY() >= height)) {
            continues = false;
        }
        
        // If the worm runs into the apple, it eats it and grows. New apple 
        // created.
        if (worm.runsInto(apple)) {
            worm.grow();
            while(true) {
                setApple(new Apple(this.random.nextInt(width), 
                    this.random.nextInt(height)));
                if (!this.worm.runsInto(this.apple)) {
                    break;
                }
            }
        }
        // If worm runsIntoItself game over
        if (worm.runsIntoItself()) {
            continues = false;
        }
        
        updatable.update();
        
        // By making the delay a function of worm length, the game gets faster
        // as you progress!
        super.setDelay(1000 / worm.getLength());
    }

}
