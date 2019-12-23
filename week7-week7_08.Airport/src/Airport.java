import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * A class to for an airport.
 * You can add planes and add flights via a user interface
 * @author Alex Jenkins
 */
public class Airport {
    
    private HashMap<String, Plane> planes;
    private ArrayList<Flight> flights;
    private Scanner reader;

    public Airport() {
        this.planes = new HashMap<String, Plane>();
        this.flights = new ArrayList<Flight>();
        this.reader = new Scanner(System.in);
    }
    
    private void addPlane() {
        // A method to add a plane to a HashMap
        
        System.out.print("Give plane ID: ");
        String planeID = reader.nextLine();
        System.out.print("Give plane capacity: ");
        int planeCapacity = Integer.parseInt(reader.nextLine());
        
        planes.put(planeID, new Plane(planeCapacity, planeID));
    }
    
    private void addFlight() {
        // A method to add a flight to an ArrayList
        
        System.out.print("Give plane ID: ");
        String planeID = reader.nextLine();
        System.out.print("Give departure airport code: ");
        String departureCode = reader.nextLine();
        System.out.print("Give destination airport code: ");
        String destinationCode = reader.nextLine();
        
        Plane plane = planes.get(planeID);
        flights.add(new Flight(plane, departureCode, destinationCode));
    }
    
    private void printPlanes() {
        // Print all planes
        
        for (Plane plane : this.planes.values()) {
            System.out.println(plane);
        }
    }
    
    private void printFlights() {
        // Print all flights
        
        for (Flight flight : this.flights) {
            System.out.println(flight);
        }
        
    }
    
    private void printPlaneInfo() {
        // Print the information of a given plane
        
        System.out.print("Give plane ID: ");
        String planeID = this.reader.nextLine();
        System.out.println(this.planes.get(planeID));
        
    }
    
    public void start() {
        // A method used to start the airport panel and flight service UI
        
        System.out.println("Airport panel");
        System.out.println("-------------");
        airportPanel();
        
        System.out.println("Flight service");
        System.out.println("--------------");
        flightService();
    }
    
    private void airportPanel() {
        // A user interface used to add planes and flights
        
        while(true) {
            
            System.out.println("Chose operation: ");
            System.out.println("[1] Add airplane");
            System.out.println("[2] Add flight");
            System.out.println("[x] Exit");
            
            String option = this.reader.nextLine();
            if (option.equals("1")) {
                addPlane();
            } else if (option.equals("2")) {
                addFlight();
            } else if (option.equals("x")){
                // Exit
                break;
            }
        }
        
    }
    
    private void flightService() {
        // A user interface used to print planes and flight info
        while(true) {
            
            System.out.println("Chose operation: ");
            System.out.println("[1] Print planes");
            System.out.println("[2] Print flights");
            System.out.println("[3] Print plane info");
            System.out.println("[x] Quit");
            
            String option = this.reader.nextLine();
            
            if (option.equals("1")) {
                printPlanes();
            } else if (option.equals("2")) {
                printFlights();
            } else if (option.equals("3")) {
                printPlaneInfo();
            } else if (option.equals("x")) {
                // Exit
                break;
            }
        }
                
    }
    
}
