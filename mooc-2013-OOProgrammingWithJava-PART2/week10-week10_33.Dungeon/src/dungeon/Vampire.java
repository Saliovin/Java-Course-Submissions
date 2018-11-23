/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon;

import java.util.Random;

/**
 *
 * @author Apo
 */
public class Vampire extends Character{
    private Random rng;
    private final char[] directions = {'w', 'a', 's', 'd'};
    
    public Vampire(int xStartPos, int yStartPos, int xLimit, int yLimit, Random rng) {
        super(xStartPos, yStartPos, xLimit, yLimit);
        this.rng = rng;
    }
    
    public char generateDirection(boolean state) {
        if(state) {
            return directions[rng.nextInt(4)];
        }
        
        return 'x';
    }
    
    
}
