package wpk.MainMenu;

import wpk.MenuMethod.MM_Manager;
import wpk.Store.MovieStore;
import wpk.Enum.AccountStatus;
import wpk.Store.ManagerService;
import java.util.Scanner;
import wpk.MenuMethod.MM_Employees;
import wpk.account.ManagerAccount;

public class MainMenu {

    static String menu
            = "<<< Menu >>>\n"
            + "--Store System-- \n"
            + "1.Manager  \n"
            + "2.Employee  \n"
            + "0.Exit    \n"
            + "----------------"
            + "\nEnter Your Menu [1‐2]: ";
    static String menuManager
            = "<<< MenuManager >>>\n"
            + "---Store System----\n"
            + "1.CreateEmployees\n"
            + "2.EditData_Employees\n"
            + "3.SearchEmployees\n"
            + "4.ListEmployees\n"
            + "5.DeleteEmployees\n"
            + "6.EditdataManager\n"
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
            + "0...Return to the MenuEmployee...\n"
            + "-------------------"
            + "\nEnter Your Menu [1‐7]: ";
    static String menuEmployeeMovie
            = "--------MenuEmployee----------\n"
            + "---Store System---\n"
            + "1.AddMovie\n"
            + "2.SearchMovie\n"
            + "3.DeleteMovie\n"
            + "4.ListMovie\n"
            + "5.ListMovieborro2\n"
            + "6.CheckoutMovie\n"
            + "7.returnMovie\n"
            + "8.CreateReceipts\n"
            + "9.Checkprice\n"
            + "0...Return to the MenuEmployee...\n"
            + "-------------------"
            + "\nEnter Your Menu [1‐14]: ";

    public static Scanner Sc = new Scanner(System.in);

    public static void main(String[] args) {

        ManagerAccount m1 = new ManagerAccount("MA01", "firstname", "lastname", "1", 05254, AccountStatus.MANAGER);
        ManagerService Desktop = new ManagerService(50, m1);
        MovieStore WPK = new MovieStore("WitPaKul", 50, 50, 50, 50);
        WPK.SetService(Desktop);
        int select;
        int selectmanager;
        int selectEmployees;
        int selectEmployeesMovie;
        int selectEmployeesMember;

        do {
            select = SeChoice();

            switch (select) {
                case 1:
                    // Desktop.CreateEmployeesAccount(CreateEmployeesAccount());
                    if (Desktop.ManagerServiceLogin(loginID(), loginPassaword())) {
                        //do{

                        do {

                            switch (selectmanager = SeChoiceManager()) {
                                case 1://CreateEmployeesAccount
                                    Desktop.CreateEmployeesAccount(MM_Manager.CreateEmployeesAccount());
                                    continue;
                                case 2://EditData_Employees
                                    Desktop.EditData_Employees(MM_Manager.EditdataEmployeesAccount());
                                    continue;
                                case 3://SearchEmployees 
                                    Desktop.SearchEmployees(MM_Manager.InputEmployeesID());
                                    continue;
                                case 4://ListEmployees 
                                    Desktop.ListEmployees();
                                    continue;
                                case 5://DeleteEmployee 
                                    Desktop.DeleteEmployees(MM_Manager.InputEmployeesID());
                                    continue;
                                case 6:
                                    Desktop.EditData_Manager(MM_Manager.EditdataManagerAccount());
                                    continue;
                                case 0:
                                    System.out.println("Good luck");
                                    break;
                            }
                            break;
                        } while (selectmanager != 0);
                    }
                    break;

                case 2:
                    if (WPK.LoginEmployeesinStore(loginID(), loginPassaword())) {
                        do {

                            switch (selectEmployees = SeChoiceEmployees()) {
                                case 1:
                                    do {

                                        switch (selectEmployeesMember = SeChoiceEmployeesMember()) {
                                            case 1://CreateMember
                                                WPK.CreateMember(MM_Employees.CreateMember());
                                                continue;
                                            case 2://EditData_Member
                                                WPK.EditData_Member(MM_Employees.EditData_Member());
                                                continue;

                                            case 3://SearchMember
                                                WPK.SearchMember(MM_Employees.InputMemberID());
                                                continue;
                                            case 4://DeleteMember
                                                WPK.DeleteMember(MM_Employees.InputMemberID());
                                                continue;

                                            case 5://ListMembers
                                                WPK.ListMembers();
                                                continue;
                                            case 6://ListMemberBorrowingList 
                                                WPK.ListMemberBorrowingList(MM_Employees.InputMemberID());
                                                continue;
                                            case 7://CheckForFine 
                                                WPK.CheckForFine(MM_Employees.InputMemberIDFor(), MM_Employees.InputMovieIDFor());
                                                continue;

                                            case 0:
                                                while (select == 0);
                                                System.out.println("Good luck");

                                                break;
                                        }
                                        break;
                                    } while (selectEmployeesMember != 0);

                                    break;

                                case 2:
                                    do {

                                        switch (selectEmployeesMovie = SeChoiceEmployeesMovie()) {
                                            case 1://AddMovie
                                                WPK.AddMovie(MM_Employees.AddMovie());
                                                continue;
                                            case 2://SearchMovie
                                                WPK.SearchMovie(MM_Employees.InputMovieID());
                                                continue;
                                            case 3://DeleteMovie
                                                WPK.DeleteMovie(MM_Employees.InputMovieID());
                                                continue;
                                            case 4://ListMovie
                                                WPK.ListMovie();
                                                continue;
                                            case 5://ListMovieborrow
                                                WPK.ListMovieborrow();
                                                continue;

                                            case 6://CheckoutMovieเอริส
                                                WPK.CheckoutMovie(MM_Employees.InputMemberIDFor(), MM_Employees.InputMovieIDFor());
                                                continue;
                                            case 7://returnMovie เอริส
                                                WPK.returnMovie(MM_Employees.InputMemberIDFor(), MM_Employees.InputMovieBorrowID());
                                                continue;

                                            case 8:
                                                WPK.CreateReceipts(MM_Employees.InputMemberID());
                                                continue;
                                            case 9:
                                                WPK.checkprice(MM_Employees.InputMovieID());
                                                continue;

                                            case 0:
                                                while (select == 0);
                                                System.out.println("Good luck");
                                                break;
                                        }
                                        break;
                                    } while (selectEmployeesMovie != 0);
                                    break;
                                case 0:
                                    while (select == 0);
                                    System.out.println("Good luck");
                                    break;

                            }

                        } while (selectEmployees != 0);

                    }

            }
        } while (select != 0);
        System.out.println("Good luck");

    }

