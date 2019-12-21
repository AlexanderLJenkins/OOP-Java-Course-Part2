/**
 *
 * @author Alex Jenkins
 */
public class Change {
    
    private char fromCharacter;
    private char toCharacter;

    public Change(char fromCharacter, char toCharacter) {
        this.fromCharacter = fromCharacter;
        this.toCharacter = toCharacter;
    }
    
    public String change(String characterString) {
        // Returns the changed version of the given character string
        return characterString.replace(fromCharacter, toCharacter);
    }
    
}
