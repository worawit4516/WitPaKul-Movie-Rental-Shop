/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import Test.Menu;
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

    static String menu
            = "--------Menu--------\n"
            + "---Store System---\n"
            + "1.Manager\n"
            + "2.Employee\n"
            + "3.Member\n"
            + "4.Movie\n"
            + "5.Exit...\n"
            + "-------------------"
            + "\nEnter Your Menu [1‐5]: ";
    static String menuManager
            = "--------Menu--------\n"
            + "---Store System---\n"
            + "1.Manager\n"
            + "2.Employee\n"
            + "3.Member\n"
            + "4.Movie\n"
            + "5.Exit...\n"
            + "-------------------"
            + "\nEnter Your Menu [1‐5]: ";

    static Scanner Sc = new Scanner(System.in);

    public static void main(String[] args) {
        ManagerAccount m1 = new ManagerAccount("EMP00", "firstname", "lastname", "password", 05254, AccountStatus.MANAGER);
        ManagerService Desktop = new ManagerService(5, m1);
        Desktop.ManagerServiceLogin("EMP00", "password");
        //  Desktop.CreateEmployeesAccount("EMP100", "firstname", "lastname", "password", 5462552, AccountStatus.EMPLOYEE);
        MovieStore WPK = new MovieStore("WitPaKul", 50, 50, 50, 50, 50, "EMP02");

        int select;
        do {
            select = SeChoice();
            switch (select) {
                case 1:
                    Desktop.CreateEmployeesAccount(CreateEmployeesAccount());
                    //Managerlogin
                    //managerใช้
                    //หน้าเมณูใหม่หลังจากล็อกอิน
                    //{ CreateEmployeesAccount
                    //EditData_Manager
                    // 1EditData_Employees
                    //SearchEmployees
                    //ListEmployees()
                    //DeleteEmployees
                    //checkEmployeesByID}
                    break;
                case 2:
                    Desktop.EditData_Employees(EditdataEmployeesAccount());
                    //employeesใช้
                    //Employeeslogin
                    //
                    //
                    //
                    //
                    //
                    //
                    //
                    //
                    //
                    //
                    //
                    break;
                case 3:
                    Desktop.ListEmployees();
            }
        } while (select != 0);
        System.out.println("Good by");

        do {
            select = SeChoice();
            switch (select) {
                case 1:
                    Desktop.CreateEmployeesAccount(CreateEmployeesAccount());
                    //Managerlogin
                    //managerใช้
                    //หน้าเมณูใหม่หลังจากล็อกอิน
                    //{ CreateEmployeesAccount
                    //EditData_Manager
                    // 1EditData_Employees
                    //SearchEmployees
                    //ListEmployees()
                    //DeleteEmployees
                    //checkEmployeesByID}
                    break;
                case 2:
                    Desktop.EditData_Employees(EditdataEmployeesAccount());
                    //employeesใช้
                    //Employeeslogin
                    //
                    //
                    //
                    //
                    //
                    //
                    //
                    //
                    //
                    //
                    //
                    break;
                case 3:
                    Desktop.ListEmployees();
            }
        } while (select != 0);
        System.out.println("Good by");
    }

    public static int SeChoice() {
        System.out.print("\n----------------------------\n");
        System.out.print(menu);
        int select = Sc.nextInt();
        return select;//Integer.parseInt(input.nextLine());
    }

//    public static void Mnlogin() {
//        while (Managerlogin() == false) {
//            System.out.println("Wrong code.... Request to enter a new code correctly.");
//        }
//    }
    public static boolean Managerlogin() {
        System.out.println("----Login Manager----");
        System.out.println("Name :");
        String id = Sc.nextLine();
        System.out.println("Password :");
        String password = Sc.nextLine();

        if (id.equals(id) && password.equals(password)) {
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
