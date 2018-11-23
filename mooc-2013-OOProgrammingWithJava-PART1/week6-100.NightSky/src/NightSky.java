/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Apo
 */
public class NightSky {
    private double density;
    private int height;
    private int width;
    private int starsInLastPrint;
    
    
    public NightSky(double density, int width, int height) {
        this.density = density;
        this.height = height;
        this.width = width;
        this.starsInLastPrint = 0;
    }
    
    public NightSky(double density) {
        this(density, 20, 10);
    }
    
    public NightSky(int width, int height) {
        this(0.1, width, height);
    }
    
    public void printLine() {
        for(int i = 0; i < this.width; i++) {
            if(Math.random() <= this.density) {
                System.out.print("*");
                starsInLastPrint++;
            }
            else {
                System.out.print(" ");
            }
        }
        System.out.println("");
    }
    
    public void print() {
        this.starsInLastPrint = 0;
        for(int i = 0; i < this.height; i++) {
            printLine();
        }
    }
    
    public int starsInLastPrint() {
        return starsInLastPrint;
    }
}
