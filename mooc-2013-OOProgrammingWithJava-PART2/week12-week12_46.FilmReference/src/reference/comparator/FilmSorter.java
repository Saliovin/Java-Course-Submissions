/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reference.comparator;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import reference.domain.Film;
import reference.domain.Rating;

/**
 *
 * @author Apo
 */
public class FilmSorter implements Comparator<Film>{
    private Map<Film, Rating> ratings;
    
    public FilmSorter(Map<Film, Rating> ratings) {
        this.ratings = ratings;
    }
    
    @Override
    public int compare(Film film1, Film film2) {
        int rating1 = ratings.get(film1).getValue();
        int rating2 = ratings.get(film2).getValue();
        
        if(rating1 < rating2) {
            return 1;
        }
        if(rating1 == rating2) {
            return 0;
        }
        return -1;
    }
    
}
