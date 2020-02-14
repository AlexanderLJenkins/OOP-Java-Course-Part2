package people;

/**
 * A class for a student. Inherits properties of a person.
 * As the student studies they gain credits.
 * @author Alex Jenkins
 */
public class Student extends Person{
    
    private int credits;
    
    public Student(String name, String address) {
        super(name, address);
        this.credits = 0;
    }
    
    public void study() {
        this.credits++;
    }
    
    public int credits() {
        return this.credits;
    }

    @Override
    public String toString() {
        return super.toString() + "\n  credits " + this.credits;
    }
}
