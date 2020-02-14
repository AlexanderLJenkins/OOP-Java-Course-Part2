package game;

import gameoflife.GameOfLifeBoard;
import java.util.Random;

/**
 * Game of Life is a simple "population simulator" which was developed by the 
 * mathematician John Conway.
 * 
 * Game of Life rules:
 * 1) Every living cell dies if they have less than two living neighbours.
 * 2) Every living cell keeps on living during the following iteration (i.e. 
 *    turn) if they have two or three living neighbours.
 * 3) Every living cell dies if they have more than three living neighbours.
 * 4) Every dead cell is turned back to life if they have exactly three living 
 *    neighbours.
 * 
 * @author Alex Jenkins
 */

public class PersonalBoard extends GameOfLifeBoard {

    private Random random;
    
    public PersonalBoard(int width, int height) {
        super(width, height);
        this.random = new Random();
    }

    @Override
    public void initiateRandomCells(double d) {
        /* Initiates all the cells of the board: every cell is alive with a 
         * probability 'd' [0, 1].
         */
        for (int i = 0; i < super.getWidth(); i++) {
            for (int i1 = 0; i1 < super.getHeight(); i1++) {
                // Draw a new random number, compare to 'd' to assign cell value
                double randomNumber = random.nextDouble();
                if (randomNumber <= d) {
                    turnToLiving(i, i1);
                } else {
                    turnToDead(i, i1);
                }
            }
        }
    }

    @Override
    public boolean isAlive(int i, int i1) {
        /* Tells whether the cell at (x, y) is alive. If the coordinates are 
         * outside the board, the method returns false.
         */
        try {
            return super.getBoard()[i][i1];
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public void turnToLiving(int i, int i1) {
        /* Animates the cell whose coordinates are (x, y), that is to say it 
         * assigns the value true to it. If the coordinates are outside the 
         * board, nothing happens.
         */
        try {
            super.getBoard()[i][i1] = true;
        } catch (Exception e) {
            // Do nothing
        }   
    }

    @Override
    public void turnToDead(int i, int i1) {
        /* Kills the cell whose coordinates are (x, y), that is to say it 
         * assigns the value false to it. If the coordinates are outside the 
         * board, nothing happens. 
         */
        try {
            super.getBoard()[i][i1] = false;
        } catch (Exception e) {
            // Do nothing
        }   
    }

    @Override
    public int getNumberOfLivingNeighbours(int i, int i1) {
        /* Calculates the number of neighbour cells which are alive. Central 
         * cells have eight neighbours, the ones on the side have five, and the
         * ones in the corner have only three.
         */
        int livingNeighbours = 0;
        
        // Loop over all neighbours to count which are alive.
        for (int x = i-1; x <= i+1; x++) {
            for (int y = i1-1; y <= i1+1; y++) {
                if (x == i && y == i1) {
                    // Do not count current cell.
                    continue;
                }
                if (isAlive(x, y)) {
                    livingNeighbours++;
                }
            }
        }
        return livingNeighbours;
    }

    @Override
    public void manageCell(int i, int i1, int livingNeighbours) {
        /** Implements the game of life rules.
         * Game of Life rules:
         * 1) Every living cell dies if they have less than two living neighbours.
         * 2) Every living cell keeps on living during the following iteration (i.e. 
         *    turn) if they have two or three living neighbours.
         * 3) Every living cell dies if they have more than three living neighbours.
         * 4) Every dead cell is turned back to life if they have exactly three living 
         *    neighbours. 
         */
        
        if (isAlive(i, i1)) {
            if (livingNeighbours < 2 || livingNeighbours > 3) {
                turnToDead(i, i1);
            } else {
                turnToLiving(i, i1);
            }
        } else {
            if (livingNeighbours == 3) {
                turnToLiving(i, i1);
            }
        }
    }
    
}
