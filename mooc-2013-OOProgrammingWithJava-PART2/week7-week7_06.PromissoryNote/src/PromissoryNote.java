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

public class PromissoryNote {
    private HashMap<String, Double> loanTable;
    
    public PromissoryNote() {
        loanTable = new HashMap<String, Double>();
    }
    
    public void setLoan(String toWhom, double value) {
        loanTable.put(toWhom, value);
    }
    
    public double howMuchIsTheDebt(String whose) {
        if(loanTable.get(whose) == null) {
            return 0;
        }
        
        return loanTable.get(whose);
    }
}
