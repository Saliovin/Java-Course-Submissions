/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movable;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Apo
 */
public class Group implements Movable{
    private List<Movable> movableObjects;
    
    public Group() {
        movableObjects = new ArrayList<Movable>();
    }
    
    public String toString() {
        String string = "";
        
        for(Movable i : movableObjects) {
            string += i + "\n";
        }
        
        return string;
    }
    
    public void addToGroup(Movable movable) {
        movableObjects.add(movable);
    }
    
    @Override
    public void move(int dx, int dy) {
        for(Movable i : movableObjects) {
            i.move(dx, dy);
        }
    }
    
}
