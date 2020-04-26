package wpk.Store;

import java.util.Iterator;
import wpk.Enum.AccountStatus;
import wpk.Enum.MovieStatus;
import wpk.account.MemberAccount;
import wpk.account.EmployeeAccount;
import wpk.serviceITF.Specifications;
import wpk.Movie.Movie;
import wpk.Enum.AccountMovieStatus;
import wpk.Movie.MovieBorrowing;
import wpk.serviceITF.EmployeeService;
import wpk.serviceITF.MemberService;

/**
 *
 * @author user
 */
public class MovieStore implements Specifications, EmployeeService, MemberService {

    private final String storeName;
    private MemberAccount member[];
    private Movie cdStoreMovie[];//เก็บจำนวนหนังในร้าน
    private MovieBorrowing cdStoreBorrowingMovie[]; //เก็บจำนวนหนังที่ถูกยืมในร้าน
    private ManagerService Service;
    private EmployeeAccount employeeInstore;
    private int countmember = 0, countMovie = 0, countMovieborrowing = 0;

    public MovieStore(String storeName, int maxcustomer, int maxmember, int maxcdStoreMovie, int maxcdStoreBorrowingMovie, int maxemployees, String id) {
        this.storeName = storeName;
        this.member = new MemberAccount[maxmember];
        this.cdStoreMovie = new Movie[maxcdStoreMovie];
        this.cdStoreBorrowingMovie = new MovieBorrowing[maxcdStoreBorrowingMovie];

    }

    public void SetService(ManagerService Service) {

        try {
            this.Service = Service;
            System.out.println("Set Complete");
        } catch (Exception e) {
            System.out.println("Set failed");
        }
    }

