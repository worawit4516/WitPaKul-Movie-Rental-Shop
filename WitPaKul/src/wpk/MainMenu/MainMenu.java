package wpk.MainMenu;

import wpk.MenuMethod.MM_Manager;
import wpk.Store.MovieStore;
import wpk.Enum.AccountStatus;
import wpk.Store.ManagerService;
import java.util.Scanner;
import static wpk.MainMenu.MainMenu.Sc;
import wpk.MenuMethod.MM_Employees;
import wpk.account.ManagerAccount;

public class MainMenu {

    static String menu
            = "<<< Menu >>>\n"
            + "Store System \n"
            + "1.Manager  \n"
            + "2.Employee  \n"
            + "0.Exit    \n"
            + "--------------"
            + "\nEnter Your Menu [1‐2]: ";
    static String menuManager
            = "<<< MenuManager >>>\n"
            + "---Store System----\n"
            + "1.CreateEmployees\n"
            + "2.EditData_Employees\n"
            + "3.SearchEmployees\n"
            + "4.ListEmployees\n"
            + "5.DeleteEmployees\n"
            + "0...Return to the menu...\n"
            + "-------------------"
            + "\nEnter Your Menu [1‐6]: ";
    static String menuEmployee
            = "--------MenuEmployee----------\n"
            + "---Store System---\n"
            + "1.Employee--Member\n"
            + "2.Employee--Movie\n"
            + "0...Return to the menu...\n"
            + "-------------------"
            + "\nEnter Your Menu [1‐2]: ";
    static String menuEmployeeMember
            = "--------menuEmployeeMember--------\n"
            + "-----------Store System-------------------\n"
            + "1.CreateMember\n"
            + "2.EditData_Member\n"
            + "3.SearchMember\n"
            + "4.DeleteMember\n"
            + "5.ListMembers\n"
            + "6.ListMemberBorrowingList\n"
            + "7.CheckForFine\n"
            + "0...Return to the menu...\n"
            + "-------------------"
            + "\nEnter Your Menu [1‐7]: ";
    static String menuEmployeeMovie
            = "--------MenuEmployee----------\n"
            + "---Store System---\n"
            + "1.AddMovie\n"
            + "2.SearchMovie\n"
            + "3.DeleteMovie\n"
            + "4.ListMovie\n"
            + "5.ListMovieborrow\n"
            + "6.CheckoutMovie\n"
            + "7.returnMovie\n"
            + "0...Return to the menu...\n"
            + "-------------------"
            + "\nEnter Your Menu [1‐14]: ";

    public static Scanner Sc = new Scanner(System.in);

