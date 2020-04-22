/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wpk.Store;

import wpk.service.EmployeeService;
import java.util.Iterator;
import wpk.account.Account;
import wpk.account.AccountStatus;

import Enum.MovieStatus;
import wpk.account.MemberAccount;
import wpk.account.EmployeeAccount;
import wpk.service.Specifications;
import wpk.account.ManagerService;
import wpk.account.ManagerAccount;
import wpk.Movie.Movie;
import Enum.AccountMovieStatus;
import wpk.Store.MovieBorrowing;

/**
 *
 * @author user
 */
public class MovieStore implements Specifications {

    private String storeName;
    private MemberAccount member[];
    private Movie cdStoreMovie[];//เก็บจำนวนหนังในร้าน
    private MovieBorrowing cdStoreBorrowingMovie[]; //เก็บจำนวนหนังที่ถูกยืมในร้าน
    private ManagerService resouse;
    private EmployeeAccount employeeInstore;
    private int countmember = 0, countMovie = 0, countMovieborrowing = 0;

    public MovieStore(String storeName, int maxcustomer, int maxmember, int maxcdStoreMovie, int maxcdStoreBorrowingMovie, int maxemployees, String id) {
        this.storeName = storeName;
        this.member = new MemberAccount[maxmember];
        this.cdStoreMovie = new Movie[maxcdStoreMovie];
        this.cdStoreBorrowingMovie = new MovieBorrowing[maxcdStoreBorrowingMovie];

    }

    public void SetResouse(ManagerService resouse) {

        try {
            this.resouse = resouse;
            System.out.println("Setcomplete");
        } catch (Exception e) {
            System.out.println("Set failed");
        }
    }

    public void SetEmployeesinStore(String EMPid) {
        try {
            this.employeeInstore = this.resouse.getEmployees(EMPid);
            System.out.println("Setcomplete");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Set failed");
        }

    }

    public Iterator<Movie> iterator() {
        return new Iterator<Movie>() {
            private int counter = 0;

            @Override
            public boolean hasNext() {
                return counter < cdStoreMovie.length;
            }

            @Override
            public Movie next() {
                return cdStoreMovie[counter++];
            }
        };
    }

    //Employeeservice code part//
    public boolean CreateMember(String Id, String fristname, String lastname, String password, long phone, AccountStatus status, AccountMovieStatus acstatus) {

        if (Id.equals(this.employeeInstore.getId())) {

            String id = String.format("MEM0%d", countmember + 1);

            MemberAccount member = new MemberAccount(id, fristname, lastname, password, phone, status, acstatus);
            if (checkMember(id) == -1 && countmember < this.member.length) {
                this.member[countmember++] = member;
                System.out.println("Compleate to Create Data this Member");
                return true;
            } else {
                System.out.println("Can't Createdata this member");
            }

        }
        return false;
    }

    public boolean AddMovie(String id, String movieTitle, int premiumStatus, MovieStatus mos) {
        if (id.equals(this.employeeInstore.getId())) {
            String MovieID = String.format("MOV0%d", countMovie + 1);
            Movie newMovie = new Movie(MovieID, movieTitle, premiumStatus, mos);
            if (checkMovie(MovieID) == -1 && countMovie < cdStoreMovie.length) {
                this.cdStoreMovie[countMovie++] = newMovie;
                System.out.println("Compleate to Create Data this Movie");
                return true;

            } else {
                System.out.println("Can't Createdata this Movie");
            }
        }
        return true;
    }

    //Check
    public boolean EditData_Member(String id, String MemberID, String fristname, String lastname, String password, long phone, AccountStatus status, AccountMovieStatus acstatus) {

        if (id.equals(this.employeeInstore.getId()) && checkMember(MemberID) != -1) {
            for (int i = 0; i < countmember; i++) {
                if (member[i].getId() == null ? id == null : member[i].getId().equals(id)) {
                    member[i].editDataMember(fristname, lastname, password, phone, status, acstatus);
                    System.out.println("Compleate");
                }
            }

        } else {
            System.out.println("Can't fine this Member");
        }
        return true;

    }

    //Search Part
    public int SearchMovie(String movieTitle) {
        if (movieTitle == null) {
            return -1;
        }

        if (movieTitle != null) {
            for (int i = 0; i < countMovie; i++) {
                if (movieTitle == null ? cdStoreMovie[i].getMovieTitle() == null : movieTitle.equals(cdStoreMovie[i].getMovieTitle())) {
                    System.out.println("Found! Data this Movie");
                    System.out.println(cdStoreMovie[i]);

                }
            }

        } else {
            System.out.println("Not found!");
        }
        return -1;
    }

