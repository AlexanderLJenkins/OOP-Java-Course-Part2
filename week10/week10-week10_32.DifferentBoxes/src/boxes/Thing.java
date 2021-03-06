package boxes;

public class Thing {

    private String name;
    private int weight;

    public Thing(String name, int weight) {
        if (weight < 0) {
            throw new IllegalArgumentException("Weight cannot be negative.");
        }
        this.name = name;
        this.weight = weight;
    }

    public Thing(String name) {
        this(name, 0);
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }
        Thing object = (Thing) obj;
        
        if (!this.name.equals(object.getName())) {
            return false;
        }
//        if (this.weight != object.getWeight()) {
//            return false;
//        }
        return true;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
