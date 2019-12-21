
import java.util.ArrayList;
import java.util.HashMap;

/**
 * A class to contain English words and their Finish translation
 * @author Alex Jenkins
 */
public class Dictionary {
    
    private HashMap<String, String> translations;

    public Dictionary() {
        this.translations = new HashMap<String, String>();
    }
    
    public String translate(String word) {
        
        if (this.translations.get(word) == null) {
            return null;
        }
        
        return this.translations.get(word);
    }
      
    public void add(String word, String translation) {
        // Add a new translation to the dictionary
        this.translations.put(word, translation);
    }
    
    public int amountOfWords() {
        // Returns the amount of words in the dictionary
        return this.translations.values().size();
    }
    
    public ArrayList<String> translationList() {
        // Return an array of strings containing all translations
        
        ArrayList<String> translations = new ArrayList<String>();
        
        for (String key : this.translations.keySet()) {
            String translationString = key + " = " + this.translations.get(key);
            translations.add(translationString);
        }
        
        return translations;
        
    }
}
