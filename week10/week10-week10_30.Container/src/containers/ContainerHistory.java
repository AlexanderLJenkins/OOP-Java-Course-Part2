package containers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A class to track changes in
 * @author Alex Jenkins
 */
public class ContainerHistory {

    private List<Double> history;
    
    public ContainerHistory() {
        history = new ArrayList<Double>();
    }
    
    public void add(double situation) {
        // Add parameter to the container history
        history.add(situation);
    }
    
    public void reset() {
        history.clear();
    }
    
    public String toString() {
        return history.toString();
    }
    
    public double maxValue() {
        // Return the maximum value in container history
        if (history.isEmpty()) {
            return 0;
        }
        
        double maxValue = history.get(0);
        for (int i = 1; i < history.size(); i++) {
            if (history.get(i) > maxValue) {
                maxValue = history.get(i);
            }
        }
        return maxValue;
    }
    
    public double minValue() {
        // Return the minimum value in container history
        if (history.isEmpty()) {
            return 0;
        }
        
        double minValue = history.get(0);
        for (int i = 1; i < history.size(); i++) {
            if (history.get(i) < minValue) {
                minValue = history.get(i);
            }
        }
        return minValue;
    }
    
    public double average() {
        // Return the mean average in container history
        if (history.isEmpty()) {
            return 0;
        }
        
        double sum = 0;
        for (int i = 0; i < history.size(); i++) {
            sum += history.get(i);
        }
        return sum / history.size();
    }
    
    public double greatestFluctuation() {
        // Returns the largest absolute change to the container volume
        if (history.isEmpty() || history.size() == 1) {
            return 0;
        }
        
        double greatestFluctuation = 0;
        for (int i = 1; i < history.size(); i++) {
            double thisFluctuation = Math.abs(history.get(i) - history.get(i-1));
            if (thisFluctuation > greatestFluctuation) {
                greatestFluctuation = thisFluctuation;
            }
        }
        return greatestFluctuation;
    }
    
    public double variance() {
        // Return the sample variance of the values in the container history
        if (history.isEmpty() || history.size() == 1) {
            return 0;
        }
        
        double average = average();
        double numerator = 0;
        for (int i = 0; i < history.size(); i++) {
            numerator += Math.pow(history.get(i) - average, 2);
        }
        return numerator / (history.size() - 1);
    }
}
