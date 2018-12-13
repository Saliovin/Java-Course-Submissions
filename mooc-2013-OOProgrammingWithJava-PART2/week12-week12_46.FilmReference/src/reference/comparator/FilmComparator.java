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
public class FilmComparator implements Comparator<Film>{
    private Map<Film, List<Rating>> ratings;
    
    public FilmComparator(Map<Film, List<Rating>> ratings) {
        this.ratings = ratings;
    }
    
    private double getAverage(Film film) {
        double avg = 0.0;
        
        for(Rating i : ratings.get(film)) {
            avg += (double)i.getValue();
        }
        
        return avg / ratings.get(film).size();
    }
    
    @Override
    public int compare(Film film1, Film film2) {
        double avg1 = getAverage(film1);
        double avg2 = getAverage(film2);
        
        if(avg1 < avg2) {
            return 1;
        }
        if(avg1 == avg2) {
            return 0;
        }
        return -1;
    }
}
