/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boxes;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Apo
 */
public class MaxWeightBox extends Box{
    private int capacity;
    private List<Thing> content;
    
    public MaxWeightBox(int maxWeight) {
        capacity = maxWeight;
        content = new ArrayList<Thing>();
    }

    @Override
    public void add(Thing thing) {
        if(thing.getWeight() + getWeight() > capacity) {
            return;
        }
        
        content.add(thing);
    }

    @Override
    public boolean isInTheBox(Thing thing) {
        return content.contains(thing);
    }
    
    private int getWeight() {
        int weight = 0;
        
        for(Thing i : content) {
            weight += i.getWeight();
        }
        
        return weight;
    }
}
