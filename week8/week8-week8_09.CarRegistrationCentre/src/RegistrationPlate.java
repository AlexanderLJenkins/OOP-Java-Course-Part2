
public class RegistrationPlate {
    // don't change the code which is already given to you

    // ATTENTION: the object variable types are final, meaning that their value cannot be changed!
    private final String regCode;
    private final String country;

    public RegistrationPlate(String country, String regCode) {
        this.regCode = regCode;
        this.country = country;
    }

    @Override
    public String toString() {
        return country + " " + regCode;
    }

    @Override
    public int hashCode() {
        if (this.country == null) {
            return 7;
        }
        
        return this.country.hashCode() + this.regCode.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        
        if (obj == null) {
            return false;
        }
        
        if (getClass() != obj.getClass()) {
            return false;
        }
        
        final RegistrationPlate other = (RegistrationPlate) obj;
        
        if ((this.regCode == null) ? (other.regCode != null) : !this.regCode.equals(other.regCode)) {
            return false;
        }
        
        if ((this.country == null) ? (other.country != null) : !this.country.equals(other.country)) {
            return false;
        }
        
        return true;
    }

    
    
}
