
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

/**
 * A class to register car plates to their owners
 * Can add, get and delete information from the register
 * @author Alex Jenkins
 */

public class VehicleRegister {
    
    private HashMap<RegistrationPlate, String> owners;

    public VehicleRegister() {
        this.owners = new HashMap<RegistrationPlate, String>();
    }
    
    public boolean add(RegistrationPlate plate, String owner) {
        // Add the owner of the car to a specific plate
        
        // Check car is already owned
        if (this.owners.get(plate) != null) {
            return false;
        }
        
        // Add owner of car
        this.owners.put(plate, owner);
        return true;
        
    }
    
    public String get(RegistrationPlate plate) {
        // Returns the car owner which corresponds to the plate
        
        // Car not registered
        if (this.owners.get(plate) == null) {
          return null;  
        }
        
        return this.owners.get(plate);
        
    }
    
    public boolean delete(RegistrationPlate plate) {
        // Delete the information connected to a plate
        
        // Car not registered
        if (this.owners.get(plate) == null) {
            return false;
        }
        
        this.owners.remove(plate);
        return true;
        
    }
    
    public void printRegistrationPlates() {
        // Print all registration plates stored

        for (RegistrationPlate reg : this.owners.keySet()) {
            System.out.println(reg);
        }
        
    }
    
    public void printOwners() {
        // Prints the car owners (only once)
        
        ArrayList<String> ownerList = new ArrayList<String>();

        for (String owner : this.owners.values()) {
            if (!ownerList.contains(owner)) {
                ownerList.add(owner);
                System.out.println(owner);
            }
        }
        
    }

}
