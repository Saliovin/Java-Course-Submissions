/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Phonebook;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Apo
 */
public class Person implements Comparable<Person>{
    private List<String> numbers;
    private List<String> addresses;
    private String name;
    
    public Person(String name) {
        this.name = name;
        numbers = new ArrayList<String>();
        addresses = new ArrayList<String>();
    }
    
    public void addNumber(String number) {
        if(numbers.contains(number)) {
            return;
        }
        
        numbers.add(number);
    }
    
    public void addAddress(String address) {
        if(addresses.contains(address)) {
            return;
        }
        
        addresses.add(address);
    }

    public List<String> getNumbers() {
        return numbers;
    }

    public List<String> getAddresses() {
        return addresses;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Person o) {
        return name.compareTo(o.getName());
    }
}
