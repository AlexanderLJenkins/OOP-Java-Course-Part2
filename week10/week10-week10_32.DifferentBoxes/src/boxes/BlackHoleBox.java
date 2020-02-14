package boxes;

/**
 * A class for a black hole box.
 * Anything can be added to this box. But nothing will be found upon search.
 * @author Alex Jenkins
 */
public class BlackHoleBox extends Box {

    @Override
    public void add(Thing thing) {
    }

    @Override
    public boolean isInTheBox(Thing thing) {
        return false;
    }
    
}
