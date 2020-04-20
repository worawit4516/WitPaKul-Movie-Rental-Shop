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
        EmployeeAccount e2 = new EmployeeAccount("42", "fristname", "lastname", "password", 1, AccountStatus.MANAGER);

        Manager m1 = new Manager("52", "fristname", "lastname", "password", 05254, AccountStatus.MANAGER);

        ManagerService Desktop = new ManagerService(50, m1);
        Desktop.AddEmpolyees(m1, e1);
        Desktop.AddEmpolyees(m1, e2);

        Desktop.ListEmployees();

        Desktop.EditData_Employees(m1, e2, "554", "fristname", "lastname", "password", 5462552, AccountStatus.MANAGER);
        System.out.println(e2);

    }

}
