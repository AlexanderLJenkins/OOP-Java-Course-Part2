package tools;

import java.util.HashSet;
import java.util.Set;

/**
 * A class to store given strings so that duplicates are removed.
 * Class also holds a record of the amount of duplicates.
 * @author Alex Jenkins
 */
public class PersonalDuplicateRemover implements DuplicateRemover {
    
    private Set<String> stringStorage;
    private int detectedDuplicates;
    
    public PersonalDuplicateRemover() {
        this.stringStorage = new HashSet<String>();
        this.detectedDuplicates = 0;
    }
    
    @Override
    public void add(String characterString) {
        // Stores the character string if it's not a duplicate
        if (!this.stringStorage.contains(characterString)) {
            this.stringStorage.add(characterString);
            return;
        }
        
        // Add one to detected count if duplicated attempted to be added
        if (this.stringStorage.contains(characterString)) {
            this.detectedDuplicates++;
        }
    }

    @Override
    public int getNumberOfDetectedDuplicates() {
        // Returns the number of detected duplicates
        return this.detectedDuplicates;
    }

    @Override
    public Set<String> getUniqueCharacterStrings() {
        // Set returned consists of unique strings with no duplicates. Empty set if not unique.
        return this.stringStorage;
    }

    @Override
    public void empty() {
        // Remove all strings and resets the amount of detected duplicates
        this.stringStorage.removeAll(this.stringStorage);
        this.detectedDuplicates = 0;
    }
    
}
