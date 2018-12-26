/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wormgame.domain;

import java.util.List;
import java.util.ArrayList;
import wormgame.Direction;

/**
 *
 * @author Apo
 */
public class Worm{
    private Direction direction;
    private List<Piece> body;
    private boolean willGrow;
    
    public Worm(int originalX, int originalY, Direction originalDirection) {
        body = new ArrayList<Piece>();
        body.add(new Piece(originalX, originalY));
        direction = originalDirection;
        willGrow = true;
    }
    
    public Direction getDirection() {
        return direction;
    }
    
    public void setDirection(Direction dir) {
        direction = dir;
    }
    
    public int getLength() {
        return body.size();
    }
    
    public List<Piece> getPieces() {
        return body;
    }
    
    public int getX() {
        return body.get(body.size() - 1).getX();
    }
    
    public int getY() {
        return body.get(body.size() - 1).getY();
    }
    
    public void move() {
        if(direction == Direction.UP) {
            createNewHead(0, -1);
        }
        else if(direction == Direction.DOWN) {
            createNewHead(0, 1);
        }
        else if(direction == Direction.LEFT) {
            createNewHead(-1, 0);
        }
        else {
            createNewHead(1, 0);
        }
        
        if(getLength() <= 3) {
            grow();
        }
        
        if(!willGrow) {
            body.remove(0);
        }
        else {
            willGrow = false;
        }
    }
    
    public void grow() {
        willGrow = true;
    }
    
    public boolean runsInto(Piece piece) {
        for(Piece i : body) {
            if(i.getX() == piece.getX() && i.getY() == piece.getY()) {
                return true;
            }
        }
        
        return false;
    } 
    
    public boolean runsIntoItself() {
        Piece head = body.get(body.size() - 1);
        
        for(Piece i : body) {
            if(head.runsInto(i)) {
                if(!head.equals(i)) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    private void createNewHead(int x, int y) {
        Piece head = body.get(body.size() - 1);
        body.add(new Piece(head.getX() + x, head.getY() + y));
    }
}
