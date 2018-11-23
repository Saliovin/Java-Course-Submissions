/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package containers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Apo
 */
public class ContainerHistory {
    private List<Double> history;
    
    public ContainerHistory() {
        history = new ArrayList<Double>();
    }
    
    public void add(double situation) {
        history.add(situation);
    }
    
    public void reset() {
        history.clear();
    }
    
    public double maxValue() {
        if(history.isEmpty()) {
            return 0;
        }
        
        Double max = history.get(0);
        
        for(int i = 1; i < history.size(); i++) {
            max = Double.max(max, history.get(i));
        }
        
        return max;
    }
    
    public double minValue() {
        if(history.isEmpty()) {
            return 0;
        }
        
        Double min = history.get(0);
        
        for(int i = 1; i < history.size(); i++) {
            min = Double.min(min, history.get(i));
        }
        
        return min;
    }
    
    public double average() {
        if(history.isEmpty()) {
            return 0;
        }
        
        Double sum = 0.0;
        
        for(Double i : history) {
            sum += i;
        }
        
        return sum/history.size();
    }
    
    public double greatestFluctuation()  {
        if(history.isEmpty() || history.size() == 1) {
            return 0;
        }
        
        double maxFluctuation = 0;
        
        for(int i = 0; i < history.size() - 1; i++) {
            maxFluctuation = Double.max(maxFluctuation, 
                    Math.abs(history.get(i) - history.get(i + 1)));
        }
        
        return maxFluctuation;
    }
    
    public double variance() {
        if(history.isEmpty() || history.size() == 1) {
            return 0;
        }
        
        Double average = average();
        Double variance = 0.0;
        
        for(int i = 0; i < history.size(); i++) {
            variance += Math.pow(history.get(i) - average, 2);
        }
        
        return variance / (history.size() - 1);
    }
    
    public String toString() {
        return history.toString();
    }
}
