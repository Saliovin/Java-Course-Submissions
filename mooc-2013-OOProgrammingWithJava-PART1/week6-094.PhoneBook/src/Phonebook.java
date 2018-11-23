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

public class Phonebook {
    private ArrayList<Person> phonebook;
    
    public Phonebook() {
        phonebook = new ArrayList<Person>();
    }
    
    public void add(String name, String number) {
        phonebook.add(new Person(name, number));
    }
    
    public void printAll() {
        for(Person i : this.phonebook) {
            System.out.println(i);
        }
    }
    
    public String searchNumber(String name) {
        for(Person i : phonebook) {
            if(i.getName().equals(name)) {
                return i.getNumber();
            }
        }
        return "number not known";
    }
}
