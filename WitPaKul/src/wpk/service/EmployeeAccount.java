package wpk.service;

import wpk.account.Account;

/**
 *
 * @author Sathipp
 */
public abstract class EmployeeAccount {
    private Account account;

    public EmployeeAccount(Account account) {
        this.account = account;
    }
    
    
    
}
