/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Apo
 */
import java.util.Collections;
import java.util.ArrayList;
import java.util.Random;

public class Tournament {
    private ArrayList<Jumper> competitors;
    private final Random rng;
    private final Judges judges;
    private int rounds;
    
    public Tournament() {
        competitors = new ArrayList<Jumper>();
        rng = new Random();
        judges = new Judges(rng);
        rounds = 1;
    }
    
    public void addJumper(String name) {
        competitors.add(new Jumper(name, rng));
    }
    
    public void startRound() {
        for(Jumper i : competitors) {
            int[] x = judges.getVotes();
            i.addScore(i.jump(), x);
        }
        rounds++;
    }
    
    public int getRounds() {
        return rounds;
    }
    
    public void sort() {
        Collections.sort(competitors);
    }
    
    public ArrayList<Jumper> getCompetitors() {
        return competitors;
    }
}
