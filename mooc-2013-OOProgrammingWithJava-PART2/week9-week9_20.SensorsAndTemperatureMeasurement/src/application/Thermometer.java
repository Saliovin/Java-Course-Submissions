/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.util.Random;
/**
 *
 * @author Apo
 */
public class Thermometer implements Sensor{
    private boolean state;
    private Random rng;
    public Thermometer() {
        state = false;
        rng = new Random();
    }
    
    @Override
    public boolean isOn() {
        return state;
    }

    @Override
    public void on() {
        state = true;
    }

    @Override
    public void off() {
        state = false;
    }

    @Override
    public int measure() {
        if(!state) {
            throw new IllegalStateException();
        }
        
        return rng.nextInt(61) - 30;
    }
    
}
