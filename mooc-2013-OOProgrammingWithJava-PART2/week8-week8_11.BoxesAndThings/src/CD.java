/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Apo
 */
public class CD implements ToBeStored{
    private String artist;
    private String title;
    private int publishingYear;
    private final double weight;
    
    public CD(String artist, String title, int publishingYear) {
        this.artist = artist;
        this.title = title;
        this.publishingYear = publishingYear;
        weight = 0.1;
    }
    
    public double weight() {
        return weight;
    }
    
    public String toString() {
        return artist + ": " + title + " (" + publishingYear + ")";
    }
}
