/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reference.comparator;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import reference.domain.Person;

/**
 *
 * @author Apo
 */
public class PersonComparator implements Comparator<Person>{
    private Map<Person, Integer> peopleIdentities;
    
    public PersonComparator(Map<Person, Integer> peopleIdentities) {
        this.peopleIdentities = peopleIdentities;
    }
    
    @Override
    public int compare(Person person1, Person person2) {
        int id1 = peopleIdentities.get(person1);
        int id2 = peopleIdentities.get(person2);
        
        if(id1 < id2) {
            return 1;
        }
        if(id1 == id2) {
            return 0;
        }
        return -1;
        
    }
}
