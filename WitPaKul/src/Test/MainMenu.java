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

    static String menu = "--------Menu--------\n"
            + "---Store System---\n"
            + "1.Manager\n"
            + "2.Employee\n"
            + "3.Member\n"
            + "4.Movie\n"
            + "5.Exit...\n"
            + "-------------------"
            + "Enter Your Menu [1‐5]: ";

    static Scanner Sc = new Scanner(System.in);

    public static void main(String[] args) {
        ManagerAccount m1 = new ManagerAccount("EMP00", "firstname", "lastname", "password", 05254, AccountStatus.MANAGER);
        ManagerService Desktop = new ManagerService(5, m1);
        Desktop.ManagerServiceLogin("EMP00", "password");

        int select;
        do {
            select = SeChoice();
            switch (select) {
                case 1:
                    //Managerlogin();
                    System.out.println("insert name");
                    String menu = Sc.nextLine();
                    Desktop.CreateEmployeesAccount(menu, menu, menu, menu, select, AccountStatus.MEMBER);
                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:
            }
        } while (select != 0);
        System.out.println("Good by");
    }

    public static int SeChoice() {
        System.out.print("\n----------------------------\n");
        System.out.print(menu);

        return Sc.nextInt();//Integer.parseInt(input.nextLine());
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

    public MemberAccount CreateMember() {
        int count = 0;
        String EMPid = Sc.nextLine();
        String firstname = Sc.nextLine();
        String lastname = Sc.nextLine();
        String password = Sc.nextLine();
        long phone = Sc.nextLong();
        AccountStatus status = null;
        AccountMovieStatus acstatus = null;
        if (firstname == null || lastname == null || password == null || status == null || acstatus == null) {
            System.out.println("NULL are prohibited");
            return null;
        }

        if (EMPid == null) {
            System.out.println("NULL are prohibited");
            return null;
        }

        String id = String.format("MEM0%d", (count + 1));

        MemberAccount member = new MemberAccount(id, firstname, lastname, password, phone, status, acstatus);

        return member;
    }

    public EmployeeAccount CreateEmployeesAccount() {
        int count = 0;
        String managerID = Sc.nextLine();
        String firstname = Sc.nextLine();
        String lastname = Sc.nextLine();
        String password = Sc.nextLine();
        long phone = Sc.nextLong();
        AccountStatus status = null;
        AccountMovieStatus acstatus = null;

        if (firstname == null || lastname == null || password == null || status == null || acstatus == null) {
            System.out.println("NULL are prohibited");
            return null;
        }

        if (managerID == null) {
            System.out.println("NULL are prohibited");
            return null;
        }
        String id = String.format("EMP0%d", (count + 1));

        EmployeeAccount employee = new EmployeeAccount(id, firstname, lastname, password, phone, status);

        return employee;
    }

    public Movie AddMovie() {
        int count = 0;
        String EMPid = Sc.nextLine();
        String movieTitle = Sc.nextLine();
        int premiumStatus = Sc.nextInt();
        MovieStatus mos = null;

        if (movieTitle == null || mos == null) {
            System.out.println("NULL are prohibited");
        }

        if (EMPid == null) {
            System.out.println("NULL are prohibited");
        }
        String id = String.format("EMP0%d", (count + 1));

        Movie newMovie = new Movie(id, movieTitle, premiumStatus, mos);

        return newMovie;
    }

}
