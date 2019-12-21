
public class Smileys {

    public static void main(String[] args) {
        // Test your method at least with the following
        printWithSmileys("Method");
        printWithSmileys("Beerbottle");
        printWithSmileys("Interface");
    }
    
    private static void printWithSmileys(String characterString) {

        // Format depending on whether string is of odd or even length
        int evenOrOddLength = characterString.length() % 2;
        if (evenOrOddLength == 1) {
            characterString += " ";
        }
        
        printLineOfSmileys(characterString);
        System.out.println(":) " + characterString + " :)");
        printLineOfSmileys(characterString);
        
         
    }
    
    private static void printLineOfSmileys(String characterString) {
        System.out.print(":):)");
        for (int i=0; i < characterString.length() / 2; i++) {
            System.out.print(":)");
        }
        System.out.println(":)");
    }

}
