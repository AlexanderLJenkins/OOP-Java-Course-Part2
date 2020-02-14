package reference.comparator;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import reference.domain.Film;
import reference.domain.Rating;

/**
 * A class to sort films by ratings.
 * @author Alex Jenkins
 */
public class FilmComparator implements Comparator<Film> {

    private Map<Film, List<Rating>> ratings;

    public FilmComparator(Map<Film, List<Rating>> ratings) {
        this.ratings = ratings;
    }
    
    @Override
    public int compare(Film o1, Film o2) {
        // Sort by the average rating of a film
        if (averageRating(o2) >= averageRating(o1)) {
            return 1;
        }
        return -1;
    }
    
    private double averageRating(Film film) {
        // Calculate the average rating of a film.
        double sum = 0;
        Iterator<Rating> it = ratings.get(film).iterator();
        while(it.hasNext()) {
            sum += it.next().getValue();
        }
        return sum / this.ratings.get(film).size();
    }
    
}
