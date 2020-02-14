package reference;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import reference.domain.Film;
import reference.domain.Person;
import reference.domain.Rating;

/**
 * A class to store ratings of films.
 * Stores ratings done by any individual, but also registers ratings done by a 
 * given individual.
 * @author Alex Jenkins
 */
public class RatingRegister {

    private Map<Film, List<Rating>> ratingRegister;
    private Map<Person, Map<Film, Rating>> personRatingRegister;
    
    public RatingRegister() {
        ratingRegister = new HashMap<Film, List<Rating>>();
        personRatingRegister = new HashMap<Person, Map<Film, Rating>>();
    }
    
    public void addRating(Film film, Rating rating) {
        // Adds a new rating to the film. Same film can have various ratings.
        if (!ratingRegister.containsKey(film)) {
            // No ratings for the film, create a new list object
            ratingRegister.put(film, new ArrayList<Rating>());
        }
        ratingRegister.get(film).add(rating);
    }
    
    public List<Rating> getRatings(Film film) {
        // Returns a list of the ratings which were added in connection to a film.
        return ratingRegister.get(film);
    }
    
    public Map<Film, List<Rating>> filmRatings() {
        // Returns the map of films and their ratings.
        return ratingRegister;
    }
    
    public void addRating(Person person, Film film, Rating rating) {
        /* Adds a rating of a specific film by a person.
         * One person can rate only one film. Their rating is added to the total
         * ratingRegister.
         */
        if (!personRatingRegister.containsKey(person)) {
            // No ratings by this person, create a new hashmap and list objects
            personRatingRegister.put(person, new HashMap<Film, Rating>());
        }
        personRatingRegister.get(person).put(film, rating);
        addRating(film, rating);
    }
    
    public Rating getRating(Person person, Film film) {
        // Returns the rating that person has assigned to film.
        if (personRatingRegister.get(person).get(film) == null) {
            return Rating.NOT_WATCHED;
        }
        return personRatingRegister.get(person).get(film);
    }
    
    public Map<Film, Rating> getPersonalRatings(Person person) {
        // Returns a map of films and ratings done by person.
        if (!personRatingRegister.containsKey(person)) {
            personRatingRegister.put(person, new HashMap<Film, Rating>());
        }
        return personRatingRegister.get(person);
    }
    
    public List<Person> reviewers() {
        // Returns a list of the people who have evaluated films.
        ArrayList<Person> p = new ArrayList<Person>(personRatingRegister.keySet());
        return p;
    }
}
