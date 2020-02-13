package personnel;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * A class for employees. A group of people.
 * @author Alex Jenkins
 */
public class Employees {
    
    private List<Person> employees;

    public Employees() {
        employees = new ArrayList<Person>();
    }
    
    public void add(Person person) {
        // Add a person to the list of employees
        employees.add(person);
    }
    
    public void add(List<Person> persons) {
        // Add a list of people to the list of employees
        Iterator<Person> it = persons.iterator();
        while(it.hasNext()) {
            employees.add(it.next());
        }
    }
    
    public void print() {
        // Print the details of all employees
        Iterator<Person> it = employees.iterator();
        while(it.hasNext()) {
            Person p = it.next();
            System.out.println(p);
        }
    }
    
    public void print(Education education) {
        // Prints all the employees with the same education level as parameter
        Iterator<Person> it = employees.iterator();
        while(it.hasNext()) {
            Person p = it.next();
            if (p.getEducation().equals(education)) {
                System.out.println(p);
            }
        }
    }
    
    public void fire(Education education) {
        // Delete all employees whose education is listed as the parameter
        Iterator<Person> it = employees.iterator();
        while(it.hasNext()) {
            Person p = it.next();
            if (p.getEducation().equals(education)) {
                it.remove();
            }
        }
    }
}
