/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import gameoflife.GameOfLifeBoard;
import java.util.Random;

/**
 *
 * @author Apo
 */
public class PersonalBoard extends GameOfLifeBoard{
    private Random rng;
    
    public PersonalBoard(int width, int height) {
        super(width, height);
        rng = new Random();
    }

    @Override
    public void initiateRandomCells(double d) {
        for(int y = 0; y < super.getHeight(); y++) {
            for(int x = 0; x < super.getWidth(); x++) {
                if(rng.nextDouble() <= d) {
                    super.getBoard()[x][y] = true;
                }
            }
        }
    }

    @Override
    public boolean isAlive(int i, int i1) {
        if(i < 0 || i >= super.getWidth() || i1 < 0 || i1 >= super.getHeight()) {
            return false;
        }
        
        return super.getBoard()[i][i1];
    }

    @Override
    public void turnToLiving(int i, int i1) {
        if(i < 0 || i >= super.getWidth() || i1 < 0 || i1 >= super.getHeight()) {
            return;
        }
        
        super.getBoard()[i][i1] = true;
    }

    @Override
    public void turnToDead(int i, int i1) {
        if(i < 0 || i >= super.getWidth() || i1 < 0 || i1 >= super.getHeight()) {
            return;
        }
        
        super.getBoard()[i][i1] = false;
    }

    @Override
    public int getNumberOfLivingNeighbours(int i, int i1) {
        int aliveCounter = 0;
        
        for(int y = i1 - 1; y < i1 + 2; y++) {
            for(int x = i - 1; x < i + 2; x++) {
                if(isAlive(x, y)) {
                    aliveCounter++;
                }
            }
        }
        
        if(isAlive(i, i1)) {
            aliveCounter--;
        }
        
        return aliveCounter;
    }

    @Override
    public void manageCell(int i, int i1, int i2) {
        if(i2 < 2 || i2 > 3) {
            turnToDead(i, i1);
        }
        
        else if(i2 == 3) {
            turnToLiving(i, i1);
        }
    }
    
}
