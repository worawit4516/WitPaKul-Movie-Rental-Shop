
package Test;
import wpk.account.Account;
import wpk.account.AccountStatus;
import wpk.account.MemberAccount;
import wpk.account.EmployeeAccount;

public class test {
    public static void main(String[] args) {
       Account a1 = new Account("15", "fristname", "lastname", "password", 0, AccountStatus.MEMBER);
      //  EmployeeAccount e1 =new  EmployeeAccount(a1);
        MemberAccount m1 = new  MemberAccount(a1);
       
        
    }
    
}
