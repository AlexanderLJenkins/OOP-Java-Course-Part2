
import java.util.HashMap;
import java.util.Map;

public class Nicknames {

    public static void main(String[] args) {
        // Do the operations requested in the assignment here!
        HashMap<String, String> nicknameMap = new HashMap<String, String>();
        nicknameMap.put("matti", "mage");
        nicknameMap.put("mikael", "mixu");
        nicknameMap.put("arto", "arppa");
        
        String nickname = nicknameMap.get("mikael");
        System.out.println(nickname);
        
                
        
        
    }

}
