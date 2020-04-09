package wpk.service;
import wpk.account.Account;
import wpk.person.Person;
/**
 *
 * @author Sathipp
 */
public class ManagerAccount extends Account{
    private String memberId;
    
    public ManagerAccount(String id, String password, Person person) {
        super(id, password, person);
    }

    public ManagerAccount(Account account) {
        super(account);
    }
}
