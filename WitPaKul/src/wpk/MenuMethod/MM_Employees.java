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
import wpk.account.MemberAccount;

/**
 *
 * @author Earty
 */
public class MM_Employees {

    private static int countMember = 0;
    private static int countMovie = 0;

    public static MemberAccount CreateMember() {
        long phone = 0;
        AccountStatus status = null;
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

        while (lastname.equals("")) {
            System.out.println("Lastname must not null");
            System.out.println("Lastname : ");
            lastname = Sc.nextLine();
        }

        System.out.println("Password : ");
        String password = Sc.nextLine();
        while (password.equals("")) {
            System.out.println("Password must not null");
            System.out.println("Password : ");
            password = Sc.nextLine();
        }

        do {
            try {
                System.out.println("Phone : ");
                phone = Sc.nextLong();

            } catch (Exception o) {
                Sc.nextLine();

                System.out.println("Please enter only numbers.");
                continue;
            }
            break;
        } while (true);

        System.out.println("AccountStatus status must only 1 or 0");
        System.out.println("1 is PremiumMember or 0 is Member");
        System.out.println("AccountStatus status : ");
        int statusinput = Sc.nextInt();
        while (password.equals("")) {
            System.out.println("AccountStatus status must not null");
            System.out.println("AccountStatus status : ");
            statusinput = Sc.nextInt();
        }
        if (statusinput == 1) {
           status = AccountStatus.PREMIUMMEMBER;
        } 
        
        if (statusinput == 0) {
           status = AccountStatus.MEMBER;
        }
       
        AccountMovieStatus acstatus = AccountMovieStatus.ACTIVEB;
        if (firstname == "" || lastname == "" || password == "") {
            System.out.println("NULL are prohibited");
            CreateMember();
        }

        String id = String.format("MEM0%d", (countMember + 1));

        MemberAccount member = new MemberAccount(id, firstname, lastname, password, phone, status, acstatus);

        countMember++;

        return member;
    }

    //
    public static MemberAccount EditData_Member() {
        long phone = 0;
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
        while (password.equals("")) {
            System.out.println("Password must not null");
            System.out.println("Password : ");
            password = Sc.nextLine();
        }

        do {
            try {
                System.out.println("Phone : ");
                phone = Sc.nextLong();

            } catch (Exception o) {
                Sc.nextLine();

                System.out.println("Please enter only numbers.");
                continue;
            }
            break;
        } while (true);

        AccountStatus status = AccountStatus.MEMBER;

        if (id.equals("") || firstname.equals("") || lastname.equals("") || password.equals("")) {
            System.out.println("NULL are prohibited");
            EditData_Member();
        }

        MemberAccount member = new MemberAccount(id, firstname, lastname, password, phone, status, AccountMovieStatus.ACTIVEB);

        return member;
    }
    //-----------

    //-----------MenuEmployeeMovie------------
    public static Movie AddMovie() {
        int premiumStatus = 0;
        System.out.println("MovieTitle : ");
        Sc.nextLine();
        String movieTitle = Sc.nextLine();
        while (movieTitle.equals("")) {
            System.out.println("Movietitle must not null");
            System.out.println("Movietitle : ");
            movieTitle = Sc.nextLine();
        }

        do {
            try {
                System.out.println("PremiumStatus must only 1 or 0");
                System.out.println("PremiumStatus : ");
                premiumStatus = Sc.nextInt();

            } catch (Exception o) {
                Sc.nextLine();
                while (premiumStatus > 1) {

                    premiumStatus = Sc.nextInt();
                }
                System.out.println("Please enter only 1 or 0");
                continue;
            }
            break;
        } while (true);

        MovieStatus mos = MovieStatus.Available;

        if (movieTitle == null) {
            System.out.println("NULL are prohibited");
            AddMovie();
        }

        String id = String.format("MOV0%d", (countMovie + 1));

        Movie newMovie = new Movie(id, movieTitle, premiumStatus, mos);
        countMovie++;
        return newMovie;
    }

    public static String InputMoviename() {

        System.out.println("----Movie name----");
        System.out.println("Name : ");
        Sc.nextLine();
        String name = Sc.nextLine();
        while (name.equals("")) {
            System.out.println("Moviename must not null");
            System.out.println("Moviename : ");
            name = Sc.nextLine();
        }

        return name;//ของMemberมันคือ MovieID 

    }

    public static String InputMovieID() {

        System.out.println("----Movie ID----");
        System.out.println("ID : ");
        Sc.nextLine();
        String id = Sc.nextLine();
        while (id.equals("")) {
            System.out.println("Movie ID must not null");
            System.out.println("Movie ID : ");
            id = Sc.nextLine();
        }

        return id;//ของMemberมันคือ MovieID 

    }

    public static String InputMovieBorrowID() {

        System.out.println("----MovieBorrow ID----");
        System.out.println("ID : ");
        String id = Sc.nextLine();
        while (id.equals("")) {
            System.out.println("MovieBorrow ID must not null");
            System.out.println("MovieBorrow ID : ");
            id = Sc.nextLine();
        }

        return id;//ของMemberมันคือ MovieID 

    }

    public static String InputMemberID() {

        System.out.println("----Member ID----");
        System.out.println("ID : ");
        Sc.nextLine();
        String id = Sc.nextLine();
        while (id.equals("")) {
            System.out.println("Member ID must not null");
            System.out.println("Member ID : ");
            id = Sc.nextLine();
        }

        return id;//ของMemberมันคือ memberID 

    }

    public static String InputMemberIDFor() {

        System.out.println("----Member ID----");
        System.out.println("ID : ");
        Sc.nextLine();
        String id = Sc.nextLine();
        while (id.equals("")) {
            System.out.println("Member ID must not null");
            System.out.println("Member ID : ");
            id = Sc.nextLine();
        }

        return id;//ของMemberมันคือ memberID 

    }

    public static String InputMovieIDFor() {

        System.out.println("----Movie ID----");
        System.out.println("ID : ");
        String id = Sc.nextLine();
        while (id.equals("")) {
            System.out.println("Movie ID must not null");
            System.out.println("Movie ID : ");
            id = Sc.nextLine();
        }

        return id;//ของMemberมันคือ MovieID 

    }

}
