/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import java.util.Scanner;

import wpk.Store.MovieStore;
import wpk.Enum.AccountStatus;
import wpk.Store.ManagerService;
import wpk.account.ManagerAccount;
import wpk.Enum.AccountMovieStatus;
import wpk.Enum.MovieStatus;
import java.util.Scanner;
import Test.MainMenu;
import static Test.MainMenu.Sc;
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
            + "6.checkEmployeesByID\n"
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
            + "6.CheckoutMovieMember\n"
            + "7.returnMovie\n"
            + "0...Return to the menu...\n"
            + "-------------------"
            + "\nEnter Your Menu [1‐14]: ";

    static Scanner Sc = new Scanner(System.in);

    public static void main(String[] args) {

        ManagerAccount m1 = new ManagerAccount("EMP00", "firstname", "lastname", "password", 05254, AccountStatus.MANAGER);
        ManagerService Desktop = new ManagerService(5, m1);
        MovieStore miStore = new MovieStore("WitPaKul", 50, 50, 50, 50, 50, "EMP02");

        Desktop.ManagerServiceLogin("EMP00", "password");
        //  Desktop.CreateEmployeesAccount("EMP100", "firstname", "lastname", "password", 5462552, AccountStatus.EMPLOYEE);
        MovieStore WPK = new MovieStore("WitPaKul", 50, 50, 50, 50, 50, "EMP02");

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
                                Desktop.CreateEmployeesAccount(CreateEmployeesAccount());

                                break;

                            case 2://EditData_Employees
                                Desktop.EditData_Employees(EditdataEmployeesAccount());
                                break;
                            case 3://SearchEmployees เอริส

                                break;
                            case 4://ListEmployees เอริส

                                break;
                            case 5://DeleteEmployee เอริส

                                break;
                            case 6://checkEmployeesByID เอริส

                                break;
                            case 0:
                                while (select != 0);
                                System.out.println("Bye");

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
                                        miStore.CreateMember(CreateMember());
                                        break;
                                    case 2://EditData_Member

                                        break;

                                    case 3://SearchMember
                                        break;
                                    case 4://DeleteMember

                                        break;

                                    case 5://ListMembers

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
                                        miStore.AddMovie(AddMovie());
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
                                while (select != 0);
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
    public static EmployeeAccount CreateEmployeesAccount() {
        int count = 0;
        System.out.println("----Creat EmployeesAccount----");
        System.out.println("Firstname : ");
        Sc.nextLine();
        String firstname = Sc.nextLine();

        while (firstname.equals("")) {
            System.out.println("firstname must not null");
            System.out.println("Firstname : ");
            firstname = Sc.nextLine();
        }

        System.out.println("Lastname : ");
        String lastname = Sc.nextLine();
        while (lastname.equals("")) {
            System.out.println("Lastname must not null");
            System.out.println("Lastname : ");
            lastname = Sc.nextLine();
        }

        System.out.println("Password : ");
        String password = Sc.nextLine();
        while (lastname.equals("")) {
            System.out.println("Password must not null");
            System.out.println("Password : ");
            password = Sc.nextLine();
        }
        System.out.println("Phone : ");

        long phone = Sc.nextLong();
        AccountStatus status = AccountStatus.EMPLOYEE;

        if (firstname == null || lastname == null || password == null) {
            System.out.println("NULL are prohibited");
            CreateEmployeesAccount();
        }

        String id = String.format("EMP0%d", (count + 1));

        EmployeeAccount employee = new EmployeeAccount(id, firstname, lastname, password, phone, status);

        return employee;
    }

    public static EmployeeAccount EditdataEmployeesAccount() {

        int count = 0;

        System.out.println("----Edit EmployeesAccount----");
        System.out.println("ID :");
        String id = Sc.next();
        Sc.nextLine();

        System.out.println("Firstname : ");
        String firstname = Sc.nextLine();
        while (firstname.equals("")) {
            System.out.println("firstname must not null");
            System.out.println("Firstname : ");
            firstname = Sc.nextLine();
        }

        System.out.println("Lastname : ");
        String lastname = Sc.nextLine();
        while (lastname.equals("")) {
            System.out.println("Lastname must not null");
            System.out.println("Lastname : ");
            lastname = Sc.nextLine();
        }

        System.out.println("Password : ");
        String password = Sc.nextLine();
        while (lastname.equals("")) {
            System.out.println("Password must not null");
            System.out.println("Password : ");
            password = Sc.nextLine();
        }
        System.out.println("Phone : ");
        long phone = Sc.nextLong();

        AccountStatus status = AccountStatus.EMPLOYEE;

        if (id.equals("") || firstname.equals("") || lastname.equals("") || password.equals("")) {
            System.out.println("NULL are prohibited");
            EditdataEmployeesAccount();
        }

        EmployeeAccount employee = new EmployeeAccount(id, firstname, lastname, password, phone, status);

        return employee;
    }

    //-------------------MenuManager--------------------------------
    //------------------MenuEmployee------------------------------
    public static boolean Employeelogin() {
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

    public static MemberAccount CreateMember() {
        int count = 0;
        System.out.println("----Creat Mamber----");
        System.out.println("Firstname : ");
        Sc.nextLine();
        String firstname = Sc.nextLine();

        while (firstname.equals("")) {
            System.out.println("firstname must not null");
            System.out.println("Firstname : ");
            firstname = Sc.nextLine();
        }

        System.out.println("Lastname : ");
        String lastname = Sc.nextLine();

        while (firstname.equals("")) {
            System.out.println("Lastname must not null");
            System.out.println("Lastname : ");
            lastname = Sc.nextLine();
        }

        System.out.println("Password : ");
        String password = Sc.nextLine();
        while (lastname.equals("")) {
            System.out.println("Password must not null");
            System.out.println("Password : ");
            password = Sc.nextLine();
        }

        System.out.println("Phone : ");
        long phone = Sc.nextLong();

        AccountStatus status = AccountStatus.MEMBER;
        AccountMovieStatus acstatus = AccountMovieStatus.ACTIVEB;
        if (firstname == "" || lastname == "" || password == "") {
            System.out.println("NULL are prohibited");
            CreateMember();
        }

        String id = String.format("MEM0%d", (count + 1));

        MemberAccount member = new MemberAccount(id, firstname, lastname, password, phone, status, acstatus);

        return member;
    }

    public static Movie AddMovie() {
        int count = 0;

        System.out.println("MovieTitle : ");
        Sc.nextLine();
        String movieTitle = Sc.nextLine();
        while (movieTitle.equals("")) {
            System.out.println("Movietitle must not null");
            System.out.println("Movietitle : ");
            movieTitle = Sc.nextLine();
        }

        System.out.println("PremiumStatus : ");
        int premiumStatus = Sc.nextInt();
        while (movieTitle.equals("")) {
            System.out.println("PremiumStatus must not null");
            System.out.println("PremiumStatus : ");
            premiumStatus = Sc.nextInt();
        }
        MovieStatus mos = MovieStatus.Available;

        if (movieTitle == null) {
            System.out.println("NULL are prohibited");
            AddMovie();
        }

        String id = String.format("MOV0%d", (count + 1));

        Movie newMovie = new Movie(id, movieTitle, premiumStatus, mos);

        return newMovie;
    }

}
