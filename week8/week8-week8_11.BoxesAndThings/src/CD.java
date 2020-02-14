/**
 * A class for a CD
 * @author Alex Jenkins
 */
public class CD implements ToBeStored {
    
    private String artist;
    private String title;
    private int yearPublished;
    private final double weight;

    public CD(String artist, String title, int yearPublished) {
        this.artist = artist;
        this.title = title;
        this.yearPublished = yearPublished;
        this.weight = 0.1;
    }

    @Override
    public double weight() {
        return this.weight;
    }

    @Override
    public String toString() {
        return this.artist + ": " + this.title + " (" + this.yearPublished + ")";
    }
    
    

}
