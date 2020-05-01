/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wpk.MenuMethod;

import wpk.Enum.AccountMovieStatus;
import wpk.Enum.AccountStatus;
import wpk.Enum.MovieStatus;
import static wpk.MainMenu.MainMenu.Sc;
import wpk.Movie.Movie;
import wpk.account.EmployeeAccount;
import wpk.account.MemberAccount;

/**
 *
 * @author Earty
 */
public class MM_Employees {
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
    //
    public static MemberAccount EditData_Member() {

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

        AccountStatus status = AccountStatus.MEMBER;

        if (id.equals("") || firstname.equals("") || lastname.equals("") || password.equals("")) {
            System.out.println("NULL are prohibited");
            EditData_Member();
        }

        MemberAccount member = new MemberAccount(id, firstname, lastname, password, phone, status, AccountMovieStatus.ACTIVEB);

        return member;
    }
    //-----------
    public static String SearchMember() {

        System.out.println("----Member ID----");
        System.out.println("ID : ");
        Sc.nextLine();
        String id = Sc.nextLine();
        return id;

    }
    public static String DeleteMember() {

        System.out.println("----Member ID----");
        System.out.println("ID : ");
        Sc.nextLine();
        String id = Sc.nextLine();
        while (id.equals("")) {
            System.out.println("Member ID must not null");
            System.out.println("Member ID : ");
            id = Sc.nextLine();
        }
       
        return id;//ของMemberมันคือ memberID ??

    }
    
    //-----------MenuEmployeeMovie------------
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
    public static String SearchMovie() {

        System.out.println("----Movie ID----");
        System.out.println("ID : ");
        Sc.nextLine();
        String id = Sc.nextLine();
        return id;

    }
          public static String DeleteMovie() {

        System.out.println("----Movie ID----");
        System.out.println("ID : ");
        Sc.nextLine();
        String id = Sc.nextLine();
        while (id.equals("")) {
            System.out.println("Movie ID must not null");
            System.out.println("Movie ID : ");
            id = Sc.nextLine();
        }
       
        return id;//ของMemberมันคือ memberID ??

    }
}
