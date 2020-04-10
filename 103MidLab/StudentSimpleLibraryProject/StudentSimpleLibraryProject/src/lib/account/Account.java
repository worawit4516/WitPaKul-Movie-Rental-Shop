package lib.account;
import java.util.Objects;
import lib.person.Person;

public abstract class Account {
    private String id;
    private String password;
    private AccountStatus status;
    private Person person;

    public Account(Account account){
        this.id=account.id;
        this.password=account.password;
        this.person=account.person;
    }
    public Account(String id, String password, Person person) {
        this.id = id;
        this.password = password;
        this.person = person;
        this.status=AccountStatus.ACTIVE;
    }

    protected boolean resetPassword() {
        this.password = null;
        return true;
    }

    public String getId() {
        return id;
    }
   
    public AccountStatus getStatus() {
        return status;
    }

    protected void setPassword(String password) {
        this.password = password;
    }

    protected void setStatus(AccountStatus status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Account other = (Account) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return "Account{" + "id=" + id + ", person=" + person + '}';
        
    }
}
