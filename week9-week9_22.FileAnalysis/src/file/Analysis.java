package file;

import java.io.File;
import java.util.Scanner;

/**
 * A class for file analysis.
 * Calculate the number of lines, characters, etc.
 * @author Alex Jenkins
 */

public class Analysis {
    private int lines;
    private int characters;
    private Scanner reader;
    
    public Analysis(File file) throws Exception {
        this.lines = 0;
        this.characters = 0;
        this.reader = new Scanner(file); // Throws exception if problems occur
        
        while (reader.hasNextLine()) {
            String line = reader.nextLine();
            this.lines++;
            this.characters += line.length();
        }
    }
    
    public int lines() {
        return this.lines;
    }
    
    public int characters() {
        // Line breaks are also characters
        return this.characters + this.lines;
    }
}
