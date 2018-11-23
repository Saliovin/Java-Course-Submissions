/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Apo
 */
import java.util.Random;
import java.util.Arrays;

public class Judges {
    private Random rng;
    private int[] votes;
    
    public Judges(Random rng) {
        this.rng = rng;
        votes = new int[5];
    }
    
    public int[] getVotes() {
        for(int i = 0; i < votes.length; i++) {
            votes[i] = rng.nextInt(11) + 10;
        }
        Arrays.sort(votes);
        return votes;
    }
    
    public String toString() {
        return Arrays.toString(votes);
    }
}
