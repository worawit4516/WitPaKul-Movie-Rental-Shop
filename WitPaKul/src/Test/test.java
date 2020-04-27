package Test;

import wpk.Store.MovieStore;
import wpk.Enum.AccountStatus;
import wpk.Store.ManagerService;
import wpk.account.ManagerAccount;
import wpk.Enum.AccountMovieStatus;
import wpk.Enum.MovieStatus;

public class test {

    public static void main(String[] args) {

        ManagerAccount m1 = new ManagerAccount("EMP00", "firstname", "lastname", "password", 05254, AccountStatus.MANAGER);

        ManagerService Desktop = new ManagerService(5, m1);

        Desktop.ManagerServiceLogin("EMP00", "password");
        Desktop.EditData_Manager("EMP00", "EMP100", "firstname", "lastname", "password", 5462552, AccountStatus.MANAGER);
        Desktop.CreateEmployeesAccount("EMP100", "firstname", "lastname", "password", 5462552, AccountStatus.EMPLOYEE);
        Desktop.CreateEmployeesAccount("EMP100", "firstname", "lastname", "password", 5462552, AccountStatus.EMPLOYEE);
        Desktop.CreateEmployeesAccount("EMP100", "firstname", "lastname", "password", 5462552, AccountStatus.EMPLOYEE);
        //Desktop.ListEmployees();
        //Desktop.SearchEmployees("EMP100", "EMP02");

        Desktop.EditData_Employees("EMP100", "EMP01", "firstname", "lastname", "password", 5462552, AccountStatus.EMPLOYEE);

        MovieStore miStore = new MovieStore("WitPaKul", 50, 50, 50, 50, 50, "EMP02");
        miStore.SetService(Desktop);
        miStore.SetEmployeesinStore("EMP02", "password");
        miStore.CreateMember("EMP02", "firstname", "lastname", "password", 0, AccountStatus.MEMBER, AccountMovieStatus.ACTIVEB);
        miStore.CreateMember("EMP02", "firstname", "lastname", "password", 0, AccountStatus.MEMBER, AccountMovieStatus.ACTIVEB);

        //miStore.ListMembers();
        miStore.AddMovie("EMP02", "movieTitle", 1, MovieStatus.Available);

        //miStore.ListMovieborrow();
        miStore.CheckoutMovieMember("MEM02", "MOV01");

        // miStore.ListMemberBorrowingList("MEM02");
        // miStore.ListMembers();
        // miStore.ListMovie();
       

         miStore.createNewReceipts("MEM02");
    }

}
