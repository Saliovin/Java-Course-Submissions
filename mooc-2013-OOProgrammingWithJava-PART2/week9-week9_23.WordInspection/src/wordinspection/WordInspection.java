/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wordinspection;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Apo
 */
public class WordInspection {
    private File file;
    
    public WordInspection(File file) {
        this.file = file;
    }
    
    public int wordCount() throws Exception{
        int words = 0;
        Scanner reader = new Scanner(file, "UTF-8");
        
        while(reader.hasNextLine()) {
            words++;
            reader.nextLine();
        }
        
        return words;
    }
    
    public List<String> wordsContainingZ() throws Exception{
        Scanner reader = new Scanner(file, "UTF-8");
        List<String> words = new ArrayList<String>();
        
        while(reader.hasNextLine()) {
            String word = reader.nextLine();
            if(word.contains("z")) {
                words.add(word);
            }
        }
        
        return words;
    }
    
    public List<String> wordsEndingInL() throws Exception{
        Scanner reader = new Scanner(file, "UTF-8");
        List<String> words = new ArrayList<String>();
        
        while(reader.hasNextLine()) {
            String word = reader.nextLine();
            if(word.endsWith("l")) {
                words.add(word);
            }
        }
        
        return words;
    }
    
    public List<String> palindromes() throws Exception{
        Scanner reader = new Scanner(file, "UTF-8");
        List<String> words = new ArrayList<String>();
        
        while(reader.hasNextLine()) {
            String word = reader.nextLine();
            if(isPalindrome(word)) {
                words.add(word);
            }
        }
        
        return words;
    }
    
     public List<String> wordsWhichContainAllVowels() throws Exception{
        Scanner reader = new Scanner(file, "UTF-8");
        List<String> words = new ArrayList<String>();
        
        while(reader.hasNextLine()) {
            String word = reader.nextLine();
            if(containsAllVowels(word)) {
                words.add(word);
            }
        }
        
        return words;
     }
    
    private boolean isPalindrome(String word) {
        String reverse = "";
        
        for(int i = word.length() - 1; i >= 0; i--) {
            reverse += word.charAt(i);
        }
        
        if(word.equals(reverse)) {
            return true;
        }
        
        return false;
    }
    
    private boolean containsAllVowels(String word) {
        if(word.contains("a") && word.contains("e") && word.contains("i") &&
                word.contains("o") && word.contains("u") && word.contains("y") 
                && word.contains("ä") && word.contains("ö")) {
            return true;
        }
        
        return false;
    }
}