    public static void main(String[] args) {

        ManagerAccount m1 = new ManagerAccount("EMP00", "firstname", "lastname", "4516", 05254, AccountStatus.MANAGER);
        ManagerService Desktop = new ManagerService(5, m1);
        MovieStore WPK = new MovieStore("WitPaKul", 50, 50, 50, 50, 50, "EMP02");
        WPK.SetService(Desktop);
        int select;
        do {
            select = SeChoice();

            switch (select) {
                case 1:
                    // Desktop.CreateEmployeesAccount(CreateEmployeesAccount());
                    if (Desktop.ManagerServiceLogin(loginID(),loginPassaword())) {
                        //do{

                        do {

                            switch (SeChoiceManager()) {
                                case 1://CreateEmployeesAccount
                                    Desktop.CreateEmployeesAccount(MM_Manager.CreateEmployeesAccount());
                                    break;

                                case 2://EditData_Employees
                                    Desktop.EditData_Employees(MM_Manager.EditdataEmployeesAccount());
                                    break;
                                case 3://SearchEmployees เอริส
                                    Desktop.SearchEmployees(MM_Manager.InputEmployeesID());
                                    break;
                                case 4://ListEmployees เอริส
                                    Desktop.ListEmployees();
                                    break;
                                case 5://DeleteEmployee เอริส
                                    Desktop.DeleteEmployees(MM_Manager.InputEmployeesID());
                                    break;

                                case 0:
                                    while (select == 0);
                                    System.out.println("Bye");
                                    break;
                            }
                          
                        } while (SeChoiceManager() != 0);
                    }
                    break;

                case 2:
                    if (WPK.LoginEmployeesinStore(loginID(),loginPassaword())) {
                        do {

                            switch (SeChoiceEmployees()) {
                                case 1:
                                    do {

                                        switch (SeChoiceEmployeesMember()) {
                                            case 1://CreateMember
                                                WPK.CreateMember(MM_Employees.CreateMember());
                                                break;
                                            case 2://EditData_Member
                                                WPK.EditData_Member(MM_Employees.EditData_Member());
                                                break;

                                            case 3://SearchMember
                                                WPK.SearchMember(MM_Employees.InputMemberID());
                                                break;
                                            case 4://DeleteMember
                                                WPK.DeleteMember(MM_Employees.InputMemberID());
                                                break;

                                            case 5://ListMembers
                                                WPK.ListMembers();
                                                break;
                                            case 6://ListMemberBorrowingList 
                                                WPK.ListMemberBorrowingList(MM_Employees.InputMemberID());
                                                break;
                                            case 7://CheckForFine เอริส
                                                WPK.CheckForFine(MM_Employees.InputMemberIDFor(), MM_Employees.InputMovieIDFor());
                                                break;

                                            case 0:
                                                while (select == 0);
                                                System.out.println("Bye");

                                                break;
                                        }
                                        break;
                                    } while (SeChoiceEmployeesMember() != 0);

                                    break;

                                case 2:
                                    do {

                                        switch (SeChoiceEmployeesMovie()) {
                                            case 1://AddMovie
                                                WPK.AddMovie(MM_Employees.AddMovie());
                                                break;
                                            case 2://SearchMovie
                                                WPK.SearchMovie(MM_Employees.InputMemberID());
                                                break;
                                            case 3://DeleteMovie
                                                WPK.DeleteMovie(MM_Employees.InputMovieID());
                                                break;
                                            case 4://ListMovie
                                                WPK.ListMovie();
                                                break;
                                            case 5://ListMovieborrow
                                                WPK.ListMovieborrow();
                                                break;

                                            case 6://CheckoutMovieเอริส
                                                WPK.CheckoutMovie(MM_Employees.InputMemberIDFor(), MM_Employees.InputMovieIDFor());
                                                break;
                                            case 7://returnMovie เอริส
                                                WPK.returnMovie(MM_Employees.InputMemberIDFor(), MM_Employees.InputMovieBorrowID());
                                                break;

                                            case 0:
                                                while (select == 0);
                                                System.out.println("Bye");
                                                break;
                                        }
                                        break;
                                    } while (SeChoiceEmployeesMovie() != 0);
                                    break;
                                case 0:
                                    while (select == 0);
                                    System.out.println("Bye");
                                    break;

                            }

                        } while (SeChoiceEmployees() != 0);

                    }

            }
        } while (select != 0);
        System.out.println("Good by");

    }

    public static int SeChoice() {
        System.out.print("\n--------------\n");
        System.out.print(menu);
        int select = Sc.nextInt();
        return select;//Integer.parseInt(input.nextLine());
    }

    public static int SeChoiceManager() {
        System.out.print("\n----------------------------\n");
        System.out.print(menuManager);
        int select = Sc.nextInt();
        if (select > 5) {
            do {
                select = SeChoiceManager();
            } while (select > 5);

        }
        return select;//Integer.parseInt(input.nextLine());
    }

    public static int SeChoiceEmployees() {
        System.out.print("\n----------------------------\n");
        System.out.print(menuEmployee);
        int select = Sc.nextInt();
        if (select > 2) {

            do {
                select = SeChoiceEmployees();
            } while (select > 2);
        }
        return select;//Integer.parseInt(input.nextLine());
    }

    public static int SeChoiceEmployeesMember() {
        System.out.print("\n----------------------------\n");
        System.out.print(menuEmployeeMember);
        int select = Sc.nextInt();
        if (select > 7) {

            do {
                select = SeChoiceEmployeesMember();
            } while (select > 7);
        }
        return select;//Integer.parseInt(input.nextLine());
    }

    public static int SeChoiceEmployeesMovie() {
        System.out.print("\n----------------------------\n");
        System.out.print(menuEmployeeMovie);
        int select = Sc.nextInt();
        if (select > 7) {

            do {
                select = SeChoiceEmployeesMovie();
            } while (select > 7);
        }
        return select;//Integer.parseInt(input.nextLine());
    }

    //----------------------MenuManager-------------------
//    public void Mnlogin() {
//        while (Managerlogin() == false) {
//            System.out.println("Wrong code.... Request to enter a new code correctly.");
//        }
//    }
    public static String loginID() {
        System.out.println("----Login----");
        System.out.println("ID :");
        Sc.nextLine();
        String id = Sc.nextLine();
        while (id.equals(null)) {
            System.out.println("ID must not null");
            System.out.println("ID : ");
            id = Sc.nextLine();
        }
        return id;
    }

    public static String loginPassaword() {
        System.out.println("Password :");
        String password = Sc.nextLine();
        while (password.equals(null)) {
            System.out.println("Password must not null");
            System.out.println("Password: ");
            password = Sc.nextLine();
        }
        return password;
    }

    //-------------------MenuManager--------------------------------
    //------------------MenuEmployee------------------------------
   

}
