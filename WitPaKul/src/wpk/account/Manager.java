package wpk.account;

public class Manager extends Account {

   

    public Manager( String id, String fristname, String lastname, String password, long phone, AccountStatus status) {
        super(id, fristname, lastname, password, phone, status);
       
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }

    
}
