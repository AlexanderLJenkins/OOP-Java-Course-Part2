
public class Main {
    
    public static void main(String[] args) {
        Box bigBox = new Box(50);
        Box medBox = new Box(25);
        Box smallBox = new Box(5);
        
        smallBox.add( new Book("Fedor Dostojevski", "Crime and Punishment", 2) ) ;
        smallBox.add( new Book("Robert Martin", "Clean Code", 1) );
        smallBox.add( new Book("Kent Beck", "Test Driven Development", 0.7) );

        medBox.add( new CD("Pink Floyd", "Dark Side of the Moon", 1973) );
        medBox.add( new CD("Wigwam", "Nuclear Nightclub", 1975) );
        medBox.add( new CD("Rendezvous Park", "Closer to Being Here", 2012) );
        medBox.add(smallBox);
        
        bigBox.add(medBox);
        
        System.out.println(smallBox);
        System.out.println(medBox);
        System.out.println(bigBox);
        
    }
}
