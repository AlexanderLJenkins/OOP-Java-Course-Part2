package reader.criteria;

/**
 * A class which implements criterion to accept all the lines passed.
 * @author Alex Jenkins
 */
public class AllLines implements Criterion {

    @Override
    public boolean complies(String line) {
        return true;
    }
    
}
