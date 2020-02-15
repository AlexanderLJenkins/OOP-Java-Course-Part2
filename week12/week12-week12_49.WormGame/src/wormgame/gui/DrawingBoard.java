package wormgame.gui;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import wormgame.domain.Piece;
import wormgame.domain.Worm;
import wormgame.game.WormGame;

/**
 * A class for a drawing board. 
 * The drawing board will paint the worm onto the GUI.
 * @author Alex Jenkins
 */
public class DrawingBoard extends JPanel implements Updatable {

    private final WormGame wormGame;
    private final int pieceLength;

    public DrawingBoard(WormGame wormGame, int pieceLength) {
        // Takes a new WormGame and piece dimensions as constructor variables.
        this.wormGame = wormGame;
        this.pieceLength = pieceLength;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        g.setColor(Color.red);
        g.fillOval(wormGame.getApple().getX()*wormGame.getWidth(), wormGame.getApple().getY()*wormGame.getHeight(), 
                pieceLength*wormGame.getWidth(), pieceLength*wormGame.getHeight());
        
        Worm worm = wormGame.getWorm();
        g.setColor(Color.BLACK);
        for (Piece p : worm.getPieces()) {
            g.draw3DRect(p.getX()*wormGame.getWidth(), p.getY()*wormGame.getHeight(), pieceLength*wormGame.getWidth(), pieceLength*wormGame.getHeight(), true);
        }
    }

    @Override
    public void update() {
        super.repaint();
    }
}
