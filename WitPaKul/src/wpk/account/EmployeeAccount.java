package wpk.account;

import wpk.account.Account;

public class EmployeeAccount extends Account {
    
    public EmployeeAccount(String id, String fristname, String lastname, String password, long phone, AccountStatus status) {
        super(id, fristname, lastname, password, phone, status);
        
    }
    
    public void editdata(String id, String fristname, String lastname, String password, long phone, AccountStatus status) {
        this.setFristname(fristname);
        this.setId(id);
        this.setLastname(lastname);
        this.setPassword(password);
        this.setPhone(phone);
        this.setStatus(status);
        
    }
    
    @Override
    public String toString() {
        return super.toString();
    }
    
}
