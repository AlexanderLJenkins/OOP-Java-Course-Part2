package file;

import java.io.File;

public class Main {

    public static void main(String[] args) {

        File file = new File("src/testfile.txt");
        try {
            Analysis a = new Analysis(file); 
            System.out.println("Lines: " + a.lines());
            System.out.println("Characters: " + a.characters());
        } catch (Exception e) {
            System.out.println("There was a problem: " + e.getMessage());
        }
    }
}
