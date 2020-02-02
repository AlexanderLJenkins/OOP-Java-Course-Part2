package ManagementSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * A class to manage the personal information of individuals.
 * @author Alex Jenkins
 */
public class PeopleManagementSystem {
    
    private Scanner reader;
    private Map<String, Set<String>> phoneBook;
    private Map<String, Set<Address>> addressBook;
    
    public PeopleManagementSystem() {
        this.reader = new Scanner(System.in); // From user input
        this.phoneBook = new HashMap<String, Set<String>>();
        this.addressBook = new HashMap<String, Set<Address>>();
    }
    
    private void addPhoneNumber() {
        // Add a phone number to the phonebook
        System.out.print("whose number: ");
        String name = this.reader.nextLine();
        System.out.print("number: ");
        String number = this.reader.nextLine();
        
        if (!this.phoneBook.containsKey(name)) {
            this.phoneBook.put(name, new HashSet<String>());
        }
        this.phoneBook.get(name).add(number);
    }

    private void searchPhoneNumber() {
        // Search for a phone number in the phone book
        System.out.print("whose number: ");
        String name = this.reader.nextLine();
        
        if (!this.phoneBook.containsKey(name)) {
            System.out.println("  not found");
            return;
        }
        
        // Print all phone numbers corresponding to the input name
        for (String phoneNumber : this.phoneBook.get(name)) {
            System.out.println(" " + phoneNumber);
        }
    }
    
    private void searchPersonByPhoneNumber() {
        // Search for a person's name by their phone number
        System.out.print("number: ");
        String number = this.reader.nextLine();
        
        for (String person : this.phoneBook.keySet()) {
            for (String eachNumber : this.phoneBook.get(person)) {
                if (eachNumber.equals(number)) {
                    System.out.println("  " + person);
                    return;
                }
            }
        }
        System.out.println(" not found");
    }
    
    private void addAddress() {
        // Add an address to the address book
        System.out.print("whose address: ");
        String name = this.reader.nextLine();
        System.out.print("street: ");
        String street = this.reader.nextLine();
        System.out.print("city: ");
        String city = this.reader.nextLine();
        
        if (!this.addressBook.containsKey(name)) {
            this.addressBook.put(name, new HashSet<Address>());
        }
        this.addressBook.get(name).add(new Address(city, street));
    }
    
    private void searchPersonalInformation(String name) {
        // Return address and phone numbers 
                
        if (!this.addressBook.containsKey(name)) {
            System.out.println("  address unknown");
        } else {
            System.out.print("  address: ");
            for (Address address : this.addressBook.get(name)) {
                System.out.println(address);
            }
        }
        
        if (!this.phoneBook.containsKey(name)) {
            System.out.println("  phone number not found");
        } else {
            System.out.println("  phone numbers: ");
            for (String number : this.phoneBook.get(name)) {
                System.out.println("   " + number);
            }
        }
    }
    
    private void deletePersonalInformation() {
        // Return address and phone numbers 
        System.out.print("whose information: ");
        String name = this.reader.nextLine();
        
        if (!this.addressBook.containsKey(name) && 
                !this.phoneBook.containsKey(name)) {
            return;
        }
        
        if (this.addressBook.get(name) != null) {
            this.addressBook.get(name).clear();
            this.addressBook.remove(name);
        }
        
        if (this.phoneBook.get(name) != null) {
            this.phoneBook.get(name).clear();
            this.phoneBook.remove(name);
        }
    }
    
    private void filteredListing(String keyword) {
        // Print all info of an individual, if the keyword is in name, address
        // or phone number
        if (keyword.isEmpty()) {
            printAllInformation(this.addressBook.keySet());
            return;
        }
        
        Set<String> allNames = new HashSet<String>();
        allNames.addAll(this.phoneBook.keySet());
        allNames.addAll(this.addressBook.keySet());
        
        Set<String> peopleWithKeyword = new HashSet<String>();
        boolean found = false;
        
        // Check the names for the keywords
        for (String name : allNames) {
            if (name.contains(keyword)) {
                peopleWithKeyword.add(name);
                found = true;
            }
            
            else if (this.addressBook.get(name) != null) {
                // Check all names' addresses for keyword
                for (Address address : this.addressBook.get(name)) {
                    if (address.toString().contains(keyword)) {
                        peopleWithKeyword.add(name);
                        found = true;
                    }
                }
            } 
            
            else if (this.phoneBook.get(name) != null) {
                // Check all names' phone numbers for keyword
                for (String number : this.phoneBook.get(name)) {
                    if (!number.isEmpty() && number.contains(keyword)) {
                        peopleWithKeyword.add(name);
                        found = true;
                    }
                }
            }
        }
        
        if (!found) {
            System.out.println(" keyword not found");
            return;
        }
        printAllInformation(peopleWithKeyword);
    }
    
    private void printAllInformation(Set<String> names) {
        // Print all personal information for names
        List<String> list = new ArrayList(names);
        Collections.sort(list);
        for (String name : list) {
            System.out.println("");
            System.out.println(" " + name);
            searchPersonalInformation(name);
            System.out.println("");
        }
        return;
    }
    
    private void launchCommand(int command) {
        // A function to launch the corresponding command
        switch (command) {
            case 1:
                addPhoneNumber();
                break;
            
            case 2:
                searchPhoneNumber();
                break;
                
            case 3:
                searchPersonByPhoneNumber();
                break;
            
            case 4:
                addAddress();
                break;
            
            case 5:
                System.out.print("whose information: ");
                String name = this.reader.nextLine();       
                if (!this.addressBook.containsKey(name) && 
                        !this.phoneBook.containsKey(name)) {
                    System.out.println("  not found");
                    break;
                }
                searchPersonalInformation(name);
                break;
            
            case 6:
                deletePersonalInformation();
                break;
                
            case 7:
                System.out.print("keyword (if empty, all listed): ");
                String keyword = this.reader.nextLine();
                filteredListing(keyword);
                break;
            
            default:
                System.out.println("Invalid command.");
                break;
        }
    }
    
    public void start() {
        System.out.println("phone search");
        System.out.println("available operations:");
        System.out.println(" 1 add a number");
        System.out.println(" 2 search for a number");
        System.out.println(" 3 search for a person by phone number");
        System.out.println(" 4 add an address");
        System.out.println(" 5 search for personal information");
        System.out.println(" 6 delete personal information");
        System.out.println(" 7 filtered listing");
        System.out.println(" x quit");
        
        while(true) {
            System.out.println("");
            System.out.print("Command: ");
            String option = this.reader.nextLine();
            if (option.equals("x")) {
                break;
            }
            int command = Integer.parseInt(option);
            launchCommand(command);
        }
    }
}
