
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileManager {

    public List<String> read(String file) throws FileNotFoundException {
        // Read from the file directory passed as parameter
        File f = new File(file);
        Scanner reader = new Scanner(f);
        ArrayList<String> fContents = new ArrayList<String>();
        while(reader.hasNextLine()) {
            fContents.add(reader.nextLine());
        }
        return fContents;
    }

    public void save(String file, String text) throws IOException {
        // Write the parameter text to file. If file exists, overwrite
        FileWriter writer = new FileWriter(file);
        writer.write(text);
        writer.close();
    }

    public void save(String file, List<String> texts) throws IOException {
        // Write the list of strings to file. If file exists, overwrite
        FileWriter writer = new FileWriter(file);
        for (String line : texts) {
            writer.write(line + "\n");
        }
        writer.close();
    }
}
