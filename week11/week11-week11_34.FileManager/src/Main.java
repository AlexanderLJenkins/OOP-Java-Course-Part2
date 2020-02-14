
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        FileManager t = new FileManager();
        ArrayList<String> texts = new ArrayList<String>();
        texts.add("toot");
        texts.add("soot");
        texts.add("boot");
        t.save("src/testinput1.txt", texts);
        for (String line : t.read("src/testinput1.txt")) {
            System.out.println(line);
        }
    }
}