    public static int SeChoice() {
        int select = 0;
        System.out.print("\n----------------\n");
        System.out.print(menu);

        do {
            try {
                select = Sc.nextInt();
                //Integer.parseInt(input.nextLine());
            } catch (Exception e) {
                Sc.nextLine();
                System.out.println("Please enter only numbers");
                System.out.println("Enter Your Menu [1‐2]:");
                continue;

            }
            return select;

        } while (true);

    }

    public static int SeChoiceManager() {
        int select = 0;
        System.out.print("\n----------------------------\n");
        System.out.print(menuManager);
        do {
            try {
                select = Sc.nextInt();
            } catch (Exception e) {
                Sc.nextLine();
                System.out.println("Please enter only numbers");
                System.out.println("Enter Your Menu [1-6]:");
                if (select > 6) {
                    do {
                        select = SeChoiceManager();
                    } while (select > 6);

                }
                continue;
            }
            return select;

        } while (true);

    }

    public static int SeChoiceEmployees() {
        int select = 0;
        System.out.print("\n----------------------------\n");
        System.out.print(menuEmployee);
        do {
            try {
                select = Sc.nextInt();
            } catch (Exception e) {
                Sc.nextLine();
                System.out.println("Please enter only numbers");
                System.out.println("Enter Your Menu [1-2]:");
                if (select > 2) {
                    do {
                        select = SeChoiceEmployees();
                    } while (select > 2);

                }
                continue;
            }
            return select;

        } while (true);
    }

    public static int SeChoiceEmployeesMember() {
        int select = 0;
        System.out.print("\n----------------------------\n");
        System.out.print(menuEmployeeMember);

        do {
            try {
                select = Sc.nextInt();
            } catch (Exception e) {
                Sc.nextLine();
                System.out.println("Please enter only numbers");
                System.out.println("Enter Your Menu [1-7]:");
                if (select > 7) {
                    do {
                        select = SeChoiceEmployeesMember();
                    } while (select > 7);

                }
                continue;
            }
            return select;

        } while (true);
    }

    public static int SeChoiceEmployeesMovie() {
        int select = 0;
        System.out.print("\n----------------------------\n");
        System.out.print(menuEmployeeMovie);

        do {
            try {
                select = Sc.nextInt();
            } catch (Exception e) {
                Sc.nextLine();
                System.out.println("Please enter only numbers");
                System.out.println("Enter Your Menu [1-7]:");
                if (select > 8) {
                    do {
                        select = SeChoiceEmployeesMovie();
                    } while (select > 8);

                }
                continue;
            }
            return select;

        } while (true);
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
