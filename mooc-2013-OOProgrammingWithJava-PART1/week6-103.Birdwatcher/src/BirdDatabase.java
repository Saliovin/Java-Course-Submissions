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

public class BirdDatabase {
    private ArrayList<Bird> database;
    
    public BirdDatabase() {
        this.database = new ArrayList<Bird>();
    }
    
    public void addBird(String name, String latinName) {
        database.add(new Bird(name, latinName));
    }
    
    public void addObservation(String name) {
        for(Bird i : database) {
            if(i.toString().contains(name)) {
                i.observation();
                return;
            }
        }
        System.out.println("Is not a Bird!");
    }
    
    public void printBird(String name) {
        for(Bird i : database) {
            if(i.toString().contains(name)) {
                System.out.println(i);
                return;
            }
        }
        System.out.println("Is not a Bird!");
    }
    
    public void printStatistics() {
        for(Bird i : database) {
            System.out.println(i);
        }
    }
}
