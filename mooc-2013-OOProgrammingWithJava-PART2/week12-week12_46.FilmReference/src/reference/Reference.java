/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reference;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import reference.comparator.FilmComparator;
import reference.comparator.FilmSorter;
import reference.domain.Film;
import reference.domain.Person;
import reference.domain.Rating;

/**
 *
 * @author Apo
 */
public class Reference {
    private RatingRegister register;
    
    public Reference(RatingRegister register) {
        this.register = register;
    }
    
    public Film recommendFilm(Person person) {
        FilmComparator filmComparator = new FilmComparator(register.filmRatings());
        Map<Film, Rating> personalRatings = register.getPersonalRatings(person);
        
        if(personalRatings == null || personalRatings.isEmpty()) {
            List<Film> films = new ArrayList<Film>();
            films.addAll(register.filmRatings().keySet());
            Collections.sort(films, filmComparator);
            return films.get(0);
        }
        
        Person recommendedPerson = this.findSimilarPerson(person);
        
        List<Film> films = new ArrayList<Film>();
        films.addAll(register.getPersonalRatings(recommendedPerson).keySet());
        Collections.sort(films, new FilmSorter(register.getPersonalRatings(recommendedPerson)));
        
        for(Film i : films) {
            if(!personalRatings.containsKey(i)) {
                return i;
            }
        }
        
        return null;
    }
    
    private int getSimilarity(Person person1, Person person2) {
        int similarity = 0;
            
        for(Film j : register.getPersonalRatings(person1).keySet()) {
            if(register.getPersonalRatings(person2).containsKey(j)) {
            similarity += register.getRating(person1, j).getValue() *
                        register.getRating(person2, j).getValue();
            }
        }
        
        return similarity;
    }
    
    private Person findSimilarPerson(Person person) {
        int highestSimilarity = -9999;
        Person similarPerson = person;
        
        for(Person i : register.reviewers()) {
            if(person.equals(i)) {
                continue;
            }
            
            int similarity = this.getSimilarity(person, i);
            
            if(similarity > highestSimilarity) {
                similarPerson = i;
                highestSimilarity = similarity;
            }
        }
        
        return similarPerson;
    }
}
