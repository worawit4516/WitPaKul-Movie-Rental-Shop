/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wpk.MainMenu;

import java.util.Scanner;
import wpk.MenuMethod.MM_Manager;
import wpk.Store.MovieStore;
import wpk.Enum.AccountStatus;
import wpk.Store.ManagerService;
import wpk.account.ManagerAccount;
import wpk.Enum.AccountMovieStatus;
import wpk.Enum.MovieStatus;
import java.util.Scanner;
import wpk.MainMenu.MainMenu;
import static wpk.MainMenu.MainMenu.Sc;
import wpk.Movie.Movie;
import wpk.account.ManagerAccount;
import wpk.account.Account;
import wpk.account.EmployeeAccount;
import wpk.account.MemberAccount;

/**
 *
 * @author user
 */
//123
public class MainMenu {
//private String Mid = "1";
    //private String Mpassword = "1";

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

        ManagerAccount m1 = new ManagerAccount("EMP00", "firstname", "lastname", "password", 05254, AccountStatus.MANAGER);
        ManagerService Desktop = new ManagerService(5, m1);
        Desktop.ManagerServiceLogin("EMP00", "password");
        MovieStore WPK = new MovieStore("WitPaKul", 50, 50, 50, 50, 50, "EMP02");
        MM_Manager me = new MM_Manager();

        int select;
        do {
            select = SeChoice();
            switch (select) {
                case 1:
                    // Desktop.CreateEmployeesAccount(CreateEmployeesAccount());
                    if (Managerlogin()) {
                        //do{
                        switch (SeChoiceManager()) {
                            case 1://CreateEmployeesAccount
                                Desktop.CreateEmployeesAccount(MM_Manager.CreateEmployeesAccount());

                                break;

                            case 2://EditData_Employees
                                Desktop.EditData_Employees(MM_Manager.EditdataEmployeesAccount());
                                break;
                            case 3://SearchEmployees เอริส
                                Desktop.SearchEmployees(MM_Manager.SearchEmployees());
                                break;
                            case 4://ListEmployees เอริส
                                 Desktop.ListEmployees();
                                break;
                            case 5://DeleteEmployee เอริส
                                  Desktop.DeleteEmployees(MM_Manager.DeleteEmployees());
                                break;
                           
                            case 0:
                                while (select == 0 );
                                System.out.println("Bye");

                                break;

                        }
                        if (SeChoiceManager() > 5 ) {
                            break;
                        }

                        // }while (select != 0);
                        //     System.out.println("Bye");
                    }
                    
                    break;

                case 2:
                    if (Employeelogin()) {
                        switch (SeChoiceEmployees()) {
                            case 1:

                                switch (SeChoiceEmployeesMember()) {
                                    case 1://CreateMember
                                        WPK.CreateMember(MM_Manager.CreateMember());
                                        break;
                                    case 2://EditData_Member

                                        break;

                                    case 3://SearchMember
                                        break;
                                    case 4://DeleteMember

                                        break;

                                    case 5://ListMembers
                                        WPK.ListMembers();
                                        break;
                                    case 6://ListMemberBorrowingList 

                                        break;
                                    case 7://CheckForFine เอริส

                                        break;
                                }
                                break;

                            case 2:
                                switch (SeChoiceEmployeesMovie()) {
                                    case 1://AddMovie
                                        WPK.AddMovie(MM_Manager.AddMovie());
                                        break;
                                    case 2://SearchMovie

                                        break;
                                    case 3://DeleteMovie

                                        break;
                                    case 4://ListMovie

                                        break;
                                    case 5://ListMovieborrow

                                        break;

                                    case 6://CheckoutMovieMember เอริส

                                        break;
                                    case 7://returnMovie เอริส

                                        break;
                                }
                                break;

                            case 0:
                                while (select == 0);
                                System.out.println("Bye");

                                break;
                        }
                    }

                    break;
                case 3:

            }
        } while (select != 0);
        System.out.println("Good by");

        /* do {
            select = SeChoiceManager();
            switch (select) {
                case 1:
                    Desktop.CreateEmployeesAccount(CreateEmployeesAccount());

                case 2:
                    Desktop.EditData_Employees(EditdataEmployeesAccount());
                    //employeesใช้
                    //Employeeslogin
                    break;

        
                case 3:
                    Desktop.ListEmployees();

                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:

                    break;
            }
        } while (select != 0);
        System.out.println("Good by");
         */
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
        return select;//Integer.parseInt(input.nextLine());
    }

    public static int SeChoiceEmployees() {
        System.out.print("\n----------------------------\n");
        System.out.print(menuEmployee);
        int select = Sc.nextInt();
        return select;//Integer.parseInt(input.nextLine());
    }

    public static int SeChoiceEmployeesMember() {
        System.out.print("\n----------------------------\n");
        System.out.print(menuEmployeeMember);
        int select = Sc.nextInt();
        return select;//Integer.parseInt(input.nextLine());
    }

    public static int SeChoiceEmployeesMovie() {
        System.out.print("\n----------------------------\n");
        System.out.print(menuEmployeeMovie);
        int select = Sc.nextInt();
        return select;//Integer.parseInt(input.nextLine());
    }

    //----------------------MenuManager-------------------
    public void Mnlogin() {
        while (Managerlogin() == false) {
            System.out.println("Wrong code.... Request to enter a new code correctly.");
        }
    }

    public static boolean Managerlogin() {
        System.out.println("----Login Manager----");
        System.out.println("Name :");
        String id = Sc.nextLine();
        Sc.nextLine();
        System.out.println("Password :");
        String password = Sc.nextLine();

        if (id.equals(id) && password.equals(password)) {
            System.out.println("OK GO");
            return true;

        }

        return false;
    }

    /*} public   boolean Managerlogin() {
        System.out.println("----Login Manager----");
        System.out.println("Name :");
        String ids = Sc.nextLine();
        System.out.println("Password :");
        String passwords = Sc.nextLine();

        if (this.Mid.equals(ids) && this.Mpassword.equals(passwords)) {

            return true;

        }
        
        return false;
    }*/
    

    //-------------------MenuManager--------------------------------
    //------------------MenuEmployee------------------------------
    public static boolean Employeelogin() {
        System.out.println("----Login Employee----");
        System.out.println("Name :");
        String id = Sc.nextLine();
        Sc.nextLine();
        System.out.println("Password :");
        String password = Sc.nextLine();

        if (id.equals(id) && password.equals(password)) {
            System.out.println("OK GO");
            return true;

        }
        return false;
    }

    
    
}
