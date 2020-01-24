package application;

import java.util.Random;

/**
 * A class for a thermometer a type of sensor.
 * Off at start, when measure is called throw exception, if on returns a random 
 * number [-30,30].
 * @author Alex Jenkins
 */
public class Thermometer implements Sensor {
    private boolean isOn;
    private Random random;
    
    public Thermometer() {
        this.isOn = false;
        this.random = new Random();
    }

    @Override
    public boolean isOn() {
        return this.isOn;
    }

    @Override
    public void on() {
        this.isOn = true;
    }

    @Override
    public void off() {
        this.isOn = false;
    }

    @Override
    public int measure() {
        if (!this.isOn) {
            throw new IllegalStateException("Thermometer must be on to measure.");
        }
        return random.nextInt(61) - 30;
    }
}
