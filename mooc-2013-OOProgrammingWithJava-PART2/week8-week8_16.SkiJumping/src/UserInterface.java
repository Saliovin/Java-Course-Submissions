/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Apo
 */
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class UserInterface {
    private final Scanner reader;
    private final Tournament tourney;
    private ArrayList<Jumper> competitors;
    
    public UserInterface() {
        reader = new Scanner(System.in);
        tourney = new Tournament();
        competitors = tourney.getCompetitors();
    }
    
    public void start() {
        System.out.println("Kumpula ski jumping week\n");
        getParticipants();
        startTournament();
    }
    private boolean getParticipant() {
        System.out.print("  Participant name: ");
        String input = reader.nextLine();
        if(input.isEmpty()) {
            return true;
        }
        tourney.addJumper(input);
        return false;
    }
    private void getParticipants() {
        System.out.println("Write the names of the participants one at a time; "
                + "an empty string brings you to the jumping phase.");
        boolean stop = false;
        while(!stop) {
            stop = getParticipant();
        }
        System.out.println("\nThe tournament begins!");
    }
    
    private void startTournament() {
        while(true) {
            System.out.print("\nWrite \"jump\" to jump; otherwise you quit: ");
            String input = reader.nextLine();
            if(input.equals("quit")) {
                break;
            }
            if(input.equals("jump")) {
                startRound();
            }
        }
        System.out.println("\nThanks!");
        printTournamentResults();
    }
    
    private void startRound() {
        int rounds = tourney.getRounds();
        System.out.println("\nRound " + rounds);
        printOrder();
        tourney.startRound();
        System.out.println("\nResults of round " + rounds);
        printResults();
        tourney.sort();
    }
    
    private void printOrder() {
        System.out.println("\nJumping order:");
        for(int i = 0; i < competitors.size(); i++) {
            System.out.println("  " + (i + 1) + ". " + competitors.get(i));
        }
    }
    
    private void printResults() {
        for(Jumper i : tourney.getCompetitors()) {
            System.out.println("  " + i.getName());
            System.out.println("    length: " + i.getLastJumpLength());
            System.out.println("    judge votes: " + 
                    Arrays.toString(i.getRoundVotes()));
        }
    }
    
    private void printTournamentResults() {
        System.out.println("\nTournament results:");
        System.out.println("Position    Name");
        for(int i = 0; i < competitors.size(); i++) {
            int index = competitors.size() - 1 - i;
            System.out.println((i + 1) + "           " + competitors.get(index));
            System.out.println("            jump lengths: " + 
                    competitors.get(index).getJumpLengths());
        }
    }
}
