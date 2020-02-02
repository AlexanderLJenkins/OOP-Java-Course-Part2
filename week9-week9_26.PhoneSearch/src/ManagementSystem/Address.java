package ManagementSystem;

import java.util.ArrayList;
import java.util.List;

/**
 * A class for an address.
 * @author Alex Jenkins
 */
public class Address {
    
    private String city;
    private String street;

    public Address(String city, String street) {
        this.city = city;
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    @Override
    public String toString() {
        return this.street + " " + this.city;
    }
}
