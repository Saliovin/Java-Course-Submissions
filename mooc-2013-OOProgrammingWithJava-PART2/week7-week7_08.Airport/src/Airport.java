/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Apo
 */
import java.util.HashMap;

public class Airport {
    private HashMap<String, Plane> planes;
    
    public Airport() {
        planes = new HashMap<String, Plane>();
    }
    
    public void addPlane(String id, int capacity) {
        planes.put(id, new Plane(capacity));
    }
    
    public void addFlight(String id, String path) {
        planes.get(id).addFlight(path);
    }
    
    public void printAllFlights() {
        for(String i : planes.keySet()) {
            planes.get(i).printFlights(i);
        }
    }
    
    public void printPlanes() {
        for(String i : planes.keySet()) {
            printPlane(i);
        }
    }
    
    public void printPlane(String id) {
        planes.get(id).printInfo(id);
    }
}
