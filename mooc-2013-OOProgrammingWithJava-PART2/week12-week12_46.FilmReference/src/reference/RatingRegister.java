/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reference;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import reference.comparator.FilmComparator;
import reference.domain.*;

/**
 *
 * @author Apo
 */
public class RatingRegister {
    private Map<Film, List<Rating>> filmRating;
    private Map<Person, Map<Film, Rating>> personRating;
    
    public RatingRegister() {
        filmRating = new HashMap<Film, List<Rating>>();
        personRating = new HashMap<Person, Map<Film, Rating>>();
    }
    
    public void addRating(Film film, Rating rating) {
        if(!filmRating.containsKey(film)) {
            filmRating.put(film, new ArrayList<Rating>());
        }
        
        filmRating.get(film).add(rating);
    }
    
    public List<Rating> getRatings(Film film) {
        return filmRating.get(film);
    }
    
    public Map<Film, List<Rating>> filmRatings() {
        return filmRating;
    }
    
    public void addRating(Person person, Film film, Rating rating) {
        if(!personRating.containsKey(person)) {
            personRating.put(person, new HashMap<Film, Rating>());
        }
        
        Map<Film, Rating> personalFilmRating = personRating.get(person);
        
        if(!personalFilmRating.containsKey(film)) {
            personalFilmRating.put(film, rating);
            this.addRating(film, rating);
        }
    }
    
    public Rating getRating(Person person, Film film) {
        Rating rating = personRating.get(person).get(film);
        
        if(rating == null) {
            return Rating.NOT_WATCHED;
        }
        
        return rating;
    }

    public Map<Film, Rating> getPersonalRatings(Person person) {
        Map<Film, Rating> ratings = personRating.get(person);
        
        if(ratings == null) {
            ratings = new HashMap<Film, Rating>();
        }
        
        return ratings;
    }
    
    public List<Person> reviewers() {
        List<Person> reviewers = new ArrayList<Person>();
        
        reviewers.addAll(personRating.keySet());
        
        return reviewers;
    }
}
