package game;

import gameoflife.GameOfLifeBoard;

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

    private boolean[][] values;
    
    public PersonalBoard(int width, int height) {
        super(width, height);
        this.values = getBoard();
    }

    @Override
    public void initiateRandomCells(double d) {
    }

    @Override
    public boolean isAlive(int i, int i1) {
        /* Tells whether the cell at (x, y) is alive. If the coordinates are 
         * outside the board, the method returns false.
         */
        try {
            return values[i][i1];
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
            values[i][i1] = true;
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
            values[i][i1] = false;
        } catch (Exception e) {
            // Do nothing
        }   
    }

    @Override
    public int getNumberOfLivingNeighbours(int i, int i1) {
        return 0;
    }

    @Override
    public void manageCell(int i, int i1, int i2) {
    }
    
}
