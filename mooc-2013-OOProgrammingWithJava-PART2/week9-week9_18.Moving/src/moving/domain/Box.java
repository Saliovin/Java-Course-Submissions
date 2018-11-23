/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moving.domain;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Apo
 */
public class Box implements Thing{
    private int capacity;
    private List<Thing> content;
    
    public Box(int maximumCapacity) {
        capacity = maximumCapacity;
        content = new ArrayList<Thing>();
    }
    
    public boolean addThing(Thing thing) {
        int newVolume = getVolume() + thing.getVolume();
        if(newVolume > capacity) {
            return false;
        }
        content.add(thing);
        return true;
    }

    @Override
    public int getVolume() {
        int volume = 0;
        for(Thing i : content) {
            volume += i.getVolume();
        }
        return volume;
    }
}
