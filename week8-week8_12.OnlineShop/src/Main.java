
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        // write some test code here
        
        Storehouse store = new Storehouse();
        store.addProduct("coffee", 5, 1);
        store.addProduct("milk", 3, 1);
        store.addProduct("milkbutter", 2, 1);
        store.addProduct("bread", 7, 1);

        Shop shop = new Shop(store, new Scanner(System.in));
        shop.manage("Pekka");
    }
}
