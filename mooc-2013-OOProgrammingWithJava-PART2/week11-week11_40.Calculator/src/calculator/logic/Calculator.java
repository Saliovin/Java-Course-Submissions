/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator.logic;

/**
 *
 * @author Apo
 */
public class Calculator {
    int result;
    
    public Calculator() {
        result = 0;
    }
    
    public void add(int number) {
        result += number;
    }
    
    public void subtract(int number) {
        result -= number;
    }
    
    public void reset() {
        result = 0;
    }
    
    public int getResult() {
        return result;
    }
}
