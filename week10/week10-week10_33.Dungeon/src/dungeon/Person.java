package dungeon;

/**
 * A class for the person character.
 * @author Alex Jenkins
 */
public class Person extends GameCharacter {
    
    public Person() {
        // Person always starts the game at 0, 0
        super(0, 0, '@');
    }

    @Override
    public void move(String operations, Dungeon game) {
        for (int i = 0; i < operations.length(); i++) {
            char operation = operations.charAt(i);
            switch (operation) {
                case 'w':
                    super.moveYIfLegal(super.getY()-1, game);
                    break;
                case 'a':
                    super.moveXIfLegal(super.getX()-1, game);
                    break;
                case 's':
                    super.moveYIfLegal(super.getY()+1, game);
                    break;
                case 'd':
                    super.moveXIfLegal(super.getX()+1, game);
                    break;
                default:
                    break;
            }
        }
    }
}
