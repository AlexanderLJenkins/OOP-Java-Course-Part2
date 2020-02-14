package reader.criteria;

/**
 * A class that implements criterion to identify lines >= a certain length.
 * @author Alex Jenkins
 */
public class LengthAtLeast implements Criterion {
    
    private final int minLength;

    public LengthAtLeast(int minLength) {
        this.minLength = minLength;
    }

    @Override
    public boolean complies(String line) {
        return line.length() >= minLength;
    }
}
