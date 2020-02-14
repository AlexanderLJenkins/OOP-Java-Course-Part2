
public class Bird {

    private String name;
    private String latinName;
    private int ringingYear;

    public Bird(String name, String latinName, int ringingYear) {
        this.name = name;
        this.latinName = latinName;
        this.ringingYear = ringingYear;
    }

    public String getLatinName() {
        return latinName;
    }

    public String getName() {
        return name;
    }

    public int getRingingYear() {
        return ringingYear;
    }
    
    @Override
    public String toString() {
        return this.latinName + " (" + this.ringingYear + ")";
    }

    @Override
    public boolean equals(Object obj) {
        // Birds are equal if they have the same latin name and observed in the 
        // same year
        
        if (obj == null) {
            return false;
        }
        
        if (obj.getClass() != this.getClass()) {
            return false;
        }
        
        Bird object = (Bird) obj;
        if (this.latinName != object.getLatinName()) {
            return false;
        }
        
        if (this.ringingYear != object.getRingingYear()) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return (this.latinName.hashCode() + this.ringingYear);
    }
}


