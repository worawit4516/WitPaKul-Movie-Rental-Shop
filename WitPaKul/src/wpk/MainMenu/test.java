package wpk.MainMenu;

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
       // Desktop.EditData_Manager("EMP00", "EMP100", "firstname", "lastname", "password", 5462552, AccountStatus.MANAGER);
        // Desktop.CreateEmployeesAccount("EMP100", "firstname", "lastname", "password", 5462552, AccountStatus.EMPLOYEE);
        //  Desktop.CreateEmployeesAccount("EMP100", "firstname", "lastname", "password", 5462552, AccountStatus.EMPLOYEE);
        // Desktop.CreateEmployeesAccount("EMP100", "firstname", "lastname", "password", 5462552, AccountStatus.EMPLOYEE);
        //Desktop.ListEmployees();
        //Desktop.SearchEmployees("EMP100",// Desktop.CreateEmployeesAccount("EMP100", "firstname", "lastname", "password", 5462552, AccountStatus.EMPLOYEE);
        //Desktop.ListEmployees(); "EMP02");

        //  Desktop.EditData_Employees("EMP100", "EMP01", "firstname", "lastname", "password", 5462552, AccountStatus.EMPLOYEE);
       // MovieStore miStore = new MovieStore("WitPaKul", 50, 50, 50, 50, 50, "EMP02");
       // miStore.SetEmployeesinStore("EMP02", "password");

        //miStore.ListMembers();
        // miStore.AddMovie("EMP02", "movieTitle", 1, MovieStatus.Available);//0
        //  miStore.AddMovie("EMP02", "movieTitle", 1, MovieStatus.Available);//1
        // miStore.AddMovie("EMP02", "movieTitle", 1, MovieStatus.Available);//2
        //miStore.ListMovieborrow();
      //  miStore.CheckoutMovieMember("MEM02", "MOV01");
        // miStore.CheckoutMovieMember("MEM02", "MOV02");
        //  miStore.CheckoutMovieMember("MEM02", "MOV03");
        //miStore.ListMovieborrow();

        // miStore.returnMovie("MEM02", "MOV03");
        // miStore.returnMovie("MEM02", "MOV02");
        //miStore.returnMovie("MEM02", "MOV01");
        // miStore.ListMovieborrow();
        //miStore.ListMovieborrow();
        //miStore.ListMembers();
        //Desktop.ListEmployees();
        // miStore.DeleteMember("EMP02","MEM01");
        //  miStore.ListMembers();   
        //  miStore.ListMovie();
        //  miStore.DeleteMovie("EMP02","MOV03");
        //miStore.ListMovie();
       // miStore.ListMemberBorrowingList("MEM02");

        // miStore.returnMovie("MEM02", "MOV03");
        //miStore.returnMovie("MEM01", "MOV01");
        //miStore.CreateReceipts("MEM02");
        //miStore.returnMovie("MEM02","MOV01");//ลบออกตำเเหน่งที่ 0
        // miStore.returnMovie("MEM02","MOV02");
        //  miStore.ListMovieborrow();
        // miStore.ListMembers();
        // miStore.ListMemberBorrowingList("MEM02");
        // miStore.CheckoutMovieMember("MEM01", "MOV02");
        // miStore.ListMemberBorrowingList("MEM02");
        // miStore.ListMembers();
        // miStore.ListMovie();
    }

}
