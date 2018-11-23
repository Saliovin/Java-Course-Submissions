/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boxes;

/**
 *
 * @author Apo
 */
public class OneThingBox extends Box{
    private Thing contained;
    
    public OneThingBox() {
        
    }
    
    @Override
    public void add(Thing thing) {
        if(contained == null) {
            contained = thing;
        }
    }

    @Override
    public boolean isInTheBox(Thing thing) {
        if(contained == null) {
            return false;
        }
        
        return contained.equals(thing);
    }
    
}
