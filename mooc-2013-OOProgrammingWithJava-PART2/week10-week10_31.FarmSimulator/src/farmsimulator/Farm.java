/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farmsimulator;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Apo
 */
public class Farm implements Alive{
    private String owner;
    private Barn barn;
    private List<Cow> cows;
    
    public Farm(String name, Barn barn) {
        owner = name;
        this.barn = barn;
        cows = new ArrayList<Cow>();
    }
    
    public String getOwner() {
        return owner;
    }
    
    public void installMilkingRobot(MilkingRobot robot) {
        barn.installMilkingRobot(robot);
    }
    
    public void addCow(Cow newCow) {
        cows.add(newCow);
    }
    
    public void manageCows() {
        barn.takeCareOf(cows);
    }
    
    @Override
    public void liveHour() {
        for(Cow i : cows) {
            i.liveHour();
        }
    }
    
    @Override
    public String toString() {
        String string = "Farm owner: " + owner + "\n" +
            "Barn bulk tank: " + barn + "\n";
        
        if(cows.isEmpty()) {
            string += "No cows.";
        }
        
        string += "Animals:\n";
        
        for(Cow i : cows) {
            string += "        " + i + "\n";
        }
        
        return string;
    }
}
