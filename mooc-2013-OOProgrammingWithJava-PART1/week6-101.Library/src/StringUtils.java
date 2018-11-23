/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Apo
 */
public class StringUtils {
    public static boolean included(String word, String searched) {
        if(word == null || searched == null) {
            return false;
        }
        word = word.toUpperCase();
        searched = searched.toUpperCase();
        searched = searched.trim();
        if(word.contains(searched)) {
            return true;
        }
        return false;
    }
}
