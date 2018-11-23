/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Apo
 */
public class AverageSensor implements Sensor{
    private List<Sensor> sensors;
    private List<Integer> measurements;
    
    public AverageSensor() {
        sensors = new ArrayList<Sensor>();
        measurements = new ArrayList<Integer>();
    }
    
    public void addSensor(Sensor additional) {
        sensors.add(additional);
    }
    
    public List<Integer> readings() {
        return measurements;
    }
    
    @Override
    public boolean isOn() {
        for(Sensor i : sensors) {
            if(!i.isOn()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void on() {
        for(Sensor i : sensors) {
            if(!i.isOn()) {
                i.on();
            }
        }
    }

    @Override
    public void off() {
        for(Sensor i : sensors) {
            if(i.isOn()) {
                i.off();
            }
        }
    }

    @Override
    public int measure() {
        if(!this.isOn() || sensors.isEmpty()) {
            throw new IllegalStateException();
        }
        
        int ave = 0;
        for(Sensor i : sensors) {
            ave += i.measure();
        }
        ave /= sensors.size();
        measurements.add(ave);
        return ave;
    }
    
}
