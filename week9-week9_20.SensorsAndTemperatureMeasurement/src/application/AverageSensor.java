package application;

import java.util.ArrayList;
import java.util.List;

/**
 * An average sensor contains many sensors.
 * On when all sensors are on. To be off, at least one sensor needs to be off.
 * @author Alex Jenkins
 */
public class AverageSensor implements Sensor {
    private List<Sensor> sensors;
    private List<Integer> readings;
    
    public AverageSensor() {
        this.sensors = new ArrayList<Sensor>();
        this.readings = new ArrayList<Integer>();
    }
    
    public void addSensor(Sensor additional) {
        this.sensors.add(additional);
    }
    
    public List<Integer> readings() {
        // Return a list of all reading results for all measurements
        return this.readings;
    }
    
    @Override
    public boolean isOn() {
        // Loop through all sensors contained. Only on is all are on.
        boolean status = true;
        for (Sensor sensor : this.sensors) {
            if (!sensor.isOn()) {
                status = false;
            }
        }
        return status;
    }

    @Override
    public void on() {
        for (Sensor sensor : this.sensors) {
            sensor.on();
        }
    }

    @Override
    public void off() {
        for (Sensor sensor : this.sensors) {
            sensor.off();
        }
    }

    @Override
    public int measure() {
        // Returns the average reading of all sensors
        if (!isOn()) {
            throw new IllegalStateException("All sensors must be on to measure the average.");
        }
        if (this.sensors.size() == 0) {
            throw new IllegalStateException("Sensors must be added to measure the average."); 
        }
        
        int sum = 0;
        for (Sensor sensor : this.sensors) {
            sum += sensor.measure();
        }
        int average = sum / this.sensors.size();
        this.readings.add(average);
        return average;
    }
}
