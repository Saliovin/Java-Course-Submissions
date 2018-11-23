
import java.util.Arrays;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Apo
 */
public class Change {
    private char fromChar, toChar;
    
    public Change(char fromCharacter, char toCharacter) {
        fromChar = fromCharacter;
        toChar = toCharacter;
    }
    
    public String change(String characterString) {
        String changedString = "";
        for(int i = 0; i < characterString.length(); i++) {
            char currentChar = characterString.charAt(i);
            if(currentChar == fromChar) {
                changedString += toChar;
            }
            else {
                changedString += currentChar;
            }
        }
        return changedString;
    }
}
