package wordinspection;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * A class to perform inspect the characteristics of words in a file.
 * Number of words, words which contain characters, etc.
 * @author Alex Jenkins
 */
public class WordInspection {
    private int wordCount;
    private Scanner reader;
    private List<String> fileLines;
    
    public WordInspection(File file) throws Exception {
        this.wordCount = 0;
        this.reader = new Scanner(file, "UTF-8");
        this.fileLines = new ArrayList<String>();
        
        while (this.reader.hasNextLine()) {
            String line = this.reader.nextLine();
            
            if (!line.isEmpty()) {
                this.wordCount++;
                this.fileLines.add(line);
            }
        }
        this.reader.close();
    }
    
    public int wordCount() {
        return this.wordCount;
    }
    
    public List<String> wordsContainingZ() {
        // Return all words in the file that contain a Z
        List<String> allWordsWithZ = new ArrayList<String>();

        for (String line : this.fileLines) {
            if (line.toUpperCase().contains("Z")) {
                allWordsWithZ.add(line);
            }
        }
        return allWordsWithZ;
    }
    
    public List<String> wordsEndingInL() {
        // Return all words in the file ending with an l
        List<String> allWordsEndInL = new ArrayList<String>();
        
        for (String line : this.fileLines) {
            char lastChar = line.toUpperCase().charAt(line.length()-1);
            if (lastChar == new Character('L')) {
                allWordsEndInL.add(line);
            }
        }
        return allWordsEndInL;
    }
    
    public List<String> palindromes() {
        // Return all the palindrome words (same backwards as forwards).
        List<String> allPalindromes = new ArrayList<String>();
        
        for (String line : this.fileLines) {
            String lineReversed = "";
            int i = line.length() - 1;
            
            // Create the reversed line string
            while (i >= 0) {
                lineReversed += line.charAt(i);
                i--;
            }
            
            // Check the line is a palindrome
            if (line.equals(lineReversed)) {
                allPalindromes.add(line);
            }
        }
        return allPalindromes;
    }
    
    public List<String> wordsWhichContainAllVowels() {
        // Finish vowels = aeiouyäö
        
        List<String> allWordsWithAllVowels = new ArrayList<String>();

        for (String line : this.fileLines) {
            if (line.contains("a") && line.contains("e") && line.contains("i")
                    && line.contains("o") && line.contains("u") && 
                    line.contains("y") && line.contains("ä") && 
                    line.contains("ö")) {
                allWordsWithAllVowels.add(line);
            }
        }
        return allWordsWithAllVowels;
        
    }
    
}
