/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reader.criteria;

import java.util.List;

/**
 *
 * @author Apo
 */
public class AtLeastOne implements Criterion{
    private Criterion[] criterions;
    
    public AtLeastOne(Criterion... criterions) {
        this.criterions = criterions;
    }
    
    @Override
    public boolean complies(String line) {
        for(Criterion i : criterions) {
            if(i.complies(line)) {
                return true;
            }
        }
        
        return false;
    }
    
}