    public void SetEmployeesinStore(String EMPid, String Password) {
        if (Service.checkEmployeesByID(EMPid).getId().equals(EMPid) && Service.checkEmployeesByID(EMPid).getPassword().equals(Password)) {
            this.employeeInstore = this.Service.checkEmployeesByID(EMPid);
            System.out.println("Set Complete");
        } else {
            System.out.println("Youe account can't set !!");
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
    public boolean CreateMember(String EMPid, String fristname, String lastname, String password, long phone, AccountStatus status, AccountMovieStatus acstatus) {
        if (fristname == null || lastname == null || password == null || status == null || acstatus == null) {
            System.out.println("Insert Data can't null");
            return false;
        }

        if (EMPid == null) {
            System.out.println("Employees ID can't null");
            return false;
        }
        if (EMPid.equals(this.employeeInstore.getId())) {

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

    public boolean AddMovie(String EMPid, String movieTitle, int premiumStatus, MovieStatus mos) {
        if (movieTitle == null || mos == null) {
            System.out.println("Movie title can't null");
        }

        if (EMPid == null) {
            System.out.println("Employees ID can't null");
        }
        if (premiumStatus == 1 || premiumStatus == 0) {

            if (EMPid.equals(this.employeeInstore.getId())) {
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
        }
        return true;
    }

    public boolean EditData_Member(String EMPid, String MemberID, String fristname, String lastname, String password, long phone, AccountStatus status, AccountMovieStatus acstatus) {
        if (fristname == null || lastname == null || password == null || status == null || acstatus == null) {
            System.out.println("Insert Data can't null");
            return false;
        }

        if (EMPid == null) {
            System.out.println("Employees ID can't null");
            return false;
        }
        if (EMPid.equals(this.employeeInstore.getId()) && checkMember(MemberID) != -1) {
            for (int i = 0; i < countmember; i++) {
                if (member[i].getId() == null ? MemberID == null : member[i].getId().equals(MemberID)) {
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
            System.out.println("Insert Data can't null");

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
            System.out.println("Insert Data can't null");

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

    public int SearchMovieBorrowinstore(String movieID) {
        if (movieID == null) {
            System.out.println("Insert Data can't null");

            return -1;
        }

        if (movieID != null) {
            for (int i = 0; i < countMovieborrowing; i++) {
                if (movieID == null ? cdStoreBorrowingMovie[i].getMovieBorrow().getMovield() == null : movieID.equals(cdStoreBorrowingMovie[i].getMovieBorrow().getMovield())) {
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
    public boolean DeleteMovie(String EMPid, String movieID) {
        if (EMPid == null || movieID == null) {
            System.out.println("Insert Data can't null");

            return false;
        }

        if (EMPid.equals(this.employeeInstore.getId()) && checkMember(movieID) != -1) {
            for (int i = checkMovie(EMPid); i < countMovie; i++) {
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

    private boolean DeleteBorrowMovie(String movieBorrowID) {
        if (movieBorrowID == null) {
            System.out.println("Insert Data can't null");

            return false;
        }

        for (int i = checkMovieBorrow(movieBorrowID); i < countMovieborrowing; i++) {
            if (i == countMovieborrowing - 1) {
                for (int j = i + 1; j < countMovieborrowing; j++) {
                    cdStoreBorrowingMovie[i] = cdStoreBorrowingMovie[j];
                }
                cdStoreBorrowingMovie[--countMovieborrowing] = null;
                return true;
            }
        }

        return false;
    }

    public boolean DeleteMember(String EMPid, String memberID) {

        if (EMPid == null || memberID == null) {
            System.out.println("Insert Data can't null");

            return false;
        }
        if (EMPid.equals(this.employeeInstore.getId()) && checkMember(memberID) != -1) {
            for (int i = checkMember(memberID); i < countmember; i++) {
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
    private MovieBorrowing checkOutMovieinstore(String memberId, String movieID) {
        if (memberId == null || movieID == null) {
            System.out.println("Insert Data can't null");

            return null;
        }
        if (checkMemberByID(memberId).getAccountMovieStatus() != AccountMovieStatus.ACTIVEB) {
            System.out.println("Your account is not ACTIVEB");
            return null;
        }

        if (checkMovieByID(movieID).getMovieStaus() == MovieStatus.Borrowed) {
            System.out.println("This Movie can't Borrow now");
            return null;
        }

        if (checkMemberByID(memberId).getMemberStatus().equals(AccountStatus.MEMBER) && checkMovieByID(movieID).getPremiumStatus() != 1) {
            System.out.println("This Movie is Premium");
            System.out.println("You account can't borrow this Movie");
            return null;

        }

        MovieBorrowing movieBorrowing = new MovieBorrowing();
        MovieBorrowing checkoutMOvie = movieBorrowing.checkOutMovie(checkMovieByID(movieID), checkMemberByID(memberId));
        cdStoreBorrowingMovie[countMovieborrowing++] = checkoutMOvie;
        System.out.println("Check out compleate");
        System.out.println(checkoutMOvie);

        //checkMemberByID(memberId).checkoutMovie(checkoutMOvie);
        return checkoutMOvie;
    }

    public boolean CheckoutMovieMember(String memberId, String movieID) {
        if (memberId == null || movieID == null) {
            System.out.println("Insert Data can't null");
            return false;
        }
        checkMemberByID(memberId).checkoutMovie(checkOutMovieinstore(memberId, movieID));
        return false;
    }

    public boolean returnMovie(String memberId, String movieborrowID) {
        if (memberId == null || movieborrowID == null) {
            System.out.println("Insert Data can't null");

            return false;
        }

        if (checkMemberByID(memberId).getId().equals(memberId) && checkMovieborrowByID(movieborrowID).getMovieBorrow().getMovield().equals(movieborrowID)) {

            int fine = checkMovieborrowByID(movieborrowID).returnMovie(checkMemberByID(memberId));
            checkMemberByID(memberId).returnMovie(checkMovieborrowByID(movieborrowID), fine);

            System.out.println("Return Compleate");
            if (fine > 0) {
                System.out.println("Your fine is + " + fine + " Bath");
            }
            DeleteBorrowMovie(movieborrowID);
            return true;
        }
        return false;

    }

    public int CheckForFine(String memberId, String movieID) {
        if (memberId == null || movieID == null) {
            System.out.println("Insert Data can't null");

            return -1;
        }

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

            System.out.println(countMovieborrowing + ". " + cdStoreBorrowingMovie[i].toString());

        }
        return -1;
    }

    public void ListMemberBorrowingList(String id) {

        checkMemberByID(id).getMovieBorrowList();

    }

    //Check path
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

    private int checkMovieBorrow(String id) {
        if (id != null) {
            for (int i = 0; i < countMovieborrowing; i++) {
                if (cdStoreBorrowingMovie[i].getMovieBorrow().getMovield() == null ? id == null : cdStoreBorrowingMovie[i].getMovieBorrow().getMovield().equals(id)) {
                    return i;
                }
            }
        }
        return -1;

    }

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
        if (MovieborrowID != null) {
            for (int i = 0; i < countMovieborrowing; i++) {
                if (cdStoreBorrowingMovie[i].getMovieBorrow().getMovield() == null ? MovieborrowID == null : cdStoreBorrowingMovie[i].getMovieBorrow().getMovield().equals(MovieborrowID)) {
                    return cdStoreBorrowingMovie[i];
                }
            }
        }
        return null;

    }
}
