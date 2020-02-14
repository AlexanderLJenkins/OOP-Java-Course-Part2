/**
 * A class for a plane, which has a capacity and an ID.
 * The plane can go on flights between different airports.
 * 
 * @author Alex Jenkins
 */
public class Plane {
    
    private int capacity;
    private String ID;

    public Plane(int capacity, String ID) {
        this.capacity = capacity;
        this.ID = ID;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getID() {
        return ID;
    }
    
    @Override
    public String toString() {
        return this.ID + " (" + this.capacity + " ppl)";
    }

}
