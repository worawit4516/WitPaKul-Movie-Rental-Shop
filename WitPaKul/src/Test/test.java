package Test;

import wpk.account.Account;
import wpk.account.AccountStatus;
import wpk.account.MemberAccount;
import wpk.account.EmployeeAccount;
import wpk.account.ManagerService;
import wpk.account.Manager;

public class test {

    public static void main(String[] args) {

        EmployeeAccount e1 = new EmployeeAccount("52", "fristname", "lastname", "password", 0, AccountStatus.EMPLOYEE);

        Manager m1 = new Manager("52", "fristname", "lastname", "password", 05254, AccountStatus.MANAGER);

        ManagerService Desktop = new ManagerService(50);

        System.out.println(Desktop.countEmployee);
        Desktop.AddEmpolyees(m1, e1);

        System.out.println(e1.toString());
        System.out.println(m1.toString());
        System.out.println(Desktop.ListEmployees());
        System.out.println(Desktop.countEmployee);
    }

}
