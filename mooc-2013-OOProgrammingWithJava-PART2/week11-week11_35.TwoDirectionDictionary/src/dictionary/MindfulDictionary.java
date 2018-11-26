package dictionary;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Apo
 */
public class MindfulDictionary {
    private Map<String, String> engToFin;
    private Map<String, String> finToEng;
    private String file;
    private FileWriter writer;
    private Scanner reader;
    
    public MindfulDictionary() {
        engToFin = new HashMap<String, String>();
        finToEng = new HashMap<String, String>();
    }
    
    public MindfulDictionary(String file) {
        this();
        this.file = file;
    }
    
    public boolean load() {
        try {
            File textFile = new File(file);
            reader = new Scanner(textFile);
        
            if(reader == null) {
                return false;
            }
        
            while (reader.hasNextLine() ){
                String line = reader.nextLine();
                String[] parts = line.split(":");   
                add(parts[0], parts[1]);
            }
        }
        catch(Exception e) {
            return false;
        }
        
        return true;
    }
    
    public boolean save() {
        try {
            writer = new FileWriter(file);
            
            for(String i : finToEng.keySet()) {
                writer.write(i + ":" + finToEng.get(i) + "\n");
            }
            
            writer.close();
        }
        catch(Exception e) {
            return false;
        }
        
        return true;
    }
    
    public void add(String word, String translation) {
        if(!finToEng.containsKey(word)) {
            finToEng.put(word, translation);
            engToFin.put(translation, word);
        }
    }
    
    public String translate(String word) {
        String translation = finToEng.get(word);
        
        if(translation == null) {
            translation = engToFin.get(word);
        }
        
        return translation;
    }
    
    public void remove(String word) {
        String translation = translate(word);
        finToEng.remove(word);
        finToEng.remove(translation);
        engToFin.remove(word);
        engToFin.remove(translation);
    }
}
