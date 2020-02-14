package reader.criteria;

import java.util.List;

/**
 * A class that implements at least one of an optional amount of different criteria.
 * @author Alex Jenkins
 */
public class AtLeastOne implements Criterion {

    private final Criterion[] criteria;
    
    public AtLeastOne(Criterion... criteria) {
        this.criteria = criteria;
    }

    @Override
    public boolean complies(String line) {
        boolean atLeastOneComplies = false;
        for (Criterion criterion : criteria) {
            if (criterion.complies(line)) {
                atLeastOneComplies = true;
            }
        }
        return atLeastOneComplies;
    }
}
