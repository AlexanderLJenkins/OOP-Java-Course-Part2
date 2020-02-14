package application;

/**
 * A class for a constant sensor, on all the time.
 * @author Alex Jenkins
 */
public class ConstantSensor implements Sensor {
    private int level;

    public ConstantSensor(int level) {
        this.level = level;
    }
    
    @Override
    public boolean isOn() {
        // Constant sensor is always on 
        return true;
    }

    @Override
    public void on() {
        // Constant sensor status cannot be changed
    }

    @Override
    public void off() {
        // Constant sensor status cannot be changed
    }

    @Override
    public int measure() {
        return this.level;
    }
}
