/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Apo
 */
public class PersonalDuplicateRemover implements DuplicateRemover{
    private Set<String> set;
    private int numberOfDuplicates;
    public PersonalDuplicateRemover() {
        set = new HashSet<String>();
        numberOfDuplicates = 0;
    }
    
    @Override
    public void add(String characterString) {
        if(set.contains(characterString)) {
            numberOfDuplicates++;
        }
        
        set.add(characterString);
    }

    @Override
    public int getNumberOfDetectedDuplicates() {
        return numberOfDuplicates;
    }

    @Override
    public Set<String> getUniqueCharacterStrings() {
        return set;
    }

    @Override
    public void empty() {
        set.clear();
        numberOfDuplicates = 0;
    }
    
}
