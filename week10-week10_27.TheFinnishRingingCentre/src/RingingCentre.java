
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A class for a bird watching center.
 * Will record the observation times and places of birds in a specific year.
 * @author Alex Jenkins
 */
public class RingingCentre {
    
    private Map<Bird, List<String>> birdPlaces;

    public RingingCentre() {
        this.birdPlaces = new HashMap<Bird, List<String>>();
    }
    
    private void addNewBird(Bird bird) {
        this.birdPlaces.put(bird, new ArrayList<String>());
    }
    
    public void observe(Bird bird, String place) {
        // A method for a bird observation
        if (this.birdPlaces.get(bird) == null) {
            addNewBird(bird);
        }
        this.birdPlaces.get(bird).add(place);
    }
    
    public void observations(Bird bird) {
        if (this.birdPlaces.get(bird) == null) {
            addNewBird(bird);
        }
        System.out.println(bird + " observations: " + this.birdPlaces.get(bird).size());
        for (String place : this.birdPlaces.get(bird)) {
            System.out.println(place);
        }
    }
}

