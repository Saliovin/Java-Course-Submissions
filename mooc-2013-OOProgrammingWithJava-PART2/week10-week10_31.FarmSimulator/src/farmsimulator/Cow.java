/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farmsimulator;

import java.util.Random;

/**
 *
 * @author Apo
 */
public class Cow implements Milkable, Alive{
    private String name;
    private Random rng;
    private double capacity;
    private double amount;
    private static final String[] NAMES = new String[] {
        "Anu", "Arpa", "Essi", "Heluna", "Hely",
        "Hento", "Hilke", "Hilsu", "Hymy", "Ihq", "Ilme", "Ilo",
        "Jaana", "Jami", "Jatta", "Laku", "Liekki",
        "Mainikki", "Mella", "Mimmi", "Naatti",
        "Nina", "Nyytti", "Papu", "Pullukka", "Pulu",
        "Rima", "Soma", "Sylkki", "Valpu", "Virpi"};
    
    public Cow() {
        this("0");
    }
    
    public Cow(String name) {
        rng = new Random();
        
        if(name.equals("0")) {
            name = NAMES[rng.nextInt(NAMES.length)];
        }
        
        this.name = name;
        capacity = (double)15 + rng.nextInt(26);
        amount = 0;
    }
    
    public String getName() {
        return name;
    }
    
    public double getCapacity() {
        return capacity;
    }
    
    public double getAmount() {
        return amount;
    }
    
    @Override
    public String toString(){
        return name + " " + Math.ceil(amount) + "/" + Math.ceil(capacity);
    }

    @Override
    public double milk() {
        double taken = amount;
        amount = 0;
        return taken;
    }

    @Override
    public void liveHour() {
        amount += ((double)7 + rng.nextInt(13)) / 10;
        
        if(amount > capacity) {
            amount = capacity;
        }
    }
}
