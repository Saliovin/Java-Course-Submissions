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

public class Box implements ToBeStored{
    private double capacity;
    private ArrayList<ToBeStored> content;
    
    public Box(double capacity) {
        this.capacity = capacity;
        content = new ArrayList<ToBeStored>();
    }
    
    public void add(ToBeStored object) {
        double totalWeight = this.weight() + object.weight();
        if(!(totalWeight > capacity)) {
            content.add(object);
        }
    }
    
    public double weight() {
        double weight = 0.0;
        for(ToBeStored i : content) {
            weight += i.weight();
        }
        return weight;
    }
    
    public String toString() {
        return "Box: " + content.size() + " things, total weight " + 
                this.weight() + " kg";
    }
}
