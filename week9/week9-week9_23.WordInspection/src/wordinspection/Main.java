package wordinspection;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        // test your code here

        File file = new File("src/wordList.txt");
        try {
            WordInspection w = new WordInspection(file);
            System.out.println(w.wordCount());
            System.out.println(w.wordsContainingZ());
            System.out.println(w.wordsEndingInL());
            System.out.println(w.palindromes());
            System.out.println(w.wordsWhichContainAllVowels());
        } catch (Exception e) {
            System.out.println("An error has occurred: " + e.getMessage());
        }
    }
}
