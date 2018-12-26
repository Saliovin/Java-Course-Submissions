/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wormgame.domain;

/**
 *
 * @author Apo
 */
public class Piece {
    private int x;
    private int y;
    
    public Piece(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
    
    public void setX(int x) {
        this.x = x;
    }
    
    public void setY(int y) {
        this.y = y;
    }
    
    public boolean runsInto(Piece piece) {
        if(piece.getX() == x && piece.getY() == y) {
            return true;
        }
        
        return false;
    }
    
    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }
}
