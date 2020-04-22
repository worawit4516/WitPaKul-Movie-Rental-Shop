package Test;

import wpk.Store.MovieStore;
import wpk.account.Account;
import wpk.account.AccountStatus;
import wpk.account.MemberAccount;
import wpk.account.EmployeeAccount;
import wpk.account.ManagerService;
import wpk.account.ManagerAccount;
import Enum.AccountMovieStatus;
import Enum.MovieStatus;

public class test {

    public static void main(String[] args) {

        // EmployeeAccount e1 = new EmployeeAccount("52", "fristname", "lastname", "password", 0, AccountStatus.EMPLOYEE);
        //EmployeeAccount e2 = new EmployeeAccount("42", "fristname", "lastname", "password", 1, AccountStatus.EMPLOYEE);
        ManagerAccount m1 = new ManagerAccount("EMP00", "fristname", "lastname", "password", 05254, AccountStatus.MANAGER);

        ManagerService Desktop = new ManagerService(5, m1);

        //Desktop.EditData_Employees(m1, e2, "554", "fristname", "lastname", "password", 5462552, AccountStatus.MANAGER);
        //Desktop.DeleteEmployees(m1, e1);
        Desktop.EditData_Manager(m1, "EMP100", "fristname", "lastname", "password", 5462552, AccountStatus.MANAGER);
        Desktop.CreatEmployeesAccount(m1, "fristname", "lastname", "password", 5462552, AccountStatus.EMPLOYEE);
        Desktop.CreatEmployeesAccount(m1, "fristname", "lastname", "password", 5462552, AccountStatus.EMPLOYEE);
        Desktop.CreatEmployeesAccount(m1, "fristname", "lastname", "password", 5462552, AccountStatus.EMPLOYEE);
        Desktop.ListEmployees();
        Desktop.SearchEmployees(m1, "EMP02");

        Desktop.EditData_Employees(m1, "EMP01", "fristname", "lastname", "password", 5462552, AccountStatus.EMPLOYEE);

        MovieStore miStore = new MovieStore("WITpakul", 50, 50, 50, 50, 50, "EMP02");
        miStore.SetResouse(Desktop);
        miStore.SetEmployeesinStore("EMP02");
        miStore.CreateMember("EMP02", "fristname", "lastname", "password", 0, AccountStatus.MEMBER, AccountMovieStatus.ACTIVEB);
        miStore.CreateMember("EMP02", "fristname", "lastname", "password", 0, AccountStatus.MEMBER, AccountMovieStatus.ACTIVEB);

        miStore.ListMembers();
        miStore.AddMovie("EMP02", "movieTitle", 0, MovieStatus.Available);
        miStore.ListMovie();

        miStore.checkOutMovie("MEM02", "MOV01");

        
        miStore.returnMovie("MEM02", "MOV01");
        
        miStore.ListMovieborrow();
               
    }

}
