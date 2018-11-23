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

public class Hand implements Comparable<Hand>{
    private ArrayList<Card> hand;
    
    public Hand() {
        hand = new ArrayList<Card>();
    }
    
    public void add(Card card) {
        hand.add(card);
    }
    
    public void print() {
        for(Card i : hand) {
            System.out.println(i);
        }
    }
    
    public void sort() {
        for(int i = 0; i < hand.size(); i++) {
            for(int j = i + 1; j < hand.size(); j++) {
                if(hand.get(i).compareTo(hand.get(j)) == 1) {
                    Card temp = hand.get(i);
                    hand.set(i, hand.get(j));
                    hand.set(j, temp);
                }
            }
        }
    }
    
    public int getValue() {
        int value = 0;
        for(Card i : hand) {
            value += i.getValue();
        }
        return value;
    }
    
    public int compareTo(Hand hand) {
        int thisValue = this.getValue();
        int otherValue = hand.getValue();
        if(thisValue > otherValue) {
            return 1;
        }
        if(thisValue == otherValue) {
            return 0;
        }
        return -1;
    }
    
    public void sortAgainstSuit() {
        SortAgainstSuitAndValue suitSorter = new SortAgainstSuitAndValue();
        hand.sort(suitSorter);
    }
}
