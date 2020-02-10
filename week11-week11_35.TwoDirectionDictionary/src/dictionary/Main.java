package dictionary;

public class Main {
    public static void main(String[] args) {
        // Test your dictionary here
        MindfulDictionary s = new MindfulDictionary("test/tmp/tmp8428.txt");
        s.add("tietokone", "computer");
        s.save();
    }
}
