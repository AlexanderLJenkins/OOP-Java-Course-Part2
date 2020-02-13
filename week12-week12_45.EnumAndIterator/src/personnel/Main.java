package personnel;

public class Main {

    public static void main(String[] args) {
        // write test code here
        Employees t = new Employees(); 
        Person h = new Person("Arto", Education.D); 
        t.add(h); 
        t.fire(Education.D); 
        t.print();
    }
}
