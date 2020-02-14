package reader.criteria;

/**
 * A class that implements criterion to accept all the lines a certain criteria
 * does not.
 * @author Alex Jenkins
 */
public class Not implements Criterion {

    private final Criterion criterion;

    public Not(Criterion criterion) {
        this.criterion = criterion;
    }
    
    @Override
    public boolean complies(String line) {
        return !criterion.complies(line);
    }
}
