
public class Main {

    public static void main(String[] args) {
        // use this main class to test your program!
        Container container = new Container(1000);
        addSuitcasesFullOfBricks(container);
        System.out.println(container);
    }
    
    public static void addSuitcasesFullOfBricks(Container container) {
        // Add 100 suitcases with one brick in each
        
        int i = 1;
        while(i <= 100) {
            
            Suitcase suitcase = new Suitcase(100);
            Thing brick = new Thing("Brick", i);
            
            suitcase.addThing(brick);
            
            container.addSuitcase(suitcase);
            i++;
        }
        
    }

}
