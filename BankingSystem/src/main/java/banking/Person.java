package banking;

/**
 * The concrete Account holder of Person type.
 */
public class Person extends AccountHolder {
    private String firstName;
    private String lastName;

    public Person(String firstName, String lastName, int idNumber) {
        super(idNumber);
        // TODO: complete the constructor
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        // TODO: complete the method
        return this.firstName;
    }

    public String getLastName() {
        // TODO: complete the method
        return this.lastName;
    }
}
