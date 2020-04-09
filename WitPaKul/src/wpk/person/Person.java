package wpk.person;
/**
 *
 * @author Sathipp
 */
public class Person {
    private String firstName;
    private String lastName;
    private long phone;
    
    public Person(String firstName, String lastName, long phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
    }
@Override
    public String toString() {
        return "Person: " + "name= " + firstName +  "  " + lastName + ", phone = " + phone;
    }
}
