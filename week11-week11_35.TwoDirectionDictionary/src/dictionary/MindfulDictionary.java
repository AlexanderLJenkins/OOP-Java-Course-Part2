package dictionary;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * A class for a dictionary that translate words English <-> Finish.
 * Words will be read and written into files.
 * @author Alex Jenkins
 */
public class MindfulDictionary {

    private Map<String, String> dictionary;
    private String file;
    
    public MindfulDictionary() {
        dictionary = new HashMap<String, String>();
    }
    
    public MindfulDictionary(String file) {
        this();
        this.file = file;
    }
    
    public void add(String word, String translation) {
        // Add a word and its translation to the dictionary if it doesn't exist
        // in dictionary
        if (dictionary.containsKey(word)) {
            return;
        }
        dictionary.put(word, translation);
    }
    
    public String translate(String word) {
        // Return a translation of the parameter if it exists in dictionary
        for (String key : dictionary.keySet()) {
            if (word.equals(key)) {
                return dictionary.get(key);
            } else if (word.equals(dictionary.get(key))) {
                return key;
            }
        }
        return null;
    }
    
    public void remove(String word) {
        // Remove the word passed as parameter, and it's translation, from the 
        // dictionary
        for (String key : dictionary.keySet()) {
            if (word.equals(key) || word.equals(dictionary.get(key))) {
                dictionary.remove(key);
                return;
            }
        }
    }

    public boolean load() {
        try {
            File f = new File(file);
            Scanner reader = new Scanner(f);
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                String[] parts = line.split(":");
                dictionary.put(parts[0], parts[1]);
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    
    public boolean save() {
        // Write contents of the dictionary to the file passed to the constructor
        try {
            FileWriter writer = new FileWriter(file);
            for (String key : dictionary.keySet()) {
                writer.write(key + ":" + dictionary.get(key) + "\n");
            }
            writer.close();
        } catch (IOException e) {
            return false;
        }
        return true;
    }
}
