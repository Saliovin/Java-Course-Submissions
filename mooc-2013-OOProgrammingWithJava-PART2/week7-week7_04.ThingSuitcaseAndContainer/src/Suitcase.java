/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Apo
 */
import java.util.ArrayList;
public class Suitcase {
    private int maxWeight;
    private ArrayList<Thing> content;
    
    public Suitcase(int maxWeight) {
        this.maxWeight = maxWeight;
        content = new ArrayList<Thing>();
    }
    
    public void addThing(Thing thing) {
        int weightTest = totalWeight() + thing.getWeight();
        if(weightTest > maxWeight) {
            return;
        }
        content.add(thing);
    }
    
    public void printThings() {
        for(Thing i : content) {
            System.out.println(i);
        }
    }
    
    public int totalWeight() {
        int weight = 0;
        for(Thing i : content) {
            weight += i.getWeight();
        }
        return weight;
    }
    
    public Thing heaviestThing() {
        if(content.isEmpty()) {
            return null;
        }
        Thing heaviest = content.get(0);
        for(Thing i : content) {
            if(i.getWeight() > heaviest.getWeight()) {
                heaviest = i;
            }
        }
        return heaviest;
    }
    public String toString() {
        int numOfThings = content.size();
        if(numOfThings == 0) {
            return "empty (0 kg)";
        }
        if(numOfThings == 1) {
            return "1 thing (" + totalWeight() + " kg)";
        }
        return numOfThings + " things (" + totalWeight() + " kg)";
    }
}
