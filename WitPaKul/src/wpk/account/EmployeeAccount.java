package wpk.account;

import wpk.Enum.AccountStatus;

public class EmployeeAccount extends Account {
    
    public EmployeeAccount(String id, String firstname, String lastname, String password, long phone, AccountStatus status) {
        super(id, firstname,lastname, password, phone, status);
        
    }
    
    public void editdata(String firstname, String lastname, String password, long phone, AccountStatus status) {
        this.setFirstname(firstname);
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
