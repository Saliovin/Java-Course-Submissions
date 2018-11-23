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

public class Team {
    
    private String name;
    private ArrayList<Player> players;
    private int maxSize;
    
    public Team(String name) {
        this.name = name;
        this.players = new ArrayList<Player>();
        this.maxSize = 16;
    }
    
    public String getName() {
        return this.name;
    }
    public void addPlayer(Player addedPlayer) {
        if(this.players.size() < this.maxSize) {
            this.players.add(addedPlayer);
        }
    }
    public void addPlayer(String name, int goals) {
        if(this.players.size() < this.maxSize) {
            this.players.add(new Player(name, goals));
        }
    }
    public void printPlayers() {
        for(Player i : players) {
            System.out.println(i);
        }
    }
    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }
    public int size() {
        return this.players.size();
    }
    public int goals() {
        int totalGoals = 0;
        for(Player i : players) {
            totalGoals += i.goals();
        }
        return totalGoals;
    }
}
