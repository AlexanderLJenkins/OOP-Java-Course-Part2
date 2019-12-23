/**
 * A class for a plane flight.
 * A plane object between two airports.
 * 
 * @author Alex Jenkins
 */
public class Flight {
    
    private Plane plane;
    private String departureAirportCode;
    private String destinationAirportCode;

    public Flight(Plane plane, String departureAirportCode, String destinationAirportCode) {
        this.plane = plane;
        this.departureAirportCode = departureAirportCode;
        this.destinationAirportCode = destinationAirportCode;
    }

    @Override
    public String toString() {
        
        String flightString = plane.toString();
        flightString += (" (" + departureAirportCode + "-" + destinationAirportCode + ")");
        return flightString;
    }
}
