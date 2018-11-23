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

public class Container {
    private int maxWeight;
    private int weight;
    private ArrayList<Suitcase> content;
    
    public Container(int maxWeight) {
        this.maxWeight = maxWeight;
        weight = 0;
        content = new ArrayList<Suitcase>();
    }
    
    public void addSuitcase(Suitcase suitcase) {
        int totalWeight = weight + suitcase.totalWeight();
        if(totalWeight > maxWeight) {
            return;
        }
        content.add(suitcase);
        weight = totalWeight;
    }
    
    public void printThings() {
        for(Suitcase i : content) {
            i.printThings();
        }
    }
    
    public String toString() {
        return content.size() + " suitcases (" + weight + " kg)";
    }
}
