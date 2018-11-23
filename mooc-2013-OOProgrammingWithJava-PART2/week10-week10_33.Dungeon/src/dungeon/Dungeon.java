/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Apo
 */
public class Dungeon {
    private final List<Vampire> vampireList;
    private final Character player;
    private final Random rng;
    private final Scanner reader;
    private final int mapLength;
    private final int mapHeight;
    private final boolean vampiresMove;
    private int movesLeft;
    
    public Dungeon(int length, int height, int vampires, int moves, boolean vampiresMove) {
        mapLength = length;
        mapHeight = height;
        movesLeft = moves;
        this.vampiresMove = vampiresMove;
        
        vampireList = new ArrayList<Vampire>();
        player = new Player(length, height);
        rng = new Random();
        reader = new Scanner(System.in);
        
        for(int i = 0; i < vampires; i++) {
            int xStartPos = 0;
            int yStartPos = 0;
            
            while(xStartPos == 0 && yStartPos == 0) {
                xStartPos = rng.nextInt(length);
                yStartPos = rng.nextInt(length);
            }
            
            vampireList.add(new Vampire(xStartPos, yStartPos, length, height, rng));
        }
    }
    
    public void run() {
        while(movesLeft > 0) {
            printState();
            String playerMove = reader.nextLine();
            move(playerMove);
            
            if(vampireList.isEmpty()) {
                System.out.println("YOU WIN");
                return;
            }
            
            movesLeft--;
        }
        
        System.out.println("YOU LOSE");
    }
    
    private void printState() {
        System.out.println(movesLeft);
        System.out.println("");
        printCharacters();
        System.out.println("");
        printMap();
    }
    
    private void printCharacters() {
        System.out.println("@ " + player.getXPos() + " " + player.getYPos());
        
        for(Vampire i: vampireList) {
            System.out.println("v " + i.getXPos() + " " + i.getYPos());
        }
    }
    
    private void printMap() {
        String map = "";
        
        for(int i = mapHeight - 1; i > -1; i--) {
            for(int j = 0; j < mapLength; j++) {
                map += ".";
            }
            
            map += "\n";
        }
        
        char[] c = map.toCharArray();
        c[positionToIndex(player.getXPos(), player.getYPos())] = '@';
        
        for(Vampire i : vampireList) {
            c[positionToIndex(i.getXPos(), i.getYPos())] = 'v';
        }
        
        map = String.valueOf(c);
        System.out.println(map);
    }
    
    private int positionToIndex(int x, int y) {
        int index = x;
        index += (y * mapLength) + y;
        return index;
    }
    
    private void move(String playerMove) {
        List<Vampire> toBeRemoved = new ArrayList<Vampire>();
        
        for(int i = 0; i < playerMove.length(); i++) {
            player.walk(playerMove.charAt(i));
            for(Vampire j : vampireList) {
                j.walk(j.generateDirection(vampiresMove));
                isPlayerTouchingVampire(j, toBeRemoved);
            }
        }
        
        vampireList.removeAll(toBeRemoved);
    }
    
    private void isPlayerTouchingVampire(Vampire vampire, List<Vampire> toBeRemoved) {
        if(player.getXPos() == vampire.getXPos() && 
                player.getYPos() == vampire.getYPos()) {
            toBeRemoved.add(vampire);
        }
    }
}
