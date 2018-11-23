/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Phonebook;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Apo
 */
public class Phonebook {
    private Map<String, Person> namePersons;
    private Map<String, Person> numberPersons;
    
    public Phonebook() {
        namePersons = new HashMap<String, Person>();
        numberPersons = new HashMap<String, Person>();
    }
    
    public void addNumber(String name, String number) {
        if(!namePersons.containsKey(name)) {
            Person newPerson = new Person(name);
            namePersons.put(name, newPerson);
            numberPersons.put(number, newPerson);
        }
        
        Person person = namePersons.get(name);
        person.addNumber(number);
        numberPersons.put(number, person);
    }
    
    public void addAddress(String name, String address) {
        if(!namePersons.containsKey(name)) {
            Person newPerson = new Person(name);
            namePersons.put(name, newPerson);
        }
      
        Person person = namePersons.get(name);
        person.addAddress(address);
    }
    
    public List<String> searchNumber(String name) {
        if(namePersons.containsKey(name)) {
            return namePersons.get(name).getNumbers();
        }
        
        return null;
    }
    
    public Person searchPersonByNumber(String number) {
        if(numberPersons.containsKey(number)) {
            return numberPersons.get(number);
        }
        
        return null;
    }
    
    public Person searchPersonByName(String name) {
        if(namePersons.containsKey(name)) {
            return namePersons.get(name);
        }
        
        return null;
    }
    
    public void removeInformation(String name) {
        if(!namePersons.containsKey(name)) {
            return;
        }
        
        List<String> numbers = namePersons.get(name).getNumbers();
        for(String i : numbers) {
            numberPersons.remove(i);
        }
        
        namePersons.remove(name);
    }
    
    public List<Person> searchByKeyword(String keyword) {
        List<Person> filtered = new ArrayList<Person>();
        
        for (String i : namePersons.keySet()) {
            Person person = namePersons.get(i);
            if(i.contains(keyword)) {
                filtered.add(person);
            }
            else {
                ArrayList<String> addresses = 
                        (ArrayList<String>)person.getAddresses();
                if(!addresses.isEmpty()) {
                    if(addresses.get(addresses.size() - 1).contains(keyword)) {
                        filtered.add(person);
                    }
                }
            }
        }
        
        Collections.sort(filtered);
        return filtered;
    }
}
