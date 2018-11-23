/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moving.logic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import moving.domain.Box;
import moving.domain.Thing;

/**
 *
 * @author Apo
 */
public class Packer {
    private int boxesVolume;
    private List<Box> boxes;
    
    public Packer(int boxesVolume) {
        this.boxesVolume = boxesVolume;
        boxes = new ArrayList<Box>();
    }
    
    public List<Box> packThings(List<Thing> things) {
        Collections.sort((ArrayList)things);
        Box box = new Box(boxesVolume);
        for(Thing i : things) {
            if(!box.addThing(i)) {
                boxes.add(box);
                box = new Box(boxesVolume);
                box.addThing(i);
            }
        }
        boxes.add(box);
        return boxes;
    }
}
