/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farmsimulator;

import java.util.Collection;

/**
 *
 * @author Apo
 */
public class Barn {
    private BulkTank tank;
    private MilkingRobot robot;
    
    public Barn(BulkTank tank) {
        this.tank = tank;
    }
    
    public BulkTank getBulkTank() {
        return tank;
    }
    
    public void installMilkingRobot(MilkingRobot milkingRobot) {
        robot = milkingRobot;
        robot.setBulkTank(tank);
    }
    
    public void takeCareOf(Cow cow) {
        try {
            robot.milk(cow);
        }
        catch(Exception e) {
            System.out.println("No Milking Robot installed");
        }
    }
    
    public void takeCareOf(Collection<Cow> cows) {
        for(Cow i : cows) {
            takeCareOf(i);
        }
    }
    
    public String toString(){
        return tank.toString();
    }
}
