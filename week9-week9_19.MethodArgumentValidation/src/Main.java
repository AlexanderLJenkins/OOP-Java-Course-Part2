
import validation.Calculator;



/**
 *
 * @author Alex Jenkins
 */
public class Main {
    public static void main(String[] args){
        
        Calculator calc = new Calculator();

        calc.multiplication(5);
        calc.multiplication(-5);
        calc.binomialCoefficient(20, 5);
        calc.binomialCoefficient(5, 20);
        calc.binomialCoefficient(-5, -10);
        
    }
}
