/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package containers;

/**
 *
 * @author Apo
 */
public class ProductContainerRecorder extends ProductContainer{
    private ContainerHistory history;
    
    public ProductContainerRecorder(String productName, double capacity, double initialVolume) {
        super(productName, capacity);
        history = new ContainerHistory();
        this.addToTheContainer(initialVolume);
    }
    
    public void printAnalysis() {
        System.out.println("Product: " + this.getName() + "\n" +
                "History: " + this.history() + "\n" +
                "Greatest product amount: " + history.maxValue() + "\n" +
                "Smallest product amount: " + history.minValue() + "\n" +
                "Average: " + history.average() + "\n" +
                "Greatest change: " + history.greatestFluctuation() + "\n" +
                "Variance: " + history.variance());
    }
    
    public String history() {
        return history.toString();
    }
    
    @Override
    public void addToTheContainer(double amount) {
        super.addToTheContainer(amount);
        history.add(super.getVolume());
    }
    
    @Override
    public double takeFromTheContainer(double amount) {
        double taken = super.takeFromTheContainer(amount);
        history.add(super.getVolume());
        return taken;
    }
}
