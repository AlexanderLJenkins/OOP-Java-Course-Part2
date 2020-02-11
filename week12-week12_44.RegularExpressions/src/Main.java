
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        // write test code here
        Scanner reader = new Scanner(System.in);
        System.out.print("Give a string: ");
        String input = reader.nextLine();
        if (allVowels(input)) {
            System.out.println("The form is fine.");
        } else {
            System.out.println("The form is wrong.");
        }
    }
    
    public static boolean isAWeekDay(String string) {
        return string.matches("(mon|tue|wed|thu|fri|sat|sun)");
    }
    
    public static boolean allVowels(String string) {
        return string.matches("((a)*(e)*(i)*(o)*(u)*(ä)*(ö)*)*");
    }
    
    public static boolean clockTime(String string) {
        // Check if parameter is a regular clock time
        String[] parts = string.split(":");
        
        if (parts.length != 3) {
            // More than three parts to the time
            return false;
        }
        
        for (int part = 0; part < parts.length; part++) {
            if (parts[part].length() != 2) {
                // One of the parts is not in correct format
                return false;
            }
        }
        
        if (!parts[0].matches("(0[0-9]{1})|(1[0-9]{1})|(2[0-3]{1})")) {
            // hours [00, 23]
            return false;
        }
        
        if (!parts[1].matches("(0[0-9]{1})|([1-5]{1}[0-9]{1})")) {
            // minutes [00, 59]
            return false;
        }
        
        // seconds [00, 59]
        return parts[2].matches("(0[0-9]{1})|([1-5]{1}[0-9]{1})");
    }
}
