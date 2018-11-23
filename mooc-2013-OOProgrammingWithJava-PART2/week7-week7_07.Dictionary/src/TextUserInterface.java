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

public class TextUserInterface {
    private Scanner reader;
    private Dictionary dictionary;
    
    public TextUserInterface(Scanner reader, Dictionary dictionary) {
        this.reader = reader;
        this.dictionary = dictionary;
    }
    
    public void start() {
        printStatements();
        while(true) {
            String statement = readStatement();
            if(statement.equals("quit")) {
                System.out.println("Cheers");
                return;
            }
            if(statement.equals("add")) {
                add();
            }
            else if(statement.equals("translate")) {
                translate();
            }
            else {
                System.out.println("Unknown statement");
            }
        }
    }
    
    private void printStatements() {
        System.out.println("Statements:");
        System.out.println("  add - adds a word pair to the dictionary");
        System.out.println("  translate - asks a word and prints its translation");
        System.out.println("  quit - quit the text user interface");
    }
    
    private String readStatement() {
        System.out.println("");
        System.out.print("Statement: ");
        return reader.nextLine();
    }
    
    public void add() {
        System.out.print("In Finnish: ");
        String word = reader.nextLine();
        System.out.print("Translation: ");
        String translation = reader.nextLine();
        dictionary.add(word, translation);
    }
    
    public void translate() {
        System.out.print("Give word: ");
        String word = reader.nextLine();
        System.out.println("Translation: " + dictionary.translate(word));
    }
}
