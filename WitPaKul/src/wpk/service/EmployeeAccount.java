package wpk.service;

import wpk.account.Account;
import wpk.person.Person;

/**
 *
 * @author Sathipp
 */
public class EmployeeAccount extends Account{

    public EmployeeAccount(Account account) {
        super(account);
    }

    public EmployeeAccount(String id, String password, Person person) {
        super(id, password, person);
    }
   

    
    
    
    
}
