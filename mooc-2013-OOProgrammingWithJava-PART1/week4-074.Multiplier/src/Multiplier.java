/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Apo
 */
public class Multiplier {
    
    private int firstNumber;
    
    public Multiplier(int number){
        this.firstNumber = number;
    }
    
    public int multiply(int otherNumber){
        return otherNumber * this.firstNumber;
    }
}
