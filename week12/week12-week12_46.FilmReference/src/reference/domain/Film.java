package reference.domain;

/**
 * A class for a film.
 * @author Alex Jenkins
 */
public class Film {
    
    private String name;

    public Film(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Film other = (Film) obj;
        return !((this.name == null) ? (other.name != null) : !this.name.equals(other.name));
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + (this.name != null ? this.name.hashCode() : 0);
        return hash;
    }
    
    @Override
    public String toString() {
        return name;
    }
}
