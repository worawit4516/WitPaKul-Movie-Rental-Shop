package wpk.account;

import wpk.Enum.AccountStatus;

public class ManagerAccount extends Account {

   

    public ManagerAccount( String id, String fristname, String lastname, String password, long phone, AccountStatus status) {
        super(id, fristname, lastname, password, phone, status);
       
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }

    public void editmanager(String id, String fristname, String lastname, String password, long phone, AccountStatus status) {
        this.setFristname(fristname);
        this.setId(id);
        this.setLastname(lastname);
        this.setPassword(password);
        this.setPhone(phone);
        this.setStatus(status);
        
    }
}
