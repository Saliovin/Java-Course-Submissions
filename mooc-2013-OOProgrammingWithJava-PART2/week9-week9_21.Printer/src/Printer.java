
import java.io.File;
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
public class Printer {
    private File file;
    private Scanner reader;
    
    public Printer(String fileName) throws Exception{
        file = new File(fileName);
    }
    
    public void printLinesWhichContain(String word) throws Exception{
        reader = new Scanner(file);
        if(word.isEmpty()) {
            while(reader.hasNextLine()) {
                String line = reader.nextLine();
                System.out.println(line);
            }
            return;
        }
        
        while(reader.hasNextLine()) {
            String text = reader.nextLine();
            if(text.contains(word)) {
                System.out.println(text);
            }
        }
    }
}
