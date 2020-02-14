
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * A class for printing the contents of a file.
 * @author Alex Jenkins
 */
public class Printer {
    private List<String> fileContents;
    private Scanner reader;
    private File file;
    
    public Printer(String fileName) throws Exception {
        // Read the file contents
        
        this.file = new File(fileName);
        this.reader = new Scanner(file, "UTF-8");
        this.fileContents = new ArrayList<String>();
        
        while (this.reader.hasNextLine()) {
            // Save each line into the fileContents parameter
            String line = this.reader.nextLine();
            this.fileContents.add(line);
        }
        this.reader.close();
    }
    
    public void printLinesWhichContain(String word) {
        // Search for word in the fileContents
        for (String line : this.fileContents) {
            if (line.contains(word) || word.isEmpty()) {
                System.out.println(line);
            }
        }
    }
    
}