    public int SearchMember(String MemberID) {
        if (MemberID == null) {
            return -1;
        }

        if (MemberID != null) {
            for (int i = 0; i < countmember; i++) {
                if (MemberID == null ? member[i].getId() == null : MemberID.equals(member[i].getId())) {
                    System.out.println("Found! Data this Member");
                    System.out.println(member[i]);

                }
            }

        } else {
            System.out.println("Not found!");
        }
        return -1;
    }

    
    
    
    //Delete Part
    public boolean DeleteMovie(String id, String movieID) {
        if (id.equals(this.employeeInstore.getId()) && checkMember(movieID) != -1) {
            for (int i = checkMovie(id); i < countMovie; i++) {
                if (i == countMovie - 1) {
                    for (int j = i + 1; j < countMovie; j++) {
                        cdStoreMovie[i] = cdStoreMovie[j];
                    }
                    cdStoreMovie[--countMovie] = null;
                    return true;
                }
            }
        }
        return false;
    }

    public boolean DeleteMember(String id, String memberID) {
//        if (id.equals(this.employeeInstore.getId()) && checkMember(memberID) != -1) {
//            for (int i = checkMember(id); i < countmember; i++) {
//                if (i == countmember - 1) {
//                    this.member[i] = null;
//                } else {
//                    this.member[i] = this.member[i + 1];
//                }
//            }
//            countmember--;
//
//        }

        if (id.equals(this.employeeInstore.getId()) && checkMember(memberID) != -1) {
            for (int i = checkMember(id); i < countmember; i++) {
                if (i == countmember - 1) {
                    for (int j = i + 1; j < countmember; j++) {
                        member[i] = member[j];
                    }
                    member[--countmember] = null;
                    return true;
                }
            }
        }
        return false;

    }

    //MovieService Code part//
//    public MovieBorrowing checkOutMovie(MemberAccount member, Movie borrowMovie) {
//        if (check(member) >= 0) {
//            if (member.getTotalMoviecheckedOut() < Specifications.MAX_BORROWDAYS && borrowMovie.getMovieStaus() == MovieStatus.Available) {
//                if (borrowMovie instanceof Movie) {
//                    Movie movie = (Movie) borrowMovie;
//
//                    MemberAccount checkedMovie = new MemberAccount();
//                    checkedMovie.checkOutMovie(movie, member);
//                    cdStoreBorrowingMovie[count++] = checkedMovie;
//                    return checkedMovie;
//                } else {
//                    return null;
//                }
//            } else {
//                return null;
//            }
//        } else {
//            return null;
//        }
//    }
    public MovieBorrowing checkOutMovie(String memberId, String movieID) {
//        MemberAccount memberborrow = null;
//        Movie borrowmovie = null;
//        for (int i = 0; i < countmember; i++) {
//            if (memberId.equals(member[i].getId())) {
//                memberborrow = member[i];
//
//            }
//        }
//
//        for (int i = 0; i < countMovie; i++) {
//            if (movieID.equals(cdStoreMovie[i].getMovield())) {
//                borrowmovie = cdStoreMovie[i];
//
//            }
//
//        }
//
//        System.out.println(memberborrow);
//        System.out.println(borrowmovie);
        MovieBorrowing movieBorrowing = new MovieBorrowing();

        MovieBorrowing checkoutMOvie = movieBorrowing.checkOutMovie(checkMovieByID(movieID), checkMemberByID(memberId));

        cdStoreBorrowingMovie[countMovieborrowing++] = checkoutMOvie;

        System.out.println(checkoutMOvie);

        return checkoutMOvie;
    }

