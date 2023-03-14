package banking;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * Account implementation for commercial (business) customers.
 * The account's holder is a {@link Company}.
 */
public class CommercialAccount extends Account {
    private List<Person> authorizedUsers;

    public CommercialAccount(Company company, Long accountNumber, int pin, double startingDeposit) {
        // TODO: complete the constructor
        super(company, accountNumber, pin, startingDeposit);
        authorizedUsers = new ArrayList<>();

        //this.accountHolder = (AccountHolder) company; TODO
    }

    /**
     * Add person to list of authorized users.
     *
     * @param person The authorized user to be added to the account.
     */
    protected void addAuthorizedUser(Person person) {
        // TODO: complete the method
        authorizedUsers.add(person);
    }

    /**
     * Verify if the person is part of the list of authorized users for this account.
     *
     * @param person: Person
     * @return <code>true</code> if person matches an authorized user in {@link #authorizedUsers}; <code>false</code> otherwise.
     */
    public boolean isAuthorizedUser(Person person) {
        // TODO: complete the method
        if (person==null){
            return false;
        }
        return authorizedUsers.stream().anyMatch(p -> p.getIdNumber() == person.getIdNumber() && p.getFirstName().equals(person.getFirstName()) && p.getLastName().equals(person.getLastName()));

    }
}
