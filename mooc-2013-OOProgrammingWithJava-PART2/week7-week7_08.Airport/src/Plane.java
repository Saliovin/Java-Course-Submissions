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

public class Plane {
    private int capacity;
    private ArrayList<String> flights;
    
    public Plane(int capacity) {
        this.capacity = capacity;
        flights = new ArrayList<String>();
    }
    
    public void addFlight(String path) {
        flights.add(path);
    }
    
    public void printInfo(String id) {
        System.out.println(id + " (" + capacity + " ppl)");
    }
    
    public void printFlights(String id) {
        for(String i : flights) {
            System.out.println(id + " (" + capacity + " ppl) (" + i + ")");
        }
    }
}
