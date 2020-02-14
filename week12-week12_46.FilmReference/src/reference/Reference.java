package reference;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import reference.comparator.FilmComparator;
import reference.comparator.PersonComparator;
import reference.domain.Film;
import reference.domain.Person;
import reference.domain.Rating;

/**
 * A class that uses the rating register to recommend a film.
 * @author Alex Jenkins
 */
public class Reference {
    
    private RatingRegister ratings;
    
    public Reference(RatingRegister ratings) {
        this.ratings = ratings;
    }
    
    public Film recommendFilm(Person person) {
        
        /** The algorithm to recommend a film to a given person.
         * If the person hasn't rated any films, we just recommend them the top
         * rated film in general. Otherwise, we suggest them a film based on 
         * similar film reviews between person and different reviewers.
         * 
         * Return null in two cases:
         * If you cannot find any film to recommend, or the most similar reviewer
         * has rated poorly to all films which person hasn't watched.
         * 
         * Do not suggest films which have already been watched.
        */
        
        List<Person> reviewers = ratings.reviewers();
        if (!reviewers.contains(person)) {
            // If person has not rated any films, recommend the top rated film.
            Map<Film, List<Rating>> filmRatings = ratings.filmRatings();
            List<Film> films = new ArrayList<Film>(filmRatings.keySet());
            Collections.sort(films, new FilmComparator(filmRatings));
            return films.get(0);
        }
        
        // Find the most similar reviewer
        reviewers.remove(person);
        Person mostSimilarReviewer = findMostSimilarReviewer(person, reviewers);
        
        // If the film has been watched by both people, remove it from the map
        Map<Film, Rating> mostSimilarReviewerRatings = 
                ratings.getPersonalRatings(mostSimilarReviewer);
        mostSimilarReviewerRatings.keySet().removeAll(ratings.getPersonalRatings(person).keySet());
        
        // Create a list of unwatched films
        List<Film> unwatchedFilms = new ArrayList<Film>(mostSimilarReviewerRatings.keySet());
        if (unwatchedFilms.isEmpty()) {
            // Most similar reviewer and person have watched all the same films.
            // Reviewer cannot make recommendation.
            return null;
        }
        
        // Find which unwatched film is rated the highest.
        Film topFilm = unwatchedFilms.get(0);
        for (int i = 1; i < unwatchedFilms.size(); i++) {
            if (mostSimilarReviewerRatings.get(topFilm).getValue() <
                    mostSimilarReviewerRatings.get(unwatchedFilms.get(i)).getValue()) {
                topFilm = unwatchedFilms.get(i);
            }
        }
        
        // If the unwatched film is rated above neutral, it can be recommended.
        if (mostSimilarReviewerRatings.get(topFilm).getValue() <= 
                Rating.NEUTRAL.getValue()) {
            return null;
        }
        return topFilm;
    }
    
    private Person findMostSimilarReviewer(Person person, List<Person> reviewers) {
        /* Personal film recommendations are based on the similarity between the
        person ratings and other reviewers ratings.
        
        Similarity = sum of the products of the ratings for the films watched by
        both.
        
        Return the reviewer who has the most similar film taste as person.
        */
        
        Map<Film, Rating> personRatings = ratings.getPersonalRatings(person);
        Map<Person, Integer> personSimilarity = new HashMap<Person, Integer>();
        
        // Compute the similarity between person and each other reviewer
        for (Person otherReviewer : reviewers) {
            int similarity = 0;
            for (Film f : personRatings.keySet()) {
                // Loop over each film the person in question has watched, and 
                // compute the similarity between each other reviewer
                similarity += ratings.getRating(person, f).getValue() *
                        ratings.getRating(otherReviewer, f).getValue();
            }
            personSimilarity.put(otherReviewer, similarity);
        }
        
        // Sort the list of reviewers by their similarity with person
        Collections.sort(reviewers, new PersonComparator(personSimilarity));
        return reviewers.get(0);
    }
    
}
