/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon;

/**
 *
 * @author Apo
 */
public abstract class Character {
    private int xPos;
    private int yPos;
    private int xLimit;
    private int yLimit;
    
    public Character(int xStartPos, int yStartPos, int xLimit, int yLimit) {
        xPos = xStartPos;
        yPos = yStartPos;
        this.xLimit = xLimit;
        this.yLimit = yLimit;
    }
    
    public void walk(char direction) {
        if(direction == 'x') {
            return;
        }
        
        if(direction == 'w') {
            if(yPos > 0) {
                yPos--;
            }
        }
        else if(direction == 'd') {
            if(xPos < xLimit - 1) {
                xPos++;
            }
        }
        else if(direction == 's') {
            if(yPos < yLimit - 1) {
                yPos++;
            }
        }
        else if(direction == 'a') {
            if(xPos > 0) {
                xPos--;
            }
        }
    }
    
    public int getXPos() {
        return xPos;
    }
    
    public int getYPos() {
        return yPos;
    }
}
