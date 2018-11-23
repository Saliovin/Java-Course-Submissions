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
import java.util.HashMap;

public class VehicleRegister {
    private HashMap<RegistrationPlate, String> owners;
    
    public VehicleRegister() {
        owners = new HashMap<RegistrationPlate, String>();
    }
    
    public boolean add(RegistrationPlate plate, String owner) {
        if(owners.get(plate) == null) {
            owners.put(plate, owner);
            return true;
        }
        return false;
    }
    
    public String get(RegistrationPlate plate) {
        if(owners.containsKey(plate)) {
            return owners.get(plate);
        }
        return null;
    }
    
    public boolean delete(RegistrationPlate plate) {
        if(owners.get(plate) == null) {
            return false;
        }
        owners.replace(plate, null);
        return true;
    }
    
    public void printRegistrationPlates() {
        for(RegistrationPlate i : owners.keySet()) {
            System.out.println(i);
        }
    }
    
    public void printOwners() {
        ArrayList<String> namesOfOwners = new ArrayList<String>();
        for(String i : owners.values()) {
            if(!namesOfOwners.contains(i)) {
                namesOfOwners.add(i);
            }
        }
        for(String i : namesOfOwners) {
            System.out.println(i);
        }
    }
}
