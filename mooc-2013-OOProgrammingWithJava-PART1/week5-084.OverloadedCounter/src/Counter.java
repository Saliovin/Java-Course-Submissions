/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Apo
 */
public class Counter {
    
    private int value;
    private boolean shouldCheck;
    
    public Counter(int startingValue, boolean check) {
        this.value = startingValue;
        this.shouldCheck = check;
    }
    public Counter(int startingValue) {
        this(startingValue, false);
    }
    public Counter(boolean check) {
        this(0, check);
    }
    public Counter() {
        this(0, false);
    }
    
    public int value() {
        return this.value;
    }
    
    public void increase() {
        this.increase(1);
    }
    public void increase(int increaseAmount) {
        if(increaseAmount > 0) {
            this.value += increaseAmount;
        }
    }
    
    public void decrease() {
        this.decrease(1);
    }
    public void decrease(int decreaseAmount) {
        if(decreaseAmount > 0) {
            if(this.shouldCheck) {
                if(this.value < decreaseAmount) {
                    this.value = 0;
                    return;
                }
            }
            this.value -= decreaseAmount;
        }
    }
}
