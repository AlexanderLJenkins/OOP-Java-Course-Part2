package farmsimulator;

import java.util.Random;

/**
 * A class for a cow.
 * @author Alex Jenkins
 */
public class Cow implements Milkable, Alive {

    private String name;
    private double capacity;
    private double amount;
    private Random random = new Random();
    private static final String[] NAMES = new String[]{
        "Anu", "Arpa", "Essi", "Heluna", "Hely",
        "Hento", "Hilke", "Hilsu", "Hymy", "Ihq", "Ilme", "Ilo",
        "Jaana", "Jami", "Jatta", "Laku", "Liekki",
        "Mainikki", "Mella", "Mimmi", "Naatti",
        "Nina", "Nyytti", "Papu", "Pullukka", "Pulu",
        "Rima", "Soma", "Sylkki", "Valpu", "Virpi"};

    public Cow(String name) {
        this.name = name;
        this.capacity = 15 + random.nextInt(26);
    }

    public Cow() {
        // Assign a random name to the cow.
        this.name = NAMES[random.nextInt(NAMES.length)];
        this.capacity = 15 + random.nextInt(26);
    }

    public String getName() {
        return name;
    }

    public double getCapacity() {
        return capacity;
    }
    
    public double getAmount() {
        return amount;
    }
    
    @Override
    public double milk() {
        // Take all milk from cow
        double everything = amount;
        amount = 0.0;
        return everything;
    }

    @Override
    public void liveHour() {
        // A cow produces between 0.7-2 litres of milk per hour
        double randomNumber = random.nextInt(21) / 10.0;
        while(true) {
            if (randomNumber >= 0.7) {
                break;
            }
            randomNumber = random.nextInt(21) / 10.0;
        }
        if (amount + randomNumber > capacity) {
            amount = capacity;
            return;
        }
        amount += randomNumber;
    }

    @Override
    public String toString() {
        return name + " " + Math.ceil(amount) + "/" + Math.ceil(capacity);
    }
}
