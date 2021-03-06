package reader.criteria;

/**
 * A class that implements criterion to accept lines that obey two other criteria.
 * @author Alex Jenkins
 */
public class Both implements Criterion {

    private final Criterion criterion1;
    private final Criterion criterion2;

    public Both(Criterion criterion1, Criterion criterion2) {
        this.criterion1 = criterion1;
        this.criterion2 = criterion2;
    }
    
    @Override
    public boolean complies(String line) {
        return criterion1.complies(line) && criterion2.complies(line);
    }
}
