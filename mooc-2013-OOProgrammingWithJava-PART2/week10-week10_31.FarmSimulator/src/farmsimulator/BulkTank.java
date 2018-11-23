/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farmsimulator;

/**
 *
 * @author Apo
 */
public class BulkTank {
    private double capacity;
    private double volume;
    
    public BulkTank() {
        this(2000.0);
    }
    
    public BulkTank(double capacity) {
        this.capacity = capacity;
        volume = 0.0;
    }
    
    public double getCapacity() {
        return capacity;
    }
    
    public double getVolume() {
        return volume;
    }
    
    public double howMuchFreeSpace() {
        return capacity - volume;
    }
    
    public void addToTank(double amount) {
        volume += amount;
        
        if(volume > capacity) {
            volume = capacity;
        }
    }
    
    public double getFromTank(double amount) {
        if(volume < amount) {
            amount = volume;
        }
        
        volume -= amount;
        return amount;
    }
   
    @Override
    public String toString() {
        return Math.ceil(volume) + "/" + Math.ceil(capacity);
    }
}