    /*checkoutItem(Item borrowItem, MemberAccount lendingMember) {
        this.borrowDate = LocalDate.of(2020, Month.FEBRUARY, 20);
        //this.borrowDate = LocalDate.now;
        this.dueDate = borrowDate.plus(Policy.MAX_LENDING_DAYS, ChronoUnit.DAYS);
        this.lendingItem = borrowItem;
        this.lendingMember = lendingMember;
        this.lendingItem.setItemStatus(ItemStatus.BORROWED);
        return this; 
    
    }*/
//    public boolean returnMovie(MemberAccount member, MovieBorrowing returnItem) {
//        if (check(member) >= 0) {
//            //no getlending ??
//            if (returnItem.getLendingMember().equals(member)) {
//                int fine = returnItem.returnItem(member);
//                remove(returnItem);
//                if (fine > 0) {
//                    System.out.println("Your fine is " + fine + " Baht.");
//                }
//                return true;
//            } else {
//                return false;
//            }
//        } else {
//            return false;
//        }
//
//    }
    public boolean returnMovie(String memberId, String movieborrowID) {
//        MemberAccount memberborrow = null;
//        MovieBorrowing returnmovie = null;
//        for (int i = checkMember(memberId); i < countmember; i++) {
//            if (memberId == null ? member[i].getId() == null : memberId.equals(member[i].getId())) {
//                memberborrow = member[i];
//            }
//        }
//
//        for (int i = 0; i < countMovieborrowing; i++) {
//            if (movieID == null ? cdStoreBorrowingMovie[i].getMovieBorrow().getMovield() == null : movieID.equals(cdStoreBorrowingMovie[i].getMovieBorrow().getMovield())) {
//                returnmovie = cdStoreBorrowingMovie[i];
//            }
//        }

        if (checkMemberByID(memberId).getId().equals(checkMovieborrowByID(movieborrowID))) {
            int fine = checkMovieborrowByID(movieborrowID).returnMovie(checkMemberByID(memberId));
            if (fine > 0) {
                System.out.println("Your fine is + " + fine + " Bath");
            }
            return true;
        }
        return false;

    }

    public int CheckForFine(String memberId, String movieID) {
      
        if (checkMember(memberId) >= 0) {
            return checkMemberByID(memberId).checkForFine(checkMovieborrowByID(movieID));
        } else {
            return -1;
        }

    }
    //List Part
    public int ListMembers() {

        System.out.println("All Member is " + countmember);

        for (int i = 0; i < countmember; i++) {

            System.out.println(". Member is " + member[i].toString());

        }
        return -1;
    }

    public int ListMovie() {

        System.out.println("All Movie is Store is " + countMovie);

        for (int i = 0; i < countMovie; i++) {

            System.out.println(". Movie is " + cdStoreMovie[i].toString());

        }
        return -1;
    }

    public int ListMovieborrow() {

        System.out.println("All MovieBorrow is Store is " + countMovieborrowing);

        for (int i = 0; i < countMovieborrowing; i++) {

            System.out.println(". Movie is " + cdStoreBorrowingMovie[i].toString());

        }
        return -1;
    }

    

    public int ListmemberBorrowingList(String memberId) {
       
        if (checkMember(memberId) >= 0) {

            return checkMemberByID(memberId).getMovieBorrowList();
        } else {
            return 1;
        }
    }

    //Check path
    private int checkMember(String id) {
        if (id != null) {
            for (int i = 0; i < countmember; i++) {
                if (member[i].getId() == null ? id == null : member[i].getId().equals(id)) {
                    return i;
                }
            }
        }
        return -1;

    }

    private int checkMovie(String id) {
        if (id != null) {
            for (int i = 0; i < countMovie; i++) {
                if (cdStoreMovie[i].getMovield() == null ? id == null : cdStoreMovie[i].getMovield().equals(id)) {
                    return i;
                }
            }
        }
        return -1;

    }

    private Movie checkMovieByID(String MovieID) {
        if (MovieID != null) {
            for (int i = 0; i < countMovie; i++) {
                if (cdStoreMovie[i].getMovield() == null ? MovieID == null : cdStoreMovie[i].getMovield().equals(MovieID)) {
                    return cdStoreMovie[i];
                }
            }
        }
        return null;

    }

    private MemberAccount checkMemberByID(String MemberID) {
        if (MemberID != null) {
            for (int i = 0; i < countmember; i++) {
                if (member[i].getId() == null ? MemberID == null : member[i].getId().equals(MemberID)) {
                    return member[i];
                }
            }
        }
        return null;

    }
    
       private MovieBorrowing checkMovieborrowByID(String MovieborrowID) {
        if (MovieborrowID!= null) {
            for (int i = 0; i < countMovieborrowing; i++) {
                if (cdStoreBorrowingMovie[i].getMovieBorrow().getMovield() == null ? MovieborrowID== null :cdStoreBorrowingMovie[i].getMovieBorrow().getMovield().equals(MovieborrowID)) {
                    return cdStoreBorrowingMovie[i];
                }
            }
        }
        return null;

    }
}
