/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Apo
 */
import java.util.ArrayList;
import java.util.Random;

public class Jumper implements Comparable<Jumper>{
    private String name;
    private Random rng;
    private int score;
    private int[] roundVotes;
    private ArrayList<Integer> jumpLengths;
    
    public Jumper(String name, Random rng) {
        jumpLengths = new ArrayList<Integer>();
        this.name = name;
        this.rng = rng;
        score = 0;
    }
    
    public int jump() {
        int length = rng.nextInt(61) + 60;
        jumpLengths.add(length);
        return length;
    }
    
    public void addScore(int length, int[] votes) {
        score += length;
        for(int i = 1; i < 4; i++) {
            score += votes[i];
        }
        roundVotes = votes.clone();
    }
    
    public int[] getRoundVotes() {
        return roundVotes;
    }
    
    public ArrayList<Integer> getJumpLengths() {
        return jumpLengths;
    }
    
    public int getLastJumpLength() {
        return jumpLengths.get(jumpLengths.size() - 1);
    }
    
    public int getScore() {
        return score;
    }
    
    public String getName() {
        return name;
    }
    
    @Override
    public int compareTo(Jumper other) {
        int otherScore = other.getScore();
        if(score > otherScore) {
            return 1;
        }
        if(score == otherScore) {
            return 0;
        }
        return -1;
    }
    
    public String toString() {
        return name + " (" + score + " points)";
    }
}
