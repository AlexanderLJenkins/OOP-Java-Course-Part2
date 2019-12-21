/**
 * A class for a calculator, performs simple arithmetic and calculates statistics
 * 
 * @author Alex Jenkins
 */
public class Calculator {
    
    private Reader reader;
    private int calculationCounter;

    public Calculator() {
        reader = new Reader();
        calculationCounter = 0;
    }
    
    private void sum() {
        // Calculates the sum for 2 integers
        
        System.out.print("value1: ");
        int value1 = reader.readInteger();
        System.out.print("value2: ");
        int value2 = reader.readInteger();
        
        System.out.println("Sum of the values " + (value1+value2));
        System.out.println("");
        calculationCounter++;
    }
    
    private void difference() {
        // Calculates the difference for 2 integers
        
        System.out.print("value1: ");
        int value1 = reader.readInteger();
        System.out.print("value2: ");
        int value2 = reader.readInteger();
        
        System.out.println("Difference of the values " + (value1-value2));
        System.out.println(""); 
        calculationCounter++;
    }
    
    private void product() {
        // Product of 2 integers
        
        System.out.print("value1: ");
        int value1 = reader.readInteger();
        System.out.print("value2: ");
        int value2 = reader.readInteger();
        
        System.out.println("Product of the values " + (value1*value2));
        System.out.println("");
        calculationCounter++;
        
    }
    
    private void statistics() {
        System.out.println("Calculations done " + calculationCounter);
    }
            
            
    public void start() {
        // Start the calculator UI
        
        while (true) {
            System.out.print("command: ");
            String command = reader.readString();
            if (command.equals("end")) {
                break;
            }

            if (command.equals("sum")) {
                sum();
            } else if (command.equals("difference")) {
                difference();
            } else if (command.equals("product")) {
                product();
            }
        }

        statistics();
    }
    
    
}
